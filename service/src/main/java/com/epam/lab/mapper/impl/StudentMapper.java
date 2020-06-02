package com.epam.lab.mapper.impl;

import com.epam.lab.dto.impl.StudentDto;
import com.epam.lab.mapper.AbstractMapper;
import com.epam.lab.model.impl.Student;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class StudentMapper implements AbstractMapper<StudentDto, Student> {

    private ModelMapper modelMapper;

    @Autowired
    public StudentMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Student toEntity(StudentDto studentDto) {
        return modelMapper.map(studentDto, Student.class);
    }

    @Override
    public StudentDto toDto(Student student) {
        return modelMapper.map(student, StudentDto.class);
    }

    @Override
    public List<StudentDto> toDtoList(List<Student> students) {
        return students.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Student> toEntityList(List<StudentDto> studentDtoList) {
        return studentDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
