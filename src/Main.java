import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("How many employees will be registered? ");

        int n = sc.nextInt();

        for (int i = 0; i< n; i++){
            System.out.println();
            System.out.println();
            System.out.println("Emplyoee #"+ (i+1) +": ");
            System.out.print("Id: ");
            Integer id = sc.nextInt();
            System.out.print("name: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salary: ");
            Double salary = sc.nextDouble();
            Employee emp = new Employee(id, name, salary);
            list.add(emp);
        }

        System.out.println("Enter the employee id that will have salary increase:");
        int id = sc.nextInt();
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);

        if (emp == null){
            System.out.println("This id does not exist!");
        } else {
            System.out.println("Enter the percentage: ");
            double percent = sc.nextDouble();
            emp.increasySalary(percent);
        }

        System.out.println();
        System.out.println("List of employees:");
        for (Employee obj : list){
            System.out.println(obj);
        }



        sc.close();

    }
}