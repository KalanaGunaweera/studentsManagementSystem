package com.StudentDataEntry;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

public class Subjects {
    private String subjectName;

    public Subjects(String subjectName) throws IOException {
        this.subjectName = subjectName;
    }
    public Subjects() throws IOException {
    }

    public String getSubjectName() {
        return subjectName;
    }
    public void setSubjectName() {
        this.subjectName = subjectName;
    }
    public File getSubjectfile() {
        return subjectfile;
    }
    public void setSubjectfile(File subjectfile) {
        this.subjectfile = subjectfile;
    }
    File subjectfile = new File("Subjects.txt");
    Map<String,Integer> subjectlistmap = new HashMap<>();
    ObjectMapper mapper = new ObjectMapper();
    Path filepath= Path.of(subjectfile.getPath());

    public void subjectsNamesWrite(String subjectName) throws IOException {
        subjectlistmap=mapper.readValue(filepath.toFile(),Map.class);
        subjectlistmap.put(subjectName,0);
        mapper.writeValue(filepath.toFile(),subjectlistmap);
    }

    public void subjectNameRead() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        subjectlistmap=mapper.readValue(filepath.toFile(),Map.class);
        System.out.println(subjectlistmap);
    }

    public void deleteSubjectName(String sunjectname) throws IOException {
        subjectlistmap=mapper.readValue(filepath.toFile(),Map.class);
        if(subjectlistmap.containsKey(sunjectname)){
            subjectlistmap.remove(sunjectname);
            System.out.println("Delete the subject ");
        }else {
            System.out.println("Subject is not found. Please enter the valid name.");
        }
    }
}
