package com.crm.GenericLibrary;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This class is having generic methods used to read data from property file
 * @author romeo
 *
 */
public class FileUtility {
	public String readDataFromPropertyFile(String key) throws IOException {
	
	FileInputStream fis=new FileInputStream(IpathConstants.FilePath);
	Properties p=new Properties();
	p.load(fis);
	String data = p.getProperty(key);
	return data;
	

}
}