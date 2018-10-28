package printties.com.view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

public class login {

	private JFrame frame;
	private JTextField username;
	private JPasswordField password;
	JCheckBox rememberCredentials;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 11));
		frame.getContentPane().setBackground(UIManager.getColor("EditorPane.background"));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		rememberCredentials = new JCheckBox("Remember Credential");
		rememberCredentials.setBounds(63, 231, 140, 23);
		frame.getContentPane().add(rememberCredentials);
		
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(63, 105, 73, 36);
		frame.getContentPane().add(lblUsername);
		
		username = new JTextField();
		username.setBounds(164, 105, 200, 36);
		frame.getContentPane().add(username);
		username.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(63, 165, 73, 36);
		frame.getContentPane().add(lblPassword);
		
		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(164, 165, 200, 36);
		frame.getContentPane().add(password);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				if(areCredentialsEmpty())
				{
					JOptionPane.showMessageDialog(frame,
						    "Fields cannot be left empty");
				}
				else
				{
					
					if(rememberCredentials.isSelected())
					{
						
					}
					
				}
			}
		});
		btnNewButton.setBounds(257, 224, 177, 36);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("PrintTies");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\sunny\\OneDrive\\Desktop\\ico.png"));
		lblNewLabel.setBounds(10, 11, 91, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPrintties = new JLabel("PrintTies");
		lblPrintties.setFont(new Font("Baskerville Old Face", Font.BOLD, 26));
		lblPrintties.setBounds(123, 30, 132, 34);
		frame.getContentPane().add(lblPrintties);
		
		
	}
	
	
	public boolean areCredentialsEmpty()
	{
		String usernameS=username.getText().toString();
		String passwordS=password.getPassword().toString();
		
		
		if(usernameS.length()==0||passwordS.length()==0)
		{
			return true;
		}
		
		return false;
	}
}
