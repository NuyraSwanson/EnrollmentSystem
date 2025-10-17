
package za.ac.cput.clientsideproject.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.clientsideproject.ClientSideProject;
import za.ac.cput.shared.WorkerClasses.Course;
import za.ac.cput.shared.WorkerClasses.Enroll;
import za.ac.cput.shared.WorkerClasses.Student;

/**
 * ADP final assignment
 */

public class StudentGUI extends JFrame {
    private ClientSideProject client;
    private String studentNo;
    
  //GUI swing components
    private JLabel lblWelcome, imgLabel;
    private JPanel menuPanel, contentPanel;
    private JButton btnProfile, btnEnroll, btnCourses, btnLogout, btnBack;
    private JTable tblCourses;
    private CardLayout cardLayout;
    
    public StudentGUI(ClientSideProject client, String studentNo) {
        this.client = client;
        this.studentNo = studentNo;
        
      setTitle("Student account");
      setSize(1050, 750);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new BorderLayout());
      
      //Logo image
       ImageIcon icon = new ImageIcon("Images/ADP.png");
       Image img = icon.getImage();
       Image scaledImg = img.getScaledInstance(95, 95, Image.SCALE_SMOOTH); 
       ImageIcon scaledIcon = new ImageIcon(scaledImg);
      
       setIconImage(scaledImg);
       
      //Side menu
      JLabel label = new JLabel(scaledIcon);
      label.setHorizontalAlignment(SwingConstants.CENTER);
      
      menuPanel = new JPanel();
      menuPanel.setBackground(new Color(0, 102, 204));
      menuPanel.setLayout(new GridLayout(5, 1, 10, 10));
      menuPanel.setPreferredSize(new Dimension(200, getHeight()));
      
      btnProfile = new JButton("My Profile");
      btnProfile.setBackground(new Color(0, 102, 204));
      btnProfile.setForeground(Color.WHITE);
      btnProfile.setFont(new Font("Arial", Font.BOLD, 16));
      btnProfile.setBorderPainted(false);
      btnProfile.setFocusPainted(false);
      
      btnCourses = new JButton(" Available Courses");
      btnCourses.setBackground(new Color(0, 102, 204));
      btnCourses.setForeground(Color.WHITE);
      btnCourses.setFont(new Font("Arial", Font.BOLD, 16));
      btnCourses.setBorderPainted(false);
      btnCourses.setFocusPainted(false);
      
      btnEnroll = new JButton("Enroll");
      btnEnroll.setBackground(new Color(0, 102, 204));
      btnEnroll.setForeground(Color.WHITE);
      btnEnroll.setFont(new Font("Arial", Font.BOLD, 16));
      btnEnroll.setBorderPainted(false);
      btnEnroll.setFocusPainted(false);
      
      btnLogout = new JButton("Logout");
      btnLogout.setBackground(new Color(0, 102, 204));
      btnLogout.setForeground(Color.WHITE);
      btnLogout.setFont(new Font("Arial", Font.BOLD, 16));
      btnLogout.setBorderPainted(false);
      btnLogout.setFocusPainted(false);
      
      menuPanel.add(label);
      menuPanel.add(btnProfile);
      menuPanel.add(btnCourses);
      menuPanel.add(btnEnroll);
      menuPanel.add(btnLogout);
      
      cardLayout = new CardLayout();
      contentPanel = new JPanel(cardLayout);
      contentPanel.setBackground(Color.DARK_GRAY);
      
       //DASHBOARD SCREEN
      JPanel card1 = new JPanel();
      card1.setLayout(null);
      card1.setBackground(Color.DARK_GRAY);
     
      lblWelcome = new JLabel("Welcome back, Student!");
      lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
      lblWelcome.setForeground(Color.WHITE);
      lblWelcome.setBounds(300, 20, 300, 40);
      card1.add(lblWelcome);
      
      JPanel pnlLeft = new JPanel();
      pnlLeft.setLayout(null);
      pnlLeft.setBackground(Color.WHITE);
      pnlLeft.setBounds(30, 100, 220, 500);
      pnlLeft.setBorder(BorderFactory.createTitledBorder("Tips: "));
      JLabel lblTip = new JLabel("<html>"
        + "• Manage your time wisely.<br>"
        + "• Stay organized with a planner.<br>"
        + "• Ask questions when unsure.<br>"
        + "• Sleep well and eat healthy.<br>"
        + "• Review notes after class."
        + "</html>");
      lblTip.setFont(new Font("Arial", Font.ITALIC, 16));
      lblTip.setForeground(Color.BLACK);
      lblTip.setBounds(10, 30, 200, 200);
      pnlLeft.add(lblTip);
      card1.add(pnlLeft);
      
      JPanel pnlCenter = new JPanel();
      pnlCenter.setLayout(null);
      pnlCenter.setBackground(Color.WHITE);
      pnlCenter.setBounds(280, 100, 250, 500);
      pnlCenter.setBorder(BorderFactory.createTitledBorder("Fun Facts: "));
      
      JLabel lblFact = new JLabel("<html>"
        + "• The brain uses about 20% of the body’s energy.<br>"
        + "• Listening to music can improve focus.<br>"
        + "• Short naps boost memory and learning.<br>"
        + "• Drinking water helps you concentrate better.<br>"
        + "• Writing notes by hand improves recall."
        + "</html>");
      lblFact.setFont(new Font("Arial", Font.ITALIC, 16));
      lblFact.setForeground(Color.BLACK);
      lblFact.setBounds(20, 30, 220, 230);
      pnlCenter.add(lblFact);
      card1.add(pnlCenter);
      
      JPanel pnlRight = new JPanel();
      pnlRight.setLayout(null);
      pnlRight.setBackground(Color.WHITE);
      pnlRight.setBounds(560, 100, 220, 500);
      pnlRight.setBorder(BorderFactory.createTitledBorder("University Info: "));
      
      JLabel lblUni = new JLabel("<html>"
        + "Email address: info@cput.ac.za<br>"
        + "Student Counselling: 021 460 3237<br>"
        + "Campus Security: 021 460 3122<br>"
        + "Campus Clinic: 021 460 3613<br>"
        + "Call Centre: 021 959 6767"
        + "</html>");
      lblUni.setFont(new Font("Arial", Font.ITALIC, 13));
      lblUni.setForeground(Color.BLACK);
      lblUni.setBounds(10, 2, 350, 200);
      pnlRight.add(lblUni);
      card1.add(pnlRight);
      
      contentPanel.add(card1, "Dashboard");
      
      //Profile screen
      JPanel card2 = new JPanel(new BorderLayout());
      card2.setBackground(Color.DARK_GRAY);
      JLabel lblProfile = new JLabel("My Profile: ");
      lblProfile.setFont(new Font("Arial", Font.BOLD, 24));
      lblProfile.setForeground(Color.WHITE);
      
     JPanel formPanel = new JPanel();
     formPanel.setLayout(null);
     formPanel.setBackground(Color.DARK_GRAY);

     JLabel lblName = new JLabel("Name: ");
     lblName.setForeground(Color.WHITE);
     lblName.setBounds(50, 30, 120, 25);
     formPanel.add(lblName);

     JTextField txtName = new JTextField(15);
     txtName.setBounds(180, 30, 200, 25);
     formPanel.add(txtName);

     JLabel lblSurname = new JLabel("Surname: ");
     lblSurname.setForeground(Color.WHITE);
     lblSurname.setBounds(50, 70, 120, 25);
     formPanel.add(lblSurname);

     JTextField txtSurname = new JTextField(15);
     txtSurname.setBounds(180, 70, 200, 25);
     formPanel.add(txtSurname);

   JLabel lblStudNo = new JLabel("Student Number: ");
   lblStudNo.setForeground(Color.WHITE);
   lblStudNo.setBounds(50, 110, 120, 25);
   formPanel.add(lblStudNo);

   JTextField txtStudNo = new JTextField(10);
   txtStudNo.setBounds(180, 110, 200, 25);
   formPanel.add(txtStudNo);

    JLabel lblGender = new JLabel("Gender: ");
    lblGender.setForeground(Color.WHITE);
    lblGender.setBounds(50, 150, 120, 25);
    formPanel.add(lblGender);

     JTextField txtGender = new JTextField(6);
     txtGender.setBounds(180, 150, 200, 25);
     formPanel.add(txtGender);

     JLabel lblEmail = new JLabel("Email Address: ");
     lblEmail.setForeground(Color.WHITE);
     lblEmail.setBounds(50, 190, 120, 25);
     formPanel.add(lblEmail);

     JTextField txtEmail = new JTextField(20);
     txtEmail.setBounds(180, 190, 200, 25);
     formPanel.add(txtEmail);

     JLabel lblPhyAdd = new JLabel("Physical Address: ");
     lblPhyAdd.setForeground(Color.WHITE);
     lblPhyAdd.setBounds(50, 230, 120, 25);
     formPanel.add(lblPhyAdd);

     JTextArea txtPhyAdd = new JTextArea();
     txtPhyAdd.setBounds(180, 230, 200, 60);
     formPanel.add(txtPhyAdd);

     JLabel lblAge = new JLabel("Age: ");
     lblAge.setForeground(Color.WHITE);
     lblAge.setBounds(50, 310, 120, 25);
     formPanel.add(lblAge);

     JTextField txtAge = new JTextField(2);
     txtAge.setBounds(180, 310, 200, 25);
     formPanel.add(txtAge);

      JLabel lblDOB = new JLabel("Date of Birth: ");
      lblDOB.setForeground(Color.WHITE);
      lblDOB.setBounds(50, 350, 120, 25);
      formPanel.add(lblDOB);

      JTextField txtDOB = new JTextField(15);
      txtDOB.setBounds(180, 350, 200, 25);
      formPanel.add(txtDOB);

      JLabel lblContNo = new JLabel("Phone Number: ");
      lblContNo.setForeground(Color.WHITE);
      lblContNo.setBounds(50, 390, 120, 25);
      formPanel.add(lblContNo);

      JTextField txtContNo = new JTextField(10);
      txtContNo.setBounds(180, 390, 200, 25);
      formPanel.add(txtContNo);

      JButton btnBackProf = new JButton("Back to dashboard");
      btnBackProf.setBackground(Color.DARK_GRAY);
      btnBackProf.setForeground(Color.WHITE);
      btnBackProf.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackProf.setBorderPainted(false);
      btnBackProf.setFocusPainted(false);
      
      card2.add(lblProfile, BorderLayout.NORTH);
      card2.add(formPanel, BorderLayout.CENTER);
      card2.add(btnBackProf, BorderLayout.SOUTH);
      contentPanel.add(card2, "Profile");
      
      //Courses screen
      JPanel card3 = new JPanel(new BorderLayout());
      card3.setBackground(Color.DARK_GRAY);
      
      JButton btnBackCourse = new JButton("Back to dashboard");
      btnBackCourse.setBackground(Color.DARK_GRAY);
      btnBackCourse.setForeground(Color.WHITE);
      btnBackCourse.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackCourse.setBorderPainted(false);
      btnBackCourse.setFocusPainted(false);
      
      JLabel lblCourses = new JLabel("Available Courses: ");
      lblCourses.setFont(new Font("Arial", Font.BOLD, 24));
      lblCourses.setForeground(Color.WHITE);
      card3.add(lblCourses, BorderLayout.NORTH);
      card3.add(btnBackCourse, BorderLayout.SOUTH);
      
      String[] columnNames = {"Course ID", "Course Name", "Credits"};
      Object[][] data = {}; 
      JTable tblCourses = new JTable(data, columnNames);
      tblCourses.setFillsViewportHeight(true);

      JScrollPane scrollPane = new JScrollPane(tblCourses);
      card3.add(scrollPane, BorderLayout.CENTER);
      contentPanel.add(card3, "Courses");
      
      //Enroll screen
      JPanel card4 = new JPanel(new BorderLayout());
      card4.setBackground(Color.DARK_GRAY);
      
      JButton btnBackEnroll = new JButton("Back to dashboard");
      btnBackEnroll.setBackground(Color.DARK_GRAY);
      btnBackEnroll.setForeground(Color.WHITE);
      btnBackEnroll.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackEnroll.setBorderPainted(false);
      btnBackEnroll.setFocusPainted(false);
      
      JLabel lblEnroll = new JLabel("Course enrollment: ");
      lblEnroll.setFont(new Font("Arial", Font.BOLD, 24));
      lblEnroll.setForeground(Color.WHITE);
      card4.add(lblEnroll, BorderLayout.NORTH);
      card4.add(btnBackEnroll, BorderLayout.SOUTH);
   
      contentPanel.add(card4, "Enrollment");
      
      JPanel enrollPanel = new JPanel();
      enrollPanel.setLayout(null);
      enrollPanel.setBackground(Color.DARK_GRAY);

      JLabel lblStudNum = new JLabel("Student Number:");
      lblStudNum.setForeground(Color.WHITE);
      lblStudNum.setBounds(50, 80, 150, 25);
      enrollPanel.add(lblStudNum);

      JTextField txtStud = new JTextField();
      txtStud.setBounds(200, 80, 200, 25);
      enrollPanel.add(txtStud);

     JLabel NameLbl = new JLabel("Full Name:");
     NameLbl.setForeground(Color.WHITE);
     NameLbl.setBounds(50, 130, 150, 25);
     enrollPanel.add(NameLbl);

    JTextField txtNam = new JTextField();
    txtNam.setBounds(200, 130, 200, 25);
    enrollPanel.add(txtNam);

   JLabel lblCourse = new JLabel("Course:");
   lblCourse.setForeground(Color.WHITE);
   lblCourse.setBounds(50, 180, 150, 25);
   enrollPanel.add(lblCourse);

   JComboBox<String> cmbCourse = new JComboBox<>();
   cmbCourse.addItem("Select a course...");
   cmbCourse.setBounds(200, 180, 200, 25);
   enrollPanel.add(cmbCourse);
   
   List<Course> courses = client.viewCourses();
   for (Course c : courses) {
       cmbCourse.addItem(c.getCourseID() + " - " + c.getCourseName());
   }

    JLabel lblSemester = new JLabel("Year of study:");
    lblSemester.setForeground(Color.WHITE);
    lblSemester.setBounds(50, 230, 150, 25);
    enrollPanel.add(lblSemester);

    JComboBox<String> cmbSemester = new JComboBox<>(new String[]{"Select...", "2026", "2027"});
    cmbSemester.setBounds(200, 230, 200, 25);
    enrollPanel.add(cmbSemester);

     JLabel lblType = new JLabel("Enrollment Type:");
     lblType.setForeground(Color.WHITE);
     lblType.setBounds(50, 280, 150, 25);
     enrollPanel.add(lblType);

     JComboBox<String> cmbType = new JComboBox<>(new String[]{"Select...", "Full-time", "Part-time"});
     cmbType.setBounds(200, 280, 200, 25);
     enrollPanel.add(cmbType);

     JButton btnSubmit = new JButton("Enroll");
     btnSubmit.setBounds(250, 350, 120, 30);
     enrollPanel.add(btnSubmit);
     card4.add(enrollPanel, BorderLayout.CENTER);
        
      //action buttons of side menu
      btnBackProf.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnBackCourse.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnBackEnroll.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnProfile.addActionListener(e -> cardLayout.show(contentPanel, "Profile"));
      btnCourses.addActionListener(e -> cardLayout.show(contentPanel, "Courses"));
      btnEnroll.addActionListener(e -> cardLayout.show(contentPanel, "Enrollment"));
      btnLogout.addActionListener(e -> {
       this.dispose();
       new LoginPage(client).setVisible(true);
      });
      
      btnCourses.addActionListener(e -> {
         try {

        DefaultTableModel model = new DefaultTableModel(
            new Object[]{"Course ID", "Course Name", "Credits"}, 0
        );

        for (Course c : courses) {
            model.addRow(new Object[]{c.getCourseID(), c.getCourseName(), c.getCredits()});
        }

        tblCourses.setModel(model);

    } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error loading courses: " + ex.getMessage());
        ex.printStackTrace();
    } 
      });
      
      btnSubmit.addActionListener(e -> {
       String studentID = txtStud.getText().trim();
       String selected = (String) cmbCourse.getSelectedItem();

    if (studentID.isEmpty() || selected == null) {
        JOptionPane.showMessageDialog(this, "Please enter your ID and select a course!");
        return;
    }

    String courseID = selected.split(" - ")[0];
    Enroll enrollObj = new Enroll(studentID, courseID);

    String response = client.enroll(enrollObj);
    JOptionPane.showMessageDialog(this,
        response.equals("ENROLL_SUCCESS") ? "Enrollment successful!" : "Enrollment failed!");
      });
      
      btnProfile.addActionListener(e -> {
       try {
           List<Student> students = client.viewStudents();
           
           for (Student s : students) {
               if (s.getStudentNo().equals(studentNo)) {
                   txtName.setText(s.getName());
                   txtSurname.setText(s.getSurname());
                   txtStudNo.setText(s.getStudentNo());
                   
                   txtEmail.setText(s.getEmailAdd());
                   
                   txtContNo.setText(s.getPhoneNo());
                   break;
               }
           }
       }catch (Exception ex) {
           JOptionPane.showMessageDialog(this, "Error loading profile: " + ex.getMessage());
       }   
      });
      
      add(menuPanel, BorderLayout.WEST);
      add(contentPanel, BorderLayout.CENTER);
      
      setVisible(true);
    }
    
}
