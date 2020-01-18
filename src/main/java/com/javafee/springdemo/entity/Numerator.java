package com.javafee.springdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "numerator")
public class Numerator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "value")
    private int value;

    @Temporal(TemporalType.DATE)
    @Column(name = "addition_date")
    private Date addition_date;

    @Column(name = "isPalindrome", columnDefinition = "BOOLEAN")
    private boolean isPalindrome;

}
