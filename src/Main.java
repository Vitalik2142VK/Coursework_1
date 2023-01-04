import java.util.Scanner;

public class Main
{


    public static void main(String[] args)
    {
        EmployeeBook eb = null;
        try
        {
            eb = new EmployeeBook();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Scanner in = new Scanner(System.in);
        int choice;
        boolean exit = true;
        int num = 3;
        do
        {
            System.out.println("Книга сотрудников.\n1.\tПолучить информацию о всех сотрудниках.\n2.\tПолучить расход на заработную плату сотрудникам." +
                    "\n3.\tВывести сотрудника с минимальной заработной платой.\n4.\tВывести сотрудника с максимальной заработной платой." +
                    "\n5.\tПолучить среднее значение заработных плат у сотрудников.\n6.\tВывести ФИО всех сотрудников." +
                    "\n7.\tПроизвести индексирование заработной платы.\n8.\tРабота с отделами.\n9.\tПоиск сотрудников с ЗП меньше указанной." +
                    "\n10.\tПоиск сотрудников с ЗП больше или равной указанной.\n11.\tДобавить нового сотрудника.\n12.\tУдалить сотрудника." +
                    "\n13.\tПоменять заработную плату у сотрудника.\n14.\tПоменять отдел у сотрудника.\n15.\tПолучить информацию о всех сотрудниках по отделам." +
                    "\n\nВведите номер пункта:\t");
            choice = in.nextInt();
            switch (choice)
            {
                case 1:
                    eb.Get_list_employees(); break;
                case 2:
                    System.out.println("Общие расходы на заработную плату сотрудникам: " + eb.Get_total_costs() + " руб.\n"); break;
                case 3:
                    eb.Get_minimum_wage_employee(); break;
                case 4:
                    eb.Get_maximum_wage_employee(); break;
                case 5:
                    System.out.println("Средняя заработная плата у сотрудников: " + eb.Get_average_value_wages() + " руб.\n"); break;
                case 6:
                    eb.Get_full_name_all_employees(); break;
                case 7:
                {
                    System.out.println("Введите процент, на который необходимо индекстровать ЗП.\nДля отрицательного индексирования введите число с минусом \"Пример: -30\"");
                    int percent = in.nextInt();
                    eb.Wage_indexation(percent);
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
                            eb.Get_minimum_wage_employee_in_department(department); break;
                        case 2:
                            eb.Get_Maximum_wage_employee_in_department(department); break;
                        case 3:
                            System.out.println("Общие расходы на заработную плату сотрудникам из отдела №" + department + "составляет: " + eb.Get_total_costs_in_department(department) + " руб.\n"); break;
                        case 4:
                            System.out.println("Средняя заработная плата у сотрудниковиз отдела №" + department + "составляет: " + eb.Get_average_value_wages_in_department(department) + " руб.\n"); break;
                        case 5:
                        {
                            System.out.println("Введите процент, на который необходимо индекстровать ЗП.\nДля отрицательного индексирования введите число с минусом \"Пример: -30\"");
                            int percent = in.nextInt();
                            eb.Wage_indexation_in_department(percent, department);
                            break;
                        }
                        case 6:
                            eb.Get_list_employees_in_department(department); break;
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
                    eb.Get_wage_employees_below_specified(wagesLower);
                    break;
                }
                case 10:
                {
                    System.out.println("Введите сумму, для поиска сотрудников с ЗП больше или равной указанной.");
                    int wagesLower = in.nextInt();
                    eb.Get_wage_employees_more_specified(wagesLower);
                    break;
                }
                case 11:
                {
                    try
                    {
                        eb.Add_new_employee();
                    }
                    catch (Exception e)
                    {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case 12:
                    eb.Remove_employee(); break;
                case 13:
                    eb.Change_wage_employee(); break;
                case 14:
                {
                    try {
                        eb.Change_department_employee();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                }
                case 15:
                    eb.Get_list_employees_by_department(); break;
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