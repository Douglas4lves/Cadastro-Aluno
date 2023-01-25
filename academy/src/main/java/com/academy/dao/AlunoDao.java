package com.academy.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.academy.model.Aluno;

@Repository
public interface AlunoDao extends JpaRepository<Aluno, Integer> {

}
