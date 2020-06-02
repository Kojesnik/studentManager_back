package com.epam.lab.controller;

import com.epam.lab.dto.impl.GroupDto;
import com.epam.lab.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/group")
public class GroupController {

    private GroupService groupService;

    @Autowired
    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<GroupDto> get(@PathVariable long id) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(id);
        return new ResponseEntity<>(groupService.get(groupDto), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<GroupDto>> getAll() {
        return new ResponseEntity<>(groupService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable long id) {
        GroupDto groupDto = new GroupDto();
        groupDto.setId(id);
        return new ResponseEntity<>(groupService.remove(groupDto), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<GroupDto> add(@RequestBody GroupDto groupDto) {
        return new ResponseEntity<>(groupService.add(groupDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<GroupDto> update(@RequestBody GroupDto groupDto, @PathVariable long id) {
        groupDto.setId(id);
        return new ResponseEntity<>(groupService.update(groupDto), HttpStatus.OK);
    }

}
