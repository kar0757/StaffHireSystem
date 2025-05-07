import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class RecruitmentSystemGUI {

    private JFrame frame;
    private JPanel inputPanel, buttonPanel, displayPanel;
    private JLabel vacancyNumberLabel, designationLabel, jobTypeLabel, staffNameLabel,
            joiningDateLabel, qualificationLabel, appointedByLabel, joinedLabel,
            salaryLabel, weeklyFractionalHoursLabel, workingHourLabel, wagesPerHourLabel,
            shiftsLabel, displayNumberLabel;
    private JTextField vacancyNumberField, designationField, jobTypeField, staffNameField,
            joiningDateField, qualificationField, appointedByField, salaryField,
            weeklyFractionalHoursField, workingHourField, wagesPerHourField,
            shiftsField, displayNumberField;
    private JComboBox<String> joinedComboBox;
    private JButton addFullTimeButton, addPartTimeButton, setSalaryButton, setShiftsButton,
            terminateButton, displayButton, clearButton;
    private JTextArea displayTextArea;
    private List<StaffHire> staffList;
    // Defining colours
    private static final Color BACKGROUND_COLOR = new Color(224, 255, 255); // Light Cyan
    private static final Color INPUT_PANEL_COLOR = new Color(255, 240, 245);  // Lavender
    private static final Color BUTTON_PANEL_COLOR = new Color(220, 220, 220); // Gray
    private static final Color DISPLAY_PANEL_COLOR = new Color(255, 255, 240); // Light yellow
    private static final Color LABEL_COLOR = new Color(75, 0, 130);       // Indigo
    private static final Color TEXT_FIELD_COLOR = Color.WHITE;
    private static final Color BUTTON_COLOR = new Color(173, 216, 230);    // Light Blue
    private static final Color BUTTON_TEXT_COLOR = Color.BLACK;
    private static final Color ERROR_COLOR = new Color(255, 0, 0);      // Red
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE; //Use constant

    public RecruitmentSystemGUI() {
        initializeComponents();
        addEventHandlers();
        frame.setVisible(true);
    }

    private void initializeComponents() {
        // creating the frame
        frame = new JFrame("Staff Recruitment System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(BACKGROUND_COLOR);

        // creatnig the panels
        inputPanel = new JPanel();
        buttonPanel = new JPanel();
        displayPanel = new JPanel();

        // Set layout managers for the panels
        inputPanel.setLayout(new GridBagLayout());
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        displayPanel.setLayout(new BorderLayout());

        // Set background colors for panels
        inputPanel.setBackground(INPUT_PANEL_COLOR);
        buttonPanel.setBackground(BUTTON_PANEL_COLOR);
        displayPanel.setBackground(DISPLAY_PANEL_COLOR);

        // create the labels and set font color
        vacancyNumberLabel = createLabel("Vacancy Number:");
        designationLabel = createLabel("Designation:");
        jobTypeLabel = createLabel("Job Type:");
        staffNameLabel = createLabel("Staff Name:");
        joiningDateLabel = createLabel("Joining Date (YYYY-MM-DD):");
        qualificationLabel = createLabel("Qualification:");
        appointedByLabel = createLabel("Appointed By:");
        joinedLabel = createLabel("Joined:");
        salaryLabel = createLabel("Salary:");
        weeklyFractionalHoursLabel = createLabel("Weekly Fractional Hours:");
        workingHourLabel = createLabel("Working Hour:");
        wagesPerHourLabel = createLabel("Wages Per Hour:");
        shiftsLabel = createLabel("Shifts:");
        displayNumberLabel = createLabel("Display Number:");

        // create the text fields and set background color
        vacancyNumberField = createTextField();
        designationField = createTextField();
        jobTypeField = createTextField();
        staffNameField = createTextField();
        joiningDateField = createTextField();
        qualificationField = createTextField();
        appointedByField = createTextField();
        salaryField = createTextField();
        weeklyFractionalHoursField = createTextField();
        workingHourField = createTextField();
        wagesPerHourField = createTextField();
        shiftsField = createTextField();
        displayNumberField = createTextField();

        // create the joined combo box
        String[] joinedOptions = {"Yes", "No"};
        joinedComboBox = new JComboBox<>(joinedOptions);
        joinedComboBox.setBackground(TEXT_FIELD_COLOR);

        // create the buttons and set colours
        addFullTimeButton = createButton("Add Full Time Staff");
        addPartTimeButton = createButton("Add Part Time Staff");
        setSalaryButton = createButton("Set Salary - Full Time Staff");
        setShiftsButton = createButton("Set Working Shifts - Part Time Staff");
        terminateButton = createButton("Terminate Part Time Staff");
        displayButton = createButton("Display Number");
        clearButton = createButton("Clear");

        // creatin the text area
        displayTextArea = new JTextArea();
        displayTextArea.setEditable(false);
        displayTextArea.setBackground(TEXT_FIELD_COLOR);
        JScrollPane scrollPane = new JScrollPane(displayTextArea);
        scrollPane.setPreferredSize(new Dimension(380, 400));

        // Initialize the staff list
        staffList = new ArrayList<>();

        // Adds components to the input panel using GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        inputPanel.add(vacancyNumberLabel, gbc);
        gbc.gridy++;
        inputPanel.add(designationLabel, gbc);
        gbc.gridy++;
        inputPanel.add(jobTypeLabel, gbc);
        gbc.gridy++;
        inputPanel.add(staffNameLabel, gbc);
        gbc.gridy++;
        inputPanel.add(joiningDateLabel, gbc);
        gbc.gridy++;
        inputPanel.add(qualificationLabel, gbc);
        gbc.gridy++;
        inputPanel.add(appointedByLabel, gbc);
        gbc.gridy++;
        inputPanel.add(joinedLabel, gbc);
        gbc.gridy++;
        inputPanel.add(salaryLabel, gbc);
        gbc.gridy++;
        inputPanel.add(weeklyFractionalHoursLabel, gbc);
        gbc.gridy++;
        inputPanel.add(workingHourLabel, gbc);
        gbc.gridy++;
        inputPanel.add(wagesPerHourLabel, gbc);
        gbc.gridy++;
        inputPanel.add(shiftsLabel, gbc);
        gbc.gridy++;
        inputPanel.add(displayNumberLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        inputPanel.add(vacancyNumberField, gbc);
        gbc.gridy++;
        inputPanel.add(designationField, gbc);
        gbc.gridy++;
        inputPanel.add(jobTypeField, gbc);
        gbc.gridy++;
        inputPanel.add(staffNameField, gbc);
        gbc.gridy++;
        inputPanel.add(joiningDateField, gbc);
        gbc.gridy++;
        inputPanel.add(qualificationField, gbc);
        gbc.gridy++;
        inputPanel.add(appointedByField, gbc);
        gbc.gridy++;
        inputPanel.add(joinedComboBox, gbc);
        gbc.gridy++;
        inputPanel.add(salaryField, gbc);
        gbc.gridy++;
        inputPanel.add(weeklyFractionalHoursField, gbc);
        gbc.gridy++;
        inputPanel.add(workingHourField, gbc);
        gbc.gridy++;
        inputPanel.add(wagesPerHourField, gbc);
        gbc.gridy++;
        inputPanel.add(shiftsField, gbc);
        gbc.gridy++;
        inputPanel.add(displayNumberField, gbc);

        // Adds buttons to the button panel
        buttonPanel.add(addFullTimeButton);
        buttonPanel.add(addPartTimeButton);
        buttonPanel.add(setSalaryButton);
        buttonPanel.add(setShiftsButton);
        buttonPanel.add(terminateButton);
        buttonPanel.add(displayButton);
        buttonPanel.add(clearButton);

        // Adds the scrollable text area to the display panel
        displayPanel.add(scrollPane, BorderLayout.CENTER);

        // Adds the panels to the frame
        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.add(displayPanel, BorderLayout.SOUTH);
    }

    private void addEventHandlers() {
        addFullTimeButton.addActionListener(e -> addFullTimeStaff());
        addPartTimeButton.addActionListener(e -> addPartTimeStaff());
        setSalaryButton.addActionListener(e -> setSalaryForFullTimeStaff());
        setShiftsButton.addActionListener(e -> setShiftsForPartTimeStaff());
        terminateButton.addActionListener(e -> terminatePartTimeStaff());
        displayButton.addActionListener(e -> displayStaffByNumber());
        clearButton.addActionListener(e -> clearInputFields());
    }

    // Method to help handle adding full-time staff
    private void addFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            LocalDate joiningDate = LocalDate.parse(joiningDateField.getText(), DATE_FORMATTER);
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedComboBox.getSelectedItem().toString().equals("Yes");
            double salary = Double.parseDouble(salaryField.getText());
            int weeklyFractionalHours = Integer.parseInt(weeklyFractionalHoursField.getText());

            // Input validation
            if (!validateInput(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy) || salary < 0 || weeklyFractionalHours < 0) {
                showErrorMessage("Please fill in all fields with valid values.");
                return; // Stop if any input is invalid
            }

            FullTimeStaffHire fullTimeStaff = new FullTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, salary, weeklyFractionalHours);
            staffList.add(fullTimeStaff);
            displayTextArea.append("Full Time Staff Added:\n" + fullTimeStaff.getStaffName() + "\n");
            clearInputFields(); 
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for numeric fields (Vacancy Number, Salary, Weekly Fractional Hours).");
        } catch (DateTimeParseException e) {
            showErrorMessage("Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    // Method for handling adding part-time staff
    private void addPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String designation = designationField.getText();
            String jobType = jobTypeField.getText();
            String staffName = staffNameField.getText();
            LocalDate joiningDate = LocalDate.parse(joiningDateField.getText(), DATE_FORMATTER);
            String qualification = qualificationField.getText();
            String appointedBy = appointedByField.getText();
            boolean joined = joinedComboBox.getSelectedItem().toString().equals("Yes");
            int workingHour = Integer.parseInt(workingHourField.getText());
            double wagesPerHour = Double.parseDouble(wagesPerHourField.getText());
            String shifts = shiftsField.getText();

            // Input validation
            if (!validateInput(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy) ||
                    workingHour < 0 || wagesPerHour < 0 || shifts.isEmpty()) {
                showErrorMessage("Please fill in all fields with valid values.");
                return; // Stops if any input is invalid
            }

            PartTimeStaffHire partTimeStaff = new PartTimeStaffHire(vacancyNumber, designation, jobType, staffName, joiningDate, qualification, appointedBy, joined, workingHour, wagesPerHour, shifts);
            staffList.add(partTimeStaff);
            displayTextArea.append("Part Time Staff Added:\n" + partTimeStaff.getStaffName() + "\n");
            clearInputFields();
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for numeric fields (Vacancy Number, Working Hour, Wages Per Hour).");
        } catch (DateTimeParseException e) {
             showErrorMessage("Invalid date format. Please use YYYY-MM-DD.");
        }
    }

    // Method for handling setting salary for full-time staff
    private void setSalaryForFullTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            double newSalary = Double.parseDouble(salaryField.getText());

            if (newSalary < 0) {
                showErrorMessage("Salary cannot be negative.");
                return;
            }

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if (staff instanceof FullTimeStaffHire) {
                        ((FullTimeStaffHire) staff).setSalary(newSalary);
                        displayTextArea.append("Salary set for staff with Vacancy Number: " + vacancyNumber + "\n");
                        clearInputFields();
                        return; // Exits
                    } else {
                        showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " is not a full-time staff member.");
                        return;
                    }
                }
            }
            showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " not found.");
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for Vacancy Number or Salary.");
        }
    }

    // Method to handle setting shifts for the part-time staff
    private void setShiftsForPartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            String newShift = shiftsField.getText();

            if (newShift.isEmpty()) {
                showErrorMessage("Shift cannot be empty.");
                return;
            }

            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if (staff instanceof PartTimeStaffHire) {
                        ((PartTimeStaffHire) staff).setShifts(newShift);
                        displayTextArea.append("Shift set for staff with Vacancy Number: " + vacancyNumber + "\n");
                        clearInputFields();
                        return;
                    } else {
                        showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " is not a part-time staff member.");
                        return;
                    }
                }
            }
            showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " not found.");
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for Vacancy Number.");
        }
    }

    // Method to handle terminating the part-time staff
    private void terminatePartTimeStaff() {
        try {
            int vacancyNumber = Integer.parseInt(vacancyNumberField.getText());
            for (StaffHire staff : staffList) {
                if (staff.getVacancyNumber() == vacancyNumber) {
                    if (staff instanceof PartTimeStaffHire) {
                        ((PartTimeStaffHire) staff).terminateStaff();
                        displayTextArea.append("Part-time staff with Vacancy Number " + vacancyNumber + " terminated.\n");
                        clearInputFields();
                        return;
                    } else {
                        showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " is not a part-time staff member.");
                        return;
                    }
                }
            }
            showErrorMessage("Staff with Vacancy Number " + vacancyNumber + " not found.");
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for Vacancy Number.");
        }
    }

    // Method to handle displaying the staff by number
    private void displayStaffByNumber() {
        try {
            int displayNumber = Integer.parseInt(displayNumberField.getText());
            if (displayNumber >= 0 && displayNumber < staffList.size()) {
                StaffHire staff = staffList.get(displayNumber);
                displayTextArea.setText("Staff Details:\n");
                staff.display();
            } else {
                showErrorMessage("Invalid Display Number.  Please enter a valid number from 0 to " + (staffList.size() - 1));
            }
            displayNumberField.setText(""); // Clears the display num field
        } catch (NumberFormatException e) {
            showErrorMessage("Invalid input for Display Number.  Please enter a number.");
        }
    }

    // Method to clear input fields
    private void clearInputFields() {
        vacancyNumberField.setText("");
        designationField.setText("");
        jobTypeField.setText("");
        staffNameField.setText("");
        joiningDateField.setText("");
        qualificationField.setText("");
        appointedByField.setText("");
        joinedComboBox.setSelectedIndex(0);
        salaryField.setText("");
        weeklyFractionalHoursField.setText("");
        workingHourField.setText("");
        wagesPerHourField.setText("");
        shiftsField.setText("");
        displayNumberField.setText("");
    }

    // Method to customize button appearance
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setBackground(BUTTON_COLOR);
        button.setForeground(BUTTON_TEXT_COLOR);
        button.setFont(new Font("Arial", Font.BOLD, 12));
        button.setBorderPainted(true);
        button.setFocusPainted(false);
        return button;
    }

    private JLabel createLabel(String text) {
        JLabel label = new JLabel(text);
        label.setForeground(LABEL_COLOR);
        return label;
    }

    private JTextField createTextField() {
        JTextField textField = new JTextField(15);
        textField.setBackground(TEXT_FIELD_COLOR);
        return textField;
    }

    private void showErrorMessage(String message) {
        JOptionPane.showMessageDialog(frame, message, "Input Error", JOptionPane.ERROR_MESSAGE);
    }

    private boolean validateInput(int vacancyNumber, String designation, String jobType, String staffName, LocalDate joiningDate, String qualification, String appointedBy) {
        return vacancyNumber > 0 && !designation.isEmpty() && !jobType.isEmpty() && !staffName.isEmpty() &&
                joiningDate != null && !qualification.isEmpty() && !appointedBy.isEmpty();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RecruitmentSystemGUI());
    }
}
