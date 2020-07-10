package Proccess;

public class TimKiem
{
    private String malop;
    private String masv;

    public TimKiem()
    {
    }
    
    public TimKiem(String malop)
    {
        this.malop = malop;
    }
    
    public TimKiem(String malop, String masv)
    {
        this.malop = malop;
        this.masv = masv;
    }

    public String getMalop()
    {
        return malop;
    }
    public void setMalop(String malop)
    {
        this.malop = malop;
    }
    
    public void setMasv(String masv)
    {
        this.masv = masv;
    }
    public String getMasv()
    {
        return masv;
    }
}
