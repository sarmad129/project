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
public class Quiz extends Student {
    
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
