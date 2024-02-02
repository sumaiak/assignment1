package ExerciseThreeAnd4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) {

        List<String> names = Arrays.asList("John", "Jane", "Jack", "Joe", "Jill");
        List<Integer> numberDivisible = List.of(10, 18, 28, 14);
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("John ", LocalDate.of(1990, 5, 15)));
        employees.add(new Employee("Jane ", LocalDate.of(1985, 8, 20)));
        employees.add(new Employee("jack ", LocalDate.of(1992, 3, 10)));
        employees.add(new Employee("joe ", LocalDate.of(1995, 5, 20)));
        employees.add(new Employee("jill ", LocalDate.of(1999, 1, 10)));

        List<Employee> em = new ArrayList<>();
        em.add(new Employee("john", 17));
        em.add(new Employee("jane", 18));
        em.add(new Employee("jack", 2004));
        em.add(new Employee("joe", 29));
        em.add(new Employee("jill", 30));


        Predicate<Integer> divisibleBy7 = num -> num % 7 == 0;
        numberDivisible.stream().filter(divisibleBy7).forEach(System.out::println);

        Supplier<List<Employee>> employeeListSupplier = () ->
                names.stream()
                        .map(Employee::new)
                        .collect(Collectors.toList());
       // List<Employee> employes = employeeListSupplier.get();




        Consumer<String> employeename = name -> System.out.println(name);
        names.forEach(employeename);


        Function<String, Integer> lengthFunction = listname -> listname.length();
        System.out.println(lengthFunction.apply(String.valueOf(names)));


        Predicate<Employee> ageDivide = n -> n.age >= 18;
        List<Employee> filtered = em.stream().filter(ageDivide).collect(Collectors.toList());
        System.out.println(filtered);









    }
}