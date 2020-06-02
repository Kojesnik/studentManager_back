package com.epam.lab.service;

import com.epam.lab.dto.impl.StudentDto;
import java.util.List;

public interface StudentService extends EntityService<StudentDto> {

    List<StudentDto> getAll();

}
