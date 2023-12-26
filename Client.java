package com.java8.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
class Emp {
    Integer eno;
    String ename;
    Integer salary;
}

public class Client {
    public static void main(String[] args) {
        List<Emp> list = new ArrayList<Emp>();
        list.add(new Emp(1, "Bharathi", 10000));
        list.add(new Emp(2, "usha", 7000));
        list.add(new Emp(3, "ajay", 13000));
        list.add(new Emp(4, "hari", 5000));
        list.add(new Emp(5, "pankaj", 20000));
        list.add(new Emp(6, "Alax", 100));
        System.out.println(list);
        System.out.println("=".repeat(40));
        // display emps name whose salary greater than 7000
        list.stream().filter(dt -> dt.getSalary() > 7000).forEach(dt -> System.out.println(dt.getEname()));

        System.out.println("=".repeat(40));
        // display emps count whose salary greater than 7000
        long empCount = list.stream().filter(dt -> dt.getSalary() > 7000).count();
        System.out.println(empCount);

        System.out.println("=".repeat(40));
        // Finding emp name whose having high salary
        String empName = list.stream().max((s1, s2) -> s1.getSalary().compare(s1.getSalary(), s2.getSalary())).get()
                .getEname();
        System.out.println(empName);
        String ename = list.stream().max(Comparator.comparing(x -> x.getSalary())).get().getEname();
        System.out.println("=".repeat(40));
        System.out.println(ename);
        String ename1 = list.stream().max(Comparator.comparing(Emp::getSalary)).get().getEname();
        System.out.println("=".repeat(40));
        System.out.println(ename1);
        Integer integer = list.stream().map(dt -> dt.getSalary()).max(Integer::compareTo).orElse(0);
        System.out.println(integer);
    }
}
