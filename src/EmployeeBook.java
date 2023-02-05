import java.util.Scanner;

public class EmployeeBook {

    EmployeeBook() throws Exception {
        companyStaff = new Employee[SIZE];
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

    public void listEmployees() {
        for (var arr : this.companyStaff) {
            System.out.println(arr);
        }
    }

    public int totalWages() {
        int totalWages = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            totalWages += companyStaff[i].getWages();
        }
        return totalWages;
    }

    public void minimumWageEmployee() {
        int j = 0;
        for (int i = 1; i < Employee.getId(); i++) {
            if (companyStaff[j].getWages() > companyStaff[i].getWages())
                j = i;
        }
        System.out.println("Минимальная заработная плата у сотрудника - " + companyStaff[j].getName() + "\t составляет: " + companyStaff[j].getWages() + " руб.\n");
    }

    public void maximumWageEmployee() {
        int j = 0;
        for (int i = 1; i < Employee.getId(); i++) {
            if (companyStaff[j].getWages() < companyStaff[i].getWages())
                j = i;
        }
        System.out.println("Максимальная заработная плата у сотрудника - " + companyStaff[j].getName() + "\t составляет: " + companyStaff[j].getWages() + " руб.\n");
    }

    public int averageValueWages() {
        return totalWages() / Employee.getId();
    }

    public void fullNameAllEmployees() {
        for (int i = 0; i < Employee.getId(); i++) {
            System.out.println(companyStaff[i].getIdEmployee() + ". " + companyStaff[i].getName());
        }
        System.out.println("\n");
    }

    public void wageIndexation(int percent) {
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
        for (int i = 0; i < Employee.getId(); i++) {
            wage = (int)(Math.ceil((float) companyStaff[i].getWages() * ratio));
            companyStaff[i].setWages(wage);
            System.out.println("Заработная плата для сотрудника " + companyStaff[i].getName() + ", при индексировании в " + percent + " процентов, будет - " + companyStaff[i].getWages());
        }
        System.out.println("\n");
    }

    public void wageEmployeesBelowSpecified(int wagesLower) {
        System.out.println("Сотрудники с заработной платой ниже: " + wagesLower + "\n");
        for (int i = 0; i < Employee.getId(); i++) {
            if (wagesLower > companyStaff[i].getWages()) {
                System.out.println("Индекс сотрудника: " + companyStaff[i].getIdEmployee() + "\nФИО сотрудника: " + companyStaff[i].getName() + "\nЗаработная плата: " + companyStaff[i].getWages() + "\n");
            }
        }
    }

    public void wageEmployeesMoreSpecified(int wagesLower) {
        System.out.println("Сотрудники с заработной платой выше или равной: " + wagesLower + "\n");
        for (int i = 0; i < Employee.getId(); i++) {
            if (wagesLower <= companyStaff[i].getWages()) {
                System.out.println("Индекс сотрудника: " + companyStaff[i].getIdEmployee() + "\nФИО сотрудника: " + companyStaff[i].getName() + "\nЗаработная плата: " + companyStaff[i].getWages() + "\n");
            }
        }
    }

    public void addNewEmployee() throws Exception {
        if (Employee.getId() >= SIZE)
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
            companyStaff[Employee.getId()] = new Employee(name, department, wage);
            System.out.println("Сотрудник добавлен!\n");
        }
    }

    public void removeEmployee() {
        Scanner in = new Scanner(System.in);
        int id;
        int choice;
        System.out.println("Введите индекс сотрудника, которого хотите удалить: ");
        id = in.nextInt();
        if (companyStaff[id-1] != null) {
            System.out.println("Сотрдуник с индексом '" + companyStaff[id-1].getIdEmployee() + "' - " + companyStaff[id-1].getName() +
                    "\nВы уверены что хотите его удалить?\t1. Да\t2. Нет \nВведите номер ответа:");
            choice = in.nextInt();
            if (choice == 1) {
                companyStaff[id-1].shiftingDataObject(companyStaff[Employee.getId()-1]);
                Employee.close(companyStaff[Employee.getId()-1]);
                System.out.println("Сотрудник удален\n:");
            } else if (choice == 2)
                System.out.println("Удаление отменено\n:");
            else {
                System.out.println("Не корректно введен пункт!\n");
            }
        }
        else
            System.out.println("Сотрудника с индексом '" + id + "' нет.");
    }

    public void changeWageEmployee() {
        Scanner in = new Scanner(System.in);
        int id;
        int wage;
        System.out.println("Введите индекс сотрудника, ЗП которого хотите поменять:\t");
        id = in.nextInt();
        System.out.println("Вы выбрали сотрудника - " + companyStaff[id-1].getName() + "\nУкажите заработную плату:\t");
        wage = in.nextInt();
        companyStaff[id-1].setWages(wage);
        System.out.println("Заработная плата сотруднику " + companyStaff[id-1].getName() + " изменена:\n");
    }

    public void changeDepartmentEmployee() throws Exception {
        Scanner in = new Scanner(System.in);
        int id;
        int department;
        System.out.println("Введите индекс сотрудника, отдел которого хотите поменять:\t");
        id = in.nextInt();
        System.out.println("Вы выбрали сотрудника - " + companyStaff[id-1].getName() + "\nУкажите отдел с 1 по 5:\t");
        department = in.nextInt();
        if (department <= 0 || department >= 6) throw new Exception("Не корректно указан отдел сотрудника. Отделов модет быть от 1 до 5!");
        companyStaff[id-1].setDepartment(department);
        System.out.println("Отдел сотрудника " + companyStaff[id-1].getName() + " изменен:\n");
    }

    public void listEmployeesByDepartment() {
        for (int j = 1; j < 6; j++) {
            System.out.println("Сотрудники отдела №" + j + ":");
            for (int i = 0; i < Employee.getId(); i++) {
                if (j == companyStaff[i].getDepartment())
                    System.out.println("Индекс сотрудника: " + companyStaff[i].getIdEmployee() + "\nФИО сотрудника: " + companyStaff[i].getName() + "\nЗаработная плата: " + companyStaff[i].getWages() + "\n");
            }
        }
    }

    //Методы для работы с отделами
    public void minimumWageEmployeeInDepartment(int department) {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                if (!firstEL) {
                    j = i;
                    firstEL = true;
                }
                if (companyStaff[j].getWages() > companyStaff[i].getWages())
                    j = i;
            }
        }
        System.out.println("Минимальная заработная плата в отделе №" + department + " у сотрудника - " + companyStaff[j].getName() + "\t составляет: " + companyStaff[j].getWages() + " руб.\n");
    }

    public void maximumWageEmployeeInDepartment(int department) {
        int j = 0;
        boolean firstEL = false;
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                if (!firstEL) {
                    j = i;
                    firstEL = true;
                }
                if (companyStaff[j].getWages() < companyStaff[i].getWages())
                    j = i;
            }
        }
        System.out.println("Максимальная заработная плата в отделе №" + department + " у сотрудника - " + companyStaff[j].getName() + "\t составляет: " + companyStaff[j].getWages() + " руб.\n");
    }

    public int totalCostsInDepartment(int department) {
        int totalCosts = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                totalCosts += companyStaff[i].getWages();
            }
        }
        return totalCosts;
    }

    public int averageValueWagesInDepartment(int department) {
        int totalCosts = 0;
        int j = 0;
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                totalCosts += companyStaff[i].getWages();
                j++;
            }
        }
        return totalCosts / j;
    }

    public void wageIndexationInDepartment(int percent, int department) {
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
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                wage = (int)(Math.ceil((float) companyStaff[i].getWages() * ratio));
                companyStaff[i].setWages(wage);
                System.out.println("Заработная плата для сотрудника " + companyStaff[i].getName() + " из отдела №" + department + ", при индексировании в " + percent + " процентов, будет - " + companyStaff[i].getWages());
            }
        }
        System.out.println("\n");
    }

    public void listEmployeesInDepartment(int department) {
        System.out.println("Сотрудники отдела №" + department + ":");
        for (int i = 0; i < Employee.getId(); i++) {
            if (department == companyStaff[i].getDepartment()) {
                System.out.println("Индекс сотрудника: " + companyStaff[i].getIdEmployee() + "\nФИО сотрудника: " + companyStaff[i].getName() + "\nЗаработная плата: " + companyStaff[i].getWages() + "\n");
            }
        }
    }

    private Employee[] companyStaff; // cs - companyStaff
    private final int SIZE = 10;
}
