package Proccess.GiangVien;

import Proccess.MonHoc.MonHoc;
import java.util.ArrayList;
import java.util.Date;

public class GiangVien
{
    private ArrayList<MonHoc> listMh;
    private String magv;
    private String hotengv;
    private boolean gioitinh;
    private Date ngaysinh;
    private String diachi;
    private String email;    
    private String sdt;
    private String mamh;   

    public ArrayList<MonHoc> getListMh()
    {
        return listMh;
    }
    public void setListMh(ArrayList<MonHoc> listMh)
    {
        this.listMh = listMh;
    }
      
    public GiangVien()
    {
    }

    public GiangVien(String magv, String hotengv, boolean gioitinh, Date ngaysinh, String diachi, String email, String sdt, String mamh)
    {
        this.magv = magv;
        this.hotengv = hotengv;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.email = email;        
        this.sdt = sdt;
        this.mamh = mamh;
    }

    public String getMagv()
    {
        return magv;
    }
    public void setMagv(String magv)
    {
        this.magv = magv;
    }

    public String getHotengv()
    {
        return hotengv;
    }
    public void setHotengv(String hotengv)
    {
        this.hotengv = hotengv;
    }
    
    public boolean isGioitinh()
    {
        return gioitinh;
    }
    public void setGioitinh(boolean gioitinh)
    {
        this.gioitinh = gioitinh;
    }

    public Date getNgaysinh()
    {
        return ngaysinh;
    }
    public void setNgaysinh(Date ngaysinh)
    {
        this.ngaysinh = ngaysinh;
    }
    
    public String getDiachi()
    {
        return diachi;
    }
    public void setDiachi(String diachi)
    {
        this.diachi = diachi;
    }
    
    public String getEmail()
    {
        return email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }    

    public String getSdt()
    {
        return sdt;
    }
    public void setSdt(String sdt)
    {
        this.sdt = sdt;
    } 
    
    public void setMamh(String mamh)
    {
        this.mamh = mamh;
    }
    public String getMamh()
    {
        return mamh;
    }
}
