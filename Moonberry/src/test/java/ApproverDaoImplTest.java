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
	public void getRequestList() {
		ApproverDao a = new ApproverDaoImpl();
  
		List<TR_Request> myT = a.getAllRequests();
		assertEquals(myT.get(1).getRequestId(), 1);
	}
	
	@Test
	public void testAutoApprover() {
		ApproverDao a = new ApproverDaoImpl();
		TR_Request request = a.getRequestById(1);
		assertEquals(2, a.getApprovalStatus(request).getStatusCode());
		LocalDateTime d = LocalDateTime.of(LocalDate.of(1998, 05, 23), LocalTime.now());
		a.autoApproveRequests(d);

	}
	
	@Test
	public void testGetRequestByDpt() {
		ApproverDao a = new ApproverDaoImpl();
		List<TR_Request> tRR = a.getRequestByDpt(1);
		assertEquals(2, tRR.size());
	}
	
	@Test
	public void testGetRequestByStatus() {
		ApproverDao a = new ApproverDaoImpl();
		List<TR_Request> tRR1 = a.getRequestByStatus(RS.AWAIT_SUPER_APPROVAL);
		assertEquals(2, tRR1.size());
		List<TR_Request> tRR2 = a.getRequestByStatus(RS.AWAIT_BENCO_APPROVAL);
		assertEquals(1, tRR2.size());
	}
	
	@Test
	public void testGetRequestBySuper() {
		ApproverDao a = new ApproverDaoImpl();
		List<TR_Request> tRR1 = a.getRequestBySuper(1);
		assertEquals(2, tRR1.size());
		List<TR_Request> tRR2 = a.getRequestBySuper(3);
		assertEquals(1, tRR2.size());
	}
}


