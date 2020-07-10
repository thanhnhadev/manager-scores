package Proccess.MonHoc;

public class MonHoc
{
    private String mamh;    
    private String tenmh;
    private int sotinchi;
    private String hinhthucthi;
    private int hocky;
    private String phonghoc;

    public MonHoc()
    {
    }

    public MonHoc(String mamh, String tenmh, int sotinchi, String hinhthucthi, int hocky, String phonghoc)
    {
        this.mamh = mamh;        
        this.tenmh = tenmh;
        this.sotinchi = sotinchi;
        this.hinhthucthi = hinhthucthi;
        this.hocky = hocky;
        this.phonghoc = phonghoc;
    }
    
    public String getMamh()
    {
        return mamh;
    }
    public void setMamh(String mamh)
    {
        this.mamh = mamh;
    }
    
    public String getTenmh()
    {
        return tenmh;
    }
    public void setTenmh(String tenmh)
    {
        this.tenmh = tenmh;
    }
    
    public int getSotinchi()
    {
        return sotinchi;
    }
    public void setSotinchi(int sotinchi)
    {
        this.sotinchi = sotinchi;
    }
    
    public String getHinhthucthi()
    {
        return hinhthucthi;
    }
    public void setHinhthucthi(String hinhthucthi)
    {
        this.hinhthucthi = hinhthucthi;
    }
    
    public int getHocky()
    {
        return hocky;
    }
    public void setHocky(int hocky)
    {
        this.hocky = hocky;
    }

    public String getPhonghoc()
    {
        return phonghoc;
    }
    public void setPhonghoc(String phonghoc)
    {
        this.phonghoc = phonghoc;
    }
}
