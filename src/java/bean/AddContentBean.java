/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import mysql.DBWorker;
import java.sql.SQLException;
import java.sql.Statement;
import bean.contentBook;
import bean.UserBean;

@ManagedBean(name="addContent")
/**
 *
 * @author Vanesh
 */
public class AddContentBean implements Serializable{
    private String subject;
     private String content;
     
     public String getSubject(){return subject;}
    public void setSubject(String subject){this.subject=subject;}
    public String getContent(){return content;}
    public void setCintent(String content){this.content=content;}
    public void insert()throws SQLException{ 
        String author = UserBean.name;
    String addCont="insert into booklist(subject, content, date, author) values('"+subject+"','"+content+"',curdate(),'"+author+"');";
    DBWorker worker = new DBWorker();
    Statement statement = worker.getConnection().createStatement();
       
    }
    
}
