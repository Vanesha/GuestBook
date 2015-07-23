/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mysql.DBWorker;
import mysql.User;

@ManagedBean(name ="user")
@SessionScoped
/**
 *
 * @author Vanesh
 */
public class UserBean implements Serializable{
    public static String name="Гость";
    private String password;
    private User LogUser = new User("","","");
    
    public String getName(){return name;}
    public void setName(String name){ this.name = name;}
    public String getPassword(){return password;}
    public void setPassword(String password){this.password=password;}
    public User getLogUser(){return LogUser;}
    public void setLogUser(User LogUser){this.LogUser=LogUser;}
    
    public void LogUser(String name, String password){
       DBWorker worker = new DBWorker();
        ResultSet res = worker.executeResult("SELECT * FROM users WHERE name='"+name+"'");
        if (res != null) {
            try {
                while(res.next()) {
                    this.LogUser = new User(res.getString("name"), res.getString("login"),
                            res.getString("password"));
                }
            } 
            catch (SQLException ex) {
                FacesContext.getCurrentInstance().addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Error",ex.toString()));
            }
            finally{worker.close();}
        }
       
        
        }
    public String logout() {
        name="Гость";
        return "index";
    }
    
    public String openIn(){
       
         return "in";
    }
    public boolean result(String name, String password){
        LogUser(name,password);
        return (this.LogUser.getPassword().equals(password));
    }
    
    public String loginProject() {
        FacesContext mesg = FacesContext.getCurrentInstance();
        if (result(name,String.valueOf(password.hashCode()))) {
            mesg.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_INFO,"Авторизация успешна.",""));
            return "indexWithLog";
        } 
        else {
            mesg.addMessage(null,new FacesMessage(FacesMessage.SEVERITY_WARN,"Неверный логин/пароль!","Повторите попытку."));
            return "index";
        }
    }

    
}
