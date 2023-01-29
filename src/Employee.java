public class Employee {

    Employee(String name, int department, int wages) throws Exception {
        id++;
        idEmployee = id;
        this.name = name;
        if (department <= 0 || department >= 6) throw new Exception("Не корректно указан отдел сотрудника. Отделов модет быть от 1 до 5!");
        this.department = department;
        this.wages = wages;
    }

    private static int id = 0;
    private int idEmployee; // индификатор сотрудника
    private String name; // имя сотрудника
    private int department; // отдел сотрудника
    private int wages; // зарплата сотрудника

    // Дополнительные методы
    public static void Close(Employee employee) {
        id--;
        employee = null;
    }
    public void Shifting_data_object(Employee other) {
        this.name = other.name;
        this.department = other.department;
        this.wages = other.wages;
    }


    // Геттеры
    public static int GetId() {
        return id;
    }
    public int GetIdEmployee() {
        return idEmployee;
    }
    public String GetName() {
        return name;
    }
    public int GetDepartment() {
        return department;
    }
    public int GetWages() {
        return wages;
    }

    // Сеттеры
    public void SetDepartment(int department) {
        this.department = department;
    }
    public void SetWages(int wages) {
        this.wages = wages;
    }

}
