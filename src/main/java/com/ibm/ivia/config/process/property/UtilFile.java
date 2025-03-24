package com.ibm.ivia.config.process.property;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UtilFile{
	//@Value( "${iviaapp.envFileLabel}" )
	private String envFileLabel="__MY_LMI_IP__,__MY_WEB1_IP__,__RUNTIME_VERSION__,__DSC_VERSION__,__ISVA_VERSION__,__LDAP_VERSION__,__DB_VERSION__,__IVIAOP_VERSION__";
	public List<String> getEnvFileLabel() {		
		List<String> wordList = Arrays.asList(envFileLabel.split(","));

		return wordList;
	}
	
	 
    
}
