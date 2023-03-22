package com.example.company.model;
import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
public class SensitiveData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float salary;
    private String position;
    private int experience;
}

