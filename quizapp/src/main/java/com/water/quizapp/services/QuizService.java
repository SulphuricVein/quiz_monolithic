package com.water.quizapp.services;
import com.water.quizapp.dao.QuestionDao;
import com.water.quizapp.models.Response;
import com.water.quizapp.models.quizDTO;
import com.water.quizapp.dao.quizDao;
import com.water.quizapp.models.question;
import com.water.quizapp.models.quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class QuizService {
    @Autowired
    quizDao qd;

    @Autowired
    QuestionDao questionDao;


    public ResponseEntity<String> setup(String category, int count, String title) {
        List<question>list=questionDao.findRandomByCategory(category,count);
        quiz q=new quiz();
        q.setTitle(title);
        q.setQues(list);
        qd.save(q);
        return new ResponseEntity<>("Created",HttpStatus.CREATED);
    }

    public List<quizDTO> getQuiz(int id) {
        Optional<quiz> org = qd.findById(id);
        List<question> quesDB = org.get().getQues();
        List<quizDTO> quizDTOs = quesDB.stream()
                .map(q -> new quizDTO(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4()))
                .collect(Collectors.toList());
        return quizDTOs;
    }

    public ResponseEntity<Integer> calc(Integer id, List<Response> res) {
        quiz q=qd.findById(id).get();
        List<question> ans=q.getQues();
        int i=0;
        int right=0;
        for(Response r:res){
            if(r.getRightAns().equals(ans.get(i).getRightAnswer())){
                right++;
            }
            i++;
        }
    return new ResponseEntity<>(right,HttpStatus.ACCEPTED);
    }
}
