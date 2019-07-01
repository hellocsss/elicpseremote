/*----------------------饼状图-----------------------*/

//药品销售详情图
(function(){
	opt = {
    title : {
        text: '药品销售详情图',
        x:'center'
    },
    tooltip : {
        trigger: 'item',
        formatter: "{a} <br/>{b} : {c} ({d}%)"
    },
    legend: {
        x : 'center',
        y : 'bottom',
        data:['感冒药','rose2','rose3','rose4','rose5','rose6','rose7','rose8']
    },
    toolbox: {
        show : true,
        feature : {
            mark : {show: true},
            dataView : {show: true, readOnly: false},
            magicType : {
                show: true,
                type: ['funnel']
            },
            restore : {show: true},
            saveAsImage : {show: true}
        }
    },
    calculable : true,
    series : [
//        {
//            name:'半径模式',
//            type:'pie',
//            radius : [20, 110],
//            center : ['25%', '50%'],
//            roseType : 'radius',
//            label: {
//                normal: {
//                    show: false
//                },
//                emphasis: {
//                    show: true
//                }
//            },
//            lableLine: {
//                normal: {
//                    show: false
//                },
//                emphasis: {
//                    show: true
//                }
//            },
//            data:[
//                {value:10, name:'感冒药'},
//                {value:5, name:'rose2'},
//                {value:15, name:'rose3'},
//                {value:25, name:'rose4'},
//                {value:20, name:'rose5'},
//                {value:35, name:'rose6'},
//                {value:30, name:'rose7'},
//                {value:40, name:'rose8'}
//            ]
//        },
        {
            name:'面积模式',
            type:'pie',
            //radius : [30, 110],
            //center : ['50%', '50%'],
            roseType : 'area',
            data:[
                {value:10, name:'感冒药'},
                {value:5, name:'rose2'},
                {value:15, name:'rose3'},
                {value:25, name:'rose4'},
                {value:20, name:'rose5'},
                {value:35, name:'rose6'},
                {value:30, name:'rose7'},
                {value:40, name:'rose8'}
            ]
        }
    ]
};
$.ajax({
	url : '/MedicalMangerment/notification_lookMore',
	data: {
		'eid': GetQueryString('eid')
	},
	async : false,
	dataType : 'json',
	success : function(msg) {
		opt.legend.data = msg.data;
		opt.series[0].data = msg.seriesData;
		opt.series[1].data = msg.seriesData;
		console.log(opt);
		
	}
});
var pie4 = echarts.init(document.getElementById("pie4"));
pie4.setOption(opt);
})();