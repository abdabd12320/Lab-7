package com.example.lms.Service;

import com.example.lms.Model.Material;
import com.example.lms.Model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

@Service
public class StudentService {

    ArrayList<Student> students = new ArrayList<>();

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean updateStudent(String id,Student student)
    {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id))
            {
                students.set(i,student);
                return true;
            }
        }
        return false;
    }

    public boolean deleteStudent(String id)
    {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id))
            {
                students.remove(i);
                return true;
            }
        }
        return false;
    }

    public Student searchById(String id)
    {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id))
            {
                return students.get(i);
            }
        }
        return null;
    }

    public Student getOldest()
    {
        int old = 0;
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
                if(students.get(i).getAge() > old)
                {
                    old = students.get(i).getAge();
                    index = i;
                }
        }
        return students.get(index);
    }

//    public ArrayList<Student> getSortAges()
//    {
//        ArrayList<Student> students1 = new ArrayList<>(students);
//        Student temp;
//        for (int i = 0; i < students.size(); i++) {
//            for (int j = 0; j < students.size(); j++) {
//                if(students1.get(i).getAge() < students1.get(j).getAge())
//                {
//                    temp = new Student(students1.get(i).getId(),students1.get(i).getName(),students1.get(i).getAge(),students1.get(i).getEmail(),students1.get(i).isRegular());
//                    students1.get(i).setId(students1.get(j).getId());
//                    students1.get(i).setName(students1.get(j).getName());
//                    students1.get(i).setAge(students1.get(j).getAge());
//                    students1.get(i).setEmail(students1.get(j).getEmail());
//                    students1.get(i).setRegular(students1.get(j).isRegular());
//                    students1.get(j).setId(temp.getId());
//                    students1.get(j).setName(temp.getName());
//                    students1.get(j).setAge(temp.getAge());
//                    students1.get(j).setEmail(temp.getEmail());
//                    students1.get(j).setRegular(temp.isRegular());
//                }
//            }
//        }
//        return students1;
//    }

    public boolean applyIsRegular(String id)
    {
        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).getId().equals(id) && students.get(i).isRegular())
            {
                students.get(i).setRegular(false);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Student> getAllRegular()
    {
        ArrayList<Student> students1 = new ArrayList<>();

        for (int i = 0; i < students.size(); i++) {
            if(students.get(i).isRegular())
            {
                students1.add(students.get(i));
            }
        }
        return students1;
    }
}
