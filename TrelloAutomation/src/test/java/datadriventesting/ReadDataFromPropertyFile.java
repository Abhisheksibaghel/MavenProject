package datadriventesting;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String[] args) throws Throwable{
		
	
	//Create the FileInputStream Obj with the file address as an input
	//the argument name is nothing but the relative path of the file
	FileInputStream fis = new FileInputStream("./src/test/resources/actitimedata.properties");
	//Create an Properties Object of Java
	Properties pobj = new Properties();
	//load all the input stream obj to the pobj obj
	pobj.load(fis);
	//call the getProperty() from the Properties Class Object reference
	String value = pobj.getProperty("url");
	System.out.println(value);
}
}