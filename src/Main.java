public class Main
{
    public static void Get_list_employees(int size, Employee[] cs)
    {
        for (int i = 0; i < size; i++)
        {
            System.out.println("Индекс сотрудника: " + cs[i].GetIdEmployee() + "\nИмя сотрудника: " + cs[i].GetName() + "\nОтдел: " + cs[i].GetDepartment() + "\nЗаработная плата: " + cs[i].GetWages() + "\n");
        }
    }
    public static void main(String[] args)
    {
        Employee[] companyStaff = new Employee[10];
        try
        {
            companyStaff[0] = new Employee("Иван", 1, 50000);
            companyStaff[1] = new Employee("Павел", 2, 7500);
            companyStaff[2] = new Employee("Дарья", 3, 36000);
            companyStaff[3] = new Employee("Ольга", 4, 73000);
            companyStaff[4] = new Employee("Даннил", 5, 66000);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        Get_list_employees(Employee.GetId(), companyStaff);

    }
}