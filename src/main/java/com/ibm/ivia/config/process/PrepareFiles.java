package com.ibm.ivia.config.process;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ibm.ivia.config.model.ContainerBean;
import com.ibm.ivia.config.model.RequestConfig;

@Component
public class PrepareFiles {

	private final Logger log = LoggerFactory.getLogger(getClass());

	public static String timeZone = "";
	public static String configstorage = "";
	public static String configService = "";
	public static String configPort = "";
	
	List <String> serv=new ArrayList<String>();
	List <String> dep=new ArrayList<String>();
	List <String> pvc=new ArrayList<String>();

	public Map<String,String> outputContent=new HashMap<String,String>(); 

	@Value("${iviaapp.common.template}")
	private String commonTemplate;

	private String getTemplateContent(File myObj) {

		String data = "";
		try {

			Scanner myReader = new Scanner(myObj);
			while (myReader.hasNextLine()) {
				data = data + myReader.nextLine() + "\n";
				// log.info(data);
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			log.error("An error occurred.");
			e.printStackTrace();
		}
		return data;
	}

	public void updateEnvFileData(HttpSession session, File subdeploy,RequestConfig requestConfig,File deploy,String keyName,String nextKey) {

	
		//File service = new File("C:/siva_ivia/ref/service.yml");
		//File storagefile = new File("C:/siva_ivia/ref/PersistentVolumeClaim.yml");


		String deployment = "" + getTemplateContent(deploy);
		//String serv = "" + getTemplateContent(service);
		//String storage = "" + getTemplateContent(storagefile);

		String fileLabel = "__vname__,__confsname__,__confvport__,__aname__,__cname__,__REP__,__V__,__TIME__,__port__,__sname__,__MEM__,__CSNAME__,__CSDNAME__,__CSPORT__,__ldaplib__,__ldapsecauthority__,__domain__,__admpwd__,__configpwd__,__uname__,__dbname__,__instance__,__hostname__,__confvname__";
		List<String> constants = Arrays.asList(fileLabel.split(","));
		
		
		//String outserv = getData(constants, serv, requestConfig);

	//	yamlString =yamlString+ "---\n" + outstorage + "---\n" + outdeployment + "---\n" + outserv;
		// writeFileContent(writeObj,yamlString);
		String outstorage = getData(constants, deployment, requestConfig);		
	//	writeFileContent(outstorage);
		outputContent.put(keyName, outstorage);

		if (null!= nextKey && null != subdeploy && subdeploy.isFile()) {
			deployment = "" + getTemplateContent(subdeploy);
			ContainerBean containerBean = requestConfig.getContainerBean();
			 outstorage= getContainerData(constants, deployment, containerBean);
		//	writeFileContent(outstorage);
			outputContent.put(nextKey, outstorage);
		}

	

	}

	public void writeFileContent(String filename) {
		try {
			
			List<String> list=new ArrayList<String>();
			list.add("ldap");
			list.add("db");
			list.add("config");
			list.add("rp");
			list.add("runtime");
			list.add("dsc");
			list.add("iviaop");

			
			BufferedWriter out = new BufferedWriter( new FileWriter(filename));
			for (String key : list) {
				if(outputContent.containsKey(key)) {

					out.write(outputContent.get(key));
				}
			}
			//out.write(outputContent.get());
			 // Closing the connection
	            out.close();
			log.info("Successfully wrote to the file.");
		} catch (IOException e) {
			log.info("writeFileContent An error occurred.");
			e.printStackTrace();
		}
	}

	public void writeFileCleanContent(String filename,String ingress) {
		try {
			
	

			
			BufferedWriter out = new BufferedWriter( new FileWriter(filename));
			for (String key : dep) {
					out.write("kubectl delete deploy "+key);
					out.newLine();
				}
			for (String key : serv) {
				out.write("kubectl delete service "+key);
				out.newLine();
			}
			for (String key : pvc) {
				if(null!=key) {
					out.write("kubectl delete pvc "+key);
					out.newLine();
				}
			}			
			List<String> constants = Arrays.asList(ingress.split(","));
			for (String key : constants) {
				out.write("kubectl delete ingress "+key);
				out.newLine();
			}
			//out.write(outputContent.get());
			 // Closing the connection
	            out.close();
			log.info("Successfully wrote to the file.");
		} catch (IOException e) {
			log.info("writeFileContent An error occurred.");
			e.printStackTrace();
		}
	}
	public String getData(List<String> constants, String finaledata, RequestConfig requestConfig) {
		try {
			for (String key : constants) {

				switch (key) {
				case "__aname__":
					finaledata = finaledata.replace("__aname__", null!=requestConfig.getAppName()?requestConfig.getAppName():"");
					dep.add(requestConfig.getAppName());
					break;
				case "__vname__":
					finaledata = finaledata.replace("__vname__", null!=requestConfig.getVolume()?requestConfig.getVolume():"");
					pvc.add(requestConfig.getVolume());
					break;
				case "__confvname__":
					//finaledata = finaledata.replace("__confvname__", ("".equals(configstorage) && null!=requestConfig.getVolume())?requestConfig.getVolume():"");
					if("".equals(configstorage) && null!=requestConfig.getVolume()) {
						configstorage = requestConfig.getVolume();
					}
					break;
				case "__confsname__":
					//finaledata = finaledata.replace("__confsname__", ("".equals(configService) && null!=requestConfig.getServname())?requestConfig.getServname():"");
					if("".equals(configService) && null!=requestConfig.getServname()) {
						configService = requestConfig.getServname();
					}
					break;					
				case "__confvport__":
					//finaledata = finaledata.replace("__confvport__",("".equals(configPort) && null!=requestConfig.getPort())?requestConfig.getPort():"");
					if("".equals(configPort) && null!=requestConfig.getPort()) {
						configPort = requestConfig.getPort();
					}
					
				case "__cname__":
					finaledata = finaledata.replace("__cname__", null!=requestConfig.getContainerName()?requestConfig.getContainerName():"");
					break;
				case "__REP__":
					finaledata = finaledata.replace("__REP__", null!=requestConfig.getRepoUrl()?requestConfig.getRepoUrl():"");
					break;
				case "__V__":
					finaledata = finaledata.replace("__V__", null!=requestConfig.getImageVersion()?requestConfig.getImageVersion():"");
					break;
				
				case "__port__":
					finaledata = finaledata.replace("__port__", null!=requestConfig.getPort()?requestConfig.getPort():"");
					break;
				case "__sname__":
					finaledata = finaledata.replace("__sname__", null!=requestConfig.getServname()?requestConfig.getServname():"");
					serv.add(requestConfig.getServname());
					break;
				case "__MEM__":
					finaledata = finaledata.replace("__MEM__", null!=requestConfig.getMemorySize()?requestConfig.getMemorySize():"");
					break;
				case "__ldaplib__":
					finaledata = finaledata.replace("__ldaplib__", null!=requestConfig.getVlibldap()?requestConfig.getVlibldap():"");
					pvc.add(requestConfig.getVlibldap());

					break;
					
				case "__ldapsecauthority__":
					finaledata = finaledata.replace("__ldapsecauthority__", null!=requestConfig.getVlibsecauthority()?requestConfig.getVlibsecauthority():"");
					pvc.add(requestConfig.getVlibsecauthority());
					break;
					
				case "__admpwd__":
					finaledata = finaledata.replace("__admpwd__", null!=requestConfig.getAdminpwd()?requestConfig.getAdminpwd():"");
					break;
					
				case "__configpwd__":
					finaledata = finaledata.replace("__configpwd__", null!=requestConfig.getConfpwd()?requestConfig.getConfpwd():"");
					break;
					
				case "__domain__":
					finaledata = finaledata.replace("__domain__",null!= requestConfig.getDomain()?requestConfig.getDomain():"");
					break;

				case "__dbname__":
					finaledata = finaledata.replace("__dbname__", null!=requestConfig.getDbName()?requestConfig.getDbName():"");
					break;
					
				case "__uname__":
					finaledata = finaledata.replace("__uname__", null!=requestConfig.getUserName()?requestConfig.getUserName():"");
					break;
					
				case "__instance__":
					finaledata = finaledata.replace("__instance__", null!=requestConfig.getInstName()?requestConfig.getInstName():"");
					break;
				case "__hostname__":
					finaledata = finaledata.replace("__hostname__", null!=requestConfig.getHostname()?requestConfig.getHostname():"");
					break;
					
				default:
					break;
				}
				if(null!=requestConfig.getTimezone()){
					finaledata = finaledata.replace("__TIME__", requestConfig.getTimezone());
					timeZone = requestConfig.getTimezone();
				}
				/*if(null!=requestConfig.getTimezone()){
					timeZone = requestConfig.getTimezone();
				}
				if(null!=requestConfig.getTimezone()){
					timeZone = requestConfig.getTimezone();
				}
				if(null!=requestConfig.getTimezone()){
					timeZone = requestConfig.getTimezone();
				}*/
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		//log.info("finaledata : " + finaledata);
		//
		finaledata=getDependancy(constants, finaledata);
		return finaledata;
	}

	public String getDependancy(List<String> constants, String finaledata) {

		for (String key : constants) {

			switch (key) {

			case "__confvname__":
				finaledata = finaledata.replace("__confvname__", configstorage);
				break;

			case "__TIME__":
				finaledata = finaledata.replace("__TIME__", timeZone);
				break;

			case "__confsname__":
				finaledata = finaledata.replace("__confsname__", configService);
				break;

			case "__confvport__":
				finaledata = finaledata.replace("__confvport__", configPort);
				break;

		
				
			default:
				break;
			}

			//log.info("finaledata : " + finaledata);
		}
		return finaledata;
	}

	public String getContainerData(List<String> constants, String finaledata, ContainerBean containerBean) {
		try {
			for (String key : constants) {

				switch (key) {
				case "__aname__":
					finaledata = finaledata.replace("__aname__", null!=containerBean.getAppName()?containerBean.getAppName():"");
					dep.add(containerBean.getAppName());
					break;
				case "__vname__":
					finaledata = finaledata.replace("__vname__", configstorage);
					break;
				case "__cname__":
					finaledata = finaledata.replace("__cname__", null!=containerBean.getContainerName()?containerBean.getContainerName():"");
					break;
				case "__REP__":
					finaledata = finaledata.replace("__REP__", null!=containerBean.getRepoUrl()?containerBean.getRepoUrl():"");
					break;
				case "__V__":
					finaledata = finaledata.replace("__V__", null!=containerBean.getImageVersion()?containerBean.getImageVersion():"");
					break;
				case "__TIME__":
					finaledata = finaledata.replace("__TIME__", timeZone);
					break;
				case "__port__":
					finaledata = finaledata.replace("__port__", null!=containerBean.getPort()?containerBean.getPort():"");
					break;
				case "__sname__":
					finaledata = finaledata.replace("__sname__", null!=containerBean.getServname()?containerBean.getServname():"");
					serv.add(containerBean.getServname());
					break;

				}

			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		//log.info("finaledata : " + finaledata);
		//
		finaledata=getDependancy(constants, finaledata);
		return finaledata;
	}
	
}
