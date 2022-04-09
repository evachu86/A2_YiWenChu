/* 
 * Name: Yi-Wen Chu    991624614
 * Program: Computer Systems Technology -
 *  Software Development and Network Engineering
 * File: Employee.java
 * Other Files in this Project: 
 *  Earning.java
 *  HourlyEmp.java
 *  SalariedEmp.java
 * Main class: TestEarning.java
 * 
 * Date: Jun 8, 2021
 * 
 * Abstract class for object of employee type. 
 */
package yiwenchu;

/**
 * The Class Employee.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
public abstract class Employee {

    private String id;
    private String name;
    
    /** 
     * The interface used to 
     * bridge different salary calculation system for children class.
     */
    protected Earning earning;
    
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    public String getId() {
        return id;
    }


    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(String id) {
        this.id = id;
    }


    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }


    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * Vacation days.
     *
     * @return the int
     */
    public abstract int vacationDays();
    
    
    /**
     * Gets the employee's category.
     *
     * @return the String
     */
    public String getCategory() {
        return this.getClass().getSimpleName().replaceAll("Emp$", " Employee");
    }
    
    
    /**
     * Print the employee information below:
     * Id, Name, Employee Category, Monthly Salary, Vacation Days
     *
     * @return the string
     */
    @Override
    public String toString() {
        
        return String.format("%4s  %-15s  %-20s  %14.2f  %13d", 
                id, name, getCategory(), 
                earning.earnPerMonth(), vacationDays());
    }
}