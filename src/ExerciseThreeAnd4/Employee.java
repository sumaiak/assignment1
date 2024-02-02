package ExerciseThreeAnd4;

import java.time.LocalDate;
import java.time.Period;

public class Employee {
    String name;
    int age;
    LocalDate birthdate;

    public LocalDate getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Lambda.Employee{" +
                "name='" + name + '\'' +
                '}';
    }
    public Employee(String name, LocalDate birthdate) {
        this.name = name;
        this.birthdate = birthdate;
    }



    public Employee(String name) {
        this.name = name;

    }

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



public int calculateage(LocalDate localDate){

        return Period.between(birthdate,localDate).getYears();


}
}
