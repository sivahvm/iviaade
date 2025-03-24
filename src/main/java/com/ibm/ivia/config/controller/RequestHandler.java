package com.ibm.ivia.config.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ibm.ivia.config.model.ConfigValidator;
import com.ibm.ivia.config.model.RequestConfig;
import com.ibm.ivia.config.model.ReverseProxyConf;
import com.ibm.ivia.config.process.ExecuteCommandProcess;
import com.ibm.ivia.config.process.FileProcessing;
import com.ibm.ivia.config.process.PrepareFiles;
import com.ibm.ivia.config.user.UserValidator;

@Controller
public class RequestHandler {
	private final Logger log = LoggerFactory.getLogger(getClass());

	private Validator validator = new UserValidator();
	private ConfigValidator confvalidator = new ConfigValidator();
	private static final int BUFFER_SIZE = 4096;

	@Value("${iviaapp.docker.zipLPath}")
	private String dockerZipPath;
	@Value("${iviaapp.minikube.input}")
	private String minikubeinput;
	
	@Value("${iviaapp.minikube.output}")
	private String minikubeoutput;
	
	@Value("${iviaapp.docker.output}")
	private String dockeroutput;
	@Autowired
	FileProcessing fileupdate;
	@Autowired
	PrepareFiles prepareFiles;
	
	  String regress="";
	
	  @Autowired
	  private ExecuteCommandProcess  executeCommandProcess;

	@RequestMapping(value={"/lmiConfig"}, method=RequestMethod.GET)
	public String getForm(Model m) {
		log.info("Calling IVIA Lmi view()");
		m.addAttribute("requestConfig", new RequestConfig());		

		return "iviaConfigView";
	}
	
	@RequestMapping(value={"/index"}, method=RequestMethod.GET)
	public String getiviaindex(Model m) {
		log.info("Calling IVIA Index view()");

		return "index";
	}
	
	/**
	 * Process the form submission.
	 * 
	 * @param u user object that was filled out on the form page
	 * @param result handles error messages to send back to the view, if necessary
	 * @param m spring-injected model object that gets filled and sent togenConf the view
	 * @return the view to display
	 */
	@RequestMapping(value="/lmiConfig", method=RequestMethod.POST)
	public String processLmiConf(@ModelAttribute("lmiConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling IVIA Lmi Post ()");
		HttpSession session = request.getSession();
		session.setAttribute("lmiConfigModel", conf);
		/*
		 * confvalidator.validate(conf, result); if (result.hasErrors()) { // error
		 * occured, lets send them back to the form to re-enter their information return
		 * "commonconfpage"; }
		 */
		confvalidator.validateLmi(conf, result);
		if (result.hasErrors()) {
			//\\ error occured, lets send them back to the form to re-enter their information
			m.addAttribute("requestConfig", new RequestConfig());		
			return "iviaConfigView";
		}

		log.info("LMI Conf" + ((RequestConfig) session.getAttribute("lmiConfigModel")).toString());
		m.addAttribute("ldapConfigModel", new RequestConfig());
		RequestConfig requestConfig = (RequestConfig) session.getAttribute("lmiConfigModel");
		File deploy = new File(minikubeinput+"configDeployment.yml");
		File runrimeDep = new File(minikubeinput+"runtimeDeployment.yml");
		prepareFiles.updateEnvFileData(session,runrimeDep,requestConfig,deploy,"config","runtime");

		return "ldapConfigView";
	}
	
	
	@RequestMapping(value="/ldapConfig", method=RequestMethod.GET)
	public String getLdapConf(Model m) {
		log.info("Calling IVIA ldap view()");
		m.addAttribute("ldapConfigModel", new RequestConfig());	
		return "ldapConfigView";
	}
	
	/**
	 * Process the form submission.
	 * 
	 * @param u user object that was filled out on the form page
	 * @param result handles error messages to send back to the view, if necessary
	 * @param m spring-injected model object that gets filled and sent togenConf the view
	 * @return the view to display
	 */
	@RequestMapping(value="/ldapConfig", method=RequestMethod.POST)
	public String processLdapconf(@ModelAttribute("ldapConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling LDAP Lmi Post ()");
		HttpSession session = request.getSession();
		session.setAttribute("ldapConfigModel", conf);
		/*
		 * confvalidator.validate(conf, result); if (result.hasErrors()) { // error
		 * occured, lets send them back to the form to re-enter their information return
		 * "commonconfpage"; }
		 */
		log.info("LDAP Conf" + ((RequestConfig) session.getAttribute("ldapConfigModel")).toString());
		RequestConfig requestConfig = (RequestConfig) session.getAttribute("ldapConfigModel");
		File deploy = new File(minikubeinput+"ldpDeployment.yml");

		//prepareFiles.updateEnvFileData(session,null,requestConfig,deploy);
		prepareFiles.updateEnvFileData(session,null,requestConfig,deploy,"ldap",null);

		//prepareFiles.writeFileContent();
		m.addAttribute("dbConfigModel", new RequestConfig());
		return "dbConfigView";
	}
	
	@RequestMapping(value="/dbConfig", method=RequestMethod.GET)
	public String getDBConf(Model m) {
		log.info("Calling IVIA DB view()");
		m.addAttribute("dbConfigModel", new RequestConfig());	
		return "dbConfigView";
	}
	
	/**
	 * Process the form submission.
	 * 
	 * @param u user object that was filled out on the form page
	 * @param result handles error messages to send back to the view, if necessary
	 * @param m spring-injected model object that gets filled and sent togenConf the view
	 * @return the view to display
	 */
	@RequestMapping(value="/dbConfig", method=RequestMethod.POST)
	public String processDBconf(@ModelAttribute("dbConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling DB  Post ()");
		HttpSession session = request.getSession();
		session.setAttribute("dbConfigModel", conf);
		/*
		 * confvalidator.validate(conf, result); if (result.hasErrors()) { // error
		 * occured, lets send them back to the form to re-enter their information return
		 * "commonconfpage"; }
		 */

		log.info("DB Conf" + ((RequestConfig) session.getAttribute("dbConfigModel")).toString());
		
		File deploy = new File(minikubeinput+"dbDeployment.yml");
		RequestConfig requestConfig = (RequestConfig) session.getAttribute("dbConfigModel");
	//	prepareFiles.updateEnvFileData(session,null,requestConfig,deploy);
		prepareFiles.updateEnvFileData(session,null,requestConfig,deploy,"db",null);
		m.addAttribute("rpConfigModel", new RequestConfig());
		m.addAttribute("rplistconf", new ReverseProxyConf());
		
		 List<RequestConfig> listObj=( List<RequestConfig>)session.getAttribute("listObj");		 
		 if(listObj==null || listObj.size()==0 ) {
			 session.setAttribute("rpCount", "1");
		 }else {
			 session.setAttribute("rpCount", listObj.size());
		 }
		return "reverseProxyView";
	}
	
	
	@RequestMapping(value="/reverseProxyList", method=RequestMethod.GET)
	public String reverseProxyList(Model m,HttpServletRequest request) {
		log.info("Calling ldapconfpage()");
		// lets add a user object to the model so the form can fill it
		m.addAttribute("rpConfigModel", new RequestConfig());		
		m.addAttribute("rplistconf", new ReverseProxyConf());
		HttpSession session = request.getSession();
		 List<RequestConfig> listObj=( List<RequestConfig>)session.getAttribute("listObj");		 
		 if(listObj==null || listObj.size()==0 ) {
			 session.setAttribute("rpCount", "1");
		 }else {
			 session.setAttribute("rpCount", listObj.size());
		 }
			
		return "reverseProxyView";
	}

	@RequestMapping(value="/addReverseProxy", method=RequestMethod.POST)
	public String addReveseProxr(@ModelAttribute("rpConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling addReverseProxy()");
		 HttpSession session = request.getSession();
		 List<RequestConfig> listObj=( List<RequestConfig>)session.getAttribute("listObj");		 
		if(listObj==null || listObj.size()==0 ) {
			listObj=new ArrayList<RequestConfig>();
			listObj.add(conf);
		    session.setAttribute("listObj", listObj);		   	 
		}else {	
		    listObj.add(conf);
		    session.setAttribute("listObj", listObj);		   
		}
		//confvalidator.validate(conf, result);
		//if (result.hasErrors()) {
			// error occured, lets send them back to the form to re-enter their information
		//	return "commonconfpage";
		//}
		 session.setAttribute("rpCount", listObj.size()+1);
		log.info("listObj "+((List<RequestConfig>)session.getAttribute("listObj")).toString());
		m.addAttribute("rpConfigModel", new RequestConfig());
		m.addAttribute("rplistconf", new ReverseProxyConf());
		return "reverseProxyView";
	}
	
	@RequestMapping(value="/reverseProxyList", method=RequestMethod.POST)
	public String commonConf(@ModelAttribute("reverseProxyListObj") ReverseProxyConf rpListConf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling ldapConf()");
		 HttpSession session = request.getSession();
		 rpListConf.setRpConf(((List<RequestConfig>)session.getAttribute("listObj"))); 
	    session.setAttribute("rpListConf", rpListConf);
		//confvalidator.validate(conf, result);
		//if (result.hasErrors()) {
			// error occured, lets send them back to the form to re-enter their information
		//	return "commonconfpage";
		//}
		
	    File deploy = new File(minikubeinput+"rpDeployment.yml");
	    ReverseProxyConf requestproxyConfig = (ReverseProxyConf) session.getAttribute("rpListConf");
	  
	    for (RequestConfig requestConfig : requestproxyConfig.getRpConf()) {
			//prepareFiles.updateEnvFileData(session,null,requestConfig,deploy);
			
			prepareFiles.updateEnvFileData(session,null,requestConfig,deploy,"rp",null);
			regress=regress+requestConfig.getAppName()+",";

		}
		
		log.info("rpListConf "+((ReverseProxyConf)session.getAttribute("rpListConf")).toString());
		m.addAttribute("iviaopConfigModel", new RequestConfig());	
		return "iviaopConfigView";
	}
	
	@RequestMapping(value="/iviaopConfig", method=RequestMethod.GET)
	public String getiviaopConf(Model m) {
		log.info("Calling IVIAOP view()");
		m.addAttribute("iviaopConfigModel", new RequestConfig());	
		return "iviaopConfigView";
	}
	
	/**
	 * Process the form submission.
	 * 
	 * @param u user object that was filled out on the form page
	 * @param result handles error messages to send back to the view, if necessary
	 * @param m spring-injected model object that gets filled and sent togenConf the view
	 * @return the view to display
	 */
	@RequestMapping(value="/iviaopConfig", method=RequestMethod.POST)
	public String processiviaopconf(@ModelAttribute("iviaopConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling iviaop  Post ()");
		HttpSession session = request.getSession();
		session.setAttribute("iviaopConfigModel", conf);
		
		
		/*
		 * confvalidator.validate(conf, result); if (result.hasErrors()) { // error
		 * occured, lets send them back to the form to re-enter their information return
		 * "commonconfpage"; }
		 */

		log.info("iviaop Conf" + ((RequestConfig) session.getAttribute("iviaopConfigModel")).toString());
		
		RequestConfig requestConfig = (RequestConfig) session.getAttribute("iviaopConfigModel");
		File deploy = new File(minikubeinput+"iviaopDeployment.yml");
		File dsc = new File(minikubeinput+"iviadscDeployment.yml");
		//prepareFiles.updateEnvFileData(session,dsc,requestConfig,deploy);
		prepareFiles.updateEnvFileData(session,dsc,requestConfig,deploy,"iviaop","dsc");

		
		m.addAttribute("iviaopConfigModel", new RequestConfig());	
		return "preview";
	}
	
	
	@RequestMapping(value="/preview", method=RequestMethod.GET)
	public String preview(@ModelAttribute("iviaopConfigModel") RequestConfig conf, BindingResult result, Model m,HttpServletRequest request) {
		log.info("Calling iviaop  Post ()");
		
		return "preview";
	}
	
	@RequestMapping(value="/executeConfig", method=RequestMethod.GET)
	public void executeConfig(Model m,HttpSession sesion,HttpServletRequest request,            HttpServletResponse response) throws Exception {
		log.info("executeConfig commonconfpage()");
		
		
		List<String> commands=new  ArrayList<String>(); 
		
		commands.add(" start --driver=docker --network minikube");
		commands.add(minikubeoutput+"/create-secrets.sh");
		commands.add(minikubeoutput+"/ivia-minikube.yaml");		
		executeCommandProcess.execCmd("dir");
		}
	
	@RequestMapping(value="/getConfig", method=RequestMethod.GET)
	public void createConfig(Model m,HttpSession sesion,HttpServletRequest request,            HttpServletResponse response) throws Exception {
		log.info("Update env File commonconfpage()");
		String fileName=minikubeoutput+"ivia-minikube.yml";
		prepareFiles.writeFileContent(fileName);
		
		prepareFiles.writeFileCleanContent(minikubeoutput+"cleanup.sh",regress);
		
	
		log.info("Update env File commonconfpage()");
		//fileupdate.updateEnvFileData(sesion);		
		Path sourcepath = (Path)Paths.get(dockeroutput);
		String dockerZipName=dockeroutput+"iviaDeployment"+getCurrentTime()+".zip";
		Path destpath = (Path)Paths.get(dockerZipName);
		fileupdate.zipFolder(sourcepath,destpath);	
        File downloadFile = new File(dockerZipName);
        FileInputStream inputStream = new FileInputStream(downloadFile);
         
        // get MIME type of the file
        String mimeType = null;
        if (mimeType == null) {
            // set to binary type if MIME mapping not found
            mimeType = "application/octet-stream";
        }
        System.out.println("MIME type: " + mimeType);
 
        // set content attributes for the response
        response.setContentType(mimeType);
        response.setContentLength((int) downloadFile.length());
 
        // set headers for the response
        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);
 
        // get output stream of the response
        OutputStream outStream = response.getOutputStream();
 
        byte[] buffer = new byte[BUFFER_SIZE];
        int bytesRead = -1;
 
        // write bytes read from the input stream into the output stream
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outStream.write(buffer, 0, bytesRead);
        }
 
        inputStream.close();
        outStream.close();
	
	}
	
	private String getCurrentTime() {
		SimpleDateFormat ft     = new SimpleDateFormat("dd-MM-yyyy_hh_mm_ss"); 

    String str = ft.format(new Date()); 

    // Printing the formatted date 
    System.out.println("Formatted Date : " + str);
    return str;
	}
}
