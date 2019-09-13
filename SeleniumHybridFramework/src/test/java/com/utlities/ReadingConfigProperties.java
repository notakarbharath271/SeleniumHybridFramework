package com.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadingConfigProperties {
	
	Properties pro;
	
	public ReadingConfigProperties() {
		File src=new File("./Configuration/config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			pro = new Properties();
			pro.load(fis);
			
		}catch(Exception e) {
			System.out.println("Exception is"+e.getMessage());
		}
	}
	
	public String getApplicationURL() {
		String url= pro.getProperty("baseURL");
		return url;
		
	}
	
	public String getUaseName() {
		String username=pro.getProperty("Username");
		return username;
	}
	
	public String getPassword() {
		String password =pro.getProperty("Pasword");
		return password;
	}
	
	public String getchromepath() {
		String chromepath=pro.getProperty("chromepath");
		return chromepath;
	}
	
	public String getffpath() {
		String ffpath= pro.getProperty("firefoxpath");
		return ffpath;
	}
	
	public String iepath() {
		String iepath=pro.getProperty("iepath");
		return iepath;
	}

}
