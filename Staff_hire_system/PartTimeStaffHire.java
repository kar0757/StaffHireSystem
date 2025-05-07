import java.time.LocalDate;

public class PartTimeStaffHire extends StaffHire {
    private int workingHour;
    private double wagesPerHour;
    private String shifts;
    private boolean terminated;

    // Constructor for PartTimeStaffHire
    public PartTimeStaffHire(int vacancyNumber, String designation, String jobType,
                             String staffName, LocalDate joiningDate, String qualification,
                             String appointedBy, boolean joined, int workingHour, double wagesPerHour, String shifts) {
        // Calling StaffHire superclass
        super(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined);

        this.workingHour = workingHour;
        this.wagesPerHour = wagesPerHour;
        this.shifts = shifts;
        this.terminated = false;
    }

    // Getter method for workingHour
    public int getWorkingHour() {
        return workingHour;
    }

    // Setter method for workingHour
    public void setWorkingHour(int workingHour) {
        this.workingHour = workingHour;
    }

    // Getter method for wagesPerHour
    public double getWagesPerHour() {
        return wagesPerHour;
    }

    // Setter method for wagesPerHour
    public void setWagesPerHour(double wagesPerHour) {
        this.wagesPerHour = wagesPerHour;
    }

    // Getter method for shifts
    public String getShifts() {
        return shifts;
    }



    // Getter method for terminated
    public boolean isTerminated() {
        return terminated;
    }

    // Setter method for terminated
    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    // Method to set shifts, only when staff has joined
    public void setShifts(String newShift) {
        if (getJoined()) {
            this.shifts = newShift;
        } else {
            System.out.println("Cannot set the shifts: Staff has not yet joined.");
        }
    }

    // Method to terminate the staff
    public void terminateStaff() {
        if (terminated) {
            System.out.println("Staff member is already terminated!.");
        } else {
            setStaffName("");
            setJoiningDate(LocalDate.of(1900, 1, 1)); // Set to a default LocalDate
            setQualification("");
            setAppointedBy("");
            setJoined(false);
            this.terminated = true;
        }
    }

    // Overriding the display method to only including part-time staff info
    @Override
    public void display() {
        super.display(); // Calls the display method of the StaffHire class
        if (getWorkingHour() != 0) { // Check if working hours are set
            System.out.println("Wages per Hour: " + wagesPerHour);
            System.out.println("Working Hour: " + workingHour);
            System.out.println("Shifts: " + shifts);
            System.out.println("Terminated: " + (terminated ? "Yes" : "No"));
            System.out.println("Income per day: " + (wagesPerHour * workingHour));
        }
    }
}
