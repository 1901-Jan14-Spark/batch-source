package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PasswordEncryption {
	public static String encodePassword(String password)
	{
		Properties prop = new Properties();
		InputStream in;
		try 
		{
			in = new FileInputStream("encryption.properties");
			prop.load(in);
			int upshift =  Integer.parseInt(prop.getProperty("upshift"));
			int downshift =  Integer.parseInt(prop.getProperty("upshift"));
			StringBuilder sb = new StringBuilder();
			int i; int length = password.length();
			for(i = 0; i < length; ++i)
			{
				if (i % 2 == 0)
				{
					sb.append((char)(password.charAt(i) + upshift));
				}
				else
				{
					sb.append((char)(password.charAt(i) - downshift));
				}
			}
			return sb.toString();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	
	public static String decodePassword(String encryption)
	{
		Properties prop = new Properties();
		InputStream in;
		try 
		{
			in = new FileInputStream("encryption.properties");
			prop.load(in);
			int upshift =  Integer.parseInt(prop.getProperty("upshift"));
			int downshift =  Integer.parseInt(prop.getProperty("upshift"));
			StringBuilder sb = new StringBuilder();
			int i; int length = encryption.length();
			for(i = 0; i < length; ++i)
			{
				if (i % 2 == 0)
				{
					sb.append((char)(encryption.charAt(i) - upshift));
				}
				else
				{
					sb.append((char)(encryption.charAt(i) + downshift));
				}
			}
			return sb.toString();
		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return null;
	}
}
