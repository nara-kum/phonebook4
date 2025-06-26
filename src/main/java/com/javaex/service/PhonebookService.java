package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
		System.out.println("PhonebookService.exeGetPhonebookList()");

		List<PhonebookVO> phonebookVO = phonebookDAO.personSelect();

		return phonebookVO;

	}

	// 전화번호 등록
	public int exePhonebookWrite(PhonebookVO phonebookVO) {
		System.out.println("PhonebookService.exePhonebookWrite()");

		//int count = phonebookDAO.personInsert(phonebookVO);
		
		/*가정: 데이터가 여기서 새로 생겨서 묶어서 db로 보내야함
		1. VO를 만들고 묶으면 된다.
		2. map으로 묶는다.
		*/
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("name", "김나라");
		pMap.put("hp", "0105555");
		pMap.put("company", "5555-");
		
		int count = phonebookDAO.personInsert2(pMap);
		
		return count;
	}
	
	//한명 데이터 가져오기
	public PhonebookVO exePhonebookModifyform(int personId) {
		System.out.println("PhonebookService.exePhonebookModifyform()");
		
		PhonebookVO phonebookVO = phonebookDAO.personSelectOne(personId);
		
		return phonebookVO;
		
	}
	
	//전화번호 수정
	public int exePhonebookModify(PhonebookVO phonebookVO) {
		System.out.println("PhonebookService.exePhonebookModify()");

		int count = phonebookDAO.personUpdate(phonebookVO);
		
		return count;
	}

	//전화번호 삭제
	public int exePhonebookRemove(int personId) {
		System.out.println("PhonebookService.exePhonebookRemove()");

		int count = phonebookDAO.personDelete(personId);
		
		return count;
	}
}
