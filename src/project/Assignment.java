/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Abdullah
 */
public class Assignment extends Student {
    
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
