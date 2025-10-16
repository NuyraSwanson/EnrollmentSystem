
package za.ac.cput.clientsideproject.GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;
import za.ac.cput.clientsideproject.ClientSideProject;
import za.ac.cput.shared.WorkerClasses.Admin;
import za.ac.cput.shared.WorkerClasses.Course;
import za.ac.cput.shared.WorkerClasses.Student;

/**
 * ADP final assignment
 */

public class AdminGUI extends JFrame {
    private ClientSideProject client;
    private String adminUsername;
    //Swing components
    private JLabel lblWelcome, imgLabel;
    private JPanel menuPanel, contentPanel;
    private JButton btnProfile, btnCourses, btnLogout, btnStudents;
    private JTable tblCourses;
    private CardLayout cardLayout; 
    
    public AdminGUI(ClientSideProject client, String adminUsername) {
      this.adminUsername = adminUsername;
      this.client = client;
      
      setTitle("Admin account");
      setSize(1000, 750);
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
      
      btnCourses = new JButton("Courses");
      btnCourses.setBackground(new Color(0, 102, 204));
      btnCourses.setForeground(Color.WHITE);
      btnCourses.setFont(new Font("Arial", Font.BOLD, 16));
      btnCourses.setBorderPainted(false);
      btnCourses.setFocusPainted(false);
      
      btnStudents = new JButton("Students");
      btnStudents.setBackground(new Color(0, 102, 204));
      btnStudents.setForeground(Color.WHITE);
      btnStudents.setFont(new Font("Arial", Font.BOLD, 16));
      btnStudents.setBorderPainted(false);
      btnStudents.setFocusPainted(false);
      
      btnLogout = new JButton("Logout");
      btnLogout.setBackground(new Color(0, 102, 204));
      btnLogout.setForeground(Color.WHITE);
      btnLogout.setFont(new Font("Arial", Font.BOLD, 16));
      btnLogout.setBorderPainted(false);
      btnLogout.setFocusPainted(false);
      
      menuPanel.add(label);
      menuPanel.add(btnProfile);
      menuPanel.add(btnCourses);
      menuPanel.add(btnStudents);
      menuPanel.add(btnLogout);
      
      cardLayout = new CardLayout();
      contentPanel = new JPanel(cardLayout);
             
      //Dashboard screen
      JPanel card1 = new JPanel();
      card1.setLayout(null);
      card1.setBackground(Color.DARK_GRAY);
      
      lblWelcome = new JLabel("Welcome back, Admin!");
      lblWelcome.setFont(new Font("Arial", Font.BOLD, 24));
      lblWelcome.setForeground(Color.WHITE);
      lblWelcome.setBounds(20, 20, 300, 40);
      card1.add(lblWelcome);
      
      JPanel pnlLeft = new JPanel();
      pnlLeft.setLayout(null);
      pnlLeft.setBackground(Color.WHITE);
      pnlLeft.setBounds(30, 100, 220, 500);
      pnlLeft.setBorder(BorderFactory.createTitledBorder("Messages of the Day"));
      JLabel lblMessage = new JLabel("<html>- Leadership is about making others better as a result of your presence.<br>"
              + "- Your work today shapes tomorrow’s success.<br>"
              + "- Stay positive, stay focused, and keep pushing forward.</html>");
      lblMessage.setForeground(Color.BLACK);
      lblMessage.setBounds(10, 30, 200, 200);
      pnlLeft.add(lblMessage);
      card1.add(pnlLeft);

     JPanel pnlCenter = new JPanel();
     pnlCenter.setLayout(null);
     pnlCenter.setBackground(Color.WHITE);
     pnlCenter.setBounds(280, 100, 250, 500);
     pnlCenter.setBorder(BorderFactory.createTitledBorder("Shortcuts"));

     JButton btnAddStudent = new JButton("View Students");
     btnAddStudent.setBackground(new Color(0, 102, 204));
     btnAddStudent.setForeground(Color.WHITE);
     btnAddStudent.setBounds(40, 50, 150, 40);
     pnlCenter.add(btnAddStudent);

     JButton btnAddCourse = new JButton("View Courses");
     btnAddCourse.setBackground(new Color(0, 102, 204));
     btnAddCourse.setForeground(Color.WHITE);
     btnAddCourse.setBounds(40, 120, 150, 40);
     pnlCenter.add(btnAddCourse);
     
     JButton btnAdd = new JButton("<html><center>Add new<br>students and courses</center></html>");
     btnAdd.setBackground(new Color(0, 102, 204));
     btnAdd.setForeground(Color.WHITE);
     btnAdd.setBounds(40, 190, 150, 80);
     pnlCenter.add(btnAdd);
     
     card1.add(pnlCenter);

     JPanel pnlRight = new JPanel();
     pnlRight.setLayout(null);
     pnlRight.setBackground(Color.WHITE);
     pnlRight.setBounds(560, 100, 220, 500);
     pnlRight.setBorder(BorderFactory.createTitledBorder("Support Contacts"));
     JLabel lblSupport = new JLabel("<html>IT Support: ITSupport@cput.ac.za<br>"
             + "Admission/Applications: 021 959 6393<br>"
             + "Campus Security: 021 460 3122<br>"
             + "Faulty office: 021 460 3043</html>");
     lblSupport.setForeground(Color.BLACK);
     lblSupport.setBounds(10, 30, 200, 200);
     pnlRight.add(lblSupport);
     card1.add(pnlRight);
     
     //Shortcut buttons
     btnAddCourse.addActionListener(e -> cardLayout.show(contentPanel, "Courses"));
     btnAddStudent.addActionListener(e -> cardLayout.show(contentPanel, "Students"));
     btnAdd.addActionListener(e -> cardLayout.show(contentPanel, "Add"));
      
      contentPanel.add(card1, "Dashboard");
      
      //Profile screen
      JPanel card2 = new JPanel(new BorderLayout());
      card2.setBackground(Color.DARK_GRAY);

      JPanel centerPnl = new JPanel();
      centerPnl.setLayout(null);
      centerPnl.setBackground(Color.DARK_GRAY);

      JLabel lblAdminProfile = new JLabel("Admin Profile");
      lblAdminProfile.setFont(new Font("Arial", Font.BOLD, 24));
      lblAdminProfile.setForeground(Color.WHITE);
      lblAdminProfile.setBounds(300, 20, 300, 30);
      centerPnl.add(lblAdminProfile);

      JLabel lblName = new JLabel("Name:");
      lblName.setForeground(Color.WHITE);
      lblName.setBounds(50, 80, 150, 25);
      centerPnl.add(lblName);

      JTextField txtName = new JTextField();
      txtName.setBounds(200, 80, 200, 25);
      centerPnl.add(txtName);

      JLabel lblSurname = new JLabel("Surname:");
      lblSurname.setForeground(Color.WHITE);
      lblSurname.setBounds(50, 130, 150, 25);
      centerPnl.add(lblSurname);

      JTextField txtSurname = new JTextField();
      txtSurname.setBounds(200, 130, 200, 25);
      centerPnl.add(txtSurname);
      
      JLabel lblEmail = new JLabel("Email:");
      lblEmail.setForeground(Color.WHITE);
      lblEmail.setBounds(50, 180, 150, 25);
      centerPnl.add(lblEmail);

     JTextField txtEmail = new JTextField();
     txtEmail.setBounds(200, 180, 200, 25);
     centerPnl.add(txtEmail);

     JLabel lblContact = new JLabel("Contact Number:");
     lblContact.setForeground(Color.WHITE);
     lblContact.setBounds(50, 230, 150, 25);
     centerPnl.add(lblContact);

     JTextField txtContact = new JTextField();
     txtContact.setBounds(200, 230, 200, 25);
     centerPnl.add(txtContact);

    JLabel lblRole = new JLabel("Role:");
    lblRole.setForeground(Color.WHITE);
    lblRole.setBounds(50, 280, 150, 25);
    centerPnl.add(lblRole);

    JTextField txtRole = new JTextField();
    txtRole.setBounds(200, 280, 200, 25);
    txtRole.setEditable(false);
    centerPnl.add(txtRole);
    
    JLabel lblAdminId = new JLabel("Admin ID: ");
    lblAdminId.setForeground(Color.WHITE);
    lblAdminId.setBounds(50, 330, 150, 25);
    centerPnl.add(lblAdminId);
    
    JTextField txtAdminId = new JTextField();
    txtAdminId.setBounds(200, 330, 200, 25);
    centerPnl.add(txtAdminId);
    
      JButton btnBackProf = new JButton("Back to Dashboard");
      btnBackProf.setBackground(Color.DARK_GRAY);
      btnBackProf.setForeground(Color.WHITE);
      btnBackProf.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackProf.setBorderPainted(false);
      btnBackProf.setFocusPainted(false);

      card2.add(centerPnl, BorderLayout.CENTER);
      card2.add(btnBackProf, BorderLayout.SOUTH);
      contentPanel.add(card2, "Profile");
      
      //Courses screen
      JPanel cardCourses = new JPanel(null);
      cardCourses.setBackground(Color.DARK_GRAY);

      JLabel lblCourses = new JLabel("Available Courses");
      lblCourses.setFont(new Font("Arial", Font.BOLD, 22));
      lblCourses.setForeground(Color.WHITE);
      lblCourses.setBounds(300, 10, 300, 30);
      cardCourses.add(lblCourses);

      String[] courseCols = {"Course ID", "Course Name", "Credits"};
      JTable tblCourses = new JTable(new DefaultTableModel(null, courseCols));
      JScrollPane scrollCourses = new JScrollPane(tblCourses);
      scrollCourses.setBounds(30, 50, 750, 550);
      cardCourses.add(scrollCourses);

      JButton btnBackCourses = new JButton("Back to Dashboard");
      btnBackCourses.setBackground(new Color(0, 102, 204));
      btnBackCourses.setForeground(Color.WHITE);
      btnBackCourses.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackCourses.setBounds(30, 620, 200, 40);
      cardCourses.add(btnBackCourses);

      JButton btnAddCourses = new JButton("Add New Course");
      btnAddCourses.setBackground(new Color(0, 102, 204));
      btnAddCourses.setForeground(Color.WHITE);
      btnAddCourses.setFont(new Font("Arial", Font.BOLD, 16));
      btnAddCourses.setBounds(580, 620, 200, 40);
      cardCourses.add(btnAddCourses);

      contentPanel.add(cardCourses, "Courses");

      //Students screen
      JPanel cardStudents = new JPanel(null); 
      cardStudents.setBackground(Color.DARK_GRAY);

      String[] studentCols = {"Student number", "Name", "Surname", "Email", "Contact detail"};
      JTable tblStudents = new JTable(new DefaultTableModel(null, studentCols));
      JScrollPane scrollStudents = new JScrollPane(tblStudents);
      scrollStudents.setBounds(30, 50, 750, 500); 
      cardStudents.add(scrollStudents);

      JButton btnBackStud = new JButton("Back to dashboard");
      btnBackStud.setBackground(new Color(0, 102, 204));
      btnBackStud.setForeground(Color.WHITE);
      btnBackStud.setFont(new Font("Arial", Font.BOLD, 16));
      btnBackStud.setBounds(30, 620, 200, 40);
      btnBackStud.setBorderPainted(false);
      btnBackStud.setFocusPainted(false);
      cardStudents.add(btnBackStud);
      
      JButton btnAddStud = new JButton("Add student");
      btnAddStud.setBackground(new Color(0, 102, 204));
      btnAddStud.setForeground(Color.WHITE);
      btnAddStud.setFont(new Font("Arial", Font.BOLD, 16));
      btnAddStud.setBounds(580, 620, 200, 40);
      btnAddStud.setBorderPainted(false);
      btnAddStud.setFocusPainted(false);
      cardStudents.add(btnAddStud);
      
      JLabel lblStudents = new JLabel("Students");
      lblStudents.setFont(new Font("Arial", Font.BOLD, 24));
      lblStudents.setBounds(300, 10, 300, 30);
      lblStudents.setForeground(Color.WHITE);
      cardStudents.add(lblStudents);
      
      contentPanel.add(cardStudents, "Students");
      
      //Adding students/courses screen
      JPanel cardAdd = new JPanel(null);
      cardAdd.setBackground(Color.DARK_GRAY);

     JLabel lblTitle = new JLabel("Add student and/or course");
     lblTitle.setFont(new Font("Arial", Font.BOLD, 22));
     lblTitle.setForeground(Color.WHITE);
     lblTitle.setBounds(280, 10, 400, 30);
     cardAdd.add(lblTitle);

     JLabel lblStudSection = new JLabel("Add New Student");
     lblStudSection.setFont(new Font("Arial", Font.BOLD, 18));
     lblStudSection.setForeground(Color.WHITE);
     lblStudSection.setBounds(60, 60, 200, 25);
     cardAdd.add(lblStudSection);

     JLabel lblAddName = new JLabel("Name:");
     lblAddName.setForeground(Color.WHITE);
     lblAddName.setBounds(60, 100, 120, 25);
     JTextField txtAddName = new JTextField();
     txtAddName.setBounds(180, 100, 150, 25);
     cardAdd.add(lblAddName);
     cardAdd.add(txtAddName);

     JLabel lblAddSurname = new JLabel("Surname:");
     lblAddSurname.setForeground(Color.WHITE);
     lblAddSurname.setBounds(60, 140, 120, 25);
     JTextField txtAddSurname = new JTextField();
     txtAddSurname.setBounds(180, 140, 150, 25);
     cardAdd.add(lblAddSurname);
     cardAdd.add(txtAddSurname);

     JLabel lblStudNo = new JLabel("Student No:");
     lblStudNo.setForeground(Color.WHITE);
     lblStudNo.setBounds(60, 180, 120, 25);
     JTextField txtStudNo = new JTextField();
     txtStudNo.setBounds(180, 180, 150, 25);
     cardAdd.add(lblStudNo);
     cardAdd.add(txtStudNo);
     
     JLabel lblStudEmail = new JLabel("Email address: ");
     lblStudEmail.setForeground(Color.WHITE);
     lblStudEmail.setBounds(60, 220, 120, 25);
     JTextField txtStudEmail = new JTextField();
     txtStudEmail.setBounds(180, 220, 150, 25);
     cardAdd.add(lblStudEmail);
     cardAdd.add(txtStudEmail);
     
     JLabel lblContNo = new JLabel("Contact number: ");
     lblContNo.setForeground(Color.WHITE);
     lblContNo.setBounds(60, 260, 120, 25);
     JTextField txtContNo = new JTextField();
     txtContNo.setBounds(180, 260, 150, 25);
     cardAdd.add(lblContNo);
     cardAdd.add(txtContNo);
     
     JButton btnAddStudents = new JButton("Add Student");
     btnAddStudents.setBackground(new Color(0, 102, 204));
     btnAddStudents.setForeground(Color.WHITE);
     btnAddStudents.setBounds(120, 400, 150, 30);
     cardAdd.add(btnAddStudents);

     JLabel lblCourseSection = new JLabel("Add New Course");
     lblCourseSection.setFont(new Font("Arial", Font.BOLD, 18));
     lblCourseSection.setForeground(Color.WHITE);
     lblCourseSection.setBounds(480, 60, 200, 25);
     cardAdd.add(lblCourseSection);

     JLabel lblCourseId = new JLabel("Course ID:");
     lblCourseId.setForeground(Color.WHITE);
     lblCourseId.setBounds(480, 100, 120, 25);
     JTextField txtCourseId = new JTextField();
     txtCourseId.setBounds(600, 100, 150, 25);
     cardAdd.add(lblCourseId);
     cardAdd.add(txtCourseId);

     JLabel lblCourseName = new JLabel("Course Name:");
     lblCourseName.setForeground(Color.WHITE);
     lblCourseName.setBounds(480, 140, 120, 25);
     JTextField txtCourseName = new JTextField();
     txtCourseName.setBounds(600, 140, 150, 25);
     cardAdd.add(lblCourseName);
     cardAdd.add(txtCourseName);
     
     JTextField txtPassword = new JTextField();

     JLabel lblCredits = new JLabel("Credits:");
     lblCredits.setForeground(Color.WHITE);
     lblCredits.setBounds(480, 180, 120, 25);
     JTextField txtCredits = new JTextField();
     txtCredits.setBounds(600, 180, 150, 25);
     cardAdd.add(lblCredits);
     cardAdd.add(txtCredits);

     JButton btnAddCours = new JButton("Add Course");
     btnAddCours.setBackground(new Color(0, 102, 204));
     btnAddCours.setForeground(Color.WHITE);
     btnAddCours.setBounds(540, 400, 150, 30);
     cardAdd.add(btnAddCours);

    JButton btnBackAdd = new JButton("Back to Dashboard");
    btnBackAdd.setBackground(new Color(0, 102, 204));
    btnBackAdd.setForeground(Color.WHITE);
    btnBackAdd.setBounds(320, 650, 200, 40);
    cardAdd.add(btnBackAdd);

    contentPanel.add(cardAdd, "Add");

      //buttons
      btnBackAdd.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnAddCourses.addActionListener(e -> cardLayout.show(contentPanel, "Add"));
      btnAddStud.addActionListener(e -> cardLayout.show(contentPanel, "Add"));
      btnBackStud.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnBackCourses.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnBackProf.addActionListener(e -> cardLayout.show(contentPanel, "Dashboard"));
      btnProfile.addActionListener(e -> cardLayout.show(contentPanel, "Profile"));
      btnCourses.addActionListener(e -> cardLayout.show(contentPanel, "Courses"));
      btnStudents.addActionListener(e -> cardLayout.show(contentPanel, "Students"));
      btnLogout.addActionListener(e -> {
       this.dispose();
       new LoginPage(client).setVisible(true);
      });
      
      btnCourses.addActionListener(e -> {
       List<Course> courses = client.viewCourses();
       if (courses != null && !courses.isEmpty()) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Course ID", "Course Name", "Credits"}, 0);
        for (Course c : courses) {
            model.addRow(new Object[]{c.getCourseID(), c.getCourseName(), c.getCredits()});
        }
        tblCourses.setModel(model);
    } else {
        JOptionPane.showMessageDialog(this, "No courses found.");
    }
      });
      
      btnAddCourse.addActionListener(e -> {
       List<Course> courses = client.viewCourses();
       if (courses != null && !courses.isEmpty()) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Course ID", "Course Name", "Credits", "Department", "Duration"}, 0);
        for (Course c : courses) {
            model.addRow(new Object[]{c.getCourseID(), c.getCourseName(), c.getCredits()});
        }
        tblCourses.setModel(model);
    } else {
        JOptionPane.showMessageDialog(this, "No courses found.");
    }   
      });
      
      btnStudents.addActionListener(e -> {
       List<Student> students = client.viewStudents();
    if (students != null && !students.isEmpty()) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Student ID", "Name", "Surname", "Email address", "Phone number"}, 0);
        for (Student s : students) {
            model.addRow(new Object[]{s.getStudentNo(), s.getName(), s.getSurname(), s.getEmailAdd(), s.getPhoneNo() });
        }
        tblStudents.setModel(model);
    } else {
        JOptionPane.showMessageDialog(this, "No students found.");
    }   
      });
      
      btnAddStudent.addActionListener(e -> {
       List<Student> students = client.viewStudents();
    if (students != null && !students.isEmpty()) {
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Student ID", "Name", "Surname", "Email address", "Phone number"}, 0);
        for (Student s : students) {
            model.addRow(new Object[]{s.getStudentNo(), s.getName(), s.getSurname(), s.getEmailAdd(), s.getPhoneNo() });
        }
        tblStudents.setModel(model);
    } else {
        JOptionPane.showMessageDialog(this, "No students found.");
    }      
      });
      
      btnAddStudents.addActionListener(e -> {
        String studentNo = txtStudNo.getText().trim();
        String name = txtAddName.getText().trim();
        String surname = txtAddSurname.getText().trim();
        String password = txtPassword.getText().trim();
        String emailAdd = txtStudEmail.getText().trim();
        String phoneNo = txtContNo.getText().trim();

    Student s = new Student(studentNo, name, surname, password, emailAdd, phoneNo);
    String response = client.addStudent(s);

    JOptionPane.showMessageDialog(this,
        response.equals("STUDENT_ADDED") ? "Student added successfully!" : "Failed to add student.");  
      });
      
      btnAddCours.addActionListener(e -> {
        String id = txtCourseId.getText().trim();
        String name = txtCourseName.getText().trim();
        int credits = Integer.parseInt(txtCredits.getText().trim());

        Course c = new Course(id, name, credits);
        String response = client.addCourse(c);

        JOptionPane.showMessageDialog(this,
        response.equals("COURSE_ADDED") ? "Course added successfully!" : "Failed to add course.");  
      });
      
      btnProfile.addActionListener(e -> {
       try {
           List<Admin> admins = client.viewAdmins();
           
           for (Admin admin : admins) {
               if (admin.getAdminId().equals(adminUsername)) {
                   txtName.setText(admin.getName());
                   txtSurname.setText(admin.getSurname());
                   txtEmail.setText(admin.getEmail());
                   txtContact.setText(admin.getContactNo());
                   txtRole.setText(admin.getRole());
                   txtAdminId.setText(admin.getAdminId());
                   break;
               }
           }
       }catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Error loading profile: " + ex.getMessage());
        ex.printStackTrace();
       } 
      });
      
      add(menuPanel, BorderLayout.WEST);
      add(contentPanel, BorderLayout.CENTER);
      
      setVisible(true);
    }
    }

