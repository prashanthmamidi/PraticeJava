package com.json.examples;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by pupsprashu on 19/12/2015.
 */
public class Staff {

    private String name;
    private String age;
    private String position;
    private BigDecimal salary;
    private List<String> skills;

    public Staff() {
    }

    public Staff(String name, String age, String position, BigDecimal salary, List<String> skills) {
        this.name = name;
        this.age = age;
        this.position = position;
        this.salary = salary;
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", skills=" + skills +
                '}';
    }
}
