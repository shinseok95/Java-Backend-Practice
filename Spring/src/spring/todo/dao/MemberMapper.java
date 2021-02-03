package spring.todo.dao;

import org.apache.ibatis.annotations.Mapper;

import spring.todo.dto.Member;

@Mapper
public interface MemberMapper {
	
	public Member getMember(String id);
	public void addMember(Member member);
	public void deleteMember(Member member);
}
