package com.StudentDataEntry;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class SubjectMarks {
    private int marks;
    private String studentName;
    private String subjectName;
    private boolean a=false,b=false;
    Map<String,Integer> subjectmarks = new HashMap<>();

    public boolean isA() {
        return a;
    }
    public void setA(boolean a) {
        this.a = a;
    }
    public boolean isB() {
        return b;
    }
    public void setB(boolean b) {
        this.b = b;
    }
    public SubjectMarks() throws IOException {
    }
    public SubjectMarks(int marks, String studentName, String subjectName) throws IOException {
        this.marks = marks;
        this.studentName = studentName;
        this.subjectName = subjectName;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    ObjectMapper mapper = new ObjectMapper();
    Students students = new Students();
    Subjects subjects = new Subjects();

    public void checkStudentName( String studentName) throws IOException {

        students.studentlistmap=mapper.readValue(students.studentlist_filepath.toFile(), Map.class);
        if (students.studentlistmap.containsKey(studentName.toString())){
            setA(true);
        }else {
            System.out.println("Please enter the valid name or update the name list ");
            return;
        }
        }
    public void checkSubjectName(String checkSubjectName) throws IOException {
        subjects.subjectlistmap=mapper.readValue(subjects.filepath.toFile(),Map.class);
        if (subjects.subjectlistmap.containsKey(checkSubjectName.toString())){
            setB(true);
        }else {
            System.out.println("Please enter the valid subject or update the subject list ");
            return;
    }
}
    public void addMarksForSubject(String studentName,String subjectName, int marks) throws IOException {
        if (isA() && isB()) {
            if (subjects.subjectlistmap.containsKey(subjectName.toString())) {
                // System.out.println("okkkkk");
                Path filepath = Paths.get("D:/PROGRAMMING/java/Class/java programmimg theory/Cording/com.studentsDataEntryProgram/" + studentName + ".txt");
                subjects.subjectlistmap = mapper.readValue(filepath.toFile(), Map.class);
                System.out.println(subjects.subjectlistmap);
                subjects.subjectlistmap.put(subjectName, marks);
                mapper.writeValue(filepath.toFile(), subjects.subjectlistmap);
            }

        }
    }



    }









