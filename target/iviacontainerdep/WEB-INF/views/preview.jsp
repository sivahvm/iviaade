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
						Engine</b></label> <label style="color: #3F91B6"><b> Preview and Download </b></label>
			</div>
			<div class="ibmlog">
				<img src="<c:url value="/resources/css/ibm_resize.png"/>"
					alt="Ibm logo">
			</div>

		</div>
	</div>
	<br>

<div align="left">
     	<i style="text-align: center; padding-left: 10px"> <b>
    <a class="linnk_button" href='<c:url value="/iviaopConfig"/>'>Back</a>    
 		</b></i>
 		<i style="text-align: center; padding-left: 10px"> <b>
	<a class="linnk_button" href='<c:url value="/index"/>'>Home</a>
 		</b></i>
    </div>

	<div align="right">
	
	<form:form method="GET" action="/iviacontainerdep/executeConfig"
					commandName="rplistconf">
<div id="submitbottonid">
			<input type="submit" id="submit_button"  class="button-click" value="Deploy and Test" />
		</div>
				</form:form>
				

	</div>	

	<table>
  <tr style="text-align: center">
    <td colspan="3" ><b>IVIA Repo Configuration</b> </td> 
 </tr>
 
  <tr>
    <th>Pod Name</th>
    <th>Repo URL</th>
    <th>Tag Version</th>
  </tr>

  <tr>
    <td><c:out value="${sessionScope.lmiConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.imageVersion }" /> </td>
  </tr>
   <tr>
    <td><c:out value="${sessionScope.lmiConfigModel.containerBean.containerName }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.containerBean.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.containerBean.imageVersion }" /> </td>
  </tr>
   <tr>
    <td><c:out value="${sessionScope.ldapConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.imageVersion }" /> </td>
  </tr>
   <tr>
    <td><c:out value="${sessionScope.dbConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.imageVersion }" /> </td>
  </tr>
   <tr>
    <td>Reverse Proxy  </td>
    <td><c:out value="${sessionScope.rpListConf.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.rpListConf.imageVersion }" /> </td>
  </tr>
  
   <tr>
    <td><c:out value="${sessionScope.iviaopConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.iviaopConfigModel.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.iviaopConfigModel.imageVersion }" /> </td>
  </tr>
   <tr>
    <td><c:out value="${sessionScope.iviaopConfigModel.containerBean.containerName }" /> </td>
    <td><c:out value="${sessionScope.iviaopConfigModel.containerBean.repoUrl }" /> </td>
    <td><c:out value="${sessionScope.iviaopConfigModel.containerBean.imageVersion }" /> </td>
  </tr>
</table>
<table>
 <tr style="text-align: center">
    <td colspan="8" align="center"><b><c:out value="Persistent Volume  and network Details" /></b></td> 
 </tr>
 
  <tr>
  	<th>Name : </th>
  	<th>Time Zone </th>
    <th>iviaconfig </th>
    <th>libldap</th>
    <th>libsecauthority</th>
    <th>ldapslapd</th>
    <th>pgdata</th>

  </tr>

  <tr>
  	<td><c:out value="Value: " /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.timezone }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.volume }" /> </td>    
    <td><c:out value="${sessionScope.ldapConfigModel.vlibldap }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.vlibsecauthority }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.volume }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.volume }" /> </td>
  </tr>
 
</table>

<table>
 <tr style="text-align: center">
    <td colspan="4" align="center"><b><c:out value="  LMI Configuration: ${sessionScope.lmiConfigModel.hostname } " /></b></td> 
 </tr>
 
  <tr>
   <th>Container Name</th>
    <th>Port Number</th>
    <th>User Name</th>
    <th>Password</th>
  </tr>

  <tr>
    <td><c:out value="${sessionScope.lmiConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.lmiConfigModel.port }" /> </td>
    <td><c:out value="admin" /> </td>
    <td><c:out value="******" /> </td>
  </tr>
  
</table>

<table>
 <tr style="text-align: center">
    <td colspan="6" align="center"><b><c:out value=" LDAP Configuration :  ${sessionScope.ldapConfigModel.podname } " /></b></td> 
 </tr>
 
  <tr>
    <th>Container Name</th>
    <th>port</th>
    <th>Domain Name</th>
    <th>Config User Password</th>
    <th>Admin User Password</th>
   

  </tr>

  <tr>
    <td><c:out value="${sessionScope.ldapConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.port }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.domain }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.confpwd }" /> </td>
    <td><c:out value="${sessionScope.ldapConfigModel.adminpwd }" /> </td>   
 
  </tr>
 
</table>

<table>
 <tr style="text-align: center">
     <td colspan="4" align="center"><b><c:out value=" DB Configuration :  ${sessionScope.dbConfigModel.hostname } " /></b></td> 
 
 </tr>
 
  <tr>
    <th>Container Name</th>
    <th>DB Name</th>
    <th>Instance</th>
    <th>Port </th>

  </tr>

  <tr>
    <td><c:out value="${sessionScope.dbConfigModel.containerName }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.dbName }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.userName }" /> </td>
    <td><c:out value="${sessionScope.dbConfigModel.adminpwd }" /> </td>
 
  </tr>
 
</table>

<table>
 <tr style="text-align: center">
     <td colspan="5" align="center"><b><c:out value=" RP Configuration  :" /></b></td> 
 
 </tr>
 
  <tr>
									<th>AppName</th>
									<th>Servname</th>			
									<th>Hostname</th>							
									<th>Port Num</th>
									<th>Instance Name</th>
	</tr>
  
  <c:forEach var="item" items="${sessionScope.rpListConf.rpConf}" varStatus="status" >   
   <tr>  
										<td><c:out value="${item.appName }" /></td>
										<td><c:out value="${item.hostname }" /></td>
										<td><c:out value="${item.servname }" /></td>
										<td><c:out value="${item.port }" /></td>
										<td><c:out value="${item.instName }" /></td>
    </tr>
   
</c:forEach>
 <!--   <tr>  
    <td><c:out value="${sessionScope.iviaconf.iviaophostname }" /> </td>
    <td><c:out value="${sessionScope.iviaconf.iviaopinstance }" /> </td> 
  </tr>  
  <tr> <td colspan="2"><hr></td></tr>
  <tr>  
    <td><c:out value="${sessionScope.iviaconf.runtimepodlabel }" /> </td>
    <td><c:out value="" /></td> 
  </tr>
  
  
    <tr> <td colspan="2"><hr></td></tr>
  <tr>  
    <td><c:out value="${sessionScope.iviaconf.dsclabel }" /> </td>
    <td><c:out value="${sessionScope.iviaconf.dscinstance }" /> </td> 
  </tr>
 -->
  </table>
  <br><br>
  				<form:form method="GET" action="/iviacontainerdep/getConfig"
					commandName="rplistconf">
<div id="submitbottonid">
			<input type="submit" id="submit_button"  class="button-click" value="Download" />
		</div>
				</form:form>
		
<br>
	

</body>
</html>

