package com.ibm.ivia.config.process;
import java.io.File;  // Import the File class
import java.io.FileInputStream;
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.ibm.ivia.config.model.RequestConfig;
import com.ibm.ivia.config.model.ReverseProxyConf;

@Component
public class FileProcessing {
	
	
	private final Logger log = LoggerFactory.getLogger(getClass());

	@Value("${iviaapp.docker.RP}")
	private String dockerRp;
	
	@Value("${iviaaap.envConf}")
	private String envConf;
	
	private String[] sessionObjList = {"lmiConfigModel", "ldapConfigModel","dbConfigModel", "iviaopConfigModel"};  


	
	@Value("${iviaapp.docker.output}")
	private String dockeroutput;

	
	@Value("${iviaapp.docker.template}")
	private String dockerTemplate;

	
	@Value("${iviaapp.common.template}")
	private String commonTemplate;

	  private String getTemplateContent( File myObj) {
		  
		  String data = "";
	    try {

	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	         data = data+myReader.nextLine()+"\n";
	        // log.info(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	    	log.error("An error occurred.");
	      e.printStackTrace();
	    }
		return data;
	  }
	  
	  
 public String updateEnvFileData( HttpSession session) {
    
	 		File myObj = new File(commonTemplate+"env-config-template.sh");
	 		File writeObj = new File(dockeroutput+"/common/env-config.sh");

	 	
	 		String finaldata =  ""+getTemplateContent(myObj);
	 		
	 		List<String> constants=  Arrays.asList(envConf.split(","));
	 		for (String sessionObj : sessionObjList) {
	 			RequestConfig configModel= (RequestConfig)session.getAttribute(sessionObj);	
	 			
	 			log.info("=================["+sessionObj+"]===================="+configModel.toString());
	 			finaldata=replaceContent(configModel,constants,finaldata);
			}   
	    
	    log.info("outputString : "+finaldata);
	    writeFileContent(writeObj,finaldata);
		return finaldata;
	  }
 
 private String replaceContent(RequestConfig requestConfig,List<String> constants,String finaldata) {
	 String outputString=""+finaldata;
	 
	 Field[] allFields = requestConfig.getClass().getDeclaredFields();
	 try {
		
	
     for (String namelabel : constants) {	        	
     	 for (Field variableName : allFields) {	
     		 	if(outputString.contains(variableName.getName())) {
     		 		outputString=outputString+outputString.replace(namelabel, (String)variableName.get(requestConfig) );		
     		 	}        		 	        	
	        }
	        
		}
	 } catch ( IllegalAccessException e) {
		 	e.printStackTrace();
	 }
	 return outputString; 
 }
 
 private void writeFileContent( File myObj,String content) {
	try {  
	 FileWriter myWriter = new FileWriter(myObj);
     myWriter.write(content);
     myWriter.close();
     log.info("Successfully wrote to the file.");
   } catch (IOException e) {
	   log.info("writeFileContent An error occurred.");
     e.printStackTrace();
   }
 }
 public  void zipFolder(Path sourceFolderPath, Path zipPath) throws Exception {
	   ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
	   Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
	       @Override
	       public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
	           zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
	           Files.copy(file, zos);
	           zos.closeEntry();
	           return FileVisitResult.CONTINUE;
	        }
	    });
	    zos.close();
	 }
	
 
 public  void zipDirectory(String zipFileName, String rootDirectoryPath) throws IOException {
     File directoryObject = new File(rootDirectoryPath);
     if (!zipFileName.endsWith(".zip")) {
         zipFileName = zipFileName + ".zip";
     }
     ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
     addDirectory(directoryObject, out);
     out.close();
 }

 private  void addDirectory(File directoryObject, ZipOutputStream out) throws IOException {
     File[] files = directoryObject.listFiles();
     byte[] tmpBuf = new byte[1024];

     for (File file : files) {
         if (file.isDirectory()) {
             addDirectory(file, out);
             continue;
         }
         FileInputStream in = new FileInputStream(file.getAbsolutePath());
         out.putNextEntry(new ZipEntry(file.getAbsolutePath()));
         int len;
         while ((len = in.read(tmpBuf)) > 0) {
             out.write(tmpBuf, 0, len);
         }
         out.closeEntry();
         in.close();
     }
 }
}



