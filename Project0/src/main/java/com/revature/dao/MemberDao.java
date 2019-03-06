package com.revature.dao;

import java.util.List;

import com.revature.bank.Member;

public interface MemberDao {
	
	// the methods to be used to retrieve the data from the database
	public List<Member> getAllMembers();
	public Member getMemberByAccountNumber(String accountNumber);
	public Member getMemberByUsername(String username);
	public int addNewMember(Member m);
	public int updateMemberInfo(Member m);
	public int deleteMember(String accountNumber);
	
	
	
}
