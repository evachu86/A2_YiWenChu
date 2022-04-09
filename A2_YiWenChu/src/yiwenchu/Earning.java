/* 
 * Name: Yi-Wen Chu    991624614
 * Program: Computer Systems Technology -
 *  Software Development and Network Engineering
 * File: Earning.java
 * Other Files in this Project: 
 *  Employee.java
 *  HourlyEmp.java
 *  SalariedEmp.java
 * Main class: TestEarning.java
 * 
 * Date: Jun 8, 2021
 * 
 * Interface class for employees' monthly earning calculation. 
 */
package yiwenchu;

public interface Earning {

    /**
     * Earning per month.
     *
     * @return the double
     */
    abstract double earnPerMonth(); 
}
