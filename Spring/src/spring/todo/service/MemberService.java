package spring.todo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import spring.todo.dao.MemberMapper;
import spring.todo.dto.Member;

@Service
public class MemberService {

	@Autowired
	MemberMapper memberMapper;
	
	public boolean isMemberExist(Member member) {
		
		Member searchedMember = memberMapper.getMember(member.getId());
		
		if(searchedMember==null)
			return false;
		else
			return true;

	}
	
	public boolean isLoginAvailable(Member member) {
		
		Member searchedMember = memberMapper.getMember(member.getId());
		
		if(member.getId().equals(searchedMember.getId())) {
			if(member.getPassword().equals(searchedMember.getPassword()))
				return true;
		}
		
		return false;
	}
}
