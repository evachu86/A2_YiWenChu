/* 
 * Name: Yi-Wen Chu    991624614
 * Program: Computer Systems Technology -
 *  Software Development and Network Engineering
 * File: HourlyEmp.java
 * Other Files in this Project: 
 *  Earning.java
 *  Employee.java
 *  SalariedEmp.java
 * Main class: TestEarning.java
 * 
 * Date: Jun 8, 2021
 * 
 * Value object class to store hourly employee information. 
 */
package yiwenchu;

/**
 * The Class HourlyEmp.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
public class HourlyEmp extends Employee implements Earning {

    private int hoursPerWeek; // working hours per week.
    private double hourRate;  // hourly payment.
    private int defaultHoliday = 15; // default vacation days.
    
    public HourlyEmp () {
        super.earning = this; 
    }
    
    /**
     * Gets the working hours per week.
     *
     * @return the working hours per week
     */
    public int getHoursPerWeek() {
        
        return hoursPerWeek;
    }
    
    /**
     * Sets the working hours per week.
     *
     * @param hoursPerWeek the new working hours per week
     */
    public void setHoursPerWeek(int hoursPerWeek) {
        if(hoursPerWeek < 10)
            throw new IllegalArgumentException(
                    "The hours per week must be equal or larger than 10.");
        this.hoursPerWeek = hoursPerWeek;
    }
    
    /**
     * Gets the hourly payment rate.
     *
     * @return the double hourly payment rate
     */
    public double getHourRate() {
        
        return hourRate;
    }
    
    /**
     * Sets the hourly payment rate.
     *
     * @param hourRate the new hourly payment rate
     */
    public void setHourRate(double hourRate) {
        
        if(hourRate < 15 || hourRate > 100)
            throw new IllegalArgumentException(
                    "The hourly rate must between 15 and 100. "
                    + "(head and tail included)");
        this.hourRate = hourRate;
    }

    /**
     * Earning per month.
     *
     * @return the double
     */
    @Override
    public double earnPerMonth() {
        return (hoursPerWeek * hourRate) * 4;
    }

    /**
     * Vacation days of the employee.
     *
     * @return the int
     */
    @Override
    public int vacationDays() {
        return defaultHoliday;
    }

}
