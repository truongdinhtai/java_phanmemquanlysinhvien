package ViewFR;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.HocSinhDao;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;

public class Login1 extends JFrame implements ActionListener,KeyListener {

	private JPanel contentPane;
	private JTextField textField,nameInput ;
	private JPasswordField passwordField;
    private JButton btnDangNhap,btnThoat;
    private JLabel lblNewLabel,lblNewLabel_1,lblchekbox;
    private java.lang.String username;
    private java.lang.String password;
    private Login1 login;
    private JCheckBox checkBox;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		Login1 frame = new Login1();
		frame.setVisible(true);

	}

	/**
	 * Create the frame.
	 */
	public Login1() {
		
		setSize(450,300);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		textField = new JTextField();
		textField.setBounds(193, 67, 193, 43);
		contentPane.add(textField);
		textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setBounds(193, 132, 193, 43);
		contentPane.add(passwordField);

	    lblNewLabel = new JLabel("Username");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(41, 76, 115, 34);
		contentPane.add(lblNewLabel);

		 lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(41, 136, 115, 34);
		contentPane.add(lblNewLabel_1);

		 btnDangNhap = new JButton("????ng nh???p");
		 btnDangNhap.setBounds(89, 216, 109, 34);
		getRootPane().setDefaultButton(btnDangNhap);
		contentPane.add(btnDangNhap);
		
		
		 btnThoat = new JButton("Tho??t");
		btnThoat.setBounds(202, 216, 109, 34);
		contentPane.add(btnThoat);
		
		JLabel lblngNhp = new JLabel("????ng nh???p");
		lblngNhp.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblngNhp.setBounds(156, 26, 100, 30);
		contentPane.add(lblngNhp);
		
		lblchekbox = new JLabel("Hi???n m???t kh???u");
		lblchekbox.setBounds(70, 186, 97, 23);
		contentPane.add(lblchekbox);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox();
		chckbxNewCheckBox.setBounds(193, 186, 97, 23);
		contentPane.add(chckbxNewCheckBox);
		
	   this.username = textField.getText();
	   this.password = passwordField.getText();
	   btnDangNhap.addActionListener(this);
	   btnThoat.addActionListener(this);
	   
	     
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnDangNhap){
			if(textField.getText().equals("")|| String.valueOf(passwordField.getPassword()).equals("")){
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????y ????? t??i kho???n v?? m???t kh???u");
			}else{
				HocSinhDao hsDao = new HocSinhDao();
				if(hsDao.isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
					JOptionPane.showMessageDialog(this, "????ng nh???p th??nh c??ng");
					GiaoDien giaodien = new GiaoDien();
					//FormAdminView chay = new FormAdminView();
					giaodien.gg();
					dispose();
				}else{
					JOptionPane.showMessageDialog(this, "????ng nh???p th???t b???i");
				}
			}
		}if(e.getSource() == btnThoat){
			
			int n = JOptionPane.showConfirmDialog(login, "B???n th???t s??? mu???n tho??t ?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
			if(n!=1)
				
				System.exit(0);
		}
		/*Object object = e.getSource();
		if(object == btnNewButton){
			HocSinhDao  hocsinh = new HocSinhDao();
			if (hocsinh.isLogin(textField.getText(), String.valueOf(passwordField.getPassword()))) {
				Fame giaoDien = new Fame();
				giaoDien.gg();
				dispose();
				System.out.println("ok");
			} else {
				JOptionPane.showMessageDialog(null, "Th???t b???i");
			}
			if(e.getSource() == btnExit) {
			//icon m???c ?????nh, ti??u ????? t??y ch???nh
			int n = JOptionPane.showConfirmDialog(login, "B???n th???t s??? mu???n tho??t ?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
			//n???u n = 0 th?? tho??t ch????ng tr??nh ng????c l???i n = 1 kh??ng tho??t
			if(n!=1)
			//l???nh tho??t ch????ng tr??nh
			System.exit(0);
		 } if(checkBox.isSelected()) {
			lblCheckBox.setText("???n m???t kh???u");
			password.setEchoChar((char)0);
		 } else {
			lblCheckBox.setText("Hi???n m???t kh???u");
			password.setEchoChar('*');	
		 }
		}*/
		
	}
	/*public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnLogin) {
			if(username.getText().equals("") || String.valueOf(password.getPassword()).equals("")) {
				JOptionPane.showMessageDialog(this, "Vui l??ng nh???p ?????y ????? t??i kho???n v?? m???t kh???u");
			}else {//Ng?????c l???i, t??i kho???n v?? m???t kh???u nh???p v??o.
				SinhVienDao userDao = new SinhVienDao();
				if(userDao.isLogint(username.getText(), String.valueOf(password.getPassword()))) {
					JOptionPane.showMessageDialog(this, "????ng nh???p th??nh c??ng");
					Main main = new Main();
					FormAdminView chay = new FormAdminView();
					chay.display();
					dispose();
				} else {
					JOptionPane.showMessageDialog(this, "????ng nh???p th???t b???i");
				}
				
			}
		} if(e.getSource() == btnExit) {
			//icon m???c ?????nh, ti??u ????? t??y ch???nh
			int n = JOptionPane.showConfirmDialog(login, "B???n th???t s??? mu???n tho??t ?", "Th??ng b??o", JOptionPane.YES_NO_OPTION);
			//n???u n = 0 th?? tho??t ch????ng tr??nh ng????c l???i n = 1 kh??ng tho??t
			if(n!=1)
			//l???nh tho??t ch????ng tr??nh
			System.exit(0);
		 } if(checkBox.isSelected()) {
			lblCheckBox.setText("???n m???t kh???u");
			password.setEchoChar((char)0);
		 } else {
			lblCheckBox.setText("Hi???n m???t kh???u");
			password.setEchoChar('*');	
		 }
		
	}*/
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
