package Proccess.Lop;

public class Lop
{
    private String malop;
    private String tenlop;
    private String khoahoc;
    private String makhoa;
    
    public Lop()
    {
    }

    public Lop(String malop, String tenlop, String khoahoc, String makhoa)
    {
        this.malop = malop;
        this.tenlop = tenlop;
        this.khoahoc = khoahoc;
        this.makhoa = makhoa;              
    }   

    public String getMalop()
    {
        return malop;
    }
    public void setMalop(String malop)
    {
        this.malop = malop;
    }

    public String getTenlop()
    {
        return tenlop;
    }
    public void setTenlop(String tenlop)
    {
        this.tenlop = tenlop;
    }
    
    public String getKhoahoc()
    {
        return khoahoc;
    }
    public void setKhoahoc(String khoahoc)
    {
        this.khoahoc = khoahoc;
    }
    
    public String getMakhoa()
    {
        return makhoa;
    }
    public void setMakhoa(String makhoa)
    {
        this.makhoa = makhoa;
    }       
}
