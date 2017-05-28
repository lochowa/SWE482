/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.sqlitejdbcdriverconnection;
 
import Insert_Person.Insert_Person;
import Create_Person_Table.Create_Person_Table;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static Create_Person_Table.Create_Person_Table.createNewTable;
/**
 *
 * @author Andrew Lochow
 */
public class SQLiteJDBCDriverConnection {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/sqlite/db/test.db";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        connect();
        Create_Person_Table.createNewTable();
        Insert_Person app2 = new Insert_Person();
        // insert three new rows
        app2.insert("Andrew Lochow", "Surface Owner");
        app2.insert("Michael Barth", "Mineral Owner");
        app2.insert("David Watts", "Deceased");
        // TODO code application logic here
    }
    
}
