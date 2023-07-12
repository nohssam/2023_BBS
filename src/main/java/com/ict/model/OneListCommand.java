package com.ict.model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ict.db.BVO;
import com.ict.db.DAO;

public class OneListCommand implements Command{
	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		String b_idx = request.getParameter("b_idx");
		
		// 조회수 업데이트 
		int result = DAO.getHit(b_idx);
		
		// 상세보기 가져오기 
		BVO bvo = DAO.getOneList(b_idx);
		
		// 나중에 해당 원글에 대한 댓글도 가져와야 된다.
		
		
		request.setAttribute("bvo", bvo);
		return "view/onelist.jsp";
	}
}
