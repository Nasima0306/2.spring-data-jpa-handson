package com.example.orm_learn.repository;

import com.example.orm_learn.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository
        extends JpaRepository<Skill, Integer> {
}