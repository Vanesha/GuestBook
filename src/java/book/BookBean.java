package book;
import bean.contentBook;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import mysql.DBWorker;

@ManagedBean
@RequestScoped

public class BookBean implements Serializable{
   
    private List<contentBook> books;
    
    public BookBean(){}
    

    public void addBooks() throws SQLException {
        books = new ArrayList<contentBook>();
        DBWorker worker = new DBWorker();
        String query ="SELECT * FROM booklist";
        Statement statement = worker.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
       
       // ResultSet rs = worker.executeResult("SELECT * FROM booklist");
        
        if (rs != null) {
            try {
                while(rs.next()) {
                    contentBook book = new contentBook();
                    book.setSubject(rs.getString(2));
                    book.setContent(rs.getString(3));
                    book.setDate(rs.getString(4));
                    book.setAuthor(rs.getString(5));
                    books.add(book);
                }
            } 
            catch (SQLException ex) {}
            finally{worker.close();}
        }
    }

    public List<contentBook> getBooks() { return books;}
   
    public void setMessages(List<contentBook> messages) {this.books = books;}
 }       
    

