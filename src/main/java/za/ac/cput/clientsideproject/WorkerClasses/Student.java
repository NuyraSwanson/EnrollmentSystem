
package za.ac.cput.clientsideproject.WorkerClasses;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * ADP Final assignment
 */

public class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //variables/attributes for students
   private String studentNo;
   private String name;
   private transient String password;
   
   //constructor
   public Student(String studentNo, String name, String password){
       this.studentNo = studentNo;
       this.name = name;
       this.password = password;
       
   }
   
   //Getters
   public String getStudentNo(){
       return studentNo;
   }
   
   public String getName(){
       return name;
   }
   
   public String getPassword(){
       return password;
   }
   
   //Setters
   public void setStudentNo(String studentNo){
       this.studentNo = studentNo;
   }
   
   public void setName(String name){
       this.name = name;
   }
   
   public void setPassword(String password){
       this.password = password;
   }
   
   //custom serialization
   private void writeObject(ObjectOutputStream out) throws IOException {
    out.defaultWriteObject();
    out.writeObject("*****");
   }
   
   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
    in.defaultReadObject();
    password = "default";
   }
   
  @Override
public String toString() {
    return "Student{" +
            "studentNo='" + studentNo + '\'' +
            ", name='" + name + '\'' +
            '}';
}
}
