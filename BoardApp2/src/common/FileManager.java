/*
 * 파일과 관련된 유용한 기능을 모아놓는 클래스
 * */
package common;

public class FileManager {
	// 확장자만 추출하기
	public static String getExtend(String path) {
		int lastIndex=path.lastIndexOf(".");
		String ext=path.substring(lastIndex+1,path.length());
		return ext;
	}

	// 미리 단위 테스트 해보기 위함
//	public static void main(String[] args) {
//		// 지난 여름에 놀러갔던 사진.jpg
//		String filename = "d:\\photo\\summer\\2020\\지난.여름에.놀러.갔던.사진.jpg";
//		getExtend(filename);
//	}
}
