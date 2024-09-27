package com.water.quizapp.services;

import com.water.quizapp.dao.QuestionDao;
import com.water.quizapp.models.question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {
    @Autowired
    QuestionDao qd;
    public ResponseEntity<List<question>> getAllQuestions() {
        try{
            return new ResponseEntity<>(qd.findAll(), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<List<question>> getCat(String category) {
        try{
            return new ResponseEntity<>(qd.findByCategory(category), HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        }

    }

    public ResponseEntity<String> add(question q) {
        try{
            qd.save(q);
            return new ResponseEntity<>("Created",HttpStatus.CREATED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
        }
    }

    public ResponseEntity<String> delete(int id) {

        try{
            qd.deleteById(id);
            return new ResponseEntity<>("Deleted",HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("Failure",HttpStatus.BAD_REQUEST);
        }
    }

}
