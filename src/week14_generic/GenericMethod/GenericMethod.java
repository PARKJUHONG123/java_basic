package week14_generic.GenericMethod;

public class GenericMethod {
	// 제네릭 메소드의 경우, 일반 클래스에서도 사용 가능함
	// 메소드의 매개 변수를 자료형 매개 변수로 사용하는 메소드	
	public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) { // 제네릭 메소드
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		return (right - left) * (bottom - top);
	}
 }

class Shape<T> {
	// 메소드 내에서의 자료형 매개 변수는 메소드 내에서만 유효함
	// 지역변수와 같은 개념
	// Shape의 T와 makeRectangle 의 T는 전혀 다른 의미
	public static <T, V> double makeRectangle(Point<T, V> p1, Point<T, V> p2) { // makeRectangle 의 T, V 는 Point 의 T, V 를 위해 존재
		double left = ((Number)p1.getX()).doubleValue();
		double right = ((Number)p2.getX()).doubleValue();
		double top = ((Number)p1.getY()).doubleValue();
		double bottom = ((Number)p2.getY()).doubleValue();
		
		return (right - left) * (bottom - top);
	}
	
	private T name; // Shape의 T 와 관련있음 (makeRectangle의 T 와는 관련이 없음)
	public void setName(T name) {
		this.name = name;
	}

	public T getName() {
		return name;
	}	
}
