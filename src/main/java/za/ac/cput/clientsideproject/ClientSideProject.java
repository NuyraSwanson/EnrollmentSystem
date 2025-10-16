
package za.ac.cput.clientsideproject;


import java.util.List;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.SwingUtilities;
import za.ac.cput.clientsideproject.GUI.AdminGUI;
import za.ac.cput.clientsideproject.GUI.LoginPage;
import za.ac.cput.clientsideproject.GUI.StudentGUI;
import za.ac.cput.shared.WorkerClasses.Admin;
import za.ac.cput.shared.WorkerClasses.Course;
import za.ac.cput.shared.WorkerClasses.Enroll;
import za.ac.cput.shared.WorkerClasses.Student;

/**
 * ADP Final assignment 2025
 */

public class ClientSideProject {
    private Socket socket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public ClientSideProject() {
        try {
            socket = new Socket("127.0.0.1", 5678);
            System.out.println("Connected to server.");
            out = new ObjectOutputStream(socket.getOutputStream());
            out.flush();
            in = new ObjectInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Connection error: " + e.getMessage());
        }
    }

    // LOGIN
    public String login(String role, String username, String password) {
        try {
            out.writeObject("LOGIN");
            out.writeObject(role);
            out.writeObject(username);
            out.writeObject(password);
            out.flush();

            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Login error: " + e.getMessage());
        }
        return "FAIL";
    }

    // ADD STUDENT
    public String addStudent(Student s) {
        try {
            out.writeObject("ADD_STUDENT");
            out.writeObject(s);
            out.flush();
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Add student error: " + e.getMessage());
        }
        return "FAIL";
    }

    // ADD COURSE
    public String addCourse(Course c) {
        try {
            out.writeObject("ADD_COURSE");
            out.writeObject(c);
            out.flush();
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Add course error: " + e.getMessage());
        }
        return "FAIL";
    }

    // VIEW STUDENTS
    public List<Student> viewStudents() {
        try {
            out.writeObject("VIEW_STUDENTS");
            out.flush();
            return (List<Student>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("View students error: " + e.getMessage());
        }
        return null;
    }

    // VIEW COURSES
    public List<Course> viewCourses() {
        try {
            out.writeObject("VIEW_COURSES");
            out.flush();
            return (List<Course>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("View courses error: " + e.getMessage());
        }
        return null;
    }

    // ENROLL
    public String enroll(Enroll e) {
        try {
            out.writeObject("ENROLL");
            out.writeObject(e);
            out.flush();
            return (String) in.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Enroll error: " + ex.getMessage());
        }
        return "FAIL";
    }
    
    public Admin getAdmin(String username) {
      try {
          out.writeObject("GET_ADMIN");
          out.writeObject(username);
          out.flush();
          return (Admin) in.readObject();
}catch (IOException | ClassNotFoundException e) {
    System.out.println("Get admin error: " + e.getMessage());
      } 
      return null;
    }
    
    public List<Admin> viewAdmins() {
    try {
        out.writeObject("VIEW_ADMINS");
        out.flush();
        return (List<Admin>) in.readObject();
    } catch (IOException | ClassNotFoundException e) {
        System.out.println("View admins error: " + e.getMessage());
    }
    return new ArrayList<>();
}
    
    

    // CLOSE
    public void close() {
        try {
            socket.close();
            out.close();
            in.close();
        } catch (IOException e) {
            System.out.println("Error closing connection: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        ClientSideProject client = new ClientSideProject();
        
        SwingUtilities.invokeLater(() -> {
        // Create and show the login page
        LoginPage loginPage = new LoginPage(client);
        loginPage.setVisible(true);
    });
    }
}
