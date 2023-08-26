package genericlibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * this class contains reusable methods to perform operations on properties file
 * @author Admit
 *
 */
public class PropertiesUtility {
	
	/**this method is used to read data from properties
	 * 
	 * @param filePath
	 * @param key
	 * @return
	 */
    private Properties property;
	public void propertiesInitialization(String filepath)
	{
		FileInputStream fis=null;
		try {
			fis=new FileInputStream(filepath);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		property=new Properties();
		try {
			property.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
			
		}
	}
	public String readFromProperties(String key)
	{
		
		return property.getProperty(key);
			
		}
	
	}

