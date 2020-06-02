package com.epam.lab.service;

import com.epam.lab.dto.impl.GroupDto;

import java.util.List;

public interface GroupService extends EntityService<GroupDto> {

    List<GroupDto> getAll();

}
