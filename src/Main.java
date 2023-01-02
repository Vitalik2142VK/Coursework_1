public class Main
{
    public static void Get_list_employees(Employee[] cs)
    {
        for (int i = 0; i < Employee.GetId(); i++)
        {
            System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nОтдел: " + cs[i].GetDepartment() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
        }
    }

    public static int Get_total_costs(Employee[] cs)
    {
        int totalCosts = 0;
        for (int i = 0; i < Employee.GetId(); i++)
        {
            totalCosts += cs[i].GetWages();
        }
        return totalCosts;
    }

    public static void Get_minimum_wage_employee(Employee[] cs)
    {
        int minWage = cs[0].GetWages();
        String name = cs[0].GetName();
        for (int i = 1; i < Employee.GetId(); i++)
        {
            if (minWage > cs[i].GetWages())
            {
                minWage = cs[i].GetWages();
                name = cs[i].GetName();
            }
        }
        System.out.println("Минимальная заработная плата у сотрудника - " + name + "\t составляет: " + minWage + " руб.\n");
    }

    public static void Get_maximum_wage_employee(Employee[] cs)
    {
        int maxWage = cs[0].GetWages();
        String name = cs[0].GetName();
        for (int i = 1; i < Employee.GetId(); i++)
        {
            if (maxWage < cs[i].GetWages())
            {
                maxWage = cs[i].GetWages();
                name = cs[i].GetName();
            }
        }
        System.out.println("Максимальная заработная плата у сотрудника - " + name + "\t составляет: " + maxWage + " руб.\n");
    }

    public static int Get_average_value_wages(Employee[] cs)
    {
        return Get_total_costs(cs) / Employee.GetId();
    }

    public static void Get_full_name_all_employees(Employee[] cs)
    {
        for (int i = 0; i < Employee.GetId(); i++)
        {
            System.out.println(cs[i].GetIdEmployee() + ". " + cs[i].GetName());
        }
    }

    public static void main(String[] args)
    {
        Employee[] companyStaff = new Employee[10];
        try
        {
            companyStaff[0] = new Employee("Пупкин Иван Сергеевич", 1, 50000);
            companyStaff[1] = new Employee("Иванов Павел Петрович", 2, 75000);
            companyStaff[2] = new Employee("Наумова Дарья Александровна", 3, 36000);
            companyStaff[3] = new Employee("Филатова Ольга Сергеевна", 4, 73000);
            companyStaff[4] = new Employee("Корнеев Даннил Юрьевич", 5, 66000);
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

        Get_list_employees(companyStaff);
        System.out.println("Общие расходы на заработную плату сотрудникам: " + Get_total_costs(companyStaff) + " руб.\n");
        Get_minimum_wage_employee(companyStaff);
        Get_maximum_wage_employee(companyStaff);
        System.out.println("Среднее значение заработных плат у сотрудников: " + Get_average_value_wages(companyStaff) + " руб.\n");
        Get_full_name_all_employees(companyStaff);
    }
}