var photoresistorSensorChart;
$(function() {
	photoresistorSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"photoresistorSensorChartContainer",
			type:"spline",
			events: {
				load: requestphotoresistorSensorData
			}
		},
		colors: ['green'],
		title: {
			text: "photoresistorSensor(조도센서)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		
		},
		yAxis: {
			
			title: {
				text: "조도",
				margin: 30
			}
		},
		series: [{
			name: "조도",
			data: []
		}]
	});
});

function requestphotoresistorSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/photoresistor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = photoresistorSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.photoresistor], true, shift);
	};
}






