/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import mysql.DBWorker;

@ManagedBean(name="registration")

/**
 *
 * @author Vanesh
 */
public class RegistrationBean {
    private String name;
    private String login;
    private String password;
    
      public String getName(){return name;}
    public void setName(String name){this.name=name;}
     public String getLogin(){return login;}
    public void setLogin(String login){this.login=login;}
     public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    
    
    public String Registation() throws SQLException{
          
       
        DBWorker worker = new DBWorker();
        String registr = "insert into users (name, login,password) values('"+name+"','"+login+"','"+password.hashCode()+"');";
        FacesContext mesg = FacesContext.getCurrentInstance(); 
        Statement statement = worker.getConnection().createStatement();
         
        if (name.trim().equals("") || password.trim().equals("") || login.trim().equals("")){
            mesg.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Warning!","Необходимо заполнить все поля"));
            worker.close();
            return "Registration";
        }
        else{
            statement.executeQuery(registr);
            worker.close();
             return "index";
        }
       
        
        }}


