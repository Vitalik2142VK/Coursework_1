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
        int j = 0;
        for (int i = 1; i < Employee.GetId(); i++)
        {
            if (cs[j].GetWages() > cs[i].GetWages())
                j = i;
        }
        System.out.println("Минимальная заработная плата у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public static void Get_maximum_wage_employee(Employee[] cs)
    {
        int j = 0;
        for (int i = 1; i < Employee.GetId(); i++)
        {
            if (cs[j].GetWages() < cs[i].GetWages())
                j = i;
        }
        System.out.println("Максимальная заработная плата у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
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

    public static void Wage_indexation(Employee[] cs, int percent)
    {
        float ratio = 1.0f;
        int wage;
        if (percent > 0)
            ratio += ((float)percent / 100);
        else if (percent < 0)
            ratio -= ((float)percent / 100);
        else
        {
            System.out.println("Процент равен 0. Для индексирования укажите на какой процент произвести индексирование.\n");
            return;
        }
        for (int i = 0; i < Employee.GetId(); i++)
        {
            wage = (int)(Math.ceil((float)cs[i].GetWages() * ratio));
            cs[i].SetWages(wage);
            System.out.println("Заработная плата для сотрудника " + cs[i].GetName() + ", при индексировании в " + percent + " процентов, будет - " + cs[i].GetWages());
        }
        System.out.println("\n");
    }

    public static void Get_wage_employees_below_specified(Employee[] cs, int wagesLower)
    {
        System.out.println("Сотрудники с заработной платой ниже: " + wagesLower + "\n");
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (wagesLower > cs[i].GetWages())
            {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    public static void Get_wage_employees_more_specified(Employee[] cs, int wagesLower)
    {
        System.out.println("Сотрудники с заработной платой выше или равной: " + wagesLower + "\n");
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (wagesLower <= cs[i].GetWages())
            {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    //Методы для работы с отделами
    public static void Get_minimum_wage_employee_in_department(Employee[] cs, int department)
    {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                if (!firstEL)
                {
                    j = i;
                    firstEL = true;
                }
                if (cs[j].GetWages() > cs[i].GetWages())
                    j = i;
            }
        }
        System.out.println("Минимальная заработная плата в отделе №" + department + " у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public static void Get_Maximum_wage_employee_in_department(Employee[] cs, int department)
    {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                if (!firstEL)
                {
                    j = i;
                    firstEL = true;
                }
                if (cs[j].GetWages() < cs[i].GetWages())
                    j = i;
            }
        }
        System.out.println("Максимальная заработная плата в отделе №" + department + " у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public static int Get_total_costs_in_department(Employee[] cs, int department)
    {
        int totalCosts = 0;
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                totalCosts += cs[i].GetWages();
            }
        }
        return totalCosts;
    }

    public static int Get_average_value_wages_in_department(Employee[] cs, int department)
    {
        int totalCosts = 0;
        int j = 0;
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                totalCosts += cs[i].GetWages();
                j++;
            }
        }
        return totalCosts / j;
    }

    public static void Wage_indexation_in_department(Employee[] cs, int percent, int department)
    {
        float ratio = 1.0f;
        int wage;
        if (percent > 0)
            ratio += ((float)percent / 100);
        else if (percent < 0)
            ratio -= ((float)percent / 100);
        else
        {
            System.out.println("Процент равен 0. Для индексирования укажите на какой процент произвести индексирование.\n");
            return;
        }
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                wage = (int)(Math.ceil((float)cs[i].GetWages() * ratio));
                cs[i].SetWages(wage);
                System.out.println("Заработная плата для сотрудника " + cs[i].GetName() + " из отдела №" + department + ", при индексировании в " + percent + " процентов, будет - " + cs[i].GetWages());
            }
        }
        System.out.println("\n");
    }

    public static void Get_list_employees_in_department(Employee[] cs, int department)
    {
        System.out.println("Сотрудники отдела №" + department + ":");
        for (int i = 0; i < Employee.GetId(); i++)
        {
            if (department == cs[i].GetDepartment())
            {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    public static void main(String[] args)
    {
        Employee[] companyStaff = new Employee[10];
        try
        {
            companyStaff[0] = new Employee("Пупкин Иван Сергеевич", 1, 50000);
            companyStaff[1] = new Employee("Иванов Павел Петрович", 1, 75000);
            companyStaff[2] = new Employee("Наумова Дарья Александровна", 2, 36000);
            companyStaff[3] = new Employee("Филатова Ольга Сергеевна", 2, 73000);
            companyStaff[4] = new Employee("Корнеев Даннил Юрьевич", 3, 66000);
            companyStaff[5] = new Employee("Троцких Федор Иванович", 3, 59000);
            companyStaff[6] = new Employee("Филатова Зоя Андреевна", 4, 67000);
            companyStaff[7] = new Employee("Краскова Людмила Дмитривна", 4, 58000);
            companyStaff[8] = new Employee("Сидоров Дмитрий Александрович", 5, 73000);
            companyStaff[9] = new Employee("Яшкин Михаил Владимирович", 5, 65000);
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
            System.out.println("Книга сотрудников.\n1.\tПолучить информацию о всех сотрудниках.\n2.\tПолучить расход на заработную плату сотрудникам.\n3.\tВывести сотрудника с минимальной заработной платой." +
                    "\n4.\tВывести сотрудника с максимальной заработной платой.\n5.\tПолучить среднее значение заработных плат у сотрудников.\n6.\tВывести ФИО всех сотрудников." +
                    "\n7.\tПроизвести индексирование заработной платы.\n8.\tРабота с отделами.\n9.\tПоиск сотрудников с ЗП меньше указанной." +
                    "\n10.\tПоиск сотрудников с ЗП больше или раво указанной.\n\nВведите номер пункта:\t");
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
                    System.out.println("Средняя заработная плата у сотрудников: " + Get_average_value_wages(companyStaff) + " руб.\n"); break;
                case 6:
                    Get_full_name_all_employees(companyStaff); break;
                case 7:
                {
                    System.out.println("Введите процент, на который необходимо индекстровать ЗП.\nДля отрицательного индексирования введите число с минусом \"Пример: -30\"");
                    int percent = in.nextInt();
                    Wage_indexation(companyStaff, percent);
                    break;
                }
                case 8:
                {
                    System.out.println("Введите номер отдела с 1 по 5, с которым будете работать: ");
                    int department = in.nextInt();
                    if (department <= 0 || department > 6)
                    {
                        System.out.println("Не корректно указан отдел! Необходимо ввести с 1 по 5");
                        break;
                    }
                    System.out.println("1.\tСотрудник с минимальной зарплатой в отделе.\n2.\tСотрудник с максимальной зарплатой в отделе.\n3.\tСумма затрат на заработную плату по отделу." +
                            "\n4.\tСредняя зарплата по отделу.\n5.\tПроиндексировать зарплату всех сотрудников отдела на процент.\n6.\tНапечатать всех сотрудников отдела.\n\nВведите номер пункта:\t");
                    choice = in.nextInt();
                    switch (choice)
                    {
                        case 1:
                            Get_minimum_wage_employee_in_department(companyStaff, department); break;
                        case 2:
                            Get_Maximum_wage_employee_in_department(companyStaff, department); break;
                        case 3:
                            System.out.println("Общие расходы на заработную плату сотрудникам из отдела №" + department + "составляет: " + Get_total_costs_in_department(companyStaff, department) + " руб.\n"); break;
                        case 4:
                            System.out.println("Средняя заработная плата у сотрудниковиз отдела №" + department + "составляет: " + Get_average_value_wages_in_department(companyStaff, department) + " руб.\n"); break;
                        case 5:
                        {
                            System.out.println("Введите процент, на который необходимо индекстровать ЗП.\nДля отрицательного индексирования введите число с минусом \"Пример: -30\"");
                            int percent = in.nextInt();
                            Wage_indexation_in_department(companyStaff, percent, department);
                            break;
                        }
                        case 6:
                            Get_list_employees_in_department(companyStaff, department); break;
                        default:
                        {
                            if (num == 0)
                                break;
                            System.out.println("Не корректно введен пункт!\nВнимание!!! Через '" + num + "' попыток программа завершит свою работу.");
                            num--;
                            break;
                        }
                    }
                    break;
                }
                case 9:
                {
                    System.out.println("Введите сумму, для поиска сотрудников с ЗП меньше указанной суммы.");
                    int wagesLower = in.nextInt();
                    Get_wage_employees_below_specified(companyStaff, wagesLower);
                    break;
                }
                case 10:
                {
                    System.out.println("Введите сумму, для поиска сотрудников с ЗП больше или равной указанной.");
                    int wagesLower = in.nextInt();
                    Get_wage_employees_more_specified(companyStaff, wagesLower);
                    break;
                }
                default:
                {
                    if (num == 0)
                        break;
                    System.out.println("Не корректно введен пункт!\nВнимание!!! Через '" + num + "' попыток программа завершит свою работу.");
                    num--;
                    break;
                }
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