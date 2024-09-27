package com.water.quizapp.controllers;


import com.water.quizapp.models.question;
import com.water.quizapp.services.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("question")
public class QuestionController {
@Autowired
    QuestionService questionService;
    @GetMapping("allQuestions")
    public ResponseEntity<List<question>>  getAllQuestions(){
        return questionService.getAllQuestions();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<question>>  getCategory(@PathVariable String category){
        return questionService.getCat(category);
    }

    @PostMapping("add")
    public ResponseEntity<String> add(@RequestBody question q){
        return questionService.add(q);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id){
        return questionService.delete(id);
    }
}
