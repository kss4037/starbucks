/**
 * 
 */
package ui.find;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.junit.Rule;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ui.main.MainFrame;


class IdFindDialogTest {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
	private IdFindDialog testIdFindDialog;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		testIdFindDialog = new IdFindDialog();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
		testIdFindDialog = null;
	}

	/**
	 * Test method for {@link ui.find.IdFindDialog#IdFindDialog()}.
	 * @throws SecurityException 
	 * @throws NoSuchMethodException 
	 * @throws InvocationTargetException 
	 * @throws IllegalArgumentException 
	 * @throws IllegalAccessException 
	 * @throws NoSuchFieldException 
	 */
	/**
	 * Purpose: Create btnIdFindFunction
	 * Input: btnIdFindFunction get ID from MEMBER TABLE USING NAME , PHONE
	 * Expected:
	 * 		GOT I Find your ID correspond your name! MEssage
	 */
	@Test
	void testbtnIdFindFunction_Success() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnIdFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtName");
		field.setAccessible(true);
		JTextField txtName = (JTextField)field.get(testIdFindDialog);
		txtName.setText("권선근");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone");
		field.setAccessible(true);
		JTextField txtPhone = (JTextField)field.get(testIdFindDialog);
		txtPhone.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone2");
		field.setAccessible(true);
		JTextField txtPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPhone2.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnIdFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog,btnIdFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		btnIdFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"회원가입 DB 통신...\r\n" + 
				"입력하신 이름은 권선근\r\n" + 
				"권선근님의 아이디가  있음!\r\n" + 
				"");
	}
	/**
	 * Purpose: Create btnIdFindFunction
	 * Input: btnIdFindFunction get ID from MEMBER TABLE USING WRONG NAME , PHONE
	 * Expected:
	 * 		GOT I CANT Find your ID correspond your name! MEssage
	 */
	@Test
	void testbtnIdFindFunction_fail() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException {
		JButton btnIdFind = new JButton();
		
		Field field = testIdFindDialog.getClass().getDeclaredField("txtName");
		field.setAccessible(true);
		JTextField txtName = (JTextField)field.get(testIdFindDialog);
		txtName.setText("failure");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone");
		field.setAccessible(true);
		JTextField txtPhone = (JTextField)field.get(testIdFindDialog);
		txtPhone.setText("5501");
		
		field = testIdFindDialog.getClass().getDeclaredField("txtPhone2");
		field.setAccessible(true);
		JTextField txtPhone2 = (JTextField)field.get(testIdFindDialog);
		txtPhone2.setText("4037");
		
		Method method = testIdFindDialog.getClass().getDeclaredMethod("btnIdFindFunction",JButton.class);
		method.setAccessible(true);
		method.invoke(testIdFindDialog,btnIdFind);
		
		System.setOut(new PrintStream(outputStreamCaptor));
		btnIdFind.doClick();
		assertEquals(outputStreamCaptor.toString(),"회원가입 DB 통신...\r\n" + 
				"입력하신 이름은 failure\r\n" + 
				"failure님의 아이디가  없음!\r\n" + 
				"");
	}

}
