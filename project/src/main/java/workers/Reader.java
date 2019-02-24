package workers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import models.Account;

public class Reader {

	private static Reader myReader = new Reader();
	private static String path = "src/main/resources/dbText/";

	private Reader() {
	}

	public static Reader getReader() {
		return myReader;
	}

	public Account retrieveFromDb(String userName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + userName + ".ser"))) {
			return (Account) ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Invalid username");
		return null;
	}
	
	public boolean existsInDb(String userName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path + userName + ".ser"))) {
			ois.readObject();
			return true;
			
		} catch (FileNotFoundException e) {
			
		} catch (IOException e) {

		} catch (ClassNotFoundException e) {

		}
		return false;
	}
}
