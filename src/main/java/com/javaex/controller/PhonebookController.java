package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.PhonebookService;
import com.javaex.vo.PhonebookVO;

@Controller
public class PhonebookController {
		
	//필드
	@Autowired
	private PhonebookService phonebookService;
	
	//메소드일반
	
	//리스트 출력
	@RequestMapping(value="/list", method = {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("/list");
		
		List<PhonebookVO> pList = phonebookService.exeGetPhonebookList();
		
		model.addAttribute("pList", pList);
		
		System.out.println(pList);
		
		return "list";
	}
	
	//등록폼으로 이동
	@RequestMapping(value="/wform", method = {RequestMethod.GET, RequestMethod.POST})
	public String wform() {
		
		System.out.println("/wform");
		
		return "writeform";
	}
	
	//등록
	@RequestMapping(value="/write", method = {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PhonebookVO phonebookVO) {
		System.out.println("/write");
		
		phonebookService.exePhonebookWrite(phonebookVO);
		
		System.out.println(phonebookVO);
		
		return "redirect:/list";
	}
	
	//수정폼으로 이동
	@RequestMapping(value="/mform", method = {RequestMethod.GET, RequestMethod.POST})
	public String mform(@RequestParam(value = "personId") int personId, Model model) {
		
		System.out.println("/mform");
		
		PhonebookVO phonebookVO = phonebookService.exePhonebookModifiform(personId);
		System.out.println(phonebookVO);
		model.addAttribute("pVO",phonebookVO);
		
		
		return "modifyform";
	}
	
	//수정
	@RequestMapping(value="/modify", method = {RequestMethod.GET, RequestMethod.POST})
	public String modify(@ModelAttribute PhonebookVO phonebookVO) {
		
		System.out.println("/modify");
		
		phonebookService.exePhonebookModify(phonebookVO);
		
		System.out.println(phonebookVO);
		
		return "redirect:/list";
	}
	
	//삭제
	@RequestMapping(value="/remove", method = {RequestMethod.GET, RequestMethod.POST})
	public String remove(@RequestParam(value = "personId") int personId) {
		System.out.println("/remove");
		
		phonebookService.exePhonebookRemove(personId);
		
		return"redirect:/list";
		
	}

}
