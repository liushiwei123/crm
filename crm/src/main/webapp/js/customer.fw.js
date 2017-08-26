$(function(){
	
	$.ajax({
		type:"post",
		url:ctx+"/report/queryServeMakeUp",
		dataType:"json",
		success:function(data){
			var data1=[];// 名称
			var data2=[];// 数量
			if(null!=data&&data.length>0){
				for(var i=0;i<data.length;i++){
					data1[i]=data[i].serveType;
					var s={};
					s.value=data[i].count;
					s.name=data[i].serveType;
					data2[i]=s;
				}
				// 基于准备好的dom，初始化echarts实例
			    var myChart1 = echarts.init(document.getElementById('main'));
			    var myChart2 = echarts.init(document.getElementById('main2'));
			    // 指定图表的配置项和数据
			    option1 = {
			    	    tooltip: {
			    	        trigger: 'item',
			    	        formatter: "{a} <br/>{b}: {c} ({d}%)"
			    	    },
			    	    legend: {
			    	        orient: 'vertical',
			    	        x: 'left',
			    	        data:data1
			    	    },
			    	    series: [
			    	        {
			    	            name:'访问来源',
			    	            type:'pie',
			    	            radius: ['50%', '70%'],
			    	            avoidLabelOverlap: false,
			    	            label: {
			    	                normal: {
			    	                    show: false,
			    	                    position: 'center'
			    	                },
			    	                emphasis: {
			    	                    show: true,
			    	                    textStyle: {
			    	                        fontSize: '30',
			    	                        fontWeight: 'bold'
			    	                    }
			    	                }
			    	            },
			    	            labelLine: {
			    	                normal: {
			    	                    show: false
			    	                }
			    	            },
			    	            data:data2
			    	        }
			    	    ]
			    	};
			    option2 = {
			    	    backgroundColor: '#2c343c',
			    	    title: {
			    	        text: 'Customized Pie',
			    	        left: 'center',
			    	        top: 20,
			    	        textStyle: {
			    	            color: '#ccc'
			    	        }
			    	    },

			    	    tooltip : {
			    	        trigger: 'item',
			    	        formatter: "{a} <br/>{b} : {c} ({d}%)"
			    	    },

			    	    visualMap: {
			    	        show: false,
			    	        min: 80,
			    	        max: 600,
			    	        inRange: {
			    	            colorLightness: [0, 1]
			    	        }
			    	    },
			    	    series : [
			    	        {
			    	            name:'访问来源',
			    	            type:'pie',
			    	            radius : '55%',
			    	            center: ['50%', '50%'],
			    	            data:data2.sort(function (a, b) { return a.value - b.value}),
			    	            roseType: 'angle',
			    	            label: {
			    	                normal: {
			    	                    textStyle: {
			    	                        color: 'rgba(255, 255, 255, 0.3)'
			    	                    }
			    	                }
			    	            },
			    	            labelLine: {
			    	                normal: {
			    	                    lineStyle: {
			    	                        color: 'rgba(255, 255, 255, 0.3)'
			    	                    },
			    	                    smooth: 0.2,
			    	                    length: 10,
			    	                    length2: 20
			    	                }
			    	            },
			    	            itemStyle: {
			    	                normal: {
			    	                    color: '#c23531',
			    	                    shadowBlur: 200,
			    	                    shadowColor: 'rgba(0, 0, 0, 0.5)'
			    	                }
			    	            },

			    	            animationType: 'scale',
			    	            animationEasing: 'elasticOut',
			    	            animationDelay: function (idx) {
			    	                return Math.random() * 200;
			    	            }
			    	        }
			    	    ]
			    	};
			    
			    
			    
			   

			    // 使用刚指定的配置项和数据显示图表。
			    myChart1.setOption(option1);
			    myChart2.setOption(option2);
			}	
		}
	})
})