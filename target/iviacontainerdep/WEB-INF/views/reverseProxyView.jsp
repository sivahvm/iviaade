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

	<div class="mahi_holder">
		<div class="container">
			<div align="left">
				<i style="text-align: center; padding-left: 10px"> <b> <a
						class="linnk_button" href='<c:url value="dbConfig"/>'>Back</a>
				</b></i>
			</div>
			<div class="row bg_2">
				<form:form method="POST" action="/iviacontainerdep/addReverseProxy"
					commandName="rpConfigModel">

					<fieldset class="fieldset">

						<legend>
							<h3>Proxy Containers</h3>
						</legend>

						
						<div class="col-3 input-effect">
							<form:input path="appName" value="iviawrprp1" class="effect-19"
								placeholder="" />
							<label>Application Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						
						<div class="col-3 input-effect">
							<form:input path="containerName" value="iviawrprp1c" class="effect-19"
								placeholder="" />
							<label>Container Name</label> <span class="focus-border">
								<i></i>
							</span>
						</div>
					<div class="col-3 input-effect">
							<form:input path="servname" value="iviawrprp1s" class="effect-19"
								placeholder="" />
							<label>Service Name <b><form:errors cssClass="error" path="servname" /></b></label> <span class="focus-border"> <i></i>
							</span>
						</div> 
						<div class="col-3 input-effect">
							<form:input path="port" value="30443" class="effect-19" placeholder="" />
							<label>Port Number </label> <span class="focus-border"> <i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="instName" value="rp1" class="effect-19"
								placeholder="" />
							<label>Instance Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="hostname" value="www.iamlab.ibm.com" class="effect-19"
								placeholder="" />
							<label>Hostname Name </label> <span class="focus-border">
								<i></i>
							</span>
						</div>
						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/ivia/ivia-wrp" class="effect-19"
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
					
						<div id="submitbottonid">
							<input type="submit" id="submit_button" class="button-click"
								value="Save and Add" />
						</div>


					</fieldset>
				</form:form>
				<form:form method="POST" action="/iviacontainerdep/reverseProxyList"
					commandName="rplistconf">

					<fieldset class="fieldset">

						<legend>
							<h3>IVIA Reverse Proxy Configuration Container</h3>
						</legend>

						<div class="col-3 input-effect">
							<form:input path="repoUrl" value="icr.io/ivia/ivia-wrp" class="effect-19"
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
						<br>


						<div class="col-1 input-effect"> 
							<table>
									<th>AppName</th>
									<th>Hostname</th>									
									<th>Servname</th>									
									<th>Port Num</th>
									<th>Instance Name</th>
								</tr>


								<c:forEach var="item" items="${sessionScope.listObj}"
									varStatus="status">
									<tr>
										<td><c:out value="${item.appName }" /></td>
										<td><c:out value="${item.hostname }" /></td>										
										<td><c:out value="${item.servname }" /></td>
										<td><c:out value="${item.port }" /></td>
										<td><c:out value="${item.instName }" /></td>
									</tr>
									<c:if test="${status.last}">
										<tr>
											<td colspan="5" align="center">
								<div id="submitbottonid">
								<input type="submit" id="submit_button" class="button-click" value="Save Config and Next" />
								</div>
						</td>
										</tr>
									</c:if>
								</c:forEach>

							</table>
							</div>
					</fieldset>
				</form:form>
			</div>
		</div>
	</div>
	</html>
</body>
</html>