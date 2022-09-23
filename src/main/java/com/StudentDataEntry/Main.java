package com.StudentDataEntry;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        boolean value =true;
        Subjects subjects = new Subjects();
        Students students =new Students();
        SubjectMarks subjectMarks = new SubjectMarks();
        Grades grades = new Grades();

        while (value) {
            System.out.println();
            System.out.println("........WELCOME TO STUDENT MANAGEMENT SYSTEM...........");
            System.out.println();
            System.out.println();
            System.out.println("For Manage Students press ----------> 1");
            System.out.println("For Manage Subjects press------------>2");
            System.out.println("For Find Ranks press----------------->3");
            System.out.println("For Exit press----------------------->4");
            System.out.println();
            int firstInput = 0;
            try {
              firstInput = input.nextInt();
            } catch (Exception e) {
                System.out.println("Please enter the valid number");
            }
            if (firstInput==1){
                System.out.println("Add Student : enter letter -----------A ");
                System.out.println("Search Student : enter letter ------- B ");
                System.out.println("Delete Student : enter letter --------C ");
                System.out.println("View student list : enter letter -----D ");
                System.out.println();
                String firstInputLetter = input.next();
                switch (firstInputLetter) {
                    case ("A"):
                        try {
                            System.out.print("Enter the student name: ");
                            String studentName = input.next();
                            students.addStudent(studentName);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case ("B"):
                        System.out.print("Enter the name what do you want to search : ");
                        String studentsearchName = input.next();
                        students.searchFile(studentsearchName);
                        break;

                    case ("C"):
                        System.out.print("What is the Student name do you want to delete: ");
                        String studentDeleteName = input.next();
                        students.deleteName(studentDeleteName);
                        break;

                    case ("D"):
                        students.studentsRegister();
                        break;

                    default:
                        System.out.println("Please enter the correct letter");
                }
            } else if (firstInput==2) {
                System.out.println("Add new Subject  : Enter letter -------E ");
                System.out.println("View existing Subject  : Enter letter -F ");
                System.out.println("Add Marks For Subject : Enter letter --G ");
                System.out.println("Delete Subject : Enter letter ---------H ");
                String firstInputLetter = input.next();
                switch (firstInputLetter) {
                    case ("E"):
                        try {
                            System.out.print("Enter the new Subject name : ");
                            String newSubjectName = input.next();
                            subjects.subjectsNamesWrite(newSubjectName);
                        }catch (Exception e){
                            e.getMessage();
                        }
                        break;

                    case ("F"):
                        subjects.subjectNameRead();
                        break;

                    case ("G"):
                        System.out.print("Enter the Student name : ");
                        String checkStudentName = input.next();
                        subjectMarks.checkStudentName(checkStudentName);
                        System.out.println();
                        System.out.print("Please enter the Subject name : ");
                        String checkSubjectName = input.next();
                        subjectMarks.checkSubjectName(checkSubjectName);
                        System.out.println();
                        System.out.print("Enter the marks : ");
                        int subjectmarks = input.nextInt();
                        subjectMarks.addMarksForSubject(checkStudentName,checkSubjectName,subjectmarks);
                        System.out.println();
                        break;

                    case("H"):
                        System.out.print("What is the Subject name do you want to delete: ");
                        String subjectDeleteName = input.next();
                        subjects.deleteSubjectName(subjectDeleteName);
                    default:
                        System.out.println("Please enter the correct letter");
                }
            } else if (firstInput==3) {
                System.out.println("Please enter the student name  : ");
                try {
                    String studentgrade = input.next();
                    grades.findGrades(studentgrade);
                }catch (Exception e){
                    System.out.println("Plese enter the studet name correctly");
                }


            } else if (firstInput==4) {
                value=false;

            }else {
                System.out.println("Plese enter the valid number");
            }
        }
    }
}