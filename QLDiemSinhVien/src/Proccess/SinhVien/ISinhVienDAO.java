package Proccess.SinhVien;

import java.util.ArrayList;

public interface ISinhVienDAO
{
    public ArrayList<SinhVien> getAll();
    public ArrayList<SinhVien>findByIDLop(String malop);
    public SinhVien addNew(SinhVien sv);
    public SinhVien updateByID(SinhVien sv);
    public ArrayList<SinhVien> CheckID(String masv);   
}
