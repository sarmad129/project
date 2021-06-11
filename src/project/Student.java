/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah
 */
public class Student extends Project implements Login{
    
   
        public void studentsignup(String username){
        
        File f = new File("studentlogindetails.txt");
        
        
        try {
            BufferedWriter n = new BufferedWriter(new FileWriter(f,true));
            n.write(username+",");
            n.write("cui@123");
            n.newLine();
            n.flush();
            n.close();
        } catch (IOException ex) {
            Logger.getLogger(Studentsignup.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(null, "Account created successfully!!");
        }
        
        
        
        
        
        @Override
        public void login(String username, String password, String filepath) {
        File d = new File(filepath);
        boolean found = false;
        String tempemail = "";
        String temppassword = "";
        
        Scanner x;
        try {
            x = new Scanner(d);
            x.useDelimiter("[,\n]");
            while (x.hasNext() && !found){
                tempemail = x.next();
                temppassword = x.next();
                
                if (tempemail.trim().equals(username.trim())  &&  temppassword.trim().equals(password.trim())){
                    found = true;
                   
                    JOptionPane.showMessageDialog(null,"Logged in successfully");
                    new StudentPortal().setVisible(true);
                    break;
                    }
                else{  
                    continue;}}
            
              
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }if (found != true){
           
            JOptionPane.showMessageDialog(null,"Invalid Credentials");
            new Studentloginpage().setVisible(true);
        }
    }
    
    
    
    
        
    
        @Override
     void add_details(String userName) throws IOException{
        
        int quiz1 = quiz.quiz_marks.get(id) + quiz.quiz_marks.get(id+1);
        int assignment1 = assignment.assignment_marks.get(id) + assignment.assignment_marks.get(id+1);
        
        calculation.calculate_grade(userName, id);
        
        File f = new File("qna_db.txt");
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(f,true))) {
                bw.write(userName + "|" + quiz1 + "|"+ assignment1 + "|" + calculation.grades.get(id));
                bw.flush();
                bw.newLine();
            }
        id=id+2;
    }

    
}
