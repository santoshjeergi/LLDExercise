package com.example.splitwise.demo.models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Data
@MappedSuperclass
@EntityListeners(value =  AuditingEntityListener.class)
public class BaseModel {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @CreatedDate
            @Temporal(TemporalType.DATE)  //????
    Date objCreated;


    @LastModifiedDate
            @Temporal(TemporalType.DATE)
    Date objLastModified;
}
