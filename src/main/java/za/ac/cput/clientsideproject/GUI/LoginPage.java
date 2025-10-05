
package za.ac.cput.clientsideproject.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * ADP final assignment
 */

public class LoginPage extends JFrame {
    private JLabel lblLogin, lblCombo, lblUsername, lblPassword;
    private JComboBox cmbRole;
    private JTextField txtUsername, txtPassword;
    private JButton btnLogin;
    private JPanel btmPanel, topPanel, centerPanel;
    private CardLayout cardLayout;
    
    String[] role = {"Student", "Admin"};
    
    public LoginPage() {
     //Setting up the frame
        setTitle("Student/Admin Enrollment System");
        setSize(850, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        getContentPane().setBackground(Color.DARK_GRAY);
        
        topPanel = new JPanel(new BorderLayout());
        topPanel.setBounds(0, 0, 850, 150);
        topPanel.setOpaque(false);
 
        ImageIcon icon = new ImageIcon("Images/ADP.png");
        Image img = icon.getImage();
        Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH); 
        ImageIcon scaledIcon = new ImageIcon(scaledImg);
      
        setIconImage(scaledImg);
       
        //logo
        JLabel label = new JLabel(scaledIcon);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(label, BorderLayout.CENTER);
        
        add(topPanel);

        // Role
        lblCombo = new JLabel("Login as:");
        lblCombo.setFont(new Font("Arial", Font.PLAIN, 20));
        lblCombo.setForeground(Color.WHITE);
        lblCombo.setBounds(250, 200, 120, 30);
        add(lblCombo);

        cmbRole = new JComboBox<>(role);
        cmbRole.setBounds(400, 200, 200, 30);
        cmbRole.setFont(new Font("Arial", Font.PLAIN, 18));
        add(cmbRole);

        // Username
        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Arial", Font.PLAIN, 20));
        lblUsername.setForeground(Color.WHITE);
        lblUsername.setBounds(250, 280, 120, 30);
        add(lblUsername);

        txtUsername = new JTextField();
        txtUsername.setBounds(400, 280, 200, 30);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 18));
        add(txtUsername);

        // Password
        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 20));
        lblPassword.setForeground(Color.WHITE);
        lblPassword.setBounds(250, 360, 120, 30);
        add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setBounds(400, 360, 200, 30);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 18));
        add(txtPassword);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(0, 102, 204));
        btnLogin.setBounds(400, 600, 100, 40);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 20));
        btnLogin.setForeground(Color.WHITE);
        add(btnLogin);

        setVisible(true);   
    }
}
