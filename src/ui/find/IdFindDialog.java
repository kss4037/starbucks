package ui.find;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import data.Member;
import data.db.MemberDBMgr;
import ui.main.MainFrame;

import LabelDecorate.LabelForeGround;
import LabelDecorate.LabelBackGround;
import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelIcon;

import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import java.awt.CardLayout;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import LabelDecorate.LabelBackGround;
import LabelDecorate.LabelBound;
import LabelDecorate.LabelFont;
import LabelDecorate.LabelForeGround;
import LabelDecorate.LabelHorizon;
import LabelDecorate.LabelIcon;

import ButtonDecorate.ButtonBackGround;
import ButtonDecorate.ButtonBound;
import ButtonDecorate.ButtonComponent;
import ButtonDecorate.ButtonDecorator;
import ButtonDecorate.ButtonFont;
import ButtonDecorate.ButtonForeGround;
import ButtonDecorate.ButtonIcon;
import ButtonDecorate.ButtonRightAlignment;
public class IdFindDialog extends JDialog {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			IdFindDialog dialog = new IdFindDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	JPanel pnCenter;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtCode;
	private JTextField txtId;
	private JTextField txtPwCode;

	MemberDBMgr mgr;
	private JTextField txtPhone2;
	private JTextField txtPwPhone2;
	private JTextField txtPwPhone3;

	public IdFindDialog() {

		mgr = new MemberDBMgr();

		setTitle("��Ÿ���� ���̵�/��й�ȣ ã�� �ý���");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);

		createMenuBar();
		createpnCenter();
		createIDFinder();
		createPWFinder();
	}

	private void createpnCenter() {
		pnCenter = new JPanel();
		pnCenter.setBounds(0, 20, 434, 241);
		getContentPane().add(pnCenter);
		pnCenter.setLayout(new CardLayout(0, 0));
	}

	private void createPWFinder() {
		
		
		JPanel pnPwFind = new JPanel();
		pnPwFind.setBackground(new Color(255, 255, 255));
		pnCenter.add(pnPwFind, "pw");
		pnPwFind.setLayout(null);

		JLabel PurposeLabel = new LabelBackGround(new LabelForeGround(new LabelFont(new LabelBound(new JLabel("��Ÿ���� ��� ��й�ȣ ã��"), 12, 10, 410, 15),"����",12,Font.PLAIN),0,102,51),255,255,255).getLabel();
		pnPwFind.add(PurposeLabel);

		JLabel DescriptLabel = new LabelFont(new LabelBound(new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�"), 12, 35, 410, 15),"����",12,Font.PLAIN).getLabel();
		pnPwFind.add(DescriptLabel);

		JLabel DescriptLabel2 = new LabelFont(new LabelBound(new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�"), 12, 54, 410, 15),"����",12,Font.PLAIN).getLabel();
		pnPwFind.add(DescriptLabel2);

		JSeparator separator_1 = new JSeparator();
		separator_1.setForeground(new Color(0, 102, 51));
		separator_1.setBounds(12, 79, 410, 2);
		pnPwFind.add(separator_1);

		JLabel lbId = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("���̵�"), 12, 104, 72, 15),"����",12,Font.PLAIN)).getLabel();
		pnPwFind.add(lbId);

		JLabel lbPhone2 = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("�ڵ�����ȣ"), 12, 135, 72, 15),"����",12,Font.PLAIN)).getLabel();
		pnPwFind.add(lbPhone2);

		JComboBox comboPwPhone = new JComboBox();
		comboPwPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPwPhone.setFont(new Font("����", Font.PLAIN, 12));
		comboPwPhone.setBackground(Color.WHITE);
		comboPwPhone.setBounds(96, 132, 52, 21);
		pnPwFind.add(comboPwPhone);

		txtId = new JTextField();
		txtId.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtId.getText().equals("")) {
					txtId.setText("");
				} else {
					txtId.selectAll();
				}
			}
		});
		txtId.setFont(new Font("����", Font.PLAIN, 12));
		txtId.setColumns(10);
		txtId.setBounds(96, 101, 198, 21);
		pnPwFind.add(txtId);

		JLabel phoneNumberSeperator  = new LabelHorizon(new LabelBound(new JLabel("-"), 160, 135, 6, 15)).getLabel();
		pnPwFind.add(phoneNumberSeperator);

		txtPwCode = new JTextField();
		txtPwCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwCode.getText().equals("")) {
					txtPwCode.setText("");
				} else {
					txtPwCode.selectAll();
				}
			}

		});
		txtPwCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
		txtPwCode.setForeground(Color.LIGHT_GRAY);
		txtPwCode.setFont(new Font("����", Font.PLAIN, 12));
		txtPwCode.setColumns(10);
		txtPwCode.setBounds(96, 163, 198, 21);
		pnPwFind.add(txtPwCode);

		JSeparator separator_2 = new JSeparator();
		separator_2.setForeground(new Color(0, 102, 51));
		separator_2.setBounds(12, 196, 410, 2);
		pnPwFind.add(separator_2);

		JButton btnPwFind = new ButtonFont( new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("��й�ȣ ã��"),0,102,51 ),255,255,255), 223,208,116,23),"����",12,Font.PLAIN).getButton();
		btnPwFindFunction(btnPwFind);
		pnPwFind.add(btnPwFind);

		JButton btnPwCancel = new ButtonFont( new ButtonBound(new ButtonForeGround(new ButtonBackGround(new JButton("���"),0,102,51 ),255,255,255), 351,208,71,23),"����",12,Font.PLAIN).getButton();
		btnPwCancelFunction(btnPwCancel);
		pnPwFind.add(btnPwCancel);

		txtPwPhone2 = new JTextField();
		txtPwPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone2.getText().equals("")) {
					txtPwPhone2.setText("");
				} else {
					txtPwPhone2.selectAll();
				}

			}
		});
		txtPwPhone2.setFont(new Font("����", Font.PLAIN, 12));
		txtPwPhone2.setColumns(10);
		txtPwPhone2.setBounds(178, 132, 52, 21);
		pnPwFind.add(txtPwPhone2);

		JLabel phoneNumberSeperator2  = new LabelHorizon(new LabelBound(new JLabel("-"), 242, 135, 6, 15)).getLabel();
		pnPwFind.add(phoneNumberSeperator2);

		txtPwPhone3 = new JTextField();
		txtPwPhone3.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPwPhone3.getText().equals("")) {
					txtPwPhone3.setText("");
				} else {
					txtPwPhone3.selectAll();
				}
			}
		});
		txtPwPhone3.setFont(new Font("����", Font.PLAIN, 12));
		txtPwPhone3.setColumns(10);
		txtPwPhone3.setBounds(260, 132, 52, 21);
		pnPwFind.add(txtPwPhone3);

		JButton btnPwCode = new ButtonFont( new ButtonBound (new ButtonBackGround(new JButton("������ȣ"),255,255,255 ), 334,131,88,23),"����",12,Font.PLAIN).getButton();
		btnPwCodeFunction(btnPwCode);
		pnPwFind.add(btnPwCode);
	}

	private void btnPwCodeFunction(JButton btnPwCode) {
		btnPwCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtId.getText().isEmpty() && txtPwPhone2.getText().isEmpty() && txtPwPhone3.getText().isEmpty()) {
					System.out.println("��ϵ��� ���� ��ȣ�Դϴ�.");
					JOptionPane.showMessageDialog(null, "��ϵ��� ���� ��ȣ�Դϴ�.");
				} else {
					System.out.println("������ȣ�� '" + varCode + "' �Դϴ�.");
					JOptionPane.showMessageDialog(null, "������ȣ�� '" + varCode + "' �Դϴ�.");
				}
			}
		});
	}

	private void btnPwCancelFunction(JButton btnPwCancel) {
		btnPwCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
	}

	private void btnPwFindFunction(JButton btnPwFind) {
		btnPwFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtId != null || !txtId.getText().isEmpty() || !txtPwPhone2.getText().isEmpty()
						|| !txtPwPhone3.getText().isEmpty()) {
					// �Է� ������ ����
					String login = txtId.getText();
					System.out.println("�Է��Ͻ� �̸��� " + login);
					// DB ����
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindPw(login);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (login + "���� ��й�ȣ�� " + b.getPw() + "�Դϴ�."));
					} else {
						JOptionPane.showMessageDialog(null, login + "���� ���̵�� ã�� �� �����ϴ�.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				}
			}
		});
	}

	private void createIDFinder() {
		JPanel pnIdFind = new JPanel();
		pnIdFind.setBackground(Color.WHITE);
		pnCenter.add(pnIdFind, "id");
		pnIdFind.setLayout(null);

		JLabel lbName = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("�̸�"), 12, 104, 72, 15),"����",12,Font.PLAIN)).getLabel();
		pnIdFind.add(lbName);

		JLabel lbPhone = new LabelHorizon(new LabelFont(new LabelBound(new JLabel("�ڵ�����ȣ"), 12, 135, 72, 15),"����",12,Font.PLAIN)).getLabel();
		pnIdFind.add(lbPhone);

		txtName = new JTextField();
		txtName.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtName.getText().equals("")) {
					txtName.setText("");
				} else {
					txtName.selectAll();
				}
			}
		});
		txtName.setFont(new Font("����", Font.PLAIN, 12));
		txtName.setBounds(96, 101, 198, 21);
		pnIdFind.add(txtName);
		txtName.setColumns(10);

		JComboBox comboPhone = new JComboBox();
		comboPhone.setBackground(new Color(255, 255, 255));
		comboPhone.setFont(new Font("����", Font.PLAIN, 12));
		comboPhone.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "017", "018", "019", "070" }));
		comboPhone.setBounds(96, 132, 52, 21);
		pnIdFind.add(comboPhone);

		JLabel PhoneNumberSeperator = new LabelHorizon(new LabelBound(new JLabel("-"), 160, 135, 6, 15)).getLabel();
		pnIdFind.add(PhoneNumberSeperator);

		txtPhone = new JTextField();
		txtPhone.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone.setBounds(178, 132, 52, 21);
		pnIdFind.add(txtPhone);
		txtPhone.setColumns(10);

		JButton btnCode = new ButtonFont( new ButtonBound (new ButtonBackGround(new JButton("������ȣ"),255,255,255 ), 334,131,88,23),"����",12,Font.PLAIN).getButton();
		btnCodeFunction(btnCode);
		pnIdFind.add(btnCode);

		txtCode = new JTextField();
//		txtCode.setEnabled(false);
		txtCode.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtCode.getText().equals("������ȣ 6�ڸ� �Է��ϱ�")) {
					txtCode.setText("");
					txtCode.setForeground(Color.black);
				} else {
					txtCode.selectAll();
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (txtCode.getText().equals("")) {
					txtCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
					txtCode.setForeground(Color.LIGHT_GRAY);
				} else {
					txtCode.selectAll();
				}
			}
		});
		txtCode.setForeground(Color.LIGHT_GRAY);
		txtCode.setFont(new Font("����", Font.PLAIN, 12));
		txtCode.setText("������ȣ 6�ڸ� �Է��ϱ�");
		txtCode.setBounds(96, 163, 198, 21);
		pnIdFind.add(txtCode);
		txtCode.setColumns(10);

		JLabel TitleIDfinderLabel = new LabelBackGround(new LabelForeGround(new LabelFont(new LabelBound(new JLabel("��Ÿ���� ��� ���̵� ã��"), 12, 10, 410, 15),"����",12,Font.PLAIN),0,102,51),255,255,255).getLabel();
		pnIdFind.add(TitleIDfinderLabel);

		JLabel DescriptIDfinderLabel = new LabelFont(new LabelBound(new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�"), 12, 35, 410, 15),"����",12,Font.PLAIN).getLabel();
		pnIdFind.add(DescriptIDfinderLabel);

		JLabel DescriptIDfinderLabel2 = new LabelFont(new LabelBound(new JLabel("���������� ����� �ڵ�����ȣ�� �Է��� �ڵ�����ȣ�� ���ƾ�"), 12, 54, 410, 15),"����",12,Font.PLAIN).getLabel();
		pnIdFind.add(DescriptIDfinderLabel2);

		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 102, 51));
		separator.setBounds(12, 79, 410, 2);
		pnIdFind.add(separator);

		JButton btnCancel = new ButtonFont( new ButtonBound (new ButtonForeGround(new ButtonBackGround(new JButton("���"),0,102,51 ),255, 255, 255), 351,208,71,23),"����",12,Font.PLAIN).getButton();
		pnIdFind.add(btnCancel);

		JButton btnIdFind = new ButtonFont( new ButtonBound (new ButtonForeGround(new ButtonBackGround(new JButton("���̵� ã��"),0,102,51 ),255, 255, 255), 223, 208, 116, 23),"����",12,Font.PLAIN).getButton();
		btnIdFindFunction(btnIdFind);
		pnIdFind.add(btnIdFind);

		JSeparator separator_3 = new JSeparator();
		separator_3.setForeground(new Color(0, 102, 51));
		separator_3.setBounds(12, 196, 410, 2);
		pnIdFind.add(separator_3);

		txtPhone2 = new JTextField();
		txtPhone2.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				if (txtPhone.getText().equals("")) {
					txtPhone.setText("");
				} else {
					txtPhone.selectAll();
				}
			}
		});
		txtPhone2.setFont(new Font("����", Font.PLAIN, 12));
		txtPhone2.setColumns(10);
		txtPhone2.setBounds(260, 132, 52, 21);
		pnIdFind.add(txtPhone2);

		JLabel PhoneNumberSeperator2 = new LabelHorizon(new LabelBound(new JLabel("-"), 242, 135, 6, 15)).getLabel();
		pnIdFind.add(PhoneNumberSeperator2);
	}

	private void btnCodeFunction(JButton btnCode) {
		btnCode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				Random ran = new Random();
				int n = ran.nextInt(900000) + 100000;
				String varCode = String.valueOf(n);

				if (txtName.getText().isEmpty() && txtPhone.getText().isEmpty() && txtPhone2.getText().isEmpty()) {
					System.out.println("��ϵ��� ���� ��ȣ�Դϴ�.");
					JOptionPane.showMessageDialog(null, "��ϵ��� ���� ��ȣ�Դϴ�.");
				} else {
					System.out.println("������ȣ�� '" + varCode + "' �Դϴ�.");
					JOptionPane.showMessageDialog(null, "������ȣ�� '" + varCode + "' �Դϴ�.");
				}
			}
		});
	}

	private void btnIdFindFunction(JButton btnIdFind) {
		btnIdFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtName != null || !txtName.getText().isEmpty() || !txtPhone.getText().isEmpty()
						|| !txtPhone2.getText().isEmpty()) {
					System.out.println("ȸ������ DB ���...");
					// �Է� ������ ����
					String name = txtName.getText();
					System.out.println("�Է��Ͻ� �̸��� " + name);
					// DB ����
					// Member mb = new Member(name, phone);
					Member b = mgr.getOneMemberFindId(name);
					if (b != null) {
						JOptionPane.showMessageDialog(null, (name + "���� ���̵�� " + b.getLogin() + "�Դϴ�."));
					} else {
						JOptionPane.showMessageDialog(null, name + "���� ���̵�� ã�� �� �����ϴ�.");
					}
					dispose();
				} else {
					JOptionPane.showMessageDialog(null, "������ �Է����ּ���");
				}
			}
		});
	}

	private void btnCancelFunction(JButton btnCancel) {
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				MainFrame frm = new MainFrame();
				frm.setVisible(true);
			}
		});
	}

	private void createMenuBar() {
	
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(0, 102, 51));
		menuBar.setBounds(0, 0, 434, 25);
		getContentPane().add(menuBar);

		JButton btnFindId = new ButtonFont(new ButtonBackGround(new JButton("���̵� ã��"),255, 255, 255),"����",12,Font.PLAIN).getButton();
		btnFindIdFunction(btnFindId);
		menuBar.add(btnFindId);

		JButton btnFindPw = new ButtonFont(new ButtonBackGround(new JButton("��й�ȣ ã��"),255, 255, 255),"����",12,Font.PLAIN).getButton();
		btnFindPwFunction(btnFindPw);
		menuBar.add(btnFindPw);
	}

	private void btnFindPwFunction(JButton btnFindPw) {
		btnFindPw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "pw");
			}
		});
	}

	private void btnFindIdFunction(JButton btnFindId) {
		btnFindId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout c = (CardLayout) pnCenter.getLayout();
				c.show(pnCenter, "id");

			}
		});
	}
}