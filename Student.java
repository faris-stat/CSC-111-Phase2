public class Student {
    [span_6](start_span)// Attributes (Private as per UML)[span_6](end_span)
    private int id;
    private String name;
    private int age;
    private double gpa;

    [span_7](start_span)// Default Constructor[span_7](end_span)
    public Student() {
        this.id = 123456;
        this.name = "NA";
        this.age = 20;
        this.gpa = 1.0;
    }

    [span_8](start_span)// Parameterized Constructor[span_8](end_span)
    public Student(int id, String name, int age, double gpa) {
        // We use setters here to apply validations
        setId(id);
        setName(name); // Name has no validation, but good practice
        setAge(age);
        setGpa(gpa);
    }

    [span_9](start_span)// Setters[span_9](end_span)
    public void setId(int id) {
        // Check if ID has 6 digits
        if (String.valueOf(id).length() == 6) {
            this.id = id;
        } else {
            System.out.println("Incorrect ID");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 0) {
            this.age = age;
        } else {
            System.out.println("Incorrect age");
        }
    }

    public void setGpa(double gpa) {
        if (gpa >= 1.0 && gpa <= 5.0) {
            this.gpa = gpa;
        } else {
            System.out.println("Incorrect GPA");
        }
    }

    [span_10](start_span)// Getters[span_10](end_span)
    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public double getGpa() { return gpa; }

    [span_11](start_span)// getGrade Method[span_11](end_span)
    public String getGrade() {
        if (gpa >= 4.75 && gpa <= 5.0) return "Excellent";
        else if (gpa >= 4.0 && gpa < 4.75) return "Very Good";
        else if (gpa >= 3.0 && gpa < 4.0) return "Good";
        else if (gpa >= 2.0 && gpa < 3.0) return "Pass";
        else return "Fail"; // 1.0 <= gpa < 2.0
    }

    [span_12](start_span)// display Method[span_12](end_span)
    public void display() {
        // Format: ID: 235452, Name: Ali, Age: 20, GPA: 4.65 (Very Good)
        System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age + ", GPA: " + gpa + " (" + getGrade() + ")");
    }

    [span_13](start_span)// compare Method[span_13](end_span)
    public int compare(Student stud) {
        if (this.gpa > stud.getGpa())
            return 1;
        else if (this.gpa == stud.getGpa())
            return 0;
        else
            return -1;
    }
}
