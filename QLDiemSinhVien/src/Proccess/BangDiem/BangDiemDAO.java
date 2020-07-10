package Proccess.BangDiem;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BangDiemDAO implements IBangDiemDAO
{
    @Override
    public ArrayList<BangDiem> getAll()
    {       
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from Diem");
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                    bd.setLanthi(rs.getInt(3));
                    bd.setHeso(rs.getInt(4));
                    bd.setDiem(rs.getFloat(5));
                    bd.setTrangthai(rs.getBoolean(6));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<BangDiem> findByIDSinhVien(String masv)
    {
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from Diem where MaSV=?");
                ps.setString(1, masv);
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                    bd.setLanthi(rs.getInt(3));
                    bd.setHeso(rs.getInt(4));
                    bd.setDiem(rs.getFloat(5));
                    bd.setTrangthai(rs.getBoolean(6));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }
       
    @Override
    public ArrayList<BangDiem> findByIDMonHoc(String mamh)
    {
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from Diem where MaMH=?");
                ps.setString(1, mamh);
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString(2));
                    bd.setLanthi(rs.getInt(3));
                    bd.setHeso(rs.getInt(4));
                    bd.setDiem(rs.getFloat(5));
                    bd.setTrangthai(rs.getBoolean(6));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }
    
    @Override
    public BangDiem addNew(BangDiem bd)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Insert into Diem values (?,?,?,?,?,?)");
                ps.setString(1, bd.getMasv());
                ps.setString(2, bd.getMamh());
                ps.setInt(3, bd.getLanthi());
                ps.setInt(4, bd.getHeso());
                ps.setFloat(5, bd.getDiem());
                ps.setBoolean(6, bd.isTrangthai());
                
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    bd = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
                bd = null;
            }
            finally
            {
                Connect.close(ps);
            }
        }
        return bd;
    }

    @Override
    public BangDiem updateByID(BangDiem bd)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Update Diem set HeSo=?, Diem=?, TrangThai=? where MaSV=? and MaMH=? and LanThi=?");
                ps.setInt(1, bd.getHeso());
                ps.setFloat(2, bd.getDiem());
                ps.setBoolean(3, bd.isTrangthai());
                ps.setString(4, bd.getMasv());
                ps.setString(5, bd.getMamh());
                ps.setInt(6, bd.getLanthi());
                
                int row = ps.executeUpdate();
                if (row < 1)
                {
                    bd = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
                bd = null;
            }
            finally
            {
                Connect.close();
            }
        }
        return bd;
    }

    public void deleteBangDiem(String MaSV, String MaMH, int LanThi) throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            ps = Connect.cnn.prepareStatement("Delete from Diem where MaSV=? and MaMH=? and LanThi=?");
            ps.setString(1, MaSV);
            ps.setString(2, MaMH);
            ps.setInt(3, LanThi);
            ps.executeUpdate();
            Connect.close();
        }
    }

    @Override
    public boolean CheckID(String masv, String mamh, int lanthi)
    {
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        boolean result = true;
        
        if (Connect.open())
        {
            try
            {
                psCheck = Connect.cnn.prepareStatement("Select * from Diem where MaSV=? and MaMH=? and LanThi=?");
                psCheck.setString(1, masv);
                psCheck.setString(2, mamh);
                psCheck.setInt(3, lanthi);
                rs = psCheck.executeQuery();
                result = rs.next();
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(psCheck, rs);
            }
        }
        return result;
    }

    @Override
    public ArrayList<BangDiem> findMaSV()
    {
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select distinct MaSV from Diem where TrangThai is not null");
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setMasv(rs.getString(1));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }
     
    @Override
    public ArrayList<BangDiem> findMaMH(String masv)
    {
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select distinct MaMH from Diem where TrangThai is not null and MaSV=?");
                ps.setString(1, masv);
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setMasv(rs.getString(1));
                    bd.setMamh(rs.getString("MaMH"));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    public ArrayList<BangDiem> loaddiem(String masv, String mamh)
    {
        ArrayList<BangDiem> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select LanThi, HeSo, Diem from Diem where MaMH=? and MaSV=?");
                ps.setString(1, mamh);
                ps.setString(2, masv);
                rs = ps.executeQuery();
                list = new ArrayList<BangDiem>();
                
                while (rs.next())
                {
                    BangDiem bd = new BangDiem();
                    bd.setLanthi(rs.getInt("LanThi"));
                    bd.setHeso(rs.getInt("HeSo"));
                    bd.setDiem(rs.getFloat("Diem"));
                    list.add(bd);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(BangDiemDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }
}
