package ui.main;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import javax.swing.JPanel;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.db.AdminDBMgr;

class MainFrameTest {
	private MainFrame testMainFrame;
	@BeforeEach
	void setUp() throws Exception {
		testMainFrame = new MainFrame();
		Method method = testMainFrame.getClass().getDeclaredMethod("setJframe");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		System.out.print(testMainFrame.getTitle());

	}

	@AfterEach
	void tearDown() throws Exception {
		testMainFrame = null;
	}

	@Test
	void testMainFrame() {
	}
	
	@Test
	void testmakeJPanel() {
	}
}
