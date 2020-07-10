package Proccess.SinhVien;

import Database.Connect;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SinhVienDAO implements ISinhVienDAO
{
    @Override
    public ArrayList<SinhVien> getAll()
    {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from SinhVien");
                rs = ps.executeQuery();
                list = new ArrayList<SinhVien>();
                
                while (rs.next())
                {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString(1));
                    sv.setHotensv(rs.getString(2));
                    sv.setHedaotao(rs.getString(3));
                    sv.setGioitinh(rs.getBoolean(4));
                    sv.setNgaysinh(new Date(rs.getDate(5).getTime()));
                    sv.setDiachi(rs.getString(6));                    
                    sv.setSdt(rs.getString(7)); 
                    sv.setMalop(rs.getString(8));
                    list.add(sv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public ArrayList<SinhVien> findByIDLop(String malop)
    {
        ArrayList<SinhVien> list = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Select * from SinhVien where MaLop=?");
                ps.setString(1, malop);
                rs = ps.executeQuery();
                list = new ArrayList<SinhVien>();
                
                while (rs.next())
                {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString(1));
                    sv.setHotensv(rs.getString(2));
                    sv.setHedaotao(rs.getString(3));
                    sv.setGioitinh(rs.getBoolean(4));
                    sv.setNgaysinh(new Date(rs.getDate(5).getTime()));
                    sv.setDiachi(rs.getString(6));                    
                    sv.setSdt(rs.getString(7));                   
                    sv.setMalop(rs.getString(8));
                    list.add(sv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(ps, rs);
            }
        }
        return list;
    }

    @Override
    public SinhVien addNew(SinhVien sv)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Insert into SinhVien values (?,?,?,?,?,?,?,?)");
                ps.setString(1, sv.getMasv());
                ps.setString(2, sv.getHotensv());
                ps.setString(3, sv.getHedaotao());
                ps.setBoolean(4, sv.isGioitinh());
                ps.setDate(5, new java.sql.Date(sv.getNgaysinh().getTime()));
                ps.setString(6, sv.getDiachi());
                ps.setString(7, sv.getSdt());               
                ps.setString(8, sv.getMalop());

                int row = ps.executeUpdate();
                if (row < 1)
                {
                    sv = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                sv = null;
            }
            finally
            {
                Connect.close(ps);
            }
        }
        return sv;
    }

    @Override
    public SinhVien updateByID(SinhVien sv)
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            try
            {
                ps = Connect.cnn.prepareStatement("Update SinhVien set HoTenSV=?, HeDaoTao=?, GioiTinh=?, NgaySinh=?, DiaChi=?, SDT=?, MaLop=?  where MaSV=?");                
                ps.setString(1, sv.getHotensv());
                ps.setString(2, sv.getHedaotao());
                ps.setBoolean(3, sv.isGioitinh());
                ps.setDate(4, new java.sql.Date(sv.getNgaysinh().getTime()));
                ps.setString(5, sv.getDiachi());               
                ps.setString(6, sv.getSdt());
                ps.setString(7, sv.getMalop());
                ps.setString(8, sv.getMasv());

                int row = ps.executeUpdate();
                if (row < 1)
                {
                    sv = null;
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
                sv = null;
            }
            finally
            {
                Connect.close();
            }
        }
        return sv;
    }

    public void deleteSinhVien(String SinhVienID) throws SQLException, ClassNotFoundException
    {
        PreparedStatement ps = null;
        if (Connect.open())
        {
            ps = Connect.cnn.prepareStatement("Delete from SinhVien where MaSV=?");
            ps.setString(1, SinhVienID);
            ps.executeUpdate();
            Connect.close();
        }
    }

    @Override
    public ArrayList<SinhVien> CheckID(String masv)
    {
        ArrayList<SinhVien> list = null;
        PreparedStatement psCheck = null;
        ResultSet rs = null;
        
        if (Connect.open())
        {
            try
            {
                psCheck = Connect.cnn.prepareStatement("Select * from SinhVien where MaSV=?");
                psCheck.setString(1, masv);
                rs = psCheck.executeQuery();
                list = new ArrayList<SinhVien>();
                                
                while (rs.next())
                {
                    SinhVien sv = new SinhVien();
                    sv.setMasv(rs.getString(1));
                    list.add(sv);
                }
            }
            catch (SQLException ex)
            {
                Logger.getLogger(SinhVienDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            finally
            {
                Connect.close(psCheck, rs);
            }
        }
        return list;
    }
}
