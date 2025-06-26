package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PhonebookDAO;
import com.javaex.vo.PhonebookVO;

@Service
public class PhonebookService {

	// 필드
	@Autowired
	private PhonebookDAO phonebookDAO;
	
	// 전체 리스트 가져오기
	public List<PhonebookVO> exeGetPhonebookList() {

		List<PhonebookVO> phonebookVO = phonebookDAO.personSelect();

		return phonebookVO;

	}

	// 전화번호 등록
	public int exePhonebookWrite(PhonebookVO phonebookVO) {

		int count = phonebookDAO.personInsert(phonebookVO);

		return count;
	}
	
	//전화번호 수정폼
	public PhonebookVO exePhonebookModifiform(int personId) {
		
		PhonebookVO phonebookVO = phonebookDAO.personSelectOne(personId);
		
		return phonebookVO;
		
	}
	
	//전화번호 수정
	public int exePhonebookModify(PhonebookVO phonebookVO) {

		int count = phonebookDAO.personUpdate(phonebookVO);
		
		return count;
	}

	//전화번호 삭제
	public int exePhonebookRemove(int personId) {

		int count = phonebookDAO.personDelete(personId);
		
		return count;
	}
}
