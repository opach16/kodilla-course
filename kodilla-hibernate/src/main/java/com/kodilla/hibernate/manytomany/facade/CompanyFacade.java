package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyFacade {

    private final Logger LOGGER = LoggerFactory.getLogger(CompanyFacade.class);
    private final CompanyDao companyDao;
    private final EmployeeDao employeeDao;

    public CompanyFacade(CompanyDao companyDao, EmployeeDao employeeDao) {
        this.companyDao = companyDao;
        this.employeeDao = employeeDao;
    }

    public List<Company> findCompany(String companyName) throws SearchingException {
        LOGGER.info("Searching company started");
        List<Company> companies = companyDao.retrieveCompanyByPartOfName(companyName);
        if (companies.isEmpty()) {
            LOGGER.error(SearchingException.COMPANY_NOT_FOUND);
            throw new SearchingException(SearchingException.COMPANY_NOT_FOUND);
        }
        LOGGER.info("Searching company finished");
        return companies;
    }

    public List<Employee> findEmployees(String lastName) throws SearchingException {
        LOGGER.info("Searching employees started");
        List<Employee> employees = employeeDao.retrieveEmployeeByPartOfLastname(lastName);
        if (employees.isEmpty()) {
            LOGGER.error(SearchingException.EMPLOYEE_NOT_FOUND);
            throw new SearchingException(SearchingException.EMPLOYEE_NOT_FOUND);
        }
        LOGGER.info("Searching employees finished");
        return employees;
    }
}
