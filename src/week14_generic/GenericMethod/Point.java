package week14_generic.GenericMethod;

// 자료형 매개 변수가 2개 이상일 때
public class Point <T, V> {
	T x;
	V y;
	
	Point(T x, V y) {
		this.x = x;
		this.y = y;
	}
	
	public T getX() { // 제네릭 메소드
		return x;
	}
	
	public V getY() { // 제네릭 메소드
		return y;
	}
}
