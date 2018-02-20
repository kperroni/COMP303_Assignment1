package lab1.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuFrame frame = new MenuFrame();
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
	public MenuFrame() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MenuFrame.class.getResource("/lab1/img/windowIcon.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 299, 397);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new LineBorder(new Color(51, 153, 0), 3, true), "Operation", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 0)));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 239, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 352, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(54, Short.MAX_VALUE))
		);
		
		JLabel lblWithdrawImage = new JLabel("");
		lblWithdrawImage.setIcon(new ImageIcon(MenuFrame.class.getResource("/lab1/img/withdraw.png")));
		
		JLabel lblDepositImage = new JLabel("");
		lblDepositImage.setIcon(new ImageIcon(MenuFrame.class.getResource("/lab1/img/deposit.png")));
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				JOptionPane.showInputDialog(null, "Enter amount to withdraw");
			}
		});
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showInputDialog(null, "Enter amount to deposit");
			}
		});
		
		JButton btnBalance = new JButton("Balance");
		btnBalance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "Your balance is:");
			}
		});
		
		JLabel lblBalanceImage = new JLabel("");
		lblBalanceImage.setIcon(new ImageIcon(MenuFrame.class.getResource("/lab1/img/balance.png")));
		
		JSeparator separator = new JSeparator();
		
		JSeparator separator_1 = new JSeparator();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(btnDeposit, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addComponent(btnBalance, GroupLayout.DEFAULT_SIZE, 92, Short.MAX_VALUE)
								.addComponent(btnWithdraw, GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_panel.createSequentialGroup()
									.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblDepositImage, GroupLayout.PREFERRED_SIZE, 139, GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_panel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED)
											.addComponent(lblWithdrawImage)))
									.addGap(8))
								.addGroup(gl_panel.createSequentialGroup()
									.addComponent(lblBalanceImage, GroupLayout.PREFERRED_SIZE, 119, GroupLayout.PREFERRED_SIZE)
									.addContainerGap())))
						.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
							.addComponent(separator, GroupLayout.DEFAULT_SIZE, 239, Short.MAX_VALUE)
							.addContainerGap())
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 239, GroupLayout.PREFERRED_SIZE)
							.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblWithdrawImage, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(24)
							.addComponent(btnWithdraw)))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(36)
							.addComponent(btnDeposit))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(13)
							.addComponent(lblDepositImage, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(10)
							.addComponent(lblBalanceImage, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(59)
							.addComponent(btnBalance)))
					.addGap(25))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
	}
}
