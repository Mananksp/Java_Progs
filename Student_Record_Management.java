import java.util.Scanner;

class Student {
    private int studentID;
    private String name;
    private int age;
    private String department;

    public Student(int studentID, String name, int age, String department) {
        this.studentID = studentID;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    public int Check_ID() {
        return studentID;
    }

    public String Get_Name() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String Get_Dept() {
        return department;
    }


    public String To_String() {
        return "Student ID: " + studentID + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

class Student_Record_System {
    private Student[] students;
    private int count;

    public Student_Record_System(int size) {
        students = new Student[size];
        count = 0;
    }

    public void Add_Student_Data(Student student) {
        if (count < students.length) {
            students[count] = student;
            count++;
        } else {
            System.out.println("100 Student already added.");
        }
    }

    public void Display_Details() {
        for (int i = 0; i < count; i++) {
            System.out.println(students[i]);
        }
        if (count == 0) {
            System.out.println("No Student Record Found");
        }
    }
    public boolean Check_ID(int id){
      for(int i=0;i<students.length;i++){
        if(students[i].Check_ID()==id){
          System.out.println(students[i]);
          return true;
        }
      }
      return false;
    }
}

public class Student_Record_Management{
    public static void main(String[] args) {
        Student_Record_System studentRecord = new Student_Record_System(100);
        int choice;
        Scanner input = new Scanner(System.in);

        do {
            System.out.println("Enter 1: Add Student Record");
            System.out.println("Enter 2: View Existing Student Records");
            System.out.println("Enter 3: Search for a Student by ID");
            System.out.println("Enter 4: Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1: {
                    System.out.println("Enter Student ID: ");
                    int id = input.nextInt();
                    System.out.println("Enter Student Name: ");
                    String name = input.next();
                    System.out.println("Enter Student Age: ");
                    int age = input.nextInt();
                    System.out.println("Enter Department: ");
                    String department = input.next();
                    Student s = new Student(id, name, age, department);
                    studentRecord.Add_Student_Data(s);
                    break;
                }
                case 2: {
                    studentRecord.Display_Details();
                    break;
                }

                case 3: {
                    System.out.println("Enter ID to Search Student Record: ");
                    int searchid = input.nextInt();
                    
                    if(studentRecord.Check_ID(searchid) == true){
                      System.out.println("Student Record found");            
                    }
                    else{
                      System.out.println("Student Record not found.");
                    }
                    break;
                }
                
                case 4: {
                    System.out.println("Exiting...");
                    break;
                }
                default: {
                    System.out.println("Invalid Choice...");
                }
            }
        } while (choice != 4);
        input.close();
    }
}
