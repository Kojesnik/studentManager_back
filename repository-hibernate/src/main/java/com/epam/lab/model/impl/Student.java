package com.epam.lab.model.impl;

import com.epam.lab.model.AbstractEntity;
import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "student")
@SecondaryTable(name = "student_grade", pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id"))
@SecondaryTable(name = "student_mark",  pkJoinColumns = @PrimaryKeyJoinColumn(name = "student_id", referencedColumnName = "id"))
public class Student extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @ManyToOne
    @JoinTable(name="student_group",
            joinColumns = @JoinColumn(name = "student_id",
                    referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "group_id",
                    referencedColumnName = "id"))
    private Group group;

    @Column(table = "student_mark")
    private Long mark;

    @Column(table = "student_grade")
    private Long grade;

    public Student(long id, String name, String surname) {
        this.id = id;
        this.name = name;
        this.surname = surname;
    }

    public Student(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Student() {}

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getMark() {
        return mark;
    }

    public void setMark(Long mark) {
        this.mark = mark;
    }

    public Long getGrade() {
        return grade;
    }

    public void setGrade(Long grade) {
        this.grade = grade;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return id == student.id &&
                Objects.equals(name, student.name) &&
                Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", surname='").append(surname).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
