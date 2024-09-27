package com.water.quizapp.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class quiz {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    int id;
    String title;
    @ManyToMany
     List<question> ques;

}
