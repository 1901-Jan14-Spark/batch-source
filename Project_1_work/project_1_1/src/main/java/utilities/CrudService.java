package utilities;

import java.util.List;

public interface CrudService <T>{

	public List<T> getAll();
	public T getEmpByUser(String username);
	
}
