package com.kodilla.patterns2.adapter.company;

import com.kodilla.patterns2.adapter.company.newhrsystem.Employee;
import com.kodilla.patterns2.adapter.company.oldhrsystem.SalaryCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class SalaryAdapter extends SalaryAdaptee implements SalaryCalculator {

    @Override
    public double totalSalary(String[][] workers, double[] salaries) {
        List<Employee> employees = new ArrayList<>();
        for (int n = 0; n < workers.length; n++) {
            employees.add(new Employee(
                    workers[n][0],
                    workers[n][1],
                    workers[n][2],
                    new BigDecimal(salaries[n])
            ));
        }
        return calculateSalary(employees).doubleValue();
    }
}
