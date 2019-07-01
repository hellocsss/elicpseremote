(function(){
	var myChart = echarts.init(document.getElementById("widget-chart-box-1"));
	var myChart2 = echarts.init(document.getElementById("widget-chart-box-2"));
	
	var labelTop = {
		
    normal : {
        label : {
            show : true,
            position : 'center',
            formatter : '{b}',
            textStyle: {
                baseline : 'bottom'
            }
        },
        labelLine : {
            show : false
        }
        
    }
};
var labelFromatter = {
    normal : {
        label : {
            formatter : function (params){
                return 100 - params.value + '%'
            },
            textStyle: {
                baseline : 'center'
            }
        }
    },
}
var labelBottom = {
    normal : {
        color: '#ccc',
        label : {
            show : true,
            position : 'center'
        },
        labelLine : {
            show : false
        }
    },
    emphasis: {
        color: '#ccc'
    }
};
var radius = [40, 35];
option = {
	
	
	
    legend: {
        x : 'center',
        y : 'center',
        
    },
    
    grid: {
    	x:0,
    	y:0,
    	x2:0,
    	y2:0
    },
    
    toolbox: {
        show : true,
        feature : {
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                option: {
                    funnel: {
                        width: '20%',
                        height: '30%',
                        itemStyle : {
                            normal : {
                                label : {
                                    formatter : function (params){
                                        return 'other\n' + params.value + '%\n'
                                    },
                                    textStyle: {
                                        baseline : 'middle'
                                    }
                                }
                            },
                        } 
                    }
                }
            }
           
        }
    },
    series : [
        {
            type : 'pie',
            
            radius : radius,
            x: '0%', // for funnel
            itemStyle : labelFromatter,
            data : [
                {name:'other', value:20, itemStyle : labelBottom},
                {name:'', value:80,itemStyle : labelTop}
            ]
        }
        
    ],
    animation :false
};
                    
	
	myChart.setOption(option);
	myChart2.setOption(option);
})();



/*
	private List<Map> datas;
	
	private List<String> legend;*/
(function(){
	
	
var opt1 = {
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        orient : 'vertical',
        x : 'left',
        /*data:['感冒药','皮肤药','抗生','处方','非处方']*/
    	data:[]
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true, 
                type: ['pie', 'funnel'],
                opt1: {
                    funnel: {
                        x: '25%',
                        width: '50%',
                        funnelAlign: 'center',
                        max: 1548
                    }
                }
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
        {
            name:'访问来源',
            type:'pie',
            radius : ['50%', '70%'],
            itemStyle : {
                normal : {
                    label : {
                        show : false
                    },
                    labelLine : {
                        show : false
                    }
                },
                emphasis : {
                    label : {
                        show : true,
                        position : 'center',
                        textStyle : {
                            fontSize : '20',
                            fontWeight : 'bold'
                        }
                    }
                }
            },
            data:[
            	
                /*{value:1000,name:'感冒药',},
                {value:310, name:'皮肤药'},
                {value:234, name:'抗生'},
                {value:135, name:'处方'},
                {value:1548, name:'非处方'}*/
            ]
        }
    ]
};
	
	//alert("第二次！！");
                 //	private List<Map> datas;

//private List<String> legend;   
	$.ajax({
		url: '/MedicalMangerment/showData_countNumOfType',
		data: {},
		async: false,
		dataType: 'json',
		success: function(res){
			
			console.log(res);
			
			//alert(res.datas[0].name);
			
			opt1.legend.data = res.legend;
			
			//alert(opt1.legend.data);
			
			var data1 = [];
			res.datas.forEach(function(target, i){
				
				//alert(target.name);
				
				var obj ={};
				obj = target;
				data1.push(obj);
			});
			
			opt1.series[0].data = data1;
			
			
		}
	})         
	var myChart = echarts.init(document.getElementById("index-pie-1"));
	myChart.setOption(opt1);
})();



//近7天收入
(function() {
	var myChart = echarts.init(document.getElementById("index-bar-1"));
	var opt = {
		color : [ '#3398DB' ],
		tooltip : {
			trigger : 'axis',
			axisPointer : { // 坐标轴指示器，坐标轴触发有效
				type : 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			}
		},
		grid : {
			left : '3%',
			right : '4%',
			bottom : '3%',
			containLabel : true
		},
		xAxis : [ {
			type : 'category',
			data : [ 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat', 'Sun' ],
			axisTick : {
				alignWithLabel : true
			}
		} ],
		yAxis : [ {
			type : 'value'
		} ],
		series : [ {
			name : '该日收入',
			type : 'bar',
			barWidth : '60%',
			data : [ 10, 52, 200, 334, 390, 330, 220 ]
		} ]
	};

	$.ajax({
		url : '/MedicalMangerment/showData_SevenDaysMoney',
		async : true,
		dataType : 'json',
		success : function(msg) {
			opt.xAxis[0].data = msg.xAxis;
			opt.series[0].data = msg.data;
			console.log(opt);
			myChart.setOption(opt);
		}
	});
})();


(function(){
	var myChart = echarts.init(document.getElementById("index-line-1"));
	
	option = {

    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data:['最高气温','最低气温'],
        x: "right"
    },
    
    xAxis:  {
        type: 'category',
        boundaryGap: false,
        data: ['周一','周二','周三','周四','周五','周六','周日']
    },
    yAxis: {
        type: 'value',
        axisLabel: {
            formatter: '{value} °C'
        }
    },
    series: [
        {
            name:'最高气温',
            type:'line',
            data:[11, 11, 15, 13, 12, 13, 10],
            markPoint: {
                data: [
                    {type: 'max', name: '最大值'},
                    {type: 'min', name: '最小值'}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'}
                ]
            }
        },
        {
            name:'最低气温',
            type:'line',
            data:[1, -2, 2, 5, 3, 2, 0],
            markPoint: {
                data: [
                    {name: '周最低', value: -2, xAxis: 1, yAxis: -1.5}
                ]
            },
            markLine: {
                data: [
                    {type: 'average', name: '平均值'},
                    [{
                        symbol: 'none',
                        x: '90%',
                        yAxis: 'max'
                    }, {
                        symbol: 'circle',
                        label: {
                            normal: {
                                position: 'start',
                                formatter: '最大值'
                            }
                        },
                        type: 'max',
                        name: '最高点'
                    }]
                ]
            }
        }
    ]
};


                    
                    
	
	myChart.setOption(option);
})();

