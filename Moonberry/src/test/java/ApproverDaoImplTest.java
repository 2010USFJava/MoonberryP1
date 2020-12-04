import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

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
	public static void beforeClass() {
		int id = 1;
		final ConnFactory CF = ConnFactory.getInstance();
		Connection conn = CF.getConnection();
		ApproverDao a = new ApproverDaoImpl();
//		String sql1= "select * from approver where approver_id = ";
//		String sql2= "insert into tr_request values(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		String sql3= "insert into department values(default,?,?)";
//		try {
//			//inserts approver
//			PreparedStatement ps1 = conn.prepareStatement(sql1,  Statement.RETURN_GENERATED_KEYS);
//			ps1.setString(1,Approver_Type.DEPARTMENT_HEAD.toString());
//			ps1.setString(2,"Lunar");
//			ps1.setString(3,"Approver");
//			ps1.setString(4,"test");
//			ps1.setString(5,"lapp");
//			ps1.setString(6,"lapp");
//			ps1.executeUpdate();
//			ResultSet keys = ps1.getGeneratedKeys();
//			if (keys.next()) {
//				id = keys.getInt(1);
//			}
//			
//			//inserts department
//			PreparedStatement ps3 = conn.prepareStatement(sql3);
//			ps3.setString(1,"test");
//			ps3.setInt(2, id );
//			
//			//inserts tr_request
//			PreparedStatement ps2 = conn.prepareStatement(sql2);
//			//insert employee
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

	@Test
	public void getApproverTest() {
		ApproverDao a = new ApproverDaoImpl();
		Approver myA = a.getApproverById(1);
		Approver myB = a.getApproverByUsername("blue");
		assertEquals(myA.getFirstname(),myB.getFirstname());
		
	}
	
	@Test
	public void approverActionsTest() {
		ApproverDao a = new ApproverDaoImpl();
		TR_Request t = a.getRequestById(1);
		LocalDateTime f = LocalDateTime.of(LocalDate.of(2020, 10, 10), LocalTime.now());
		a.setApprovalStatus(RS.AWAIT_SUPER_APPROVAL, t , f );
		assertEquals(t.getRequestStatus(),RS.AWAIT_SUPER_APPROVAL);
	}

}


