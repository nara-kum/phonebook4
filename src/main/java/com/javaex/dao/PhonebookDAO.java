package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.PhonebookVO;

@Repository
public class PhonebookDAO {

	@Autowired
	private SqlSession sqlSession;

	// 전체리스트 가져오기
	public List<PhonebookVO> personSelect() {
		System.out.println("sqlselect");

		List<PhonebookVO> phonebookList = sqlSession.selectList("phonebook.selectList");

		return phonebookList;

	}

	// 1명 정보 가져오기
	public PhonebookVO personSelectOne(PhonebookVO phonebookVO) {
		System.out.println("sqlselectOne");
		
		phonebookVO = sqlSession.selectOne("phonebook.selectOne", phonebookVO);
		
		return phonebookVO;

	}

	// 사람(주소) 등록
	public int personInsert(PhonebookVO phonebookVO) {
		System.out.println("sqlInsert()");
		
		int count = sqlSession.insert("phonebook.insert",phonebookVO);
		
		return count;
	}

	// 사람(주소) 수정
	public int personUpdate(PhonebookVO phonebookVO) {
		System.out.println("sqlUpdate()");
		
		int count = sqlSession.insert("phonebook.update",phonebookVO);
		
		return count;
	}

	// 사람(주소) 삭제
	public int personDelete(PhonebookVO phonebookVO) {
		System.out.println("sqlDelete");

		int count = sqlSession.insert("phonebook.delete",phonebookVO);
				
		return count;
	}

}