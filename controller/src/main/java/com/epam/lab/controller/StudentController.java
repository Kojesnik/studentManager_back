package com.epam.lab.controller;

import com.epam.lab.dto.impl.StudentDto;
import com.epam.lab.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/student")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDto> get(@PathVariable long id) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(id);
        return new ResponseEntity<>(studentService.get(studentDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getAll() {
        return new ResponseEntity<>(studentService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(id);
        return new ResponseEntity<>(studentService.remove(studentDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<StudentDto> add(@RequestBody StudentDto studentDto) {
        System.out.println(studentDto);
        return new ResponseEntity<>(studentService.add(studentDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@RequestBody StudentDto studentDto, @PathVariable long id) {
        System.out.println(studentDto);
        System.out.println(id);
        studentDto.setId(id);
        return new ResponseEntity<>(studentService.update(studentDto), HttpStatus.OK);
    }

}
