package Utils;

import java.util.ArrayList;

public class AllEmployeeResponsePattern {
    public String success;
    public ArrayList<Data> data;
}

class Data
{
    public int id;
    public String employee_name;
    public String employee_salary;
    public String employee_age;
    public String profile_image;
}