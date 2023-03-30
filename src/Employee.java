public class Employee {
    private String firstName;
    private String lastName;
    private double hourlyRate;
    private double workedHours;

    public Employee(String firstName, String lastName, double hourlyRate, double workedHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
        this.workedHours = workedHours;
    }

    public double calculateSalary() throws PayRollException {
        if (hourlyRate <= 0 || workedHours < 0){
            throw new PayRollException("Invalid data");
        }
        double salary = hourlyRate * workedHours;
        if (salary < 0) {
            throw new PayRollException("Error");
        }
        return salary;
    }

    public String toString() {
        return firstName + " " + lastName + ": " + String.format("%.2f", hourlyRate) + " kn/h, " + workedHours + " h";
    }
}
