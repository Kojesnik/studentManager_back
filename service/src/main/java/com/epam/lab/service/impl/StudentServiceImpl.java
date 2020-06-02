package com.epam.lab.service.impl;

import com.epam.lab.dto.impl.StudentDto;
import com.epam.lab.exception.FindException;
import com.epam.lab.mapper.AbstractMapper;
import com.epam.lab.model.impl.Student;
import com.epam.lab.repository.StudentRepository;
import com.epam.lab.service.StudentService;
import com.epam.lab.specification.impl.student.StudentAllSpecification;
import com.epam.lab.specification.impl.student.StudentIdSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;
    private AbstractMapper<StudentDto, Student> studentMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, AbstractMapper<StudentDto, Student> studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public List<StudentDto> getAll() {
        List<Student> students = studentRepository.query(new StudentAllSpecification());
        return studentMapper.toDtoList(students);
    }

    @Override
    public StudentDto add(StudentDto studentDto) {
        Student student = studentRepository.add(studentMapper.toEntity(studentDto));
        System.out.println(student);
        return studentMapper.toDto(student);
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        Student student = studentRepository.update(studentMapper.toEntity(studentDto));
        return studentMapper.toDto(student);
    }

    @Override
    public Boolean remove(StudentDto studentDto) {
        return studentRepository.remove(studentMapper.toEntity(studentDto));
    }

    @Override
    public StudentDto get(StudentDto studentDto) {
        List<Student> students = studentRepository.query(new StudentIdSpecification(studentDto.getId()));
        if (students.isEmpty()) {
            throw new FindException("Such student doesn't exists");
        }
        return studentMapper.toDto(students.get(0));
    }
}
