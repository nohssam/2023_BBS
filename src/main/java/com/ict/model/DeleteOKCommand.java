package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.DAO;

public class DeleteOKCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
		String cPage = request.getParameter("cPage");
		
		// 방법1. 원글에 속한 댓글 모두 삭제
		int res = DAO.getCommentDeleteAll(b_idx);
		
		// 방법2. error 페이지로 이동 (퀴즈)
		
		
		// 방법3. 삭제된 게시글입니다로 변경 시키는 것 ( 컬럼추가 )
		
		// 원글 삭제 
		int result = DAO.getDelete(b_idx);
		return "MyController?cmd=list&cPage="+cPage;
	}
}
