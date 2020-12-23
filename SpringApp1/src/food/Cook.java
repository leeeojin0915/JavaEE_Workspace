/*요리사 정의 */
package food;

public class Cook {
	//상위 자료형으로 has a 관계를 명시했을때 얻는 장점?
	//하위 자료형이 삭제되거나 변화가 생기더라도 현재클래스와 has a 관계에 있는 클래스 간의 의존성을 약화시켰기 때문에
	//유지보수성이 좋아진다.
	private Pan pan;//정확한 지료형으로 has a 관계를 표시하기 있기 없기?>
	
	//외부로부터 필요한 객체를 주입받기 위한 setter메서드
	public void setPan(Pan pan) {
		this.pan = pan;
	}
	
	public void makFood() {
		pan.boil();
	}
}
