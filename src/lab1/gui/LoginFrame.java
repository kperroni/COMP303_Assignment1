package lab1.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.border.TitledBorder;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.PrintWriter;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	public JTextField txtUsername;
	public JPasswordField txtPassword;
	public int userAccount;
	PrintWriter writer;
	private boolean checkLogin = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		setResizable(false);
		setTitle("COMP303_Lab1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginFrame.class.getResource("/lab1/img/windowIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 502, 258);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JPanel containerPanel = new JPanel();
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(containerPanel, GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(containerPanel, GroupLayout.PREFERRED_SIZE, 210, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 0), 3, true), "Login", TitledBorder.LEADING,
				TitledBorder.TOP, null, new Color(51, 153, 0)));

		txtPassword = new JPasswordField();
		txtPassword.setColumns(10);

		JLabel lblUsername = new JLabel("Username:");

		txtUsername = new JTextField();
		txtUsername.setColumns(10);

		JLabel lblLoginTitle = new JLabel("Welcome to the ATM");
		lblLoginTitle.setFont(new Font("Bernard MT Condensed", Font.PLAIN, 18));
		GroupLayout gl_containerPanel = new GroupLayout(containerPanel);
		gl_containerPanel.setHorizontalGroup(gl_containerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_containerPanel.createSequentialGroup().addContainerGap()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 456, Short.MAX_VALUE).addContainerGap()));
		gl_containerPanel.setVerticalGroup(gl_containerPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_containerPanel.createSequentialGroup()
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE).addContainerGap()));

		// BankDatabase accountValidation = new BankDatabase();

		JButton btnLogin = new JButton("");
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public synchronized void mouseClicked(MouseEvent arg0) {
				// Implemented login validation
				checkLogin = true;
				/*
				 * try { char[] userPinChar = txtPassword.getPassword(); String passString = new
				 * String(userPinChar); int userPin = Integer.parseInt(passString); userAccount
				 * = Integer.parseInt(txtUsername.getText());
				 * 
				 * if (accountValidation.authenticateUser(userAccount,userPin)) { MenuFrame menu
				 * = new MenuFrame(); menu.setVisible(true); menu.setResizable(false);
				 * menu.setLocationRelativeTo(null); menu.setTitle("COMP303_Lab1");
				 * setVisible(false); } else { JOptionPane.showMessageDialog(panel,
				 * "Could not find User or Password", "Error", JOptionPane.ERROR_MESSAGE); }
				 * }catch (Exception e) { JOptionPane.showMessageDialog(panel,
				 * "Could not find User or Password", "Error", JOptionPane.ERROR_MESSAGE); }
				 */
			}
		});

		btnLogin.setToolTipText("Log in");
		btnLogin.setIcon(new ImageIcon(LoginFrame.class.getResource("/lab1/img/loginButton.png")));

		JLabel lblPasscode = new JLabel("Passcode:");

		JLabel lblLoginImage = new JLabel("New label");
		lblLoginImage.setIcon(new ImageIcon(LoginFrame.class.getResource("/lab1/img/login.png")));

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public synchronized void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null,
						"Responsabilities:\n\nServer: Wesley Angus #\nClasses: Manoel Britto #300903820\nGUI: Kenny Perroni #300825160",
						"About Authors", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnNewButton_1.setToolTipText("Help");
		btnNewButton_1.setIcon(new ImageIcon(LoginFrame.class.getResource("/lab1/img/help.png")));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addContainerGap(26, Short.MAX_VALUE)
				.addGroup(gl_panel
						.createParallelGroup(Alignment.LEADING).addComponent(lblPasscode).addComponent(lblUsername))
				.addGap(7)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup().addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
								.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblLoginTitle, GroupLayout.PREFERRED_SIZE, 156,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
												.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 59,
														GroupLayout.PREFERRED_SIZE)
												.addGap(18).addComponent(btnNewButton_1)))
								.addGap(29)))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(lblLoginImage, GroupLayout.PREFERRED_SIZE, 136, GroupLayout.PREFERRED_SIZE).addGap(20)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup().addGap(18)
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblLoginImage, GroupLayout.PREFERRED_SIZE, 110, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup().addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lblLoginTitle).addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtUsername, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblUsername))
								.addGap(18)
								.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtPassword, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblPasscode))
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 30,
												GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(26, Short.MAX_VALUE)));

		panel.setLayout(gl_panel);
		containerPanel.setLayout(gl_containerPanel);
		contentPane.setLayout(gl_contentPane);

	}

	public synchronized void showMessage(String message) {

		JOptionPane.showMessageDialog(null, message);
	}

	public void setCheckLogin(boolean value) {
		this.checkLogin = value;
	}

	public boolean getCheckLogin() {
		return this.checkLogin;
	}
}
