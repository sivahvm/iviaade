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
						Engine</b></label> <label style="color: #3F91B6"><b> IVIA
						Configuration Container </b></label>
			</div>
			<div class="ibmlog">
				<img src="<c:url value="/resources/css/ibm_resize.png"/>"
					alt="Ibm logo">
			</div>

		</div>
	</div>
	<br>
	<form:form method="POST" action="/iviacontainerdep/lmiConfig"
		commandName="requestConfig">
		<div class="">
			<div class="container">
						<div align="left">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/index"/>'>Home</a> </b></i>
					    </div>
				<div class="row bg_2">
					<fieldset class="fieldset">
						<legend>
							<h3>IVIA Configuration Container</h3>
						</legend>
						<!-- <div class="col-3 input-effect">
							<form:input path="network" value="ivia" class="effect-19"
								placeholder="" />
							<label>Network label Name <b><form:errors cssClass="error" path="network" /></b></label> <span class="focus-border">
								<i></i>
							</span>
						</div>-->
						<div class="col-3 input-effect">
							<form:input path="volume" value="iviaconfigv" class="effect-19"
								placeholder="" />
							<label>Persistent Volume Name</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="timezone" value="Asia/Kolkata" class="effect-19"
								placeholder="" />
							<label>Container Time Zone</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="appName" value="iviaconfiga" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="containerName" value="iviaconfigc" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="memorySize" value="500" class="effect-19"
								placeholder="" />
							<label>Memory Size</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<!--  <div class="col-3 input-effect">
							<form:input path="numCpu" value="2" class="effect-19"
								placeholder="" />
							<label>CPU Number of Core</label> <span class="focus-border">
								<i></i>
							</span>
						</div>	 -->					
						<div class="col-3 input-effect">
							<form:input path="servname" value="iviaconfigs" class="effect-19"
								placeholder="" />
							<label>Service Name <b><form:errors cssClass="error" path="servname" /></b></label> <span class="focus-border"> <i></i>
							</span>
						</div> 
					<!-- <div class="col-3 input-effect">
							<form:input path="ipaddress" value="" class="effect-19"
								placeholder="" />
							<label>LMI IP Address  <b><form:errors cssClass="error" path="ipaddress" /></b> </label> <span class="focus-border">
								<i></i>
							</span>
						</div> -->
						<div class="col-3 input-effect">
							<form:input path="port" value="9443" class="effect-19" placeholder="" />
							<label>LMI Port Number </label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<!-- <div class="col-3 input-effect">
							<form:input path="adminpwd" value="Passw0rd" class="effect-19"
								placeholder="" />
							<label>LMI admin password</label> <span class="focus-border">
								<i></i>
							</span>
						</div> -->
						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/ivia/ivia-config" class="effect-19"
								placeholder="" />
							<label>ivia-config image repository URL <b><form:errors cssClass="error" path="repoUrl" /></b> </label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

						<div class="col-3 input-effect">
							<form:input path="imageVersion" value="11.0.0.0" class="effect-19"
								placeholder="" />
							<label>ivia-config image tag version <b><form:errors cssClass="error" path="imageVersion" /></b></label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

					</fieldset>
					
		<fieldset class="fieldset">
						<legend>
							<h3>Runtime Configuration Container</h3>
						</legend>					
						
						<div class="col-3 input-effect">
							<form:input path="containerBean.appName" value="iviaruntime" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="containerBean.containerName" value="iviaruntimec" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="containerBean.servname" value="iviaruntims" class="effect-19"
								placeholder="" />
							<label>Service Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div>						
						 <div class="col-3 input-effect">
							<form:input path="containerBean.volume" value="iviaruntime" class="effect-19"
								placeholder="" />
							<label>Persistent Volume Name</label> <span class="focus-border"> <i></i>
							</span>
						</div>						
						<div class="col-3 input-effect">
							<form:input path="containerBean.port" value="" class="effect-19" placeholder="" />
							<label>Runtime Port Number </label> <span class="focus-border">
								<i></i>
							</span>
						</div> 

						<div class="col-3 input-effect">
							<form:input path="containerBean.repoUrl" value="icr.io/ivia/ivia-runtime" class="effect-19"
								placeholder="" />
							<label>Runtime repository URL</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

						<div class="col-3 input-effect">
							<form:input path="containerBean.imageVersion" value="11.0.0.0" class="effect-19"
								placeholder="" />
							<label>Runtime image tag version</label> <span
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
</html>