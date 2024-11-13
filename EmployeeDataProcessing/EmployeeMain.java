package EmployeeDataProcessing;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class EmployeeMain {
    public List<Employee> filterEmployees(List<Employee> employees) {
        return employees.stream().filter((emp)-> emp.getDepartment().equals("Engineering") && emp.getSalary() >80000.0).toList();
    }

    public List<Employee> sortEmployeeBySalary(List<Employee> employees) {
        return employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).toList();
    }

    public Map<String , List<Employee>> groupEmployeeByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy(Employee::getDepartment));
    }

    public Map<String, Double> averageSalaryByDepartment(List<Employee> employees) {
        return employees.stream().collect(Collectors.groupingBy((emp) -> emp.getDepartment(), Collectors.averagingDouble(Employee::getSalary)));
    }

    public static void main(String[] args) {
        EmployeeMain emp = new EmployeeMain();
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101,"Tom", "Engineering", 90000.0));
        employees.add(new Employee(102,"Jerry", "MBA", 60000.0));
        employees.add(new Employee(103,"Smith", "Engineering", 85000.0));
        employees.add(new Employee(104,"Satish", "BCA", 75000.0));

        List<Employee> filteredEmp = emp.filterEmployees(employees);
        for(Employee employee : filteredEmp) {
            System.out.println("ID: "+employee.getId()+"    "+"Name: "+employee.getName()+" "+"Department: "+employee.getDepartment()+" "+"Salary: "+employee.getSalary());
        }

        System.out.println();

        List<Employee> sortedEmployeesOnSalary = emp.sortEmployeeBySalary(employees);
        for(Employee employee : sortedEmployeesOnSalary){
            System.out.println(employee);
        }

        Map<String, List<Employee>> groupByDepartment = emp.groupEmployeeByDepartment(employees);
        Set<String> dept = groupByDepartment.keySet();
        for(String d : dept) {
            System.out.println(d+" : "+groupByDepartment.get(d));
        }

        System.out.println();

        Map<String, Double> avgSalOfDept = emp.averageSalaryByDepartment(employees);
        Set<String> depts = avgSalOfDept.keySet();
        for(String d : depts) {
            System.out.println(d+" : "+avgSalOfDept.get(d));
        }
    }
}
