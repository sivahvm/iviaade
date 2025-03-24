<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Accelerated Deployment Engine</title>
<link rel="icon" type="image/x-icon"
	href="<c:url value="/resources/css/ibm.ico"/>">
<link rel="stylesheet" type="text/css" media="screen"
	href='<c:url value="/resources/css/input.css"/>' />
<script src="<c:url value="/resources/javascript/input.js"/>"></script>

</head>
<body id="contentpage">

	<!--   <p>Here we demonstrate the process of filling out a form and submitting it to web application to be processed.</p> -->
	<div class="logobaner">
		<div class="row ">
			<div class="adelog">
				<img src="<c:url value="/resources/css/ADE_logo_resize.jpg"/>"
					alt="Ibm logo" />
			</div>
			<div class="div_backgrndimg">
				<label class="headlabel"><b>Accelerated Deployment
						Engine</b></label> <label style="color: #3F91B6"><b> Database Configuration </b></label>
			</div>
			<div class="ibmlog">
				<img src="<c:url value="/resources/css/ibm_resize.png"/>"
					alt="Ibm logo">
			</div>

		</div>
	</div>
	<br>
<body>

	 
<form:form method = "POST" action = "/iviacontainerdep/dbConfig" commandName="dbConfigModel">
	
	<div class="mahi_holder">
			<div class="container">
						<div align="left">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/ldapConfig"/>'>Back</a> </b></i>
					    </div>
					    <div align="right">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/reverseProxyList"/>'>Skip</a> </b></i>
					    </div>
				<div class="row bg_2">
					<fieldset class="fieldset">

						<legend>
							<h3>Database Configuration Container</h3>
						</legend>
						<div class="col-3 input-effect">
							<form:input path="volume" value="pgdata" class="effect-19"
								placeholder="" />
							<label>postgresql Persistent Volume Name</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="appName" value="postgresqla" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="containerName" value="postgresqlc" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="memorySize" value="250" class="effect-19"
								placeholder="" />
							<label>Memory Size</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="servname" value="postgresqls" class="effect-19"
								placeholder="" />
							<label>Service Name <b><form:errors cssClass="error" path="servname" /></b></label> <span class="focus-border"> <i></i>
							</span>
						</div> 					
						<!--  <div class="col-3 input-effect">
							<form:input path="hostname" value="postgresql" class="effect-19"
								placeholder="" />
							<label>Hostname Name</label> <span class="focus-border"> <i></i>
							</span>
						</div> -->
						<div class="col-3 input-effect">
							<form:input path="dbName" value="ivia" class="effect-19"
								placeholder="" />
							<label>Database Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<!-- <div class="col-3 input-effect">
							<form:input path="instName" value="ivia" class="effect-19" placeholder="" />
							<label>Database Instance Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div> -->
						<div class="col-3 input-effect">
							<form:input path="port" value="30443" class="effect-19" placeholder="" />
							<label>Port Number </label> <span class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="userName" value="postgres" class="effect-19" placeholder="" />
							<label>Database User Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="adminpwd" value="Passw0rd" class="effect-19"
								placeholder="" />
							<label>Database admin password</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/ivia/ivia-postgresql" class="effect-19"
								placeholder="" />
							<label>ivia-config image repository URL</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

						<div class="col-3 input-effect">
							<form:input path="imageVersion" value="11.0.0.0" class="effect-19"
								placeholder="" />
							<label>ivia-config image tag version</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

					</fieldset>

					
				</div>
			</div>
		</div>
		<br>		
		<div id="submitbottonid">
			<input type="submit" id="submit_button"  class="button-click" value="Save config and Next" />
		</div>
		
	</form:form>

</body>
</html>