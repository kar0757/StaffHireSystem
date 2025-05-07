import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class StaffHire {
    private int vacancyNumber;
    private String designation;
    private String jobType;
    private String staffName;
    private LocalDate joiningDate;
    private String qualification;
    private String appointedBy;
    private boolean joined;

    // Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType,
                    String staffName, LocalDate joiningDate, String qualification,
                    String appointedBy, boolean joined) {
        // Assigning parameter values to class attributes
        this.vacancyNumber = vacancyNumber;
        this.designation = designation;
        this.jobType = jobType;
        this.staffName = staffName;
        this.joiningDate = joiningDate;
        this.qualification = qualification;
        this.appointedBy = appointedBy;
        this.joined = joined;
    }

    // Alternative Constructor
    public StaffHire(int vacancyNumber, String designation, String jobType,
                    String staffName, LocalDate joiningDate, String qualification,
                    String appointedBy) {
        this(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, false);
    }

    // Getter method for vacancyNumber
    public int getVacancyNumber() {
        return vacancyNumber;
    }

    // Setter method for vacancyNumber
    public void setVacancyNumber(int vacancyNumber) {
        if (vacancyNumber > 0) {
            this.vacancyNumber = vacancyNumber;
        } else {
            throw new IllegalArgumentException("Vacancy number must be positive");
        }
    }

    // Getter method for designation
    public String getDesignation() {
        return designation;
    }

    // Setter method for designation
    public void setDesignation(String designation) {
        if (designation != null && !designation.trim().isEmpty()) {
            this.designation = designation;
        } else {
            throw new IllegalArgumentException("Designation cannot be null or empty");
        }
    }

    // Getter method for jobType
    public String getJobType() {
        return jobType;
    }

    // Setter method for jobType
    public void setJobType(String jobType) {
        if (jobType != null && (jobType.equals("Full-Time") || jobType.equals("Part-Time"))) {
            this.jobType = jobType;
        } else {
            throw new IllegalArgumentException("Invalid job type. Must be 'Full-Time' or 'Part-Time'");
        }
    }

    // Getter method for staffName
    public String getStaffName() {
        return staffName;
    }

    // Setter method for staffName
    public void setStaffName(String staffName) {
        if (staffName != null && !staffName.trim().isEmpty()) {
            this.staffName = staffName;
        } else {
            throw new IllegalArgumentException("Staff name cannot be null or empty");
        }
    }

    // Getter method for joiningDate
    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    // Setter method for joiningDate
    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }

    // Setter method for joiningDate (String version for GUI)
    public void setJoiningDate(String joiningDateStr) {
        if (joiningDateStr != null && !joiningDateStr.trim().isEmpty()) {
            try {
                this.joiningDate = LocalDate.parse(joiningDateStr, DateTimeFormatter.ISO_LOCAL_DATE);
            } catch (DateTimeParseException e) {
                throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd");
            }
        } else {
           throw new IllegalArgumentException("Joining date cannot be null or empty");
        }
    }

    // Getter method for qualification
    public String getQualification() {
        return qualification;
    }

    // Setter method for qualification
    public void setQualification(String qualification) {
        if (qualification != null && !qualification.trim().isEmpty()) {
            this.qualification = qualification;
        } else {
            throw new IllegalArgumentException("Qualification cannot be null or empty");
        }
    }

    // Getter method for appointedBy
    public String getAppointedBy() {
        return appointedBy;
    }

    // Setter method for appointedBy
    public void setAppointedBy(String appointedBy) {
        if (appointedBy != null && !appointedBy.trim().isEmpty()) {
            this.appointedBy = appointedBy;
        } else {
            throw new IllegalArgumentException("Appointed by cannot be null or empty");
        }
    }

    // Getter method for joined
    public boolean getJoined() {
        return joined;
    }

    // Setter method for joined
    public void setJoined(boolean joined) {
        this.joined = joined;
    }

    public void amendJoinedStatus(boolean joinedStatus) {
        // Update the joined status to the new value provided
        this.joined = joinedStatus;
    }

    // Output display method
    public void display() {
        System.out.println("Vacancy Number: " + vacancyNumber);
        System.out.println("Designation: " + designation);
        System.out.println("Job Type: " + jobType);
        System.out.println("Staff Name: " + staffName);
        System.out.println("Joining Date: " + joiningDate);
        System.out.println("Qualification: " + qualification);
        System.out.println("Appointed By: " + appointedBy);
        System.out.println("Joined: " + (joined ? "Yes" : "No"));
    }
}
