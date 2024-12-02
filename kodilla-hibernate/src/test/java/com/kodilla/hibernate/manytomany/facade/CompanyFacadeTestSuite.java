package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CompanyFacadeTestSuite {

    @Autowired
    private CompanyFacade companyFacade;
    @Autowired
    private CompanyDao companyDao;
    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findCompany() {
        //given
        Company firma = companyDao.save(new Company("firma"));
        Company comarch = companyDao.save(new Company("comarch"));
        int id = firma.getId();
        int id1 = comarch.getId();
        //when
        List<Company> companies = companyFacade.findCompany("ma");
        //then
        assertEquals(2, companies.size());
        assertEquals("firma", companies.get(0).getName());
        assertEquals("comarch", companies.get(1).getName());
        //cleanUp
        companyDao.deleteById(id);
        companyDao.deleteById(id1);
    }

    @Test
    void findEmployees() {
        Employee konrad = employeeDao.save(new Employee("konrad", "opach"));
        Employee michal = employeeDao.save(new Employee("michał", "szpak"));
        int konradId = konrad.getId();
        int michalId = michal.getId();
        //when
        List<Employee> employees = companyFacade.findEmployees("pak");
        //then
        assertEquals(1, employees.size());
        assertEquals("szpak", employees.get(0).getLastName());
        //cleanUp
        employeeDao.deleteById(konradId);
        employeeDao.deleteById(michalId);
    }
}
