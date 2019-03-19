package daos;

import java.util.HashMap;
import java.util.List;

public interface EmployeeDao {

	public HashMap<String, String> getEmployeeCredentials();
	public int getManager(String username);
	public HashMap<String, String> checkManager();
	public List<Request> getRequests(String username);
	public List<Employee> getEmployees();
	public Employee getEmpByUser(String username);
	public String getManagerName(String username);
	public List<Employee> getManagersEmployee(String username);
	public int getEmployeeId(String username);
	public void postRequest(String username, int id, double cost, String reason);
	public List<Request> apiRequest();
	public void updatePassword(String username, String password);
	
}
