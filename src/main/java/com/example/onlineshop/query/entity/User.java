package com.example.onlineshop.query.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Id;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class User{


    @Id
    private String phoneNumber;

    @GeneratedValue
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String userCode;

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private Date created;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updated;

    @Column(name = "delete_date")
    private Long deleteDate = 0L;

}
