package com.ibm.ivia.config.model;

public class RequestConfigRuntime {
	private String podname;
	private String volume;
	private String hostname;	
	private String port;
	private String repoUrl;
	private String imageVersion;
	private String ipaddress;
	private String memorySize;
	private String numCpu;
	private String timezone;
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
	
	
	
}