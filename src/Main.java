import java.util.Scanner;

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
        System.out.println("\n");
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

        Scanner in = new Scanner(System.in);
        int choice;
        boolean exit = true;
        int num = 3;
        do
        {
            System.out.println("Книга сотрудников.\n1.\tПолучить информацию о всех сотрдниках.\n2.\tПолучить расход на заработную плату сотрудникам.\n3.\tВывести сотрудника с минимальной заработной платой." +
                    "\n4.\tВывести сотрудника с максимальной заработной платой.\n5.\tПолучить среднее значение заработных плат у сотрудников.\n6.\tВывести ФИО всех сотрудников\n\nВведите номер пункта:\t");
            choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    Get_list_employees(companyStaff); break;
                case 2:
                    System.out.println("Общие расходы на заработную плату сотрудникам: " + Get_total_costs(companyStaff) + " руб.\n"); break;
                case 3:
                    Get_minimum_wage_employee(companyStaff); break;
                case 4:
                    Get_maximum_wage_employee(companyStaff); break;
                case 5:
                    System.out.println("Среднее значение заработных плат у сотрудников: " + Get_average_value_wages(companyStaff) + " руб.\n"); break;
                case 6:
                    Get_full_name_all_employees(companyStaff); break;
                default:
                    if (num == 0)
                        break;
                    System.out.println("Не корректно введен пункт!\nВнимание!!! Через '" + num + "' попыток программа завершит свою работу.");
                    num--;
                    break;
            }
            System.out.println("1.\tПродолжить работу в программе.\n2.\tЗакрыть программу.\n\nВведите номер пункта:\t");
            choice = in.nextInt();
            if (choice == 1)
                exit = true;
            else if (choice == 2 || num == 0)
                exit = false;
            else
            {
                System.out.println("Не корректно введен пункт! Программа продолжит работу.\nВнимание!!! Через '" + num + "' попыток программа завершит свою работу.");
                num--;
            }
        }
        while (exit);
    }
}