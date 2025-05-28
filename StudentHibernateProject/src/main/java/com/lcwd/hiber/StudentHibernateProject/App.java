package com.lcwd.hiber.StudentHibernateProject;

import java.util.Scanner;

import java.util.List;





public class App 
{
	public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Student Management ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Student by ID");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();

            switch (ch) {
                case 1:
                    Student s = new Student();
                    System.out.print("Enter Name: ");
                    s.setName(sc.next());
                    System.out.print("Enter Email: ");
                    s.setEmail(sc.next());
                    dao.insertStudent(s);
                    break;
                case 2:
                    System.out.print("Enter ID: ");
                    Student st = dao.getStudent(sc.nextInt());
                    System.out.println("Student: " + st.getName() + ", " + st.getEmail());
                    break;
                case 3:
                	List<Student> students = dao.getAllStudents();
                    for (Student std : students) {
                        System.out.println(std.getId() + ": " + std.getName() + ", " + std.getEmail());
                    }
                    break;
                case 4:
                    System.out.print("Enter ID to Update: ");
                    Student su = dao.getStudent(sc.nextInt());
                    System.out.print("New Name: ");
                    su.setName(sc.next());
                    System.out.print("New Email: ");
                    su.setEmail(sc.next());
                    dao.updateStudent(su);
                    break;
                case 5:
                    System.out.print("Enter ID to Delete: ");
                    dao.deleteStudent(sc.nextInt());
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
            }
        }
    }
}
