package Proccess.BangDiem;

import java.util.ArrayList;

public interface IBangDiemDAO 
{
    public ArrayList<BangDiem> getAll();
    public ArrayList<BangDiem> findByIDSinhVien(String masv);
    public ArrayList<BangDiem> findByIDMonHoc(String mamh);
    public BangDiem addNew(BangDiem bd);
    public BangDiem updateByID(BangDiem bd);
    public boolean CheckID(String masv, String mamh, int lanthi);
    public ArrayList<BangDiem> findMaSV();
    public ArrayList<BangDiem> findMaMH(String masv);
    public ArrayList<BangDiem> loaddiem(String masv, String mamh);
}
