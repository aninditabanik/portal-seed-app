package com.portal.seed.portal.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "users", schema = "abanik")
public class Users {

//    @Column(columnDefinition = "createdAt")
//    //@CreatedDate
//    private Date createdAt;

    @Column(columnDefinition = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(generator = "id_generator")
    @SequenceGenerator(
            name = "id_generator",
            sequenceName = "id_sequence",
            initialValue = 1000
    )
    private Long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    public Date getCreatedAt() {
//        return createdAt;
//    }
//
//    public void setCreatedAt(Date createdAt) {
//        this.createdAt = createdAt;
//    }
}