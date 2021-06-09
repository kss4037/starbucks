package data.db;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.Admin;
import util.db.OracleDBUtil;

class AdminDBMgrTest {
	private AdminDBMgr testDBMgr;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		testDBMgr = new AdminDBMgr();
	}

	@AfterEach
	void tearDown() throws Exception {
		testDBMgr = null;
	}
	/**
	 * Purpose: Constructor  of AdminDBMgr class.
	 * Input: AdminDBMgr get util.db.OracleDBUtil.java's conn and assign it to AdminDBMgr's conn
	 * Expected:
	 * 		return PASS
	 * 		util.db.OracleDBUtil.java's conn = AdminDBMgr's conn
	 */
	@Test
	void testConstructor() {
		testDBMgr = new AdminDBMgr();
		assertEquals(testDBMgr.conn, OracleDBUtil.getConn());
	}
	/**
	 * Purpose: get Admin data from ADMINS Table Using LOGIN COLUMN DATA
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="sgg"
	 * Expected:
	 * 		return PASS
	 * 		Name = "adm"
	 * 		Pw = "1234"
	 * 		Login = "sgg"
	 * 		
	 */
	@Test
	void testGetAdminByLoginSucess() {
		Admin testAdmin = testDBMgr.getAdminByLogin("sgg");
		assertEquals(testAdmin.getName(),"adm");
		assertEquals(testAdmin.getPw(),"1234");
		assertEquals(testAdmin.getLogin(),"sgg");
	}
	/**
	 * Purpose: Request Non exist data of Table Admin
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="failure"
	 * Expected:
	 * 		return PASS
	 * 		return Data will be null
	 */
	@Test
	void testGetAdminByLogin_WrongLogin() {
		Admin testAdmin = testDBMgr.getAdminByLogin("failure");
		assertEquals(testAdmin , null);
	}
	/**
	 * Purpose: excute GetAdminByLogin when connection is invaild
	 * Input: getAdminByLogin return correspond Admin data using sql Query Login="failure"
	 * Expected:
	 * 		return PASS
	 * 		return Data will be null
	 */
	@Test
	void testGetAdminByLogin_NullConn() {
		testDBMgr.conn = null;
		Admin testAdmin = testDBMgr.getAdminByLogin("sgg");
		assertEquals(testAdmin , null);
	}
	/**
	 * Purpose: 
	 * Input: 
	 * Expected:
	 * 		return PASS
	 * 
	 */
	@Test
	void testLoginProcess() {
		assertEquals(0, 0);
	}

}
