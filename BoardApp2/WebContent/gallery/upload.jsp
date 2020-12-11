<%@page import="java.io.File"%>
<%@page import="common.file.FileManager"%>
<%@page import="java.io.IOException"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	/*
	클라이언트가 전송한 제목 테스트 및 바이너라리 파일을 서버의 특정 디렉토릴에 저장해부자
	이런처리를 업로드라 함
	*/
	request.setCharacterEncoding("utf-8");//파라미터에 한글개지지 않도록 인코딩 처리
	//String msg=request.getParameter("msg");//String 메세지 받기

	//이미지는 글씨가 아닌 바이너리 파일이믈 ,request.getParameter로 받을 수 없다
	//따라서 IO,네트워크등의 처리를 해야하는데 이 자체만으로도 하나의 개발 프로젝트일 것이다
	//해결책? 누군가가 만든 라이브러리를 이용해서 개발시간을 단축하자
	//현재 우리가 선택한 라이브러리는 cos.jar라는 Oreilly라는 출판사에서 제작한 컴포넌트이다
	String saveDirectory="D:/koreaIT/Workspace/javaEE_workspace/BoardApp2/WebContent/data";//하드디스크의 물리적full 경로를 명시해야 한다.
	int maxSize=2*1024*1024;//2M byte
	String encoding="utf-8";
	//FileRenamePolicy policy : 업로드 시, 동일한 파일을 업로드했을때? 자동으로 이름을 부여한다
	//예)p.jpg,1.jpg(파일명은 개발자가 주도하여 명명하므로,policy를 사용할 필요 x)''
	try{
		MultipartRequest multi=new MultipartRequest(request,saveDirectory,maxSize,encoding);//업로드 발생
		
		//업로드 컴포넌트를 이용할 경우, 스트링 파라미터도 업로드 컴포넌트를 이용해야 한다.
		String msg=multi.getParameter("msg");
		out.print("님이 전송한 메세지는 "+msg);
		
		//업로드가 완료된 후 즉, 서버의 저장소에 파이링 존재하게 된 후 해야할 일
		//파일명을 개발자가 정한 규칙으로 변경해야한다...현재시간의 밀리세컨트까지 구해보자
		long time=System.currentTimeMillis();
		//구한시간에 확장자를 붙임켠 최종적으로 ~~.jpg
		out.print(time);
		
		//내가 업로드한 파일명 알아맞추기(업로드 컴포넌트가 알고있다. api조사)
		String ori=multi.getOriginalFileName("photo");
		out.print("당신이 업로드한 로컬 원래 파일명은"+ori);
		
		String ext=FileManager.getExtend(ori);
		
		String filename=time+"."+ext;
		out.print("내가 조작한 파일명은"+filename);
		
		//조작한 이름으로 파일명을 바꾸어야 함
		//결국 파일을 다루어야 하므로 javaSE의 File 클래스를 이용하면 된다.
		//File 클래스의 .api문서를 찾아서 파일명을 바꾸는 메서드 찾기
		File file=multi.getFile("photo");//원래파일명
		file.renameTo(new File(saveDirectory+"/"+filename));//파일명교체
		
		//클라이언트에게 전송 할 응답정보를 가진 객체
		//클라이언트의 브라우저로 하여금 지정한 URL로 재접속을 시도하게 만듬
		//response.sendRedirect("/gallery/photo_list.jsp");
		out.print("업로드완료");
	}catch(IOException e){
		e.printStackTrace();//콘솔로그에 에러 출력,관리자에게 이메일,sns
		out.print("업로드 용량이 너무 큽니다.");//서블릿 쓰레드 에러..
	}
%>
