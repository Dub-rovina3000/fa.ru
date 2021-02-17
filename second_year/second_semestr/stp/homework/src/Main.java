import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    private static List<Employee> employees;

    public static void main(String[] args) {
        employees = new ArrayList<Employee>() {};
        employees.add(new FixedRatedEmp(1, "Badmaev Bair", 40000));
        employees.add(new HourlyRatedEmp(2, "Bedak Ivan", 300));
        employees.add(new FixedRatedEmp(3, "Volkova Tatiana", 35000));
        employees.add(new HourlyRatedEmp(4, "Kozlovskii Aleksei", 400));
        employees.add(new FixedRatedEmp(5, "Harry Potter", 15000));
        employees.add(new HourlyRatedEmp(6, "Prishchepa Ekaterina", 400));
        employees.add(new FixedRatedEmp(7, "Someone who cannot be named", 30000));

        System.out.println("List without changes: ");
        for (Employee emp: employees){
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
        }

        System.out.println("-------- Sorted list --------");

        Collections.sort(employees, (em1, em2) -> {
            if (em1.getSalary() > em2.getSalary()){
                return -1;
            }
            else {
                if (em1.getSalary() == em2.getSalary()) {
                    return em1.getName().compareTo(em2.getName());
                }
                return 1;
            }
        });

        for (Employee emp: employees){
            System.out.println(emp.getId() + " " + emp.getName() + " " + emp.getSalary());
        }

        System.out.println("-------- 5 first names of employees from sorted list --------");

        for (int i = 0; i < 5; i++){
            System.out.println(employees.get(i).getName());
        }

        System.out.println("-------- 3 last ids of employees from sorted list --------");

        for (int i = employees.size()-3; i < employees.size(); i++){
            System.out.println(employees.get(i).getId());
        }

        System.out.println("-------- Writing to file --------");

        try(FileWriter writer = new FileWriter("employees.txt", false))
        {
            for (Employee emp: employees){
                writer.write(emp.getId() + " " + emp.getName() + " " + emp.getSalary() + "\n");
            }
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

        System.out.println("-------- Written --------");
        System.out.println("-------- Reading from file --------");

        try(FileReader reader = new FileReader("employees.txt"))
        {
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }

    }
}
