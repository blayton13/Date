
/**
 * This class stores dates and allows user to add, subtract, and compare them. Dates can be created with full integer input, or String input for month and integer
 * for day and year. User can also calculate the number of days between two Date objects, compare them to determine chronological order, and determine if two dates
 * are equal to eachother.
 *
 *  *****  Works for leap years  *****
 *
 * @author Blayton Thomas
 * @version 10/30/12
 */
public class Date
{
    private int day;            //day of month
    private int month;          //month of year
    private int year;           //current year
    
    /**
     * Default Constructor - sets day and month to 1 and year to 0
     */
    public Date(){
        day=1;
        month=1;
        year=0;
    }
    
    /**
     * Copy constructor - creates a Date object based on fields of other Date
     * @param other Date object to copy
     */
    public Date(Date other){
        this.day=other.getDay();
        this.month=other.getMonth();
        this.year=other.getYear();
    }
    
    /**
     * Overloaded Constructor - takes input for integer month, integer day, and integer year.
     * @param month integer of month 1 through 12
     * @param day integer of day
     * @param year integer of year
     */
    public Date(int month, int day, int year){
        this.day=day;
        this.month=month;
        this.year=year;
    }
    
    /**
     * Overloaded Constructor - takes input for String month, integer day, and integer year.
     * @param month String of month January through December
     * @param day integer of day, minimum of 1, max depends on month entered.
     * @param year integer of year
     */
    public Date(String month, int day, int year){
        this.day=day;
        this.month=getMonthInt(month);
        this.year=year;
    }
    
    /**
     * Mutator method for day
     */
    public void setDay(int inDay){
        this.day=inDay;
    }
    
    /**
     * Mutator method for month
     */
    public void setMonth(int inMonth){
        this.month=inMonth;
    }
    
    /**
     * Mutator method for year
     */
    public void setYear(int inYear){
        this.year=inYear;
    }
    
    /**
     * Accessor method for day
     */
    public int getDay(){
        return this.day;
    }
    
    /**
     * Accessor method for month
     */
    public int getMonth(){
        return this.month;
    }
    
    /**
     * Accessor method for year
     */
    public int getYear(){
        return this.year;
    }
    
    /**
     * Adds a user defined number of days to a Date object
     * @param numDays number of days to add to the date
     */
    public void add(int numDays){
        while((day+numDays)>getNumDays()){
           numDays-=getNumDays();
           if(month==12){
               year++;
               month=1;
            }
           else month++;
        }
        day+=numDays;
    }
    
    /**
     * Subtracts a user defined number of days from a Date object
     * @param numDays number of days to subtract from the date
     */
    public void subtract(int numDays){
        while((day-numDays)<1){
           numDays-=getNumDays();
           if(month==1){
               year--;
               month=12;
            }
           else month--;
        }
        day-=numDays;
    }
    
    /**
     * Calculates the number of days between two Date objects and returns an integer
     * @param other the second date to find the number of days between.
     * @return number of days between the two date objects
     */
    public int daysInBetween(Date other){
        if(this.equals(other)) return 0;
        Date temp = new Date(this);
        int numDays=0;
        while(!temp.equals(other)){
            if(temp.compareTo(other)>0) temp.subtract(1);
            else temp.add(1);
            numDays++;
        }
        return numDays;
    }
    
    /**
     * Returns a String representing the date in two formats: long (Month D, Y), or short (M/D/Y)
     * @param format format of date String (enter string beginning with 'l' for long, else will retrun short format)
     * @return String representing Date object in user chosen format (long or short)
     */
    public String getDate(String format){
        if(format.toLowerCase().charAt(0)=='l') return getMonthString(month)+" "+day+", "+year;
        else return this.toString();
    }
    
    /**
     * Static method that turns a String representation of a month in to integer representation
     * @param inMonth String of month (ex: "January")
     * @return integer representing month (1-12), if String isn't recognized returns 0
     */
    public static int getMonthInt(String inMonth){
        inMonth=inMonth.toLowerCase();
        switch (inMonth){
            case "january":
                return 1;
            case "february":
                return 2;
            case "march":
                return 3;
            case "april":
                return 4;
            case "may":
                return 5;
            case "june":
                return 6;
            case "july":
                return 7;
            case "august":
                return 8;
            case "september":
                return 9;
            case "october":
                return 10;
            case "november":
                return 11;
            case "december":
                return 12;
            default:
                return 0;
        }
    }
    
    /**
     * Static Method that turns integer represenation of month to String representation
     * @param inMonth integer representing month (1-12)
     * @return String representing month, returns entered integer if not in range
     */
    public static String getMonthString(int inMonth){
        switch (inMonth){
            case 1:
                return "January";
            case 2:
                return "February";
            case 3:
                return "March";
            case 4:
                return "April";
            case 5:
                return "May";
            case 6:
                return "June";
            case 7:
                return "July";
            case 8:
                return "August";
            case 9:
                return "September";
            case 10:
                return "October";
            case 11:
                return "November";
            case 12:
                return "December";
            default:
                return String.valueOf(inMonth);
        }
    }
    
    /**
     * Determines if the current year of object is a leap year
     * @return true or false depending on if current year is leap year
     */
    public boolean isLeapYear(){
        return (year % 400 == 0) || ((year % 4 == 0) && (year % 100 != 0));
    }
    
    /**
     * Private method to determing number of days in current month of year
     * @return integer of number of days in the current month, accounting for leap years
     */
    private int getNumDays(){
        switch (month){
            case 1:
                return 31;
            case 2:
                if(this.isLeapYear()) return 29;
                else return 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                return 0;
        }
    }
    
    /**
     * Sets a Date object to the exact day, month, and year of another Date object
     * @param other the date to be sent to current object
     * @return Date object containing the date that is set
     */
    private Date setDate(Date other){
        this.day=other.getDay();
        this.month=other.getMonth();
        this.year=other.getYear();
        return this;
    }
    
    /**
     * Compares two Date objects chronologically. Returns -1,0,1 depending on if equal, lower, or higher.
     * @param other second Date object to compare first to
     * @return -1 if less, 0 if equal, 1 if greater than param object
     */
    public int compareTo(Date other){
        if(this.year>other.getYear() || (this.year>=other.getYear() && this.month>other.getMonth()) || (this.year>=other.getYear() && this.month>=other.getMonth() && this.day>other.getDay()))return 1;
        else if(this.year<other.getYear() || (this.year<=other.getYear() && this.month<other.getMonth()) || (this.year<=other.getYear() && this.month<=other.getMonth() && this.day<other.getDay())) return -1;
        else return 0;
    }
    
    /**
     * Determines if two Date objects are equal in terms of day, month, and year
     * @param other second Date object to test equality
     * @return true if equal, false if not equal
     */
    public boolean equals(Date other){
        return this.year == other.getYear() && this.month == other.getMonth() && this.day == other.getDay();
    }
    
    /**
     * Converts Date object to String representing the date in format (M/D/Y)
     * @return date in format (M/D/Y)
     */
    public String toString(){
        return month+"/"+day+"/"+year;
    }

    public int getJulianDate(){
        return ((1461*(this.year + 4800 + (this.month-14)/12))/4 +(367*(this.month-2-12*((this.month-14)/12)))/12-(3*((this.year + 4900 + (this.month-14)/12)/100))/4 + this.day-32075);
    }
}
