package daos;

import java.util.HashMap;

public interface EmployeeDao {

	public HashMap<String, String> getEmployeeCredentials();
	public int getManager(String username);
	public boolean checkManager(String username);
	
}
