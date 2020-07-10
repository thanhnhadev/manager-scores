package Proccess.GiangVien;

import java.util.ArrayList;

public interface IGiangVienDAO
{
    public ArrayList<GiangVien> getAll();
    public ArrayList<GiangVien> findByIDMonHoc(String mamh);
    public GiangVien addNew(GiangVien gv);
    public GiangVien updateByID(GiangVien gv);
    public ArrayList<GiangVien> CheckID(String magv);   
}
