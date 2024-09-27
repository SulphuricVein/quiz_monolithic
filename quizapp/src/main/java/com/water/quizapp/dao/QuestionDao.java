package com.water.quizapp.dao;

import com.water.quizapp.models.question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<question,Integer> {
    List<question> findByCategory(String category);
    @Query(value = "Select * from question where category= :category order by random() limit :count",nativeQuery = true)
    List<question> findRandomByCategory(String category, int count);
}
