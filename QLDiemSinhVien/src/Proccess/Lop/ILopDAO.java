package Proccess.Lop;

import java.util.ArrayList;

public interface ILopDAO
{
    public ArrayList<Lop> getAll();
    public ArrayList<Lop> findByIDKhoa(String makhoa);
    public Lop addNew(Lop lop);
    public Lop updateByID(Lop lop);
    public ArrayList<Lop> checkID(String malop);
}
