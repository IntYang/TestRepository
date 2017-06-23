var gasSensorChart;
$(function() {
	gasSensorChart = new Highcharts.Chart({
		chart: {
			renderTo:"gasSensorChartContainer",
			type:"spline",
			events: {
				load: requestgasSensorData
			}
		},
		colors: ['blue'],
		title: {
			text: "gasSensor(가스센서)"
		},
		xAxis: {
			type: "datetime",
			tickPixelInterval: 100,
			minRange: 20*1000
		
		},
		yAxis: {
			
			title: {
				text: "검출",
				margin: 30
			}
		},
		series: [{
			name: "검출",
			data: []
		}]
	});
});

function requestgasSensorData() {
	var ws = new WebSocket("ws://" + location.host + "/SensingCarRemoteWebControl/websocket/gassensor");
	ws.onmessage = function(event) {
		var data = JSON.parse(event.data);
		var series = gasSensorChart.series[0];
		var shift = series.data.length > 20;
		series.addPoint([data.time, data.gas], true, shift);
	};
}






