package com.crm.CAH.generic_Utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Fileutility {

	/*
	 * This method is use to read the data from Property file
	 * @author Aparna
	 * @param key
	 * @return value
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException  {
		FileInputStream fis = new FileInputStream(IPathConstant.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
 

	}
}
