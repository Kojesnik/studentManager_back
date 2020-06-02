package com.epam.lab.service.impl;

import com.epam.lab.dto.impl.GroupDto;
import com.epam.lab.exception.FindException;
import com.epam.lab.mapper.AbstractMapper;
import com.epam.lab.model.impl.Group;
import com.epam.lab.repository.GroupRepository;
import com.epam.lab.service.GroupService;
import com.epam.lab.specification.impl.group.GroupAllSpecification;
import com.epam.lab.specification.impl.group.GroupIdSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupRepository groupRepository;
    private AbstractMapper<GroupDto, Group> groupMapper;

    @Autowired
    public GroupServiceImpl(GroupRepository groupRepository, AbstractMapper<GroupDto, Group> groupMapper) {
        this.groupRepository = groupRepository;
        this.groupMapper = groupMapper;
    }

    @Override
    public List<GroupDto> getAll() {
        return groupMapper.toDtoList(groupRepository.query(new GroupAllSpecification()));
    }

    @Override
    public GroupDto add(GroupDto groupDto) {
        Group group = groupRepository.add(groupMapper.toEntity(groupDto));
        return groupMapper.toDto(group);
    }

    @Override
    public GroupDto update(GroupDto groupDto) {
        Group group = groupRepository.update(groupMapper.toEntity(groupDto));
        return groupMapper.toDto(group);
    }

    @Override
    public Boolean remove(GroupDto groupDto) {
        return groupRepository.remove(groupMapper.toEntity(groupDto));
    }

    @Override
    public GroupDto get(GroupDto groupDto) {
        List<Group> groups = groupRepository.query(new GroupIdSpecification(groupDto.getId()));
        if (groups.isEmpty()) {
            throw new FindException("Such group doesn't exists");
        }
        return groupMapper.toDto(groups.get(0));
    }
}
