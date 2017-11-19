/**
 * Driver class to test the methods of the Date class. User enters two dates, and is able to mutate, access, and compare the two Objects and the data
 * stored within them.
 *
 * @author Blayton Thomas
 * @version 11/7/17
 */
import java.util.*;
public class Driver
{
    public static void main(String args[]){
        
        //create scanner object to take in user text input
        Scanner console = new Scanner(System.in);

        //Store temporary data to create first date object
        System.out.println("Enter date 1 information:");
        System.out.print("Enter month: ");
        int month = console.nextInt();
        System.out.print("Enter day: ");
        int day = console.nextInt();
        System.out.print("Enter year: ");
        int year = console.nextInt();
        Date d1 = new Date(month,day,year);
        
        System.out.println();
        //Store temporary data to create second date object
        System.out.println("Enter date 2 information:");
        System.out.print("Enter month: ");
        month = console.nextInt();
        System.out.print("Enter day: ");
        day = console.nextInt();
        System.out.print("Enter year: ");
        year = console.nextInt();
        console.nextLine();
        Date d2 = new Date(month,day,year);

        System.out.println("\nDate 1: " + d1.getDate("long")+"\nDate 2: "+d2.getDate("long"));

        //stores users choice of menu option
        int option = 0;
        //second user menu choice
        int choice;
        //temp days input storage
        int numDays;
        do{
            //Pauses until user is ready for next dialog
            System.out.println("\nPress enter to continue");
            console.nextLine();
            //prompts user to choose from menu options and stores in option variable
            System.out.println("\nEnter one of the following:\n1 to change Date 1\n2 to change Date 2\n3 to compare dates\n4 to calculate days in between\n5 to check if equal\n6 to add days\n7 to subtract days\n8 to print dates\n9 for Julian date\n10 to exit");
            option=console.nextInt();
            console.nextLine();
            switch(option){
                //Change date 1
                case 1:
                    System.out.print("Enter month: ");
                    month = console.nextInt();
                    System.out.print("Enter day: ");
                    day = console.nextInt();
                    System.out.print("Enter year: ");
                    year = console.nextInt();
                    //sets each value of date to user inputted date
                    d1.setDay(day);
                    d1.setMonth(month);
                    d1.setYear(year);
                    break;
                //change date 2
                case 2:
                    System.out.print("Enter month: ");
                    month = console.nextInt();
                    System.out.print("Enter day: ");
                    day = console.nextInt();
                    System.out.print("Enter year: ");
                    year = console.nextInt();
                    //sets each value of date to user inputted date
                    d2.setDay(day);
                    d2.setMonth(month);
                    d2.setYear(year);
                    break;
                //compare dates to one another
                case 3:
                    //use compareTo method in else if statements to determine output
                    if(d1.compareTo(d2)>0)
                        System.out.println("Date 1 is greater than Date 2");
                    else if(d1.compareTo(d1)<0)
                        System.out.println("Date 2 is greater than Date 1");
                    else
                        System.out.println("Date 1 is equal to Date 2");
                    break;
                //calculate days in between two dates
                case 4:
                    System.out.println("Days in between Date 1 and Date 2 is: " + d1.daysInBetween(d2));
                    break;
                //determine if the dates entered are equal
                case 5:
                    System.out.println("Date 1 = Date 2: "+d1.equals(d2));
                    break;
                //Add days to either date 1 or date 2
                case 6:
                    //makes sure user enters valid number
                    do{
                        System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                        choice=console.nextInt();
                    }
                    while(choice!=1 && choice!=2);
                    //verifies number of days is positive
                    do{
                        System.out.println("How many days would you like to add to Date "+choice+"?");
                        numDays=console.nextInt();
                        console.nextLine();
                    }
                    while(numDays<0);
                    if(choice==1) d1.add(numDays);
                    else d2.add(numDays);
                    break;
                //subtract days from either date 1 or date 2
                case 7:
                    //makes sure user enters valid number
                    do{
                        System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                        choice=console.nextInt();
                    }
                    while(choice!=1 && choice!=2);
                    //verifies number of days is positive
                    do{
                        System.out.println("How many days would you like to subtract to Date "+choice+"?");
                        numDays=console.nextInt();
                    }
                    while(numDays<0);
                    if(choice==1) d1.subtract(numDays);
                    else d2.subtract(numDays);
                    break;
                //Display the dates in long form or shot form
                case 8:
                    System.out.println("Enter format of date (long or short)");
                    String format = console.nextLine();
                    System.out.println("Date 1: " + d1.getDate(format));
                    System.out.println("Date 2: " + d2.getDate(format));
                    break;
                //Display the Julian form of either date
                case 9:
                    do {
                        System.out.print("Enter 1 to for Date 1, or 2 for Date 2: ");
                        choice = console.nextInt();
                    }while (choice!=1 && choice!=2);
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

        }while(option<10);
            
        System.out.println("Exiting program");
    }
}
