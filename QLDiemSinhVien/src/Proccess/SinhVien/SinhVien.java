package Proccess.SinhVien;

import java.util.Date;

public class SinhVien
{
    private String masv;
    private String hotensv;
    private String hedaotao;
    private boolean gioitinh;
    private Date ngaysinh;
    private String diachi;
    private String sdt;
    private String malop;

    public SinhVien()
    {
    }

    public SinhVien(String masv, String hotensv, String hedaotao, boolean gioitinh, Date ngaysinh, String diachi, String sdt, String malop)
    {
        this.masv = masv;
        this.hotensv = hotensv;
        this.hedaotao = hedaotao;
        this.gioitinh = gioitinh;
        this.ngaysinh = ngaysinh;
        this.diachi = diachi;
        this.sdt = sdt;
        this.malop = malop;       
    }

    public String getMasv()
    {
        return masv;
    }
    public void setMasv(String masv)
    {
        this.masv = masv;
    }

    public String getHotensv()
    {
        return hotensv;
    }
    public void setHotensv(String hotensv)
    {
        this.hotensv = hotensv;
    }
    
    public String getHedaotao()
    {
        return hedaotao;
    }
    public void setHedaotao(String hedaotao)
    {
        this.hedaotao = hedaotao;
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
    
    public String getSdt()
    {
        return sdt;
    }
    public void setSdt(String sdt)
    {
        this.sdt = sdt;
    }

    public String getMalop()
    {
        return malop;
    }
    public void setMalop(String malop)
    {
        this.malop = malop;
    }      
}
