/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.Serializable;
import bean.UserBean;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Vanesh
 */
@ManagedBean(name = "book")
public class contentBook implements Serializable {
    public String subject;
    public String content;
    public String date;
    public String author;
    
    public contentBook(String subject,String content,String date,String author){
        this.author=author;
        this.content=content;
        this.date=date;
        this.subject=subject;
    }
    public contentBook(){}
    
    public String getSubject(){return subject;}
    public void setSubject(String subject){this.subject=subject;}
    public String getContent(){return content;}
    public void setContent(String content){this.content=content;}
    public String getDate(){return date;}
    public void setDate(String date){this.date=date;}
    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author=author;}
    
}
