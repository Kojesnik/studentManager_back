package com.epam.lab.dto.impl;

import com.epam.lab.dto.EntityDto;

public class GroupDto extends EntityDto {

    private long id;
    private String groupNumber;

    public GroupDto(long id, String groupNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
    }

    public GroupDto(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public GroupDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    public void setGroupNumber(String groupNumber) {
        this.groupNumber = groupNumber;
    }


}
