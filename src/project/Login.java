/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

/**
 */
public interface Login {
    
    String username = null;
    String password = null;
    
    public void login(String username, String password, String filepath);
    
}
