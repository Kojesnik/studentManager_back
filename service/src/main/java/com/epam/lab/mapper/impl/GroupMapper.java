package com.epam.lab.mapper.impl;

import com.epam.lab.dto.impl.GroupDto;
import com.epam.lab.mapper.AbstractMapper;
import com.epam.lab.model.impl.Group;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class GroupMapper implements AbstractMapper<GroupDto, Group> {

    private ModelMapper modelMapper;

    @Autowired
    public GroupMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public Group toEntity(GroupDto groupDto) {
        return modelMapper.map(groupDto, Group.class);
    }

    @Override
    public GroupDto toDto(Group group) {
        return modelMapper.map(group, GroupDto.class);
    }

    @Override
    public List<GroupDto> toDtoList(List<Group> groups) {
        return groups.stream().map(this::toDto).collect(Collectors.toList());
    }

    @Override
    public List<Group> toEntityList(List<GroupDto> groupDtoList) {
        return groupDtoList.stream().map(this::toEntity).collect(Collectors.toList());
    }

}
