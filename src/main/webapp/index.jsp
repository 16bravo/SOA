<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
<html>
<body>
	<h2>Classroom Management System</h2>
	<h3>Values:</h3>
	<div class="row">
		<div class="col-md-6">
			<form action="TemperatureServlet" method="POST">
				Last known Room 1 temperature :
				<c:out value="${ t.value }" />
				<!--  </br> <input type="number" step="0.1" name="temperature" value="${ t.value }"> </br> <a href="webapi/temperature">(temperature value JSON)</a>-->
				</br>Last known outside temperature :
				<c:out value="${ ot.value }" />
				<!-- </br> <input type="number" step="0.1" name="otemp" value="${ ot.value }"> </br> <a href="webapi/temperature_ext">(temperature value JSON)</a> </br> <input type="submit" value="Submit" /> -->
			</form>
		</div>
	</div>
	<div class="row">
		<div class="col-md-2">
			Light status :
			<form action="LightServlet" method="POST">
				<input class="${ l.value }" name="light" type="submit" value="${ l.value }" />
			</form>
			<a href="webapi/lumieres">(light status JSON)</a>
		</div>
		<div class="col-sm-3 col-md-2">
			Door status :
			<form action="DoorServlet" method="POST">
				<input class="${ d.value }" name="door" type="submit" value="${ d.value }" />
			</form>
			<a href="webapi/portes">(door status JSON)</a>
		</div>
		<div class="col-sm-3 col-md-2">
			Window status :
			<form action="WindowServlet" method="POST">
				<input class="${ w.value }" name="window" type="submit" value="${ w.value }" />
			</form>
			<a href="webapi/fenetres">(window status JSON)</a>
		</div>
	</div>
	<div class="row">
		<div class="col-sm-3 col-md-2">
			Heater status :
			<form action="HeaterServlet" method="POST">
				<input class="${ h.value }" name="heater" type="submit" value="${ h.value }" />
			</form>
			<a href="webapi/chauffage">(heater status JSON)</a>
		</div>
		<div class="col-sm-3 col-md-2">
			Presence in the room :
			<form action="PresenceServlet" method="POST">
				<input class="${ p.value }" name="presence" type="submit" value="${ p.value }" />
			</form>
			<a href="webapi/presence">(presence status JSON)</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-6">
			<h3>Test:</h3>
			<form action="TestServlet" method="POST">
				Time : <input type="time" name="time" value="${ time }">
				<input name="test" type="submit" value="Test" />
			</form>
		</div>
	</div>
	<div class="row">
	<div class="col-md-6">
	Tested time : ${ ttime }</br>
	Alarm state : ${ alert }
	</div>
	</div>
	</br>
	<div class="row">
		<div class="col-md-6">
		<h3>Scenarios:</h3>
		<ul>
			<li>If inside temperature is less than 19 and there is presence in the room, then turn on the heater</li>
			<li>If inside temperature is more than 20 and there is no presence in the room, then turn off the heater</li>
			<li>If outside temperature is between 18 and 27 (both included) and outside temperature is smaller than inside, then open the windows</li>
			<li>If change in door state between 10pm and 6 am and there is no presence in the room, then alarm</li>
			<li>If there is no presence in the room between 6pm and 6am, then turn off the lights</li>
		</ul>
		</div>
	</div>
	<script>
		
	</script>
</body>
</html>
