/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.rogerio.application;

import br.com.rogerio.model.Employee;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author roger
 */
public class Program {

    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner scan = new Scanner(System.in);

        List<Employee> list = new ArrayList<>();

        System.out.println("");
        System.out.print("How many employees will be registered ? ");
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {

            System.out.println("");
            System.out.println("Employee #" + (i + 1) + ":");
            System.out.print("Id: ");
            Integer id = scan.nextInt();
            while (hasId(list, id)) {
                System.out.println("Id already taken! Try again: ");
                id = scan.nextInt();

            }

            System.out.print("Name: ");
            scan.nextLine();
            String name = scan.nextLine();
            System.out.print("Salary: ");
            Double salary = scan.nextDouble();

            Employee emp = new Employee(id, name, salary);

            list.add(emp);
        }

        System.out.println("");
        System.out.print("Enter the employee id that will have salary increase : ");
        Integer idSalary = scan.nextInt();

       // Employee emp = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);

        Integer pos = position(list, idSalary);
        if (pos == null) {
            System.out.println("This id does not exist!");
        } else {
            System.out.println("Enter the percentage: ");
            double percent = scan.nextDouble();
            list.get(pos).increaseSalary(percent);
        }

        System.out.println("");
        System.out.println("List of employees: ");
        for (Employee employee : list) {
            System.out.println(employee);
        }

        scan.close();
    }

    static Integer position(List<Employee> list, int id) {

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == id) {
                return i;
            }
        }
        return null;
    }

    static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;

    }

}
