package ui.main;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.GridLayout;
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
		Method method = testMainFrame.getClass().getDeclaredMethod("setJframe");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		method = testMainFrame.getClass().getDeclaredMethod("setContentPane");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		method = testMainFrame.getClass().getDeclaredMethod("makeJPanel");
		method.setAccessible(true);
		JPanel panel = (JPanel) method.invoke(testMainFrame);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		testMainFrame = null;
	}
	/**
	 * Purpose: set JFrame's title , icon , defaultCloseOperation
	 * Input: makeJFrame set Jframe's title , icon as Sturbucks related. set EXIT_ON_CLOSE operation
	 * Expected:
	 * 		return PASS
	 * 		Title = "스타벅스 음료 주문 프로그램"
	 * 		Icon = "images\\logo\\로고(50x50).jpg"
	 * 		Frame's Close operation = JFrame.EXIT_ON_CLOSE
	 */
	@Test
	void testmakeJFrame() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = testMainFrame.getClass().getDeclaredMethod("setJframe");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		assertEquals("스타벅스 음료 주문 프로그램", testMainFrame.getTitle());
		assertEquals(Toolkit.getDefaultToolkit().getImage("images\\logo\\로고(50x50).jpg"), testMainFrame.getIconImage());
		assertEquals(testMainFrame.getDefaultCloseOperation(),JFrame.EXIT_ON_CLOSE);
	}
	/**
	 * Purpose: set ContentPain as default
	 * Input: setContentPane set contentpane as new white Background grid ContentPane Object
	 * Expected:
	 * 		return PASS
	 * 		Background = "white"
	 * 		Layout = "GridLayout[0,0,0,2]"
	 */
	@Test
	void testsetContentPane() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = testMainFrame.getClass().getDeclaredMethod("setContentPane");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		assertEquals(Color.white, testMainFrame.getContentPane().getBackground());
		assertEquals("java.awt.GridLayout[hgap=0,vgap=0,rows=0,cols=2]",testMainFrame.getContentPane().getLayout().toString());
	}
	/**
	 * Purpose: Create JPanel
	 * Input: makeJPanel set JPanel's background white and Layout as null
	 * Expected:
	 * 		return PASS
	 * 		Background = white
	 * 		Layout = null
	 */
	@Test
	void testmakeJPanel() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = testMainFrame.getClass().getDeclaredMethod("makeJPanel");
		method.setAccessible(true);
		JPanel testpanel = (JPanel) method.invoke(testMainFrame);
		
		assertEquals(Color.WHITE, testpanel.getBackground());
		assertEquals(null, testpanel.getLayout());
	}

}
