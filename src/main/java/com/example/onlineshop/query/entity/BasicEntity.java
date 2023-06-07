package com.example.onlineshop.query.entity;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Id;
import java.io.Serializable;
import java.util.Date;

@Data
@EqualsAndHashCode(of = "id", doNotUseGetters = true)
@MappedSuperclass
public class BasicEntity implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "uuid2")
    private String id;

    @Column(updatable = false, nullable = false)
    @CreatedDate
    private Date created;

    @Column(nullable = false)
    @LastModifiedDate
    private Date updated;

    @Column(name = "delete_date")
    private Long deleteDate = 0L;
}
