package com.Ty.Github.geericlib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author QSP
 *
 */
public class PropertyFile {
	/**It is generic method to read the data rom property file
	 * 
	 * @param key
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	
	public String getData(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(IEndPoints.propertyfilepath));
	   return p.getProperty(key);
	
	}

}
