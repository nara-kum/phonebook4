package com.javaex.dao;

import java.util.List;
import java.util.Map;

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
	public PhonebookVO personSelectOne(int personId) {
		System.out.println("sqlselectOne");
		
		PhonebookVO phonebookVO = sqlSession.selectOne("phonebook.selectOne", personId);
		
		Map<String, Object> map = sqlSession.selectOne("phonebook.selectOne2", personId);
		
		System.out.println(map);
		
		return phonebookVO;

	}

	// 사람(주소) 등록
	public int personInsert(PhonebookVO phonebookVO) {
		System.out.println("sqlInsert()");
		
		int count = sqlSession.insert("phonebook.insert",phonebookVO);
		
		return count;
	}
	
	// 사람(주소) 등록 Map
		public int personInsert2(Map<String, String> personMap) {
			System.out.println("sqlInsert2 Map()");
			System.out.println(personMap);
			

			int count = sqlSession.insert("phonebook.insert2",personMap);
			
			return 0;
		}

	// 사람(주소) 수정
	public int personUpdate(PhonebookVO phonebookVO) {
		System.out.println("sqlUpdate()");
		
		int count = sqlSession.insert("phonebook.update",phonebookVO);
		
		return count;
	}

	// 사람(주소) 삭제
	public int personDelete(int personId) {
		System.out.println("sqlDelete");

		int count = sqlSession.insert("phonebook.delete",personId);
				
		return count;
	}

}