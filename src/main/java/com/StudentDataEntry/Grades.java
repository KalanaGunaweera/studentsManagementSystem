package com.StudentDataEntry;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Grades {
    Subjects subjects = new Subjects();
    Students students = new Students();
    ObjectMapper mapper = new ObjectMapper();

    private String name;
    public Grades() throws IOException {
    }
    public Grades(String name) throws IOException {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void findGrades(String name) throws IOException {
        students.studentlistmap= mapper.readValue(students.studentlist_filepath.toFile(), Map.class);
        if (students.studentlistmap.containsKey(name.toString())){
            Map <String,Integer> totalvaluemap= new HashMap<>();
            Map <Integer,Integer> studentRankmap= new HashMap<>();
            int[] studenttotalmarks= new int[students.studentlistmap.size()];


            for (Map.Entry<String, Integer> entry : students.studentlistmap.entrySet()) {
                String k = entry.getKey();
                Path filepathname = Paths.get("D:/PROGRAMMING/java/Class/java programmimg theory/Cording/com.studentsDataEntryProgram/"+k+".txt");
                subjects.subjectlistmap=mapper.readValue(filepathname.toFile(),Map.class);
                int sum = subjects.subjectlistmap.values().stream().mapToInt(Integer::intValue).sum();
                totalvaluemap.put(k,sum);
            }
            int a=0;
            for (Map.Entry<String, Integer> entry : totalvaluemap.entrySet()) {
                int x= entry.getValue();
                studenttotalmarks[a]=x;
                a++;

            }

            for (int i = 0; i <studenttotalmarks.length; i++) {
                for (int j = 1; j < studenttotalmarks.length; j++) {
                    if (studenttotalmarks[j - 1] < studenttotalmarks[j]) {
                        int b = studenttotalmarks[j - 1];
                        studenttotalmarks[j - 1] = studenttotalmarks[j];
                        studenttotalmarks[j] = b;
                    }
                }
            }

            int rank =1;
            for (int arr : studenttotalmarks){
                studentRankmap.put(arr,rank);
                rank++;
            }
            //System.out.println(studentRankmap);
            Path filepath = Paths.get("D:/PROGRAMMING/java/Class/java programmimg theory/Cording/com.studentsDataEntryProgram/"+name+".txt");
            totalvaluemap.get(name);
            //System.out.println(totalvaluemap.get(name));
            studentRankmap.get(totalvaluemap.get(name));
            System.out.println("Your rank is : "+studentRankmap.get(totalvaluemap.get(name)));
        }
    }
}
