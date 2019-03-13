package daos;

import java.util.HashMap;
import java.util.List;

public interface EmployeeDao {

	public HashMap<String, String> getEmployeeCredentials();
	public int getManager(String username);
	public HashMap<String, String> checkManager();
	public void getRequests(String username);
	public List<Employee> getEmployees();
	
}
