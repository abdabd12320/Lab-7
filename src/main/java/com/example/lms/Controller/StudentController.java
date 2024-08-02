package com.example.lms.Controller;

import com.example.lms.ApiResponse.StudentApiResponse;
import com.example.lms.Model.Student;
import com.example.lms.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/get")
    public ResponseEntity getStudents()
    {
        return ResponseEntity.status(200).body(studentService.getStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@Valid@RequestBody Student student, Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        studentService.addStudent(student);
        return ResponseEntity.status(200).body(new StudentApiResponse("Student added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable String id,@Valid@RequestBody Student student,Errors errors)
    {
        if(errors.hasErrors())
        {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        if(studentService.updateStudent(id, student))
        {
            return ResponseEntity.status(200).body(new StudentApiResponse("Student updated"));
        }
        return ResponseEntity.status(400).body(new StudentApiResponse("not found"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable String id)
    {
        if(studentService.deleteStudent(id))
        {
            return ResponseEntity.status(200).body(new StudentApiResponse("Student deleted"));
        }
        return ResponseEntity.status(400).body(new StudentApiResponse("not found"));
    }
    @GetMapping("/search/{id}")
    public ResponseEntity searchById(@PathVariable String id)
    {
        if(studentService.searchById(id) == null)
        {
            return ResponseEntity.status(400).body(new StudentApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(studentService.searchById(id));
    }
    @GetMapping("/get-oldest")
    public ResponseEntity getOldest()
    {
        return ResponseEntity.status(200).body(studentService.getOldest());
    }
//    @GetMapping("/get-sort-ages")
//    public ResponseEntity getSortAges()
//    {
//        return ResponseEntity.status(200).body(studentService.getSortAges());
//    }
    @PutMapping("/apply-is-regular/{id}")
    public ResponseEntity applyIsRegular(@PathVariable String id)
    {
        if(studentService.applyIsRegular(id))
        {
            return ResponseEntity.status(200).body(new StudentApiResponse("Done"));
        }
        return ResponseEntity.status(400).body(new StudentApiResponse("not found or it is false"));
    }
    @GetMapping("/get-all-regular")
    public ResponseEntity getAllRegular()
    {
        if(studentService.getAllRegular().isEmpty())
        {
            return ResponseEntity.status(400).body(new StudentApiResponse("not found"));
        }
        return ResponseEntity.status(200).body(studentService.getAllRegular());
    }

}
