package ui.main;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Toolkit;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JFrame;
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

	}

	@AfterEach
	void tearDown() throws Exception {
		testMainFrame = null;
	}
	/**
	 * Purpose: set JFrame's title , icon , defaultCloseOperation
	 * Input: makeJPanel set Jframe's title , icon as Sturbucks related. set EXIT_ON_CLOSE operation
	 * Expected:
	 * 		return PASS
	 * 		Title = "스타벅스 음료 주문 프로그램"
	 * 		Icon = "images\\logo\\로고(50x50).jpg"
	 * 		Frame's Close operation = JFrame.EXIT_ON_CLOSE
	 */
	@Test
	void testmakeJPanel() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = testMainFrame.getClass().getDeclaredMethod("setJframe");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		assertEquals("스타벅스 음료 주문 프로그램", testMainFrame.getTitle());
		assertEquals(Toolkit.getDefaultToolkit().getImage("images\\logo\\로고(50x50).jpg"), testMainFrame.getIconImage());
		assertEquals(testMainFrame.getDefaultCloseOperation(),JFrame.EXIT_ON_CLOSE);
	}
}
