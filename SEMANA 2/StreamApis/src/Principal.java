import java.util.*;
import java.util.stream.Collectors;

public class Principal {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", "HR", 50000),
            new Employee("Jane Smith", "HR", 60000),
            new Employee("Michael Brown", "IT", 70000),
            new Employee("Emily White", "IT", 80000),
            new Employee("James Black", "Finance", 75000),
            new Employee("Sarah Green", "Finance", 85000)
        );

        // 1. Filtering employees with salary greater than 60,000
        List<Employee> highEarners = employees.stream()
            .filter(emp -> emp.getSalary() > 60000)
            .collect(Collectors.toList());
        System.out.println("High Earners: " + highEarners.stream().map(Employee::getName).collect(Collectors.joining(", ")));

        // 2. Finding the highest-paid employee in each department
        Map<String, Optional<Employee>> highestPaidInDepartment = employees.stream()
            .collect(Collectors.groupingBy(
                Employee::getDepartment,
                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
            ));
        highestPaidInDepartment.forEach((dept, emp) ->
            System.out.println("Highest paid in " + dept + ": " + emp.map(Employee::getName).orElse("None"))
        );

        // 3. Calculating the average salary across all employees
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)
            .average()
            .orElse(0.0);
        System.out.println("Average Salary: " + averageSalary);

        // 4. Grouping employees by department
        Map<String, List<Employee>> employeesByDepartment = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment));
        employeesByDepartment.forEach((dept, emps) -> 
            System.out.println(dept + ": " + emps.stream().map(Employee::getName).collect(Collectors.joining(", ")))
        );

        // 5. Checking if all employees in IT earn more than 60,000
        boolean allITHighEarners = employees.stream()
            .filter(emp -> "IT".equals(emp.getDepartment()))
            .allMatch(emp -> emp.getSalary() > 60000);
        System.out.println("All IT employees earn more than 60,000: " + allITHighEarners);
    }
}