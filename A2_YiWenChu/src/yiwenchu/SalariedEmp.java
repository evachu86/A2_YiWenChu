/* 
 * Name: Yi-Wen Chu    991624614
 * Program: Computer Systems Technology -
 * 	Software Development and Network Engineering
 * File: SalariedEmp.java
 * Other Files in this Project: 
 * 	Earning.java
 * 	Employee.java
 * 	HourlyEmp.java
 * Main class: TestEarning.java
 * 
 * Date: Jun 8, 2021
 * 
 * Value object class to store salaried employee information. 
 */
package yiwenchu;

/**
 * The Class SalariedEmp.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
public class SalariedEmp extends Employee implements Earning {

	private double monthlySalary;
	private int defaultHoliday = 30; 
	
	public SalariedEmp () {
		super.earning = this; 
	}
	
	/**
	 * Gets the monthly salary.
	 *
	 * @return the monthly salary
	 */
	public double getMonthlySalary() {
		
		return monthlySalary;
	}

	/**
	 * Sets the monthly salary.
	 *
	 * @param monthlySalary the new monthly salary
	 */
	public void setMonthlySalary(double monthlySalary) {
		
		if(monthlySalary < 1000)
			throw new IllegalArgumentException(
					"The monthly salary must be equal or larger than 1000.");
		this.monthlySalary = monthlySalary;
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
	
	/**
	 * Earning per month.
	 *
	 * @return the double
	 */
	@Override
	public double earnPerMonth() {
		
		return this.monthlySalary;
	}

}
