/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.io.Serializable;

/**
 *
 * @author Vanesh
 */
public class User implements Serializable{
    private String name;
    private String password;
    private String login;
    
    public User(){}
    
    public User(String login, String password){
        this.login=login;
        this.password=password;
    }
    
    public User( String name, String login, String password){
        this.login=login;
        this.name=name;
        this.password=password;
    }
    
    
     public String getName(){return name;}
    public void setName(String name){this.name=name;}
     public String getLogin(){return login;}
    public void setLogin(String login){this.login=login;}
     public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    
    
}
