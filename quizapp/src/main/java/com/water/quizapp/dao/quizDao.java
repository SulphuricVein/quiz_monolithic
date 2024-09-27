package com.water.quizapp.dao;

import com.water.quizapp.models.quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

public interface quizDao extends JpaRepository<quiz,Integer> {
}
