<%@page import="board.model.ImageBoard"%>
<%@page import="board.model.ImageBoardDAO"%>
<%@page import="common.file.FileManager"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.List"%>
<%@page import="java.io.File"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/inc/lib.jsp" %>
<%!
	String saveDir="D:/koreaIT/Workspace/javaEE_workspace/BoardApp2/WebContent/data";
	int maxSize=3*1024*1024;//3M
%>
<%
	//실습했던 예제보자 기능이 추가됨, db에 넣어야함 DAO이용
	ImageBoardDAO dao=new ImageBoardDAO();
	//업로드컴포넌트에 대한 설정을 하기 위해 FileItemFactory객체를 이용해야 한다.
	DiskFileItemFactory itemFactory=new DiskFileItemFactory();
	itemFactory.setRepository(new File(saveDir));	
	itemFactory.setSizeThreshold(maxSize);
	itemFactory.setDefaultCharset("utf-8");
	
	ServletFileUpload upload=new ServletFileUpload(itemFactory);
	request.setCharacterEncoding("utf-8");
	List<FileItem> items=upload.parseRequest(request);//업로드된 정보 분석. 각각의 컴포넌트들을 FileItem단위로 쪼갠다
	
	ImageBoard board=new ImageBoard();//empty상태의 VO
	for(FileItem item:items){
		if(item.isFormField()){//textfield라면 db
			//vo에 텍스트필드들의 값을 담자
			if(item.getFieldName().equals("author")){//필드명이 author라면
				board.setAuthor(item.getString());	
			}else if(item.getFieldName().equals("title")){
				board.setTitle(item.getString());	
			}else if(item.getFieldName().equals("content")){
				board.setContent(item.getString());
			}
		}else{//textfield가 아니라면 업로드
			String newName=System.currentTimeMillis()+"."+FileManager.getExtend(item.getName());
			String destFile=saveDir+"/"+newName;
			File file=new File(destFile);
			item.write(file);//물리적 저장 시점
			
			out.print("업로드 완료");			
			board.setFilename(newName);//vo에 파일명 담기
		}
	}
	//반복문을 지나친 이 시점에는 VO에 데이터가 이미 채워진 상태 일것이다.
	int result=dao.insert(board);//이 시점에느 채워진 VO를 원함
	if(result==0){
		out.print(getMsgBack("등록실패"));
	}else{
		out.print(getMsgURL("등록성공", "/imageboard/list.jsp"));
	}
%>
