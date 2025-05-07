import java.time.LocalDate;

public class FullTimeStaffHire extends StaffHire {
    private double salary;
    private int weeklyFractionalHours;

    // Constructor for FullTimeStaffHire
    public FullTimeStaffHire(int vacancyNumber, String designation, String jobType,
                            String staffName, LocalDate joiningDate, String qualification,
                            String appointedBy, boolean joined, double salary, int weeklyFractionalHours) {
        // Calling StaffHire superclass
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);
       
        this.salary = salary;
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Getter method for salary
    public double getSalary() {
        return salary;
    }


    // Getter method for weeklyFractionalHours
    public int getWeeklyFractionalHours() {
        return weeklyFractionalHours;
    }

    // Setter method for weeklyFractionalHours
    public void setWeeklyFractionalHours(int weeklyFractionalHours) {
        this.weeklyFractionalHours = weeklyFractionalHours;
    }

    // Method to set the salary, only if the staff has joined
    public void setSalary(double newSalary) {
        if (getJoined()) {
            this.salary = newSalary;
        } else {
            System.out.println("Cannot set salary: Staff not yet joined.");
        }
    }

    // Override the display method to include salary and weeklyFractionalHours
    @Override
    public void display() {
        super.display(); // Call the display method of the StaffHire class
        if (getSalary() != 0) { //check if the salary has been initialized
            System.out.println("Salary: " + salary);
            System.out.println("Weekly Fractional Hours: " + weeklyFractionalHours);
        }
    }
}
