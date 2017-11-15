/**
 * Driver class to test the methods of the Date class.
 *
 * @author Blayton Thomas
 * @version 11/7/17
 */
import java.util.*;
public class Driver
{
    public static void main(String args[]){
        
        
        Scanner console = new Scanner(System.in);
        System.out.println("Enter date 1 information:");
        System.out.print("Enter month: ");
        int month = console.nextInt();
        System.out.print("Enter day: ");
        int day = console.nextInt();
        System.out.print("Enter year: ");
        int year = console.nextInt();
        Date d1 = new Date(month,day,year);
        
        System.out.println();
        
        System.out.println("Enter date 2 information:");
        System.out.print("Enter month: ");
        month = console.nextInt();
        System.out.print("Enter day: ");
        day = console.nextInt();
        System.out.print("Enter year: ");
        year = console.nextInt();
        Date d2 = new Date(month,day,year);
        
        int option = 0;
        int choice;
        int numDays;
        do{
            System.out.println("\nEnter one of the following:\n1 to change Date 1\n2 to change Date 2\n3 to compare dates\n4 to calculate days in between\n5 to check if equal\n6 to add days\n7 to subtract days\n8 to print dates\n9 for Julian date\n10 to exit");
            option=console.nextInt();
            console.nextLine();
            switch(option){
                case 1:
                    System.out.print("Enter month: ");
                    month = console.nextInt();
                    System.out.print("Enter day: ");
                    day = console.nextInt();
                    System.out.print("Enter year: ");
                    year = console.nextInt();
                    d1.setDay(day);
                    d1.setMonth(month);
                    d1.setYear(year);
                    break;
                case 2:
                    System.out.print("Enter month: ");
                    month = console.nextInt();
                    System.out.print("Enter day: ");
                    day = console.nextInt();
                    System.out.print("Enter year: ");
                    year = console.nextInt();
                    d2.setDay(day);
                    d2.setMonth(month);
                    d2.setYear(year);
                    break;
                case 3:
                    if(d1.compareTo(d2)>0)
                        System.out.println("Date 1 is greater than Date 2");
                    else if(d1.compareTo(d1)<0)
                        System.out.println("Date 2 is greater than Date 1");
                    else
                        System.out.println("Date 1 is equal to Date 2");
                    break;
                case 4:
                    System.out.println("Days in between Date 1 and Date 2 is: " + d1.daysInBetween(d2));
                    break;
                case 5:
                    System.out.println("Date 1 = Date 2: "+d1.equals(d2));
                    break;
                case 6:
                    do{
                        System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                        choice=console.nextInt();
                    }
                    while(choice!=1 && choice!=2);
                    do{
                        System.out.println("How many days would you like to add to Date "+choice+"?");
                        numDays=console.nextInt();
                        console.nextLine();
                    }
                    while(numDays<0);
                    if(choice==1) d1.add(numDays);
                    else d2.add(numDays);
                    break;
                case 7:
                    do{
                        System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                        choice=console.nextInt();
                    }
                    while(choice!=1 && choice!=2);
                    do{
                        System.out.println("How many days would you like to subtract to Date "+choice+"?");
                        numDays=console.nextInt();
                    }
                    while(numDays<0);
                    if(choice==1) d1.subtract(numDays);
                    else d2.subtract(numDays);
                    break;
                case 8:
                    System.out.println("Enter format of date (long or short)");
                    String format = console.nextLine();
                    System.out.println("Date 1: " + d1.getDate(format));
                    System.out.println("Date 2: " + d2.getDate(format));
                    break;
                case 9:
                    System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                    choice=console.nextInt();
                    switch(choice){
                        case 1:
                            System.out.println("Julian date for Date "+choice+": "+ d1.getJulianDate());
                            break;
                        case 2:
                            System.out.println("Julian date for Date "+choice+": "+ d2.getJulianDate());
                            break;
                    }
                    console.nextLine();
            }
            System.out.println("\nPress enter to continue");
            console.nextLine();
        }while(option<10);
            
        System.out.println("Exiting program");
    }
}
