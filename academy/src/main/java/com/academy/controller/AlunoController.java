package com.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.academy.dao.AlunoDao;
import com.academy.model.Aluno;

import jakarta.validation.Valid;
//import jakarta.validation.constraints.AssertFalse.List;

@Controller
public class AlunoController {

	@Autowired
	private AlunoDao alunoRepository;
	
	@GetMapping("/inserirAlunos")
	public ModelAndView InsertAlunos(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/formAluno");
		mv.addObject("aluno",new Aluno());
		return mv;
	}
	
	@PostMapping("insertAlunos")
	public ModelAndView inserirAluno(@Valid Aluno aluno, BindingResult br) {
		ModelAndView mv = new ModelAndView();
		if(br.hasErrors() ) {
			mv.setViewName("Aluno/formAluno");
			mv.addObject("aluno", aluno);
			
		}else {					
			mv.setViewName("redirect:/alunos-adicionados");
			alunoRepository.save(aluno);
			
		}
		return mv;
	}
	
	@GetMapping("alunos-adicionados")
	public ModelAndView listagemAlunos() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/listAlunos");
		mv.addObject("alunosList", alunoRepository.findAll());
		return mv;
	}
	
	@GetMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("Aluno/alterar");
		Aluno aluno = alunoRepository.getOne(id);
		mv.addObject("aluno", aluno);
		
		return mv;
	}
	
	@PostMapping("/alterar")
	public ModelAndView alterar(Aluno aluno) {
		ModelAndView mv = new ModelAndView();
		alunoRepository.save(aluno);
		mv.setViewName("redirect:/alunos-adicionados");
		return mv;
	}
	
	
	@GetMapping("/excluir/{id}")
	public String excluirAluno(@PathVariable("id") Integer id) {
		alunoRepository.deleteById(id);
		return "redirect:/alunos-adicionados";
	}
	
	
	
	
	
	
	
}
