import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;

import org.junit.Test;

import com.revature.dao.ApproverDao;
import com.revature.dao.EmployeeDao;
import com.revature.daoimpl.ApproverDaoImpl;
import com.revature.daoimpl.EmployeeDaoImpl;
import com.revature.model.Employee;
import com.revature.model.TR_Request;

public class EmployeeDaoImplTest {

	@Test
	public void getEmployeeTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		ApproverDao a = new ApproverDaoImpl();
		for (Employee result : e.findAll()) {
			assertNotNull(result);
		}
		assertNull(e.findById(100));
		assertNotNull(e.findById(1));
		assertNotNull(e.findByUsername("blue"));
		TR_Request request = a.getRequestById(1);
		assertNotNull(e.findByRequest(request));
	}
	
	@
	
	@Test
	public void makeRequestTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		Employee employee = e.findByUsername("blue");
		LocalDateTime requestMadeDate = LocalDateTime.of(LocalDate.of(1998, 05, 03), LocalTime.now());
		//e.makeRequest(null, requestMadeDate, tuitionAmount, eventStartDate, eventEndDate, eventName, eventLocation, eventDescription, gradeFormat, eventType, workJust, emailProvided)
	}
}
