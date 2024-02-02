package ExerciseThreeAnd4;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Exercise4 {


    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John ", LocalDate.of(1990, 5, 15)));
        employees.add(new Employee("Jane ", LocalDate.of(1985, 8, 20)));
        employees.add(new Employee("jack ", LocalDate.of(1992, 3, 10)));
        employees.add(new Employee("joe ", LocalDate.of(1995, 5, 20)));
        employees.add(new Employee("jill ", LocalDate.of(1999, 1, 10)));


        LocalDate startDate = LocalDate.of(2023, 1, 1);

        for (Employee employee : employees) {
            int age = employee.calculateage(startDate);
            System.out.println(employee.getName() + " is " + age + " years old.");
        }


        int totalAge = 0;
        int numberOfEmployees = employees.size();

        for (Employee employee : employees) {
            totalAge += employee.calculateage(startDate);
        }

        double averageAge = (double) totalAge / numberOfEmployees;

        System.out.println("Average age is " + averageAge + " years.");
        for (Employee may : employees) {
            if (may.birthdate.getMonthValue() == 5) {
                System.out.println(may.getName());

            }
        }
        Map<Integer, Long> groupByBirthMonth = employees.stream()
                .collect(Collectors.groupingBy(
                        employee -> employee.getBirthdate().getMonthValue(),
                        Collectors.counting()


                ));

        groupByBirthMonth.forEach((month, count) ->
                System.out.println("Month: " + month + ", Employees Count: " + count));

        Month currentMonth = LocalDate.now().getMonth();
        for (Employee m : employees) {
            if (m.getBirthdate().getMonth() == currentMonth) {
                System.out.println(m.getName());

            }
        }

    }
}