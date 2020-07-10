package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Connect
{
    public static Connection cnn;
    public static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static String url = "jdbc:sqlserver://DELL-PC:1433; databaseName=QLDiemSinhVien";
    public static String user = "sa";
    public static String pass = "123456";   

    public static boolean open()
    {
        try
        {
            if (cnn == null || cnn.isClosed())
            {
                Class.forName(driver);
                cnn = DriverManager.getConnection(url, user, pass);
            }
            return true;
        }
        catch (SQLException ex)
        {
            System.out.println(ex.getMessage()+"1");
        }
        catch (ClassNotFoundException ex)
        {
            System.out.println(ex.getMessage()+"2");
        }
        return false;
    }

    public static void close()
    {
        try
        {
            if (cnn != null)
                cnn.close();
        } 
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }       
    }
    
    public static void close(PreparedStatement ps)
    {
        try
        {
            if (ps != null)
                ps.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close();
    }
    
    public static void close(PreparedStatement ps, ResultSet rs)
    {
        try
        {
            if (rs !=null)
                rs.close();
        }
        catch (SQLException ex)
        {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        close(ps);
    }
}
