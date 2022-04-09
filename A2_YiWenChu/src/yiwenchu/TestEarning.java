/* 
 * Name: Yi-Wen Chu    991624614
 * Assignment: Assigntment 2 
 * Program: Computer Systems Technology -
 *  Software Development and Network Engineering
 * 
 * Date: Jun 8, 2021
 * 
 * Description: Main / test class for employee.
 * Initialize two HourlyEmp class and SalariedEmp class respectively,
 * and ask for the employee information. 
 */
package yiwenchu;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * The Class TestEarning.
 *
 * @author Yi-Wen Chu
 * Computer Systems Technology
 * Software Development and Network Engineering
 */
public class TestEarning {

    private static Scanner input; // Scanner object
    
    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        input = new Scanner(System.in);
        
        // Preset mandatory kinds of employee object.
        Employee[] emplist = {new HourlyEmp(), new HourlyEmp(), 
                new SalariedEmp(), new SalariedEmp()};
        
        // Use string buffer to collect employee string data
        StringBuilder sb = new StringBuilder(); 
        // Ask for employee data sequentially.
        for(int i = 0; i<emplist.length; i++) {
            Employee emp = emplist[i];
            System.out.print("Employee "+(i+1)+", ");
            System.out.println(emplist[i].getCategory()+" :");
            inqEmp(emp);
            sb.append(emp).append("\n");
        }
        System.out.printf("%n%4s  %-15s  %-20s  %14s  %13s%n", 
                "Id", "Name", "Employee Category", "Monthly Salary", 
                "Vacation Days");
        System.out.println("-".repeat(74));
        System.out.println(sb);
    }
    
    /**
     * Inquires the data of employee from the user.
     *
     * @param emp the emp
     */
    public static void inqEmp(Employee emp) {
        
        /* 
         * Extract all the setter from the value object,
         * and sorting to let the order begin from id.
         */
        List<Method> methods = Arrays.asList(emp.getClass().getMethods());
        Collections.reverse(methods);
        
        /* 
         * Ask for fields with a setter in the employee object.
         * Prompt different message according to the setter.  
         */
        String methodName = null, promptMsg = null;
        for (Method method: methods) {
            methodName = method.getName();
            // Only setter will trigger the input requiring process.
            if(methodName.startsWith("set")) {
                // Alternate prompt message according to the specific setter.
                switch(methodName) {
                    case "setId": promptMsg = "Please input employee's ID: ";
                        break;
                    case "setName": promptMsg = "Please input "
                                        + "employee's name: "; 
                        break;
                    case "setHoursPerWeek": promptMsg = "Please input "
                                        + "employee's weekly working hours: ";
                        break;
                    case "setHourRate": promptMsg = "Please input employee's "
                                        + "hourly rate: ";
                        break;  
                    case "setMonthlySalary": promptMsg = "Please input "
                                        + "employee's monthly salary: ";
                        break;
                    default: System.out.println("There's no such field "
                                        + "for employee data.\n");
                        continue;
                }
                
                // Asking for data according the setter in the switch options. 
                inqDetail(promptMsg, method, emp);
            }
        } 
        
    }
    
    /* 
     * The parameter definition:
     * msg: The message shown to the user to ask for data.
     * method: The setter of Employee object used to store data from the user.
     * emp: The value object to store employee information. 
     */
    private static void inqDetail(String msg, Method method, Employee emp) {
        
        System.out.print(msg);
        /* 
         * Call different scanner method 
         * according to the method input data type.
         */
        // list of input data type 
        Class<?>[] paramTypes = method.getParameterTypes(); 
        // Ensure the method has input parameter to continue.
        if(paramTypes.length > 0) {
            // Data inquired from the user.
            Object inputParam = null;   
            // The hint for input wrong data type.
            String typeStr = "String."; 
            // Input data type.
            Class<?> paramType = paramTypes[0]; 
            
            try {
                if(paramType == int.class) {
                    typeStr = "integer number.";
                    inputParam = input.nextInt();
                } else if(paramType == double.class) {
                    typeStr = "float number.";
                    inputParam = input.nextDouble();
                } else if(paramType == String.class) {
                    if(method.getName().equals("setName")) {
                        /*
                         * Don't use nextLine() because you don't know
                         * whether the Scanner has been called.
                         */
                        input.useDelimiter("\\n");
                        inputParam = input.next().trim();
                        input.reset();
                    } else {
                        inputParam = input.next();
                    }
                }
                // Clean the scanner buffer each time.
                input.nextLine();
                method.invoke(emp, inputParam);
            } catch (InputMismatchException e) {
                /*
                 * Handle the InputMismatchException 
                 * caused by Scanner accepting wrong input format.
                 */
                System.out.println("Please input a " + typeStr+ "\n");
                input.nextLine(); 
                inqDetail(msg, method, emp);
            } catch (InvocationTargetException e) {
                /*
                 * Show message for the user 
                 * if this exception caused by IllegalArgumentException 
                 * from the data validation in setter, 
                 * otherwise show error message.
                 */
                Throwable causeE = e.getCause();
                if(causeE instanceof IllegalArgumentException) {
                    System.out.println(causeE.getMessage());
                    inqDetail(msg, method, emp);
                } else {
                    e.printStackTrace();
                }
            } catch (IllegalArgumentException|IllegalAccessException e) {
                e.printStackTrace();
            } 
            
        }
    }

}
