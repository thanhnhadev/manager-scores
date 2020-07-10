package Proccess.GiangVien;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GiangVienDAO implements IGiangVienDAO
{
    @Override
    public ArrayList<GiangVien> getAll()
    {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from GiangVien");
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                
                while (rs.next())
                {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setGioitinh(rs.getBoolean(3));
                    gv.setNgaysinh(new Date(rs.getDate(4).getTime()));
                    gv.setDiachi(rs.getString(5));
                    gv.setEmail(rs.getString(6));                    
                    gv.setSdt(rs.getString(7));
                    gv.setMamh(rs.getString(8));                                                                              
                    list.add(gv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<GiangVien> findByIDMonHoc(String mamh)
    {
        ArrayList<GiangVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from GiangVien where MaMH=?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<GiangVien>();
                
                while (rs.next())
                {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    gv.setHotengv(rs.getString(2));
                    gv.setGioitinh(rs.getBoolean(3));                                        
                    gv.setNgaysinh(new Date(rs.getDate(4).getTime()));
                    gv.setDiachi(rs.getString(5));
                    gv.setEmail(rs.getString(6));                    
                    gv.setSdt(rs.getString(7));
                    gv.setMamh(rs.getString(8));
                    list.add(gv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public GiangVien addNew(GiangVien gv)
    {
        PreparedStatement ps = null;      
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Insert into GiangVien values (?,?,?,?,?,?,?,?)");
                ps.setString(1, gv.getMagv());
                ps.setString(2, gv.getHotengv());
                ps.setBoolean(3, gv.isGioitinh());
                ps.setDate(4, new java.sql.Date(gv.getNgaysinh().getTime()));
                ps.setString(5, gv.getDiachi());
                ps.setString(6, gv.getEmail());                
                ps.setString(7, gv.getSdt());
                ps.setString(8, gv.getMamh());
                
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    gv = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            }
            finally
            {
                Connect.close(ps);
            }
        }
        return gv;
    }

    @Override
    public GiangVien updateByID(GiangVien gv)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Update GiangVien set HoTenGV=?, GioiTinh=?, NgaySinh=?, DiaChi=?, Email=?, SDT=?, MaMH=? where MaGV=?");                               
                ps.setString(1, gv.getHotengv());
                ps.setBoolean(2, gv.isGioitinh());
                ps.setDate(3, new java.sql.Date(gv.getNgaysinh().getTime()));
                ps.setString(4, gv.getDiachi());
                ps.setString(5, gv.getEmail());                
                ps.setString(6, gv.getSdt());               
                ps.setString(7, gv.getMamh());
                ps.setString(8, gv.getMagv());

                int row = ps.executeUpdate();
                if (row < 1)
                {
                    gv = null;
                } 
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                gv = null;
            }
            finally
            {
                Connect.close();
            }
        }
        return gv;
    }
    
    public void deleteGiangVien(String GiangVienID) throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            ps = Connect.cnn.prepareStatement("Delete from GiangVien where MaGV=?");
            ps.setString(1, GiangVienID);
            ps.executeUpdate();
            Connect.close();
        }
    }

    @Override
    public ArrayList<GiangVien> CheckID(String magv)
    {
        ArrayList<GiangVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                psCheck = Connect.cnn.prepareStatement("Select * from GiangVien where MaGV=?");
                psCheck.setString(1, magv);
                rs = psCheck.executeQuery();
                list = new ArrayList<GiangVien>();
                                
                while (rs.next())
                {
                    GiangVien gv = new GiangVien();
                    gv.setMagv(rs.getString(1));
                    list.add(gv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(GiangVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(psCheck, rs);
            }
        }
        return  list;
    }
}
