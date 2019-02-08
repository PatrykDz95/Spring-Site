<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>


<!-- <script language="javascript" type="text/javascript">
alert("Welcome to my site")
</script>
 -->
<html>

<head>
	<title>
	Home Page
	</title>
</head>

	<p>
			<a href="${pageContext.request.contextPath}/showMyLoginPage">Login</a>
				<a href="${pageContext.request.contextPath}/weather/list">weather</a>
				<a href="${pageContext.request.contextPath}/store">Upload File</a>
	
	</p>

<body>
	<h2>
	<security:authorize access="hasRole('EMPLOYEE')">
	<p>
	Welcome to my page!</p>
		 You are logged in as: <security:authentication property="principal.username" /> 
	</p>
	</security:authorize>
	</h2>
	<hr>
	<button type="button" onclick="plotly1()">Meteorite Landing Locations</button> <button type="button" onclick="plotly2()">Multiple Trace Filled-Area Animation</button>
	
		<security:authorize access="hasRole('EMPLOYEE')"><br>
		Town: 
		<br>
		<form action="${pageContext.request.contextPath}/api/weather/Warsaw">
		<input type="submit" value="Warsaw Weather">  
		</form>
		
		<form action="${pageContext.request.contextPath}/pong">
	    <input type="submit" value="Weather API with Google maps" />
		</form>
		
		<form action="${pageContext.request.contextPath}/api/currency">
		<input type="submit" value="Current Bitcoin price">  
		</form>
		
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" 
			   method="POST">
	
		<input type="submit" value="Logout" />
	
	</form:form>
		</security:authorize>
	
	
	
	<!-- display user name and role -->

	<security:authorize access="hasRole('EMPLOYEE')">
	
		<!-- Add a link to point to /leaders ... this is for the managers -->
		
		<p>
			<a href="${pageContext.request.contextPath}/machine">Machine Learning</a>
		</p>

	</security:authorize>	
	
	
	<!--<security:authorize access="hasRole('ADMIN')">  

		<!-- Add a link to point to /systems ... this is for the admins -->
		
		<!--<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for Admin peeps)
		</p>
	
	</security:authorize>
	-->
	<hr>
	
</body>

</html>


<html>
<head>
    <!-- Plotly.js -->
    <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>

<!-- Plotly chart will be drawn inside this DIV -->
<div id="graphDiv"></div>
<script>
function plotly1(){ 
    Plotly.d3.csv('https://raw.githubusercontent.com/bcdunbar/datasets/master/meteorites_subset.csv', function(err, rows){
        var classArray = unpack(rows, 'class');
        var classes = [...new Set(classArray)];
        function unpack(rows, key) {
            return rows.map(function(row) { return row[key]; });
        }
        var data = classes.map(function(classes) {
            var rowsFiltered = rows.filter(function(row) {
                return (row.class === classes);
            });
            return {
                type: 'scattermapbox',
                name: classes,
                lat: unpack(rowsFiltered, 'reclat'),
                lon: unpack(rowsFiltered, 'reclong')
            };
        });
        var layout = {
            title: 'Meteorite Landing Locations',
            font: {
                color: 'white'
            },
            dragmode: 'zoom',
            mapbox: {
                center: {
                    lat: 38.03697222,
                    lon: -90.70916722
                },
                domain: {
                    x: [0, 1],
                    y: [0, 1]
                },
                style: 'dark',
                zoom: 1
            },
            margin: {
                r: 20,
                t: 40,
                b: 20,
                l: 20,
                pad: 0
            },
            paper_bgcolor: '#191A1A',
            plot_bgcolor: '#191A1A',
            showlegend: true,
            annotations: [{
                x: 0,
                y: 0,
                xref: 'paper',
                yref: 'paper',
                text: 'Source: <a href="https://data.nasa.gov/Space-Science/Meteorite-Landings/gh4g-9sfh" style="color: rgb(255,255,255)">NASA</a>',
                showarrow: false
            }]
        };
        Plotly.setPlotConfig({
            mapboxAccessToken: 'pk.eyJ1IjoiZXRwaW5hcmQiLCJhIjoiY2luMHIzdHE0MGFxNXVubTRxczZ2YmUxaCJ9.hwWZful0U2CQxit4ItNsiQ'
        });
        Plotly.plot('graphDiv', data, layout);
    });
}
</script>
</div>
</body>
</html>


<head>
  <!-- Plotly.js -->
  <script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>
<body>
<!-- Plotly chart will be drawn inside this DIV -->
<div id="myDiv"></div>
  <script>
  function plotly2(){ 
  Plotly.d3.csv("https://raw.githubusercontent.com/plotly/datasets/master/finance-charts-apple.csv", function(err, rows){

	  function unpack(rows, key) {
	  return rows.map(function(row) { return row[key]; });
	}

	  var frames = []
	  var x = unpack(rows, 'Date')
	  var y = unpack(rows, 'AAPL.High')
	  var x2 = unpack(rows, 'Date')
	  var y2 = unpack(rows, 'AAPL.Low')
	  
	  var n = 100;
	  for (var i = 0; i < n; i++) { 
	    frames[i] = {data: [{x: [], y: []}, {x: [], y: []}]}
	    frames[i].data[1].x = x.slice(0, i+1);
	    frames[i].data[1].y = y.slice(0, i+1);
	    frames[i].data[0].x = x2.slice(0, i+1);
	    frames[i].data[0].y = y2.slice(0, i+1);
	  }
	  
	  var trace2 = {
	    type: "scatter",
	    mode: "lines",
	    name: 'AAPL High',
	    fill: 'tonexty',
	    x: frames[5].data[1].x,
	    y: frames[5].data[1].y,
	    line: {color: 'grey'}
	  }

	  var trace1 = {
	    type: "scatter",
	    mode: "lines",
	    name: 'AAPL Low',
	    x: frames[5].data[0].x,
	    y: frames[5].data[0].y,
	    line: {color: 'lightgrey'}
	  }

	  var data = [trace1,trace2]; 
	    
	  var layout = {
	    title: 'Multiple Trace Filled-Area Animation',
	    xaxis: {
	      range: [frames[99].data[0].x[0], frames[99].data[0].x[99]],
	      showgrid: false
	    },
	    yaxis: {
	      range: [120, 140],
	      showgrid: false
	    },
	    legend: {
	      orientation: 'h',
	      x: 0.5,
	      y: 1.2,
	      xanchor: 'center'
	    },
	    updatemenus: [{
	      x: 0.5,
	      y: 0,
	      yanchor: "top",
	      xanchor: "center",
	      showactive: false,
	      direction: "left",
	      type: "buttons",
	      pad: {"t": 87, "r": 10},
	      buttons: [{
	        method: "animate",
	        args: [null, {
	          fromcurrent: true,
	          transition: {
	            duration: 0,
	          },
	          frame: {
	            duration: 40,
	            redraw: false
	          }
	        }],
	        label: "Play"
	      }, {
	        method: "animate",
	        args: [
	          [null],
	          {
	            mode: "immediate",
	            transition: {
	              duration: 0
	            },
	            frame: {
	              duration: 0,
	              redraw: false
	            }
	          }
	        ],
	        label: "Pause"
	      }]
	    }]
	  };

	  Plotly.newPlot('myDiv', data, layout).then(function() {
	    Plotly.addFrames('myDiv', frames);
	  });
	})
  }
	</script>
	
	<div id="openweathermap-widget-11"></div>
<script src='//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/d3.min.js'>
</script>
<script>
window.myWidgetParam ? window.myWidgetParam : window.myWidgetParam = [];  
window.myWidgetParam.push({id: 11,cityid: '756135',appid: 'd3f402ba364691fc61e4a73cbe0358c2',units: 'metric',containerid: 'openweathermap-widget-11',  }); 
(function() {
var script = document.createElement('script');
script.async = true;
script.charset = "utf-8";
script.src = "//openweathermap.org/themes/openweathermap/assets/vendor/owm/js/weather-widget-generator.js";
var s = document.getElementsByTagName('script')[0];
s.parentNode.insertBefore(script, s);  
})
();
</script>
	
</body>
</html>



