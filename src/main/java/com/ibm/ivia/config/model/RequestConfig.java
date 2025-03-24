package com.ibm.ivia.config.model;

public class RequestConfig {
	public String podname;
	public String hostname;	
	public String domain;
	public String adminpwd;
	public String confpwd;	
	public String containerType;
	public String dbName;
	public String userName;
	public String instName;
	public String seq;
	public String pwdPolicySet;
	public String numCpu;
	public String network;
	
	

	
	
	public ContainerBean containerBean;
	public PasswordPolicy passwordPolicy;
	
	
	public String getPwdPolicySet() {
		return pwdPolicySet;
	}
	public void setPwdPolicySet(String pwdPolicySet) {
		this.pwdPolicySet = pwdPolicySet;
	}


	public PasswordPolicy getPasswordPolicy() {
		return passwordPolicy;
	}
	public void setPasswordPolicy(PasswordPolicy passwordPolicy) {
		this.passwordPolicy = passwordPolicy;
	}
	public ContainerBean getContainerBean() {
		return containerBean;
	}
	public void setContainerBean(ContainerBean containerBean) {
		this.containerBean = containerBean;
	}
	public String getPodname() {
		return podname;
	}
	public void setPodname(String podname) {
		this.podname = podname;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getVlibldap() {
		return vlibldap;
	}
	public void setVlibldap(String vlibldap) {
		this.vlibldap = vlibldap;
	}
	public String getVlibsecauthority() {
		return vlibsecauthority;
	}
	public void setVlibsecauthority(String vlibsecauthority) {
		this.vlibsecauthority = vlibsecauthority;
	}
	public String getVldapslapd() {
		return vldapslapd;
	}
	public void setVldapslapd(String vldapslapd) {
		this.vldapslapd = vldapslapd;
	}
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getAdminpwd() {
		return adminpwd;
	}
	public void setAdminpwd(String adminpwd) {
		this.adminpwd = adminpwd;
	}
	public String getConfpwd() {
		return confpwd;
	}
	public void setConfpwd(String confpwd) {
		this.confpwd = confpwd;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getRepoUrl() {
		return repoUrl;
	}
	public void setRepoUrl(String repoUrl) {
		this.repoUrl = repoUrl;
	}
	public String getImageVersion() {
		return imageVersion;
	}
	public void setImageVersion(String imageVersion) {
		this.imageVersion = imageVersion;
	}
	public String getIpaddress() {
		return ipaddress;
	}
	public void setIpaddress(String ipaddress) {
		this.ipaddress = ipaddress;
	}
	public String getMemorySize() {
		return memorySize;
	}
	public void setMemorySize(String memorySize) {
		this.memorySize = memorySize;
	}
	public String getNumCpu() {
		return numCpu;
	}
	public void setNumCpu(String numCpu) {
		this.numCpu = numCpu;
	}
	public String getNetwork() {
		return network;
	}
	public void setNetwork(String network) {
		this.network = network;
	}
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getContainerType() {
		return containerType;
	}
	public void setContainerType(String containerType) {
		this.containerType = containerType;
	}
	public String getDbName() {
		return dbName;
	}
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
	}
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	
	
	public String servname;
	public String containerName;
	public String appName;	
	public String port;
	public String repoUrl;
	public String imageVersion;
	public String ipaddress;
	public String memorySize;
	public String timezone;
	public String volume;
	public String vlibldap;
	public String vlibsecauthority;
	public String vldapslapd;
	
	public String getServname() {
		return servname;
	}
	public void setServname(String servname) {
		this.servname = servname;
	}
	public String getContainerName() {
		return containerName;
	}
	public void setContainerName(String containerName) {
		this.containerName = containerName;
	}
	public String getAppName() {
		return appName;
	}
	public void setAppName(String appName) {
		this.appName = appName;
	}
	
	@Override
	public String toString() {
		return "RequestConfig [podname=" + podname + ", volume=" + volume + ", vlibldap=" + vlibldap
				+ ", vlibsecauthority=" + vlibsecauthority + ", vldapslapd=" + vldapslapd + ", hostname=" + hostname
				+ ", domain=" + domain + ", adminpwd=" + adminpwd + ", confpwd=" + confpwd + ", port=" + port
				+ ", repoUrl=" + repoUrl + ", imageVersion=" + imageVersion + ", ipaddress=" + ipaddress
				+ ", memorySize=" + memorySize + ", numCpu=" + numCpu + ", network=" + network + ", timezone="
				+ timezone + ", containerType=" + containerType + ", dbName=" + dbName + ", userName=" + userName
				+ ", instName=" + instName + ", seq=" + seq + ", pwdPolicySet=" + pwdPolicySet + ", containerBean="
				+ containerBean + ", passwordPolicy=" + passwordPolicy + ", servname=" + servname + ", containerName="
				+ containerName + ", appName=" + appName + ", getPwdPolicySet()=" + getPwdPolicySet()
				+ ", getPasswordPolicy()=" + getPasswordPolicy() + ", getContainerBean()=" + getContainerBean()
				+ ", getPodname()=" + getPodname() + ", getVolume()=" + getVolume() + ", getVlibldap()=" + getVlibldap()
				+ ", getVlibsecauthority()=" + getVlibsecauthority() + ", getVldapslapd()=" + getVldapslapd()
				+ ", getHostname()=" + getHostname() + ", getDomain()=" + getDomain() + ", getAdminpwd()="
				+ getAdminpwd() + ", getConfpwd()=" + getConfpwd() + ", getPort()=" + getPort() + ", getRepoUrl()="
				+ getRepoUrl() + ", getImageVersion()=" + getImageVersion() + ", getIpaddress()=" + getIpaddress()
				+ ", getMemorySize()=" + getMemorySize() + ", getNumCpu()=" + getNumCpu() + ", getNetwork()="
				+ getNetwork() + ", getTimezone()=" + getTimezone() + ", getContainerType()=" + getContainerType()
				+ ", getDbName()=" + getDbName() + ", getUserName()=" + getUserName() + ", getInstName()="
				+ getInstName() + ", getSeq()=" + getSeq() + ", getServname()=" + getServname()
				+ ", getContainerName()=" + getContainerName() + ", getAppName()=" + getAppName() + ", getClass()="
				+ getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	
	
}