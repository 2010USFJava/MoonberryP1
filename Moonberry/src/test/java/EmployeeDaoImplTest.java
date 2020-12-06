import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

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
import com.revature.model.Event_Type;
import com.revature.model.Grade_Format;
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
	
	@Test
	public void getRequestsFromEmployeeTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		Employee blue = e.findById(1);
		assertNotNull(e.findEmployeeRequests(blue));
		
	}
	
//	@Test
//	public void makeRequestTest() {
//		EmployeeDao e = new EmployeeDaoImpl();
//		Employee employee = e.findByUsername("blue");
//		LocalDateTime requestMadeDate = LocalDateTime.of(LocalDate.of(1998, 05, 03), LocalTime.now());
//		double tuitionAmount = 300;
//		LocalDateTime eventStartDate = LocalDateTime.of(LocalDate.of(1998, 05, 13), LocalTime.now());
//		LocalDateTime eventEndDate = LocalDateTime.of(LocalDate.of(1998, 07, 17), LocalTime.now());
//		String eventName = "Operating Systems 101";
//		String eventLocation = "Old Stinky University";
//		String eventDescription = "We gonna learn about operating systems!";
//		Grade_Format gradeFormat = Grade_Format.LETTER;
//		Event_Type eventType = Event_Type.UNIVERSITY_COURSE;
//		String workJust = "This course will help me understand why unix is cool";
//		boolean emailProvided = false;
//		TR_Request request = e.makeRequest(employee, requestMadeDate, tuitionAmount, eventStartDate, eventEndDate, eventName, eventLocation, eventDescription, gradeFormat, eventType, workJust, emailProvided);
//		assertNotNull(request);
//	}
	
	
//	@Test 
//	public void insertEmployeeTest() {
//		EmployeeDao e = new EmployeeDaoImpl();
//		Employee bob = new Employee(-1, "bob", "smith", 1, 1, "boba", "1234");
//		e.insert(bob);
//		assertNotNull(e.findByUsername("boba"));
//	}
	
	@Test
	public void isSuperAlsoDptHeadTest() {
		EmployeeDao e = new EmployeeDaoImpl();
		Employee employee1 = e.findByUsername("blue");
		assertTrue(e.isSuperAlsoDptHead(employee1));
		Employee employee2 = e.findByUsername("harvey");
		assertFalse(e.isSuperAlsoDptHead(employee2));
	}
	
	
	
}
