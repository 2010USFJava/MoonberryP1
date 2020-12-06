import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.dao.ApproverDao;
import com.revature.daoimpl.ApproverDaoImpl;
import com.revature.model.Approver;
import com.revature.model.RS;
import com.revature.model.TR_Request;
import com.revature.util.ConnFactory;

public class ApproverDaoImplTest {
	
	@BeforeClass
	public static void beforeClass() { }

	@Test
	public void getApproverTest() {
		ApproverDao a = new ApproverDaoImpl();
		Approver myA = a.getApproverById(1);
		Approver myB = a.getApproverByUsername("lapp");
		assertEquals(myA.getFirstname(),myB.getFirstname());
		
	}
	
	@Test
	public void approverActionsTest() {
		ApproverDao a = new ApproverDaoImpl();
		TR_Request t = a.getRequestById(1);
		LocalDateTime f = LocalDateTime.of(LocalDate.of(2020, 10, 10), LocalTime.now());
		a.setApprovalStatus(RS.AWAIT_SUPER_APPROVAL, t , f );
		assertEquals(RS.AWAIT_SUPER_APPROVAL,a.getRequestById(1).getRequestStatus());
	}
	
	@Test
	public void approverActions2Test() {
		ApproverDao a = new ApproverDaoImpl();
		TR_Request t = a.getRequestById(1);
		a.updateRMBMAmount(t, 50.05);
		 double DELTA = 1e-15;
		assertEquals(a.getAllRequests().get(0).getRmbsmentAmount(), 50.05, DELTA );
	}
	@Test
	public void getApproverList() {
		ApproverDao a = new ApproverDaoImpl();
		List<TR_Request> myA = a.getAllRequests();
		assertEquals(myA.get(0).getRequestId(), 1);
	}

}


