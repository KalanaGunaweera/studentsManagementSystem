package com.StudentDataEntry;
import java.io.BufferedWriter;
import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Students {
    String studentName;

    public Students(String studentName) throws IOException {
        this.studentName = studentName;
    }
    public Students() throws IOException {
    }
    public String getStudentName() {
        return studentName;
    }
    File studentsfile = new File("StudentsRegister.txt");
    Map<String,Integer> studentlistmap = new HashMap<>();
    Map<String,Integer> studentNameMap = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    Subjects subjects = new Subjects();
    Path studentlist_filepath= Path.of(studentsfile.getPath());

    public void addStudent(String studentName) throws IOException {
        this.studentName=studentName;
        File file = new File(studentName+".txt");
        Path studentNamefile = Path.of(file.getPath());
        subjects.subjectlistmap=mapper.readValue(subjects.filepath.toFile(),Map.class);
        mapper.writeValue(studentNamefile.toFile(),subjects.subjectlistmap);
        studentlistmap=mapper.readValue(studentlist_filepath.toFile(),Map.class);
        studentlistmap.put(studentName,0);
        mapper.writeValue(studentlist_filepath.toFile(),studentlistmap);
    }
    public void searchFile(String name){
        File file = new File("D:/PROGRAMMING/java/Class/java programmimg theory/Cording/com.studentsDataEntryProgram/"+name+".txt");
        if (file.exists()){
            System.out.println("File is exist");
        }else {
            System.out.println("File is not exist");
        }
    }

    public void deleteName(String name){
        File file = new File("D:/PROGRAMMING/java/Class/java programmimg theory/Cording/com.studentsDataEntryProgram/"+name+".txt");
        if (file.exists()){
            file.delete();
            studentlistmap.remove(name);
            System.out.println("Delete the file");
        }else {
            System.out.println("File is not in the directory. Please enter the valid name.");
        }

    }

    public void studentsRegister() throws IOException {
        studentlistmap=mapper.readValue(studentlist_filepath.toFile(),Map.class);
        System.out.println(studentlistmap);
    }
    }


