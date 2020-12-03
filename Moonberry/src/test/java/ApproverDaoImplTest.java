import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.BeforeClass;
import org.junit.Test;

import com.revature.model.Approver_Type;
import com.revature.util.ConnFactory;

public class ApproverDaoImplTest {
	@BeforeClass
	public static void beforeClas() {
		int id = 0;
		final ConnFactory CF = ConnFactory.getInstance();
		Connection conn = CF.getConnection();
		String sql1= "insert into approver values(default,?,?,?,?,?,?)";
		String sql2= "insert into tr_request values(default,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql3= "insert into department values(default,?,?)";
		try {
			//inserts approver
			PreparedStatement ps1 = conn.prepareStatement(sql1,  Statement.RETURN_GENERATED_KEYS);
			ps1.setString(1,Approver_Type.DEPARTMENT_HEAD.toString());
			ps1.setString(2,"Lunar");
			ps1.setString(3,"Approver");
			ps1.setString(4,"test");
			ps1.setString(5,"lapp");
			ps1.setString(6,"lapp");
			ps1.executeUpdate();
			ResultSet keys = ps1.getGeneratedKeys();
			if (keys.next()) {
				id = keys.getInt(1);
			}
			
			//inserts department
			PreparedStatement ps3 = conn.prepareStatement(sql3);
			ps3.setString(1,"test");
			ps3.setInt(2, id );
			
			//inserts tr_request
			PreparedStatement ps2 = conn.prepareStatement(sql2);
			//insert employee
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

}
