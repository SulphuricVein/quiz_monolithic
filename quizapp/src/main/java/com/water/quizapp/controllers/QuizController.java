package com.water.quizapp.controllers;


import com.water.quizapp.models.Response;
import com.water.quizapp.models.quizDTO;
import com.water.quizapp.services.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {
    @Autowired
    QuizService quizService;
    @GetMapping("category/{category}/{count}/{title}")
    public ResponseEntity<String> setup(@PathVariable String category, @PathVariable int count, @PathVariable String title){
        return quizService.setup(category,count,title);
    }
    @GetMapping("{id}")
    public ResponseEntity<List<quizDTO>> getQuiz(@PathVariable int id){
        return new ResponseEntity<>(quizService.getQuiz(id), HttpStatus.ACCEPTED);
    }
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> getResponse(@PathVariable Integer id, @RequestBody List<Response> res){
        return quizService.calc(id,res);
    }
}
