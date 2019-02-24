package workers;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import models.Account;

public class Writer {

	private static Writer myWriter = new Writer();
	private static String path = "src/main/resources/dbText/";

	private Writer() {
	}

	public static Writer getWriter() {
		return myWriter;
	}

	public boolean addToDb(Account account) {
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(path + account.getUsername() + ".ser"))) {
			oos.writeObject(account);
			return true;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;

	}
}
