package com.ibm.ivia.config.model;

public class ContainerBean {
	private String podname;
	private String hostname;	
	private String numCpu;	
	private String instName;
	
	
	
	
	
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
	public String getHostname() {
		return hostname;
	}
	public void setHostname(String hostname) {
		this.hostname = hostname;
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
	public String getTimezone() {
		return timezone;
	}
	public void setTimezone(String timezone) {
		this.timezone = timezone;
	}
	public String getInstName() {
		return instName;
	}
	public void setInstName(String instName) {
		this.instName = instName;
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
		return "ContainerBean [podname=" + podname + ", hostname=" + hostname + ", numCpu=" + numCpu + ", instName="
				+ instName + ", servname=" + servname + ", containerName=" + containerName + ", appName=" + appName
				+ ", port=" + port + ", repoUrl=" + repoUrl + ", imageVersion=" + imageVersion + ", ipaddress="
				+ ipaddress + ", memorySize=" + memorySize + ", timezone=" + timezone + ", volume=" + volume + "]";
	}
	
	
}