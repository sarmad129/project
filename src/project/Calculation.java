/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;

/**
 *
 * @author Abdullah
 */
public class Calculation extends Student{
    
    static ArrayList<String> grades = new ArrayList<String>(); 
    Assignment assignment = new Assignment();
    Quiz quiz = new Quiz();
    static Calculation calculation = new Calculation();

    
    
    
    
    void calculate_grade(String userName,int id){
        int grade_marks=quiz.quiz_marks.get(id)+quiz.quiz_marks.get(id+1)+assignment.assignment_marks.get(id)+assignment.assignment_marks.get(id+1);
        
        double final_grades=grade_marks*2.5;
        
        if(final_grades > 80.0)
            grades.add("A");
        else if(final_grades <80.0 && final_grades>70.0){ 
            grades.add("B");
        }
        else if(final_grades <70.0 && final_grades>60.0)
            grades.add("C");
        else{
            grades.add("D");
        }
        System.out.println(grades);
        
        
    }  
    
}
