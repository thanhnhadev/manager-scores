package Proccess.Lop;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LopDAO implements ILopDAO
{
    @Override
    public ArrayList<Lop> getAll()
    {
        ArrayList<Lop> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from Lop");
                rs = ps.executeQuery();              
                list = new ArrayList<Lop>();
                
                while (rs.next())
                {
                    Lop lop = new Lop();
                    lop.setMalop(rs.getString(1));
                    lop.setTenlop(rs.getString(2));
                    lop.setKhoahoc(rs.getString(3));
                    lop.setMakhoa(rs.getString(4));                                                            
                    list.add(lop);
                }                
            }
            catch (SQLException ex)
            {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<Lop> findByIDKhoa(String makhoa)
    {
        ArrayList<Lop> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from Lop where MaKhoa=?");
                ps.setString(1, makhoa);
                rs = ps.executeQuery();
                list = new ArrayList<Lop>();
                
                while (rs.next())
                {
                    Lop lop = new Lop();
                    lop.setMalop(rs.getString(1));
                    lop.setTenlop(rs.getString(2));
                    lop.setKhoahoc(rs.getString(3)); 
                    lop.setMakhoa(rs.getString(4));                                                          
                    list.add(lop);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public Lop addNew(Lop lop)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Insert into Lop values(?,?,?,?)");
                ps.setString(1, lop.getMalop());
                ps.setString(2, lop.getTenlop());
                ps.setString(3, lop.getKhoahoc());
                ps.setString(4, lop.getMakhoa());               
                
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    lop = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
                lop = null;
            }
            finally
            {
                Connect.close(ps);
            }
        }
        return lop;
    }

    @Override
    public Lop updateByID(Lop lop)    
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Update Lop set TenLop=?, KhoaHoc=?, MaKhoa=? where MaLop=?");                
                ps.setString(1, lop.getTenlop());
                ps.setString(2, lop.getKhoahoc());
                ps.setString(3, lop.getMakhoa());
                ps.setString(4, lop.getMalop());
               
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    lop = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
                lop = null;
            }
            finally
            {
                Connect.close();
            }
        }
        return lop;
    }
    
    public void deleteLop(String LopID) throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            ps = Connect.cnn.prepareStatement("Delete from Lop where MaLop=?");
            ps.setString(1, LopID);
            ps.executeUpdate();
            Connect.close();
        }
    }

    @Override
    public ArrayList<Lop> checkID(String malop)
    {        
        ArrayList<Lop> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                psCheck = Connect.cnn.prepareStatement("Select * from Lop where MaLop=?");
                psCheck.setString(1, malop);
                rs = psCheck.executeQuery();
                list = new ArrayList<Lop>();
                
                while (rs.next())
                {
                    Lop lop = new Lop();
                    lop.setMalop(rs.getString(1));
                    list.add(lop);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(LopDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(psCheck, rs);
            }           
        }
        return list;
    }   
}
