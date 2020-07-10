package Proccess.Khoa;

import java.util.ArrayList;

public interface IKhoaDAO
{
    public ArrayList<Khoa> getAll();
    public Khoa addNew(Khoa khoa);
    public Khoa updateByID(Khoa khoa);
    public ArrayList<Khoa> checkID(String makhoa);
}
