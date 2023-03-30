import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Employee.class.getName());
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Ana", "Anic", 80, 20));
        employeeList.add(new Employee("Ivan", "Ivic", 100, 40));
        employeeList.add(new Employee("Maja", "Majic", 60, 30));

        for (Employee employee : employeeList) {
            try {
                FileHandler fileHandler = new FileHandler("log.txt");
                logger.addHandler(fileHandler);
                SimpleFormatter formatter = new SimpleFormatter();
                fileHandler.setFormatter(formatter);
                double salary = employee.calculateSalary();
                System.out.println(employee + ", Salary: " + String.format("%.2f", salary) + " kn");
            } catch (PayRollException | IOException e) {
                logger.severe("Error");
            }
        }
    }
}
