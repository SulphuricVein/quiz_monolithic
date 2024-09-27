package com.water.quizapp.models;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Response {
    int id;
    String rightAns;
}
