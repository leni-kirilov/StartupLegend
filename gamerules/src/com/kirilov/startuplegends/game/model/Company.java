package com.kirilov.startuplegends.game.model;

import com.kirilov.startuplegends.game.enums.NamesGenerator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Leni on 18.8.2014 г..
 */
public class Company {

    private String name;
    private long cash;
    private List<Employee> employees;
    private List<Project> projects;

    public Company() {
        employees = new ArrayList<>();
        projects = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Employee employee = new Employee();
            employee.setName(NamesGenerator.getRandomName());
            employees.add(employee);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCash() {
        return cash;
    }

    public void setCash(long cash) {
        this.cash = cash;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void displayTeam() {
        for (Employee e : employees) {
            e.displayStats();
        }
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    //add/remove employee
}
