$(function(){
	
	$.ajax({
		type:"post",
		url:ctx+"/report/queryCustomerGc",
		dataType:"json",
		success:function(data){
			var data1=[];// 名称
			var data2=[];// 数量
			if(null!=data&&data.length>0){
				for(var i=0;i<data.length;i++){
					data1[i]=data[i].level;
					data2[i]=data[i].count;
				}
				// 基于准备好的dom，初始化echarts实例
			    var myChart = echarts.init(document.getElementById('main'));
			    // 指定图表的配置项和数据
			    /*var option = {
			        title: {
			            text: 'ECharts 入门示例'
			        },
			        tooltip: {},
			        legend: {
			            data:['销量']
			        },
			        xAxis: {
			            data: data1
			        },
			        yAxis: {},
			        series: [{
			            name: '销量',
			            type: 'bar',
			            data: data2
			        }]
			    };*/

			    
			    
			    option = {
			    	    color: ['#3398DB'],
			    	    tooltip : {
			    	        trigger: 'axis',
			    	        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
			    	            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
			    	        }
			    	    },
			    	    grid: {
			    	        left: '3%',
			    	        right: '4%',
			    	        bottom: '3%',
			    	        containLabel: true
			    	    },
			    	    xAxis : [
			    	        {
			    	            type : 'category',
			    	            data :data1,
			    	            axisTick: {
			    	                alignWithLabel: true
			    	            }
			    	        }
			    	    ],
			    	    yAxis : [
			    	        {
			    	            type : 'value'
			    	        }
			    	    ],
			    	    series : [
			    	        {
			    	            name:'直接访问',
			    	            type:'bar',
			    	            barWidth: '60%',
			    	            data:data2
			    	        }
			    	    ]
			    	};

			    // 使用刚指定的配置项和数据显示图表。
			    myChart.setOption(option);
			}	
		}
	})
})