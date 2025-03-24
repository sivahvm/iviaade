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
						Engine</b></label> <label style="color: #3F91B6"><b> IVIA-OP Container </b></label>
			</div>
			<div class="ibmlog">
				<img src="<c:url value="/resources/css/ibm_resize.png"/>"
					alt="Ibm logo">
			</div>

		</div>
	</div>
	<br>
<body>
<form:form method = "POST" action = "/iviacontainerdep/iviaopConfig" commandName="iviaopConfigModel">
	
	<div class="mahi_holder">
			<div class="container">
						<div align="left">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/reverseProxyList"/>'>Back</a> </b></i>
					    </div>
					    <div align="right">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/preview"/>'>Skip</a> </b></i>
					    </div>
				<div class="row bg_2">
					<fieldset class="fieldset">

						<legend>
							<h3>IVIA-OP Container</h3>
						</legend>
						<div class="col-3 input-effect">
							<form:input path="volume" value="iviaop-config" class="effect-19"
								placeholder="" />
							<label> Persistent Volume Name</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="containerName" value="iviaopc" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
					<div class="col-3 input-effect">
							<form:input path="servname" value="iviaops" class="effect-19"
								placeholder="" />
							<label>Service Name <b><form:errors cssClass="error" path="servname" /></b></label> <span class="focus-border"> <i></i>
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
							<form:input path="appName" value="iviaopa" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						

						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/ivia/ivia-oidc-provider" class="effect-19"
								placeholder="" />
							<label>ivia-config image repository URL</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

						<div class="col-3 input-effect">
							<form:input path="imageVersion" value="24.12" class="effect-19"
								placeholder="" />
							<label>ivia-config image tag version</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
					</fieldset>			
					<fieldset class="fieldset">

						<legend>
							<h3>IVIA DSC Container </h3>
						</legend>

						<div class="col-3 input-effect">
							<form:input path="containerBean.appName" value="iviadsc" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="containerBean.containerName" value="iviadscc" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="containerBean.servname" value="iviadscs" class="effect-19"
								placeholder="" />
							<label>Service Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div>						

					
						<div class="col-3 input-effect">
							<form:input path="containerBean.port" value="9443" class="effect-19" placeholder="" />
							<label>Runtime Port Number </label> <span class="focus-border">
								<i></i>
							</span>
						</div> 
						<div class="col-3 input-effect">
							<form:input path="containerBean.instName" value="1" class="effect-19" placeholder="" />
							<label>Instance </label> <span class="focus-border">
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