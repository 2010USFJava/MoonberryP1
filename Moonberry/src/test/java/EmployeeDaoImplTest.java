import org.junit.Test;

import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.EmployeeDaoImpl;

public class EmployeeDaoImplTest {

	@Test
	public void getEmployeeTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		System.out.println(e.findAll());
	}
	
	@Test
	public void makeRequestTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		
	}
}
