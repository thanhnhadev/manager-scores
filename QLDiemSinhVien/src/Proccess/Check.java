package Proccess;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check
{
    public Check()
    {
    }
    
    public static boolean check(String n)
    {
        if (n == null || n.length() == 0)
        {
            return false;
        }
        return true;
    }
    
    public static boolean checkSpace(String n)
    {
        String strPattern = "[^ ]";
        Pattern p;
        Matcher m;
        int flag = Pattern.CASE_INSENSITIVE;
        p = Pattern.compile(strPattern, flag);
        m = p.matcher(n);
        return m.find();
    }
    
    public static boolean checkID(String n)
    {
        if (n == null || n.length() > 10 || n.length() < 2)
        {
            return false;
        }
        else
        {
            String strPattern = "[^a-z0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean checkPhone(String n)
    {
        if (n == null || n.length() > 13 || n.length() < 8)
        {
            return false;
        }
        else
        {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }
    
    public static boolean checkHPhone(String n)
    {
        if (n == null || n.length() != 8)
        {
            return false;
        }
        else
        {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }
    
    public static boolean checkEmail(String n)
    {
        if (n == null || n.length() == 0)
        {
            return false;
        }
        else
        {
            String strPattern = "\\b[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}\\b";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return m.find();
        }
    }
    
    public static boolean checkCourse(String n)
    {
        if (n == null || n.length() != 9)
        {
            return false;
        }
        else
        {
            String strPattern = "[^0-9-]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }

    public static boolean checkMark(String n)
    {
        if (n == null || n.length() > 4 || n.length() < 1)
        {
            return false;
        }
        else
        {
            String strPattern = "[^0-9.]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }
    
    public static boolean checkNumber(String n)
    {
        if (n == null || n.length() != 1)
        {
            return false;
        }
        else
        {
            String strPattern = "[^0-9]";
            Pattern p;
            Matcher m;
            int flag = Pattern.CASE_INSENSITIVE;
            p = Pattern.compile(strPattern, flag);
            m = p.matcher(n);
            return !m.find();
        }
    }
}
