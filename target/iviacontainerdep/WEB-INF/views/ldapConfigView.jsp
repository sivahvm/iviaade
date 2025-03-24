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
<form:form method = "POST" action = "/iviacontainerdep/ldapConfig" commandName="ldapConfigModel">

		<div class="">
			<div class="container">
						<div align="left">
					     	<i style="text-align: center; padding-left: 10px"> <b>	<a class="linnk_button" href='<c:url value="/lmiConfig"/>'>Back</a> </b></i>
					    </div>
				<div class="row bg_2">
					<fieldset class="fieldset">
						<legend>
							<h3>ISVD Configuration Container </h3>
						</legend>
						<div class="col-3 input-effect">
							<form:input path="volume" value="openldapv" class="effect-19"
								placeholder="" />
							<label>ldap Volume Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="vlibldap" value="libldapv" class="effect-19"
								placeholder="" />
							<label>libldap Volume Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="vlibsecauthority" value="libsecauthorityv" class="effect-19"
								placeholder="" />
							<label>libsecauthority Volume Name</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
					<!-- 	<div class="col-3 input-effect">
							<form:input path="vldapslapd" value="ldapslapd" class="effect-19"
								placeholder="" />
							<label>ldapslapd Volume Name</label> <span
								class="focus-border"> <i></i>
							</span>
						</div> -->
						<div class="col-3 input-effect">
							<form:input path="appName" value="openldapa" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="containerName" value="openldapc" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="servname" value="openldaps" class="effect-19"
								placeholder="" />
							<label>Service Name <b><form:errors cssClass="error" path="servname" /></b></label> <span class="focus-border"> <i></i>
							</span>
						</div> 
						<div class="col-3 input-effect">
							<form:input path="memorySize" value="50" class="effect-19"
								placeholder="" />
							<label>Memory Size</label> <span class="focus-border">
								<i></i>
							</span>
						</div>											
						<div class="col-3 input-effect">
							<form:input path="hostname" value="openldap" class="effect-19"
								placeholder="" />
							<label>Hostname Name</label> <span class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="domain" value="ibm.com" class="effect-19"
								placeholder="ibm.com" />
							<label>Domain Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div> 
						<div class="col-3 input-effect">
							<form:input path="port" value="636" class="effect-19" placeholder="" />
							<label>Ldap Port Number </label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="adminpwd" value="Passw0rd" class="effect-19"
								placeholder="" />
							<label>LDAP admin password</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="confpwd" value="Passw0rd" class="effect-19"
								placeholder="" />
							<label>LDAP Config password</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/isva/verify-access-openldap" class="effect-19"
								placeholder="" />
							<label>ivia-config image repository URL</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>

						<div class="col-3 input-effect">
							<form:input path="imageVersion" value="10.0.6.0_IF1" class="effect-19"
								placeholder="" />
							<label>ivia-config image tag version</label> <span
								class="focus-border"> <i></i>
							</span>
						</div>
						<div class="checkboxes-and-radios col-3 input-effect">
							<input type="checkbox" path="pwdPolicySet" name="pwdPolicySet" id="pwdPolicySet" value="0" onclick="showcontent();"/> 
							<label class="labelRadio" for="pwdPolicySet">Password Policy set ?</label>
						</div>
					</fieldset>
					
		<fieldset id="fieldsetpwd" class="fieldsetpwd">
						<legend>
							<h3>Password Policy</h3>
						</legend>					
						
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.lockDuration" value="3600" class="effect-19"
								placeholder="" />
							<label>Lock duration</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.minLenth" value="6" class="effect-19"
								placeholder="" />
							<label>Pwd minimum Length</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.maxFailures" value="5" class="effect-19"
								placeholder="" />
							<label>Maximum failure Length</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.loginAttributeId" value="uid" class="effect-19"
								placeholder="" />
							<label>Login attribute Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.minLower" value="2" class="effect-19"
								placeholder="" />
							<label>Number of lower case</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.minUpper" value="2" class="effect-19"
								placeholder="" />
							<label>Number of upper case</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="passwordPolicy.minSpecial" value="2" class="effect-19"
								placeholder="" />
							<label>Number of Special character </label> <span class="focus-border">
								<i></i>
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