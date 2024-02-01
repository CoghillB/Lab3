import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        int choice;
        //if exception is caught it will print out the error and loop back to the previous option
        try {
            do {
                System.out.println();
                System.out.println("Menu");
                System.out.println();
                System.out.println("1. Add Student");
                System.out.println("2. Edit Student Grade");
                System.out.println("3. Exit");

                choice = input.nextInt();
                if (choice != 1 && choice != 2 && choice != 3) {
                    System.out.println("Enter a valid input");

                } else if (choice == 1) {
                    addStudents(students, input);
                } else if (choice == 2) {
                    editStudentGrade(students, input);
                }else if(choice == 3){
                    System.out.println("Goodbye");
                    break;
                }

            } while (choice != 3);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input");
            input.nextLine();
            main(args);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds exception");
            input.nextLine();
            main(args);
            
        }
        input.close();
    }

    public static void editStudentGrade(ArrayList<Student> students, Scanner input) {
        try {
            if (students.size() == 0) {
                System.out.println("No students have been added");
                return;
            }
            System.out.println("what students grade would you like to edit?");
            for (int i = 0; i < students.size(); i++) {
                System.out.println((i + 1) + ". " + students.get(i).getName() + " - " + students.get(i).getGrade());
                
            }
            int choice = input.nextInt();
            while (choice < 1 || choice > students.size()) {
                System.out.println("Not a valid choice, please choose again.");
                choice = input.nextInt();
            }
            System.out.println("What is the new grade?");
            int newGrade = input.nextInt();
            while (newGrade < 0 || newGrade > 100) {
                System.out.println("Not a valid choice, please choose again.");
                newGrade = input.nextInt();
            }
            students.get(choice - 1).setGrade(newGrade);
        
        } catch (InputMismatchException e) {
            System.out.println("Please enter the correct input.");
            input.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
            input.next();
        }
    }

    public static void addStudents(ArrayList<Student> students, Scanner input) {
        try {
            System.out.println("What is the name of the student you would like to add?");
            String name = input.next();
            System.out.println("What is the students grade?");
            int grade = input.nextInt();
            while (grade < 0 || grade > 100) {
                System.out.println("Not a valid choice, please choose again.");
                grade = input.nextInt();
            }
            students.add(new Student(name, grade));
        } catch (InputMismatchException e) {
            System.out.println("Invalid Input");
            input.next();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Index out of bounds");
            input.next();
        }
    }
}