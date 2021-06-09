package ui.main;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import data.db.AdminDBMgr;

class MainFrameTest {
	private MainFrame testMainFrame;
	private JPanel panel;
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
		panel = (JPanel) method.invoke(testMainFrame);
		
	}

	@AfterEach
	void tearDown() throws Exception {
		testMainFrame = null;
		panel = null;
	}
	/**
	 * Purpose: set JFrame's title , icon , defaultCloseOperation
	 * Input: makeJFrame set Jframe's title , icon as Sturbucks related. set EXIT_ON_CLOSE operation
	 * Expected:
	 * 		return PASS
	 * 		Title = "��Ÿ���� ���� �ֹ� ���α׷�"
	 * 		Icon = "images\\logo\\�ΰ�(50x50).jpg"
	 * 		Frame's Close operation = JFrame.EXIT_ON_CLOSE
	 */
	@Test
	void testmakeJFrame() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method = testMainFrame.getClass().getDeclaredMethod("setJframe");
		method.setAccessible(true);
		method.invoke(testMainFrame);
		
		assertEquals("��Ÿ���� ���� �ֹ� ���α׷�", testMainFrame.getTitle());
		assertEquals(Toolkit.getDefaultToolkit().getImage("images\\logo\\�ΰ�(50x50).jpg"), testMainFrame.getIconImage());
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
	/**
	 * Purpose: Create Login_Button FUNCTION
	 * Input: btnLoginFunction get ID,PW form textFields then verify with MEMBERS TABLE
	 * Expected:
	 * @throws NoSuchFieldException 
	 * 		GOT LOGIN SUCEES MESSAGE
	 */
	@Test
	void testbtnLoginFunction_LOGIN_SUCCESS() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnLogin = new JButton();
		
		Field field = testMainFrame.getClass().getDeclaredField("txtLogin");
		field.setAccessible(true);
		JTextField loginfield = (JTextField)field.get(testMainFrame);
		loginfield.setText("sgg");
		
		field = testMainFrame.getClass().getDeclaredField("passwordField");
		field.setAccessible(true);
		JTextField passwordField = (JTextField)field.get(testMainFrame);
		passwordField.setText("1234");
		
		
		Method method = testMainFrame.getClass().getDeclaredMethod("btnLoginFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testMainFrame,btnLogin);
		
		btnLogin.doClick();
		
		assertEquals(testMainFrame.lbLoginMessage.getText(),"�α��ο� �����ϼ̽��ϴ�.");
		assertEquals(testMainFrame.lbLoginMessage.getForeground(),Color.black);
		assertEquals(testMainFrame.Login,"sgg");
	}
	/**
	 * Purpose: Create Login_Button FUNCTION
	 * Input: btnLoginFunction get ID,PW form textFields then verify with MEMBERS TABLE
	 * Expected:
	 * @throws NoSuchFieldException 
	 * 		GOT LOGIN NOT FOUND MESSAGE
	 */
	@Test
	void testbtnLoginFunction_LOGIN_NOT_FOUND() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnLogin = new JButton();
		
		Field field = testMainFrame.getClass().getDeclaredField("txtLogin");
		field.setAccessible(true);
		JTextField loginfield = (JTextField)field.get(testMainFrame);
		loginfield.setText("failure");
		
		field = testMainFrame.getClass().getDeclaredField("passwordField");
		field.setAccessible(true);
		JTextField passwordField = (JTextField)field.get(testMainFrame);
		passwordField.setText("1234");
		
		
		Method method = testMainFrame.getClass().getDeclaredMethod("btnLoginFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testMainFrame,btnLogin);
		
		btnLogin.doClick();
		
		assertEquals(testMainFrame.lbLoginMessage.getText(),"ȸ���� ������ ã�� �� �����ϴ�.");
		assertEquals(testMainFrame.lbLoginMessage.getForeground(),Color.red);
	}
	/**
	 * Purpose: Create Login_Button FUNCTION
	 * Input: btnLoginFunction get ID,PW form textFields then verify with MEMBERS TABLE
	 * Expected:
	 * @throws NoSuchFieldException 
	 * 		GOT LOGIN_PW_MISMATCH MESSAGE
	 */
	@Test
	void testbtnLoginFunction_LOGIN_PW_MISMATCH() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnLogin = new JButton();
		
		Field field = testMainFrame.getClass().getDeclaredField("txtLogin");
		field.setAccessible(true);
		JTextField loginfield = (JTextField)field.get(testMainFrame);
		loginfield.setText("failure");
		
		field = testMainFrame.getClass().getDeclaredField("passwordField");
		field.setAccessible(true);
		JTextField passwordField = (JTextField)field.get(testMainFrame);
		passwordField.setText("1234");
		
		
		Method method = testMainFrame.getClass().getDeclaredMethod("btnLoginFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testMainFrame,btnLogin);
		
		btnLogin.doClick();
		
		assertEquals(testMainFrame.lbLoginMessage.getText(),"�α��� Ȥ�� ��й�ȣ�� Ʋ���̽��ϴ�.");
		assertEquals(testMainFrame.lbLoginMessage.getForeground(),Color.red);
	}

}
