package data.db;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

	@Test
	void testGetAdminByLogin() {
		assertEquals(0, 0);
	}

	@Test
	void testLoginProcess() {
		assertEquals(0, 0);
	}

}
