/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Abdullah
 */
public class Teacher extends Person {
    
    
    
    
    public void teacherlogin(){
        File f = new File("teacherlogindetails.txt");
        
        try {
            BufferedWriter n = new BufferedWriter(new FileWriter(f));
            n.write("admin,");
            n.write("admin");
            n.close();
        } catch (IOException ex) {
            Logger.getLogger(Teacher.class.getName()).log(Level.SEVERE, null, ex);
        }
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
                    new Teacherportal().setVisible(true);
                    break;
                    }
                else{  
                    continue;}}
            
              
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(Project.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }if (found != true){
           
            JOptionPane.showMessageDialog(null,"Invalid Credentials");
            new Teacherlogin().setVisible(true);
        }
    }
    
    
    
    
    
        void admin_search_record() throws IOException {

        String ID,record = "";
        Scanner input = new Scanner(System.in);
        
        BufferedReader br = new BufferedReader(new FileReader("qna_db.txt") );

        System.out.println(" ---------------------------------------------------------- ");        
        System.out.println("\t\t Search Student Record\n");
        System.out.println(" ---------------------------------------------------------- ");
    
       ID = JOptionPane.showInputDialog(null, "Enter the Student Reg.No. : ");
      
        System.out.println(" ------------------------------------------------------------------------------------- ");
        System.out.println("|\tReg.No.\t\t\tQuiz\t\t\tAssignment\t\t\tGrade\t|");
        System.out.println(" ------------------------------------------------------------------------------------- ");
        
        while( ( record = br.readLine() ) != null ) {
            
            StringTokenizer st = new StringTokenizer(record,"|");
            if(record.contains(ID) ) {
                System.out.println("|\t"+st.nextToken()+"\t\t"+st.nextToken()+"\t\t\t"+st.nextToken()+"\t\t\t\t"+st.nextToken()+"\t|");
            }
        }
        
        System.out.println("|	                                            	                                   |");
        System.out.println(" -------------------------------------------------------------------------------------- ");
    
        br.close();
    }

        
        
        
         
    
    void admin_delete_record() throws IOException{
        Scanner input =  new Scanner(System.in);
        String ID, record;
        
        File tempDB = new File("qna_db_temp.txt");
        File db = new File("qna_db.txt");
        
        
        BufferedReader br = new BufferedReader( new FileReader(db) );
        BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );
        
        System.out.println(" ---------------------------------------------------------- ");
        System.out.println("\t\t DELETE STUDENT RECORD\n");
        System.out.println(" ---------------------------------------------------------- ");

     
        ID = JOptionPane.showInputDialog(null, "Enter the Studet's Reg.No. : ");
     
        while( ( record = br.readLine() ) != null ) {
            
            if(record.contains(ID)) 
                continue;

            bw.write(record);
            bw.flush();
            bw.newLine();
        }
        
        br.close();
        bw.close();
        
        db.delete();
        
        tempDB.renameTo(db);
        JOptionPane.showMessageDialog(null, "Record Deleted Successfully!!");
}
    
    
    
    
     void admin_update_record() throws IOException{

            String new_quiz, new_assignment, new_grade, record, ID,record2;

            boolean check = true;
            int len = 0;
                
            File db = new File("qna_db.txt");
            File tempDB = new File("qna_db_temp.txt");
            
            BufferedReader br = new BufferedReader( new FileReader(db) );
            BufferedWriter bw = new BufferedWriter( new FileWriter(tempDB) );
                        
            Scanner input = new Scanner(System.in);
            
            System.out.println(" ---------------------------------------------------------- ");
            System.out.println("\t\t Update Student Record\n\n"); 
            System.out.println(" ---------------------------------------------------------- ");

       
            ID = JOptionPane.showInputDialog(null, "Enter the Student Reg. No. : ");
            System.out.println(" ------------------------------------------------------------------------------------- ");
            System.out.println("|\tReg.No.\t\t\tQuiz\t\t\tAssignment\t\t\tGrade\t|");
            System.out.println(" ------------------------------------------------------------------------------------- ");
            
            while( ( record = br.readLine() ) != null ) {
                
                StringTokenizer st = new StringTokenizer(record,"|");
                if( record.contains(ID) ) {
                    System.out.println("|\t"+st.nextToken()+"\t\t"+st.nextToken()+"\t\t\t"+st.nextToken()+"\t\t\t\t"+st.nextToken()+"\t|");
                }
            }	    		
            System.out.println("|	                                            	                                   |");
            System.out.println(" -------------------------------------------------------------------------------------- ");
            
        br.close();
      
        new_quiz = JOptionPane.showInputDialog(null, "Enter the new Quiz Marks: ");
      
        new_assignment = JOptionPane.showInputDialog(null, "Enter the new Assignment Marks: ");
      
        new_grade = JOptionPane.showInputDialog(null, "Enter the new Grade: ");

        BufferedReader br2 = new BufferedReader( new FileReader(db) );
            
        while( (record2 = br2.readLine() ) != null ) {    			
            if(record2.contains(ID)) {
                bw.write(ID+"|"+new_quiz+"|"+new_assignment+"|"+new_grade);
            } else {
                bw.write(record2);	
            }    			
            bw.flush();
            bw.newLine();
        }
        
        bw.close();
        br2.close();    		
        db.delete();    		
        boolean success = tempDB.renameTo(db);
        JOptionPane.showMessageDialog(null, "Record Updated Successfully!!");
    }

     
     
     
     
         void admin_view_record() throws IOException{
        BufferedReader br = new BufferedReader(new FileReader("qna_db.txt") );
            
        String record;
            
        System.out.println(" ------------------------------------------------------------------------------------- ");
        System.out.println("|\tReg.No.\t\t\tQuiz\t\t\tAssignment\t\t\tGrade\t|");
        System.out.println(" ------------------------------------------------------------------------------------- ");
               
        while((record = br.readLine()) != null) {
                
            StringTokenizer st = new StringTokenizer(record,"|");
                
            System.out.println("|\t"+st.nextToken()+"\t\t"+st.nextToken()+"\t\t\t"+st.nextToken()+"\t\t\t\t"+st.nextToken()+"\t|");
    
        }
        System.out.println("|	                                            	                                   |");
        System.out.println(" -------------------------------------------------------------------------------------- ");
        br.close();    		
}
    
    
    
}
