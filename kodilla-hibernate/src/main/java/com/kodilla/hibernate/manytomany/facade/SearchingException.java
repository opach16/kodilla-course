package com.kodilla.hibernate.manytomany.facade;

public class SearchingException extends RuntimeException {
    public static final String COMPANY_NOT_FOUND = "Company not found";
    public static final String EMPLOYEE_NOT_FOUND = "Employee not found";
    public SearchingException(String message) {
        super(message);
    }
}
