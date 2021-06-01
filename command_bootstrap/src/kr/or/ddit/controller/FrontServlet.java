package kr.or.ddit.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.internal.ws.resources.HandlerMessages;

import jdk.internal.org.objectweb.asm.Handle;
import kr.or.ddit.handler.Handler;

public class FrontServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
	
	private HandlerMapper handlerMapper;
	
	private void requestPro(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		//사용자 URI검출
		String command = request.getRequestURI(); //contextPath 포함.
		if(command.indexOf(request.getContextPath()) == 0) { // contextPath 삭제
			command = command.substring(request.getContextPath().length());
		}
		
		//commandHandler 실행(HandlerMapper 의뢰 handler 할당)
		Handler handler = null;
		String view = null;
		
		if(handlerMapper != null) {
			handler = handlerMapper.getHandler(command);
			if(handler != null) { //올바른 요청
				try {
					view = handler.process(request, response);
					
					if(view != null) ViewResolver.view(request, response, view);
				} catch (Exception e) {
					response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
				}
			}else {
			response.sendError(HttpServletResponse.SC_BAD_REQUEST);
			}
		} else {
			response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
		}
	} 
}
