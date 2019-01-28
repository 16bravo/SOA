<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css"
	integrity="sha384-GJzZqFGwb1QTTN6wy59ffF1BuGJpLSa9DkKMp0DgiMDm4iYMj70gZWKYbI706tWS"
	crossorigin="anonymous">
<html>
<body>
	<h2>Classroom Management System</h2>
	<div class="row">
	<div class="col-md-4">
		Time : <input type="time" id="time" name="time" value="${ time }">
		</div>
	</div>
	<div class="row">
		<input name="light" type="submit" value="${ l.value }" />
	</div>
	<div class="row">
	<div class="col-md-4">
		Last known Room 1 temperature :
		<c:out value="${ t.value }" />
		<a href="webapi/temperature">(temperature value JSON)</a>
		</div>
	</div>
	<div class="row">
	<div class="col-md-4">
		Last known outside temperature :
		<c:out value="${ ot.value }" />
		<a href="webapi/temperature_ext">(temperature value JSON)</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			Light status :
			<form action="LightServlet" method="POST">
				<input name="light" type="submit" value="${ l.value }" />
			</form>
			<a href="webapi/lumieres">(light status JSON)</a>
		</div>
		<div class="col-md-1">
			Door status :
			<form action="DoorServlet" method="POST">
				<input name="door" type="submit" value="${ d.value }" />
			</form>
			<a href="webapi/portes">(door status JSON)</a>
		</div>
		<div class="col-md-1">
			Window status :
			<form action="WindowServlet" method="POST">
				<input name="window" type="submit" value="${ w.value }" />
			</form>
			<a href="webapi/fenetres">(window status JSON)</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-1">
			Heater status :
			<form action="HeaterServlet" method="POST">
				<input name="heater" type="submit" value="${ h.value }" />
			</form>
			<a href="webapi/chauffage">(heater status JSON)</a>
		</div>
		<div class="col-md-1">
			Presence in the room :
			<form action="PresenceServlet" method="POST">
				<input name="presence" type="submit" value="${ p.value }" />
			</form>
			<a href="webapi/presence">(presence status JSON)</a>
		</div>
	</div>
	<div class="row">
		<div class="col-md-4">
			Test :
			<form action="TestServlet" method="POST">
				<input name="test" type="submit" value="Test" />
			</form>
		</div>
	</div>
	<script>
	
	</script>
</body>
</html>
