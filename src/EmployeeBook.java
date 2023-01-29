import java.util.Scanner;

public class EmployeeBook {

    EmployeeBook() throws Exception {
        cs = new Employee[SIZE];
        try {
            cs[0] = new Employee("Пупкин Иван Сергеевич", 1, 50000);
            cs[1] = new Employee("Иванов Павел Петрович", 1, 75000);
            cs[2] = new Employee("Наумова Дарья Александровна", 2, 36000);
            cs[3] = new Employee("Филатова Ольга Сергеевна", 2, 73000);
            cs[4] = new Employee("Корнеев Даннил Юрьевич", 3, 66000);
            cs[5] = new Employee("Троцких Федор Иванович", 3, 59000);
            cs[6] = new Employee("Филатова Зоя Андреевна", 4, 67000);
            cs[7] = new Employee("Краскова Людмила Дмитривна", 4, 58000);
            cs[8] = new Employee("Сидоров Дмитрий Александрович", 5, 73000);
            cs[9] = new Employee("Яшкин Михаил Владимирович", 5, 65000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void Get_list_employees() {
        for (int i = 0; i < Employee.GetId(); i++) {
            System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nОтдел: " + cs[i].GetDepartment() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
        }
    }

    public int Get_total_costs() {
        int totalCosts = 0;
        for (int i = 0; i < Employee.GetId(); i++) {
            totalCosts += cs[i].GetWages();
        }
        return totalCosts;
    }

    public void Get_minimum_wage_employee() {
        int j = 0;
        for (int i = 1; i < Employee.GetId(); i++) {
            if (cs[j].GetWages() > cs[i].GetWages())
                j = i;
        }
        System.out.println("Минимальная заработная плата у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public void Get_maximum_wage_employee() {
        int j = 0;
        for (int i = 1; i < Employee.GetId(); i++) {
            if (cs[j].GetWages() < cs[i].GetWages())
                j = i;
        }
        System.out.println("Максимальная заработная плата у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public int Get_average_value_wages() {
        return Get_total_costs() / Employee.GetId();
    }

    public void Get_full_name_all_employees() {
        for (int i = 0; i < Employee.GetId(); i++) {
            System.out.println(cs[i].GetIdEmployee() + ". " + cs[i].GetName());
        }
        System.out.println("\n");
    }

    public void Wage_indexation(int percent) {
        float ratio = 1.0f;
        int wage;
        if (percent > 0)
            ratio += ((float)percent / 100);
        else if (percent < 0)
            ratio -= ((float)percent / 100);
        else {
            System.out.println("Процент равен 0. Для индексирования укажите на какой процент произвести индексирование.\n");
            return;
        }
        for (int i = 0; i < Employee.GetId(); i++) {
            wage = (int)(Math.ceil((float)cs[i].GetWages() * ratio));
            cs[i].SetWages(wage);
            System.out.println("Заработная плата для сотрудника " + cs[i].GetName() + ", при индексировании в " + percent + " процентов, будет - " + cs[i].GetWages());
        }
        System.out.println("\n");
    }

    public void Get_wage_employees_below_specified(int wagesLower) {
        System.out.println("Сотрудники с заработной платой ниже: " + wagesLower + "\n");
        for (int i = 0; i < Employee.GetId(); i++) {
            if (wagesLower > cs[i].GetWages()) {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    public void Get_wage_employees_more_specified(int wagesLower) {
        System.out.println("Сотрудники с заработной платой выше или равной: " + wagesLower + "\n");
        for (int i = 0; i < Employee.GetId(); i++) {
            if (wagesLower <= cs[i].GetWages()) {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    public void Add_new_employee() throws Exception {
        if (Employee.GetId() >= SIZE)
            System.out.println("Нет свободных ячеек для записи нового сотрудника. Удалите старого сотрудника для записи нового.\n");
        else {
            int department;
            int wage;
            String name;
            Scanner inSting = new Scanner(System.in);
            Scanner inInt = new Scanner(System.in);
            System.out.println("Введите ФИО нового сотрудника:\t");
            name = inSting.next();
            System.out.println("Введите номер отдела с 1 по 5, в котором он будет работать:\t");
            department = inInt.nextInt();
            System.out.println("Введите его заработную плату:\t");
            wage = inInt.nextInt();
            cs[Employee.GetId()] = new Employee(name, department, wage);
            System.out.println("Сотрудник добавлен!\n");
        }
    }

    public void Remove_employee() {
        Scanner in = new Scanner(System.in);
        int id;
        int choice;
        System.out.println("Введите индекс сотрудника, которого хотите удалить: ");
        id = in.nextInt();
        if (cs[id-1] != null) {
            System.out.println("Сотрдуник с индексом '" + cs[id-1].GetIdEmployee() + "' - " + cs[id-1].GetName() +
                    "\nВы уверены что хотите его удалить?\t1. Да\t2. Нет \nВведите номер ответа:");
            choice = in.nextInt();
            if (choice == 1) {
                cs[id-1].Shifting_data_object(cs[Employee.GetId()-1]);
                Employee.Close(cs[Employee.GetId()-1]);
                System.out.println("Сотрудник удален\n:");
            } else if (choice == 2)
                return;
            else {
                System.out.println("Не корректно введен пункт!\n");
                return;
            }
        }
        else
            System.out.println("Сотрудника с индексом '" + id + "' нет.");
    }

    public void Change_wage_employee() {
        Scanner in = new Scanner(System.in);
        int id;
        int wage;
        System.out.println("Введите индекс сотрудника, ЗП которого хотите поменять:\t");
        id = in.nextInt();
        System.out.println("Вы выбрали сотрудника - " + cs[id-1].GetName() + "\nУкажите заработную плату:\t");
        wage = in.nextInt();
        cs[id-1].SetWages(wage);
        System.out.println("Заработная плата сотруднику " + cs[id-1].GetName() + " изменена:\n");
    }

    public void Change_department_employee() throws Exception {
        Scanner in = new Scanner(System.in);
        int id;
        int department;
        System.out.println("Введите индекс сотрудника, отдел которого хотите поменять:\t");
        id = in.nextInt();
        System.out.println("Вы выбрали сотрудника - " + cs[id-1].GetName() + "\nУкажите отдел с 1 по 5:\t");
        department = in.nextInt();
        if (department <= 0 || department >= 6) throw new Exception("Не корректно указан отдел сотрудника. Отделов модет быть от 1 до 5!");
        cs[id-1].SetDepartment(department);
        System.out.println("Отдел сотрудника " + cs[id-1].GetName() + " изменен:\n");
    }

    public void Get_list_employees_by_department() {
        for (int j = 1; j < 6; j++) {
            System.out.println("Сотрудники отдела №" + j + ":");
            for (int i = 0; i < Employee.GetId(); i++) {
                if (j == cs[i].GetDepartment())
                    System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    //Методы для работы с отделами
    public void Get_minimum_wage_employee_in_department(int department) {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                if (!firstEL) {
                    j = i;
                    firstEL = true;
                }
                if (cs[j].GetWages() > cs[i].GetWages())
                    j = i;
            }
        }
        System.out.println("Минимальная заработная плата в отделе №" + department + " у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public void Get_Maximum_wage_employee_in_department(int department) {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                if (!firstEL) {
                    j = i;
                    firstEL = true;
                }
                if (cs[j].GetWages() < cs[i].GetWages())
                    j = i;
            }
        }
        System.out.println("Максимальная заработная плата в отделе №" + department + " у сотрудника - " + cs[j].GetName() + "\t составляет: " + cs[j].GetWages() + " руб.\n");
    }

    public int Get_total_costs_in_department(int department) {
        int totalCosts = 0;
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                totalCosts += cs[i].GetWages();
            }
        }
        return totalCosts;
    }

    public int Get_average_value_wages_in_department(int department) {
        int totalCosts = 0;
        int j = 0;
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                totalCosts += cs[i].GetWages();
                j++;
            }
        }
        return totalCosts / j;
    }

    public void Wage_indexation_in_department(int percent, int department) {
        float ratio = 1.0f;
        int wage;
        if (percent > 0)
            ratio += ((float)percent / 100);
        else if (percent < 0)
            ratio -= ((float)percent / 100);
        else {
            System.out.println("Процент равен 0. Для индексирования укажите на какой процент произвести индексирование.\n");
            return;
        }
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                wage = (int)(Math.ceil((float)cs[i].GetWages() * ratio));
                cs[i].SetWages(wage);
                System.out.println("Заработная плата для сотрудника " + cs[i].GetName() + " из отдела №" + department + ", при индексировании в " + percent + " процентов, будет - " + cs[i].GetWages());
            }
        }
        System.out.println("\n");
    }

    public void Get_list_employees_in_department(int department) {
        System.out.println("Сотрудники отдела №" + department + ":");
        for (int i = 0; i < Employee.GetId(); i++) {
            if (department == cs[i].GetDepartment()) {
                System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nФИО сотрудника: " + cs[i].GetName() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
            }
        }
    }

    private Employee[] cs; // cs - companyStaff
    private final int SIZE = 10;
}
