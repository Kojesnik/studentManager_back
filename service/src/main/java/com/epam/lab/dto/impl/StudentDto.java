package com.epam.lab.dto.impl;

import com.epam.lab.dto.EntityDto;

public class StudentDto extends EntityDto {

    private long id;
    private String name;
    private String surname;
    private GroupDto groupDto;
    private long grade;
    private long mark;

    public StudentDto(long id, String name, String surname, GroupDto groupDto, long grade) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.groupDto = groupDto;
        this.grade = grade;
    }

    public StudentDto(String name, String surname, GroupDto groupDto, long grade) {
        this.name = name;
        this.surname = surname;
        this.groupDto = groupDto;
        this.grade = grade;
    }

    public StudentDto() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public GroupDto getGroupDto() {
        return groupDto;
    }

    public void setGroupDto(GroupDto groupDto) {
        this.groupDto = groupDto;
    }

    public long getGrade() {
        return grade;
    }

    public void setGrade(long grade) {
        this.grade = grade;
    }

    public long getMark() {
        return mark;
    }

    public void setMark(long mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("StudentDto{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append(", groupDto=").append(groupDto);
        sb.append(", grade=").append(grade);
        sb.append(", mark=").append(mark);
        sb.append('}');
        return sb.toString();
    }
}
