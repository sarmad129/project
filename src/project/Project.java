package project;

import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Project{
   
    static Project project = new Project();
    Assignment assignment = new Assignment();
    Quiz quiz = new Quiz();
    Calculation calculation = new Calculation();
    
    ArrayList<String> ids = new ArrayList<String>();
    
    int id = 0;


    
    

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

    
    
    
    
    
    void add_details(String userName) throws IOException{
        
        int quiz1 = quiz.quiz_marks.get(id) + quiz.quiz_marks.get(id+1);
        int assignment1 = assignment.assignment_marks.get(id) + assignment.assignment_marks.get(id+1);
        
        calculation.calculate_grade(userName, id);
        
        File f = new File("qna_db.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(f,true)); 
            bw.write(userName + "|" + quiz1 + "|"+ assignment1 + "|" + calculation.grades.get(id));
            bw.flush();
            bw.newLine();
            bw.close();
        id=id+2;
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
    
       
       
       
       
    
   

    public static void main(String[] args){
        
        new MainPage().setVisible(true);
        
    }
}








class Calculation{

    static ArrayList<String> grades = new ArrayList<String>(); 
    Assignment assignment = new Assignment();
    Quiz quiz = new Quiz();
    static Calculation calculation = new Calculation();

    void calculate_grade(String userName,int id){
        int grade_marks=quiz.quiz_marks.get(id)+quiz.quiz_marks.get(id+1)+assignment.assignment_marks.get(id)+assignment.assignment_marks.get(id+1);
        
        double final_grades=grade_marks*2.5;
        
        if(final_grades > 80.0)
            grades.add("A");
        else
            grades.add("B");

        System.out.println(grades);
    }   
}







class Quiz {

    static ArrayList<Integer> quiz_marks = new ArrayList<Integer>();
    static Quiz quiz = new Quiz();
    static Project project = new Project();

    
    
    void take_quiz(String userName){
        quiz_marks.add(7);
        quiz_marks.add(8);
    }

    
    
    void quiz_details_show(String userName){
        System.out.println();
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println("\t\t\tQuiz Marks Summary");
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println(" |                          "+ userName.toUpperCase() + "                          | ");
        System.out.println();
        System.out.println(" |  Subjects\t\t\t\t\tMarks");
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println(" |  English\t\t\t\t\t\t" + quiz.quiz_marks.get(project.id) + "                   |");
        System.out.println(" |  Multi-Cal\t\t\t\t\t" + quiz.quiz_marks.get(project.id+1) + "                     |");
        System.out.println(" --------------------------------------------------------------------- ");
       
    }
}








class Assignment{
    Random rand = new Random();
    static ArrayList<Integer> assignment_marks = new ArrayList<>();
    static Assignment assignment = new Assignment();
    static Project project = new Project();

    int assignment_count = 0;

    void take_assignment(String userName){
        int r1 = rand.nextInt((10 - 5) + 1) + 5;
        int r2 = rand.nextInt((10 - 5) + 1) + 5;
        assignment_marks.add(r1);
        assignment_marks.add(r2);
        System.out.println(" ------------------------------------------------------------------------ ");
        System.out.println("\t\tAssignment Uploaded Successfully!");
        System.out.println(" ------------------------------------------------------------------------ ");
        System.out.println();
        assignment_count++;
       
    }

    
    
    
    
    
    void assignment_details_show(String userName){
        System.out.println();
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println("\t\t\tAssignment Marks Summary");
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println(" |                          "+ userName.toUpperCase() + "                          | ");
        System.out.println();
        System.out.println(" |  Subjects\t\t\t\t\tMarks");
        System.out.println(" --------------------------------------------------------------------- ");
        System.out.println(" |  English\t\t\t\t\t  " + assignment.assignment_marks.get(project.id) + "                   |");
        System.out.println(" |  Multi-Cal\t\t\t\t\t  " + assignment.assignment_marks.get(project.id+1) + "                     |");
        System.out.println(" --------------------------------------------------------------------- ");
      
    }


}