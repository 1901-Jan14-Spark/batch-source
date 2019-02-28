package Classes;

import java.io.*;

public class FileIO {
	public static boolean writeUserData(User user)
	{
		try
		{
			FileOutputStream fOut = new FileOutputStream("src/Main/user.ser");
			ObjectOutputStream oOut = new ObjectOutputStream(fOut);
			oOut.writeObject(user);
			oOut.close();
			fOut.close();
			return true;
		} 
		catch (IOException e)
		{
			return false;
		}
	}
	public static User readUserData()
	{
		User user = null;
		try
		{
			FileInputStream fIn = new FileInputStream("src/Main/user.ser");
			ObjectInputStream oIn = new ObjectInputStream(fIn);
			user = (User)oIn.readObject();
			oIn.close();
			fIn.close();
			return user;
		}
		catch (IOException e)
		{
			return null;
		}
		catch (ClassNotFoundException e)
		{
			return null;
		}
	}
}
