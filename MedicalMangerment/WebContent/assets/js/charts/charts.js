/*----------------------折线图-----------------------*/
//折线图堆叠

line = function(url, timeRange, element, opt){
	var option = {
		    title: {
		        text: '折线图堆叠'
		    },
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        data:[]
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    toolbox: {
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        boundaryGap: false,
		        data: []
		    },
		    yAxis: {
		        type: 'value'
		    },
		    series: [
		        /*{
		            name:'搜索引擎',
		            type:'line',
		            stack: '总量',
		            data:[820, 932, 901, 934, 1290, 1330, 1320]
		        }*/
		    ]
		};
	if(opt){
		option = opt;
	}
	$.ajax({
		url: url,
		data: {
			"timeRange": timeRange,
		},
		async: false,
		dataType: 'json',
		success: function(res){
			option.legend.data = res.legend;
			option.xAxis.data = res.xAxis;
			var series = [];
			res.datas.forEach(function(target, i){
				var obj ={};
				obj.name = res.legend[i];
				obj.type = 'line';
				obj.data = target;
				series.push(obj);
			});
			option.series = series;
			console.log(option);
		}
	})
	var myChart = echarts.init(document.getElementById(element));
	myChart.setOption(option);
}