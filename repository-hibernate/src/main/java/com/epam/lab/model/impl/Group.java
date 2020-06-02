package com.epam.lab.model.impl;

import com.epam.lab.model.AbstractEntity;
import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "`group`")
public class Group extends AbstractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "group_number")
    private String groupNumber;

    @OneToMany(mappedBy="group")
    Set<Student> students;

    public Group(long id, String groupNumber) {
        this.id = id;
        this.groupNumber = groupNumber;
    }

    public Group(String groupNumber) {
        this.groupNumber = groupNumber;
    }

    public Group() {}

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

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return id == group.id &&
                Objects.equals(groupNumber, group.groupNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, groupNumber);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Group{");
        sb.append("id=").append(id);
        sb.append(", groupNumber='").append(groupNumber).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
