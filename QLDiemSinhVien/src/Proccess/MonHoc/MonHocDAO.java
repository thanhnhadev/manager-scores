package Proccess.MonHoc;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MonHocDAO implements IMonHocDAO
{
    @Override
    public ArrayList<MonHoc> getAll()
    {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from MonHoc");
                rs = ps.executeQuery();
                list = new ArrayList<MonHoc>();
                
                while (rs.next())
                {
                    MonHoc mh = new MonHoc();
                    mh.setMamh(rs.getString(1));
                    mh.setTenmh(rs.getString(2));
                    mh.setSotinchi(rs.getInt(3));
                    mh.setHinhthucthi(rs.getString(4));
                    mh.setHocky(rs.getInt(5));
                    mh.setPhonghoc(rs.getString(6));
                    list.add(mh);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<MonHoc> findByIDMonHoc(String mamh)
    {
        ArrayList<MonHoc> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from MonHoc where MaMH=?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<MonHoc>();
                
                while (rs.next())
                {
                    MonHoc mh = new MonHoc();
                    mh.setMamh(rs.getString(1));
                    mh.setTenmh(rs.getString(2));
                    mh.setSotinchi(rs.getInt(3));
                    mh.setHinhthucthi(rs.getString(4));
                    mh.setHocky(rs.getInt(5));
                    mh.setPhonghoc(rs.getString(6));
                    list.add(mh);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public MonHoc addNew(MonHoc mh)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Insert into MonHoc values (?,?,?,?,?,?)");
                ps.setString(1, mh.getMamh());
                ps.setString(2, mh.getTenmh());
                ps.setInt(3, mh.getSotinchi());
                ps.setString(4, mh.getHinhthucthi());
                ps.setInt(5, mh.getHocky());
                ps.setString(6, mh.getPhonghoc());

                int row = ps.executeUpdate();
                if (row < 1)
                {
                    mh = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                mh = null;
            }
            finally
            {
                Connect.close(ps);
            }
        }
        return mh;
    }

    @Override
    public MonHoc updateByID(MonHoc mh)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Update MonHoc set TenMH=?, SoTinChi=?, HinhThucThi=?, HocKy=?, PhongHoc=? where MaMH=?");                
                ps.setString(1, mh.getTenmh());
                ps.setInt(2, mh.getSotinchi());
                ps.setString(3, mh.getHinhthucthi());
                ps.setInt(4, mh.getHocky());
                ps.setString(5, mh.getPhonghoc());
                ps.setString(6, mh.getMamh());
                
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    mh = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
                mh = null;
            }
            finally
            {
                Connect.close();
            }
        }
        return mh;
    }

    public void deleteMonHoc(String MonHocID) throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            ps = Connect.cnn.prepareStatement("Delete from MonHoc where MaMH=?");
            ps.setString(1, MonHocID);
            ps.executeUpdate();
            Connect.close();
        }
    }

    @Override
    public ArrayList<MonHoc> CheckID(String mamh)
    {
        ArrayList<MonHoc> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                psCheck = Connect.cnn.prepareStatement("Select * from MonHoc where MaMH=?");
                psCheck.setString(1, mamh);
                rs = psCheck.executeQuery();
                list = new ArrayList<MonHoc>();
                
                while (rs.next())
                {
                    MonHoc mh = new MonHoc();
                    mh.setMamh(rs.getString(1));
                    list.add(mh);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(MonHocDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(psCheck, rs);
            }
        }
        return  list;
    }
}
