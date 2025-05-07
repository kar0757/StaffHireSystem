import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentSystem {

    private List<StaffHire> staffList;

    public RecruitmentSystem() {
        this.staffList = new ArrayList<>();
    }

    public void addStaff(StaffHire staff) {
        this.staffList.add(staff);
    }

    public List<StaffHire> getStaffList() {
        return this.staffList;
    }

    public static void main(String[] args) {
        RecruitmentSystem recruitmentSystem = new RecruitmentSystem();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try {
            // Create StaffHire objects (vacancies and hired staff)
            StaffHire vacancy1 = new StaffHire(1, "Software Engineer", "Full-Time", "", null, "", "", false);
            StaffHire vacancy2 = new StaffHire(2, "Data Scientist", "Part-Time", "", null, "", "", false);

            // Example of adding a FullTimeStaffHire
            LocalDate fullTimeJoiningDate = LocalDate.parse("2024-01-15", dateFormatter);
            FullTimeStaffHire fullTimeEmployee1 = new FullTimeStaffHire(3, "Project Manager", "Full-Time", "John Smith", fullTimeJoiningDate, "Bachelor's", "Jane Doe", true, 80000.0, 40);

            // Example of adding a PartTimeStaffHire
            LocalDate partTimeJoiningDate = LocalDate.parse("2024-02-20", dateFormatter);
            PartTimeStaffHire partTimeEmployee1 = new PartTimeStaffHire(4, "Web Developer", "Part-Time", "Alice Johnson", partTimeJoiningDate, "Associate's", "Bob Williams", true, 20, 25.0, "Morning");

            // Add staff to the list
            recruitmentSystem.addStaff(vacancy1);
            recruitmentSystem.addStaff(vacancy2);
            recruitmentSystem.addStaff(fullTimeEmployee1);
            recruitmentSystem.addStaff(partTimeEmployee1);

            // Perform some operations
            fullTimeEmployee1.setSalary(90000.0);
            partTimeEmployee1.setShifts("Evening");
            partTimeEmployee1.terminateStaff();

            // Display staff information
            System.out.println("\n--- Staff Information ---");
            for (StaffHire staff : recruitmentSystem.staffList) {
                staff.display();
                System.out.println("----------------------");
            }
        } catch (DateTimeParseException e) {
            System.err.println("Error date: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

