package week14_generic.BoundedGeneric;

// 바운디드 제네릭 (Bounded Generic) [T extends 클래스]
// 1. T 대신에 사용될 자료형을 제한하기 위해 사용 (= Material 클래스를 상속받은 자료형들만 사용 가능함)
// 2. 아래 예시에서는  Material 클래스에 정의된 메소드를 공유할 수 있음

// 다중 바운드 (Multiple Bounds)
// 1. 인터페이스를 extends 구문 뒤에 추가해서 사용할 수 있음
// 2. 단 자료형 또한 해당 인터페이스를 implements 해야 함 (또는 Material 에 해당 인터페이스를 추가함 = 의미 없음)

public class GenericPrinter<T extends Material & Ingredient> {
	private T material; 
	
	public T getMatrial() {
		return material;
	}
	
	public void setMaterial(T material) {
		this.material = material;
	}
	
	public String toString() {
		return material.toString();
	}
	
	private void working() {
		material.doPrinting();
	}
	
	private void notWorking() {
		System.out.println("재료가 부족합니다");
	}
	
	public void printing() {
		if (material.isLeft()) {
			working();
		}
		else {
			notWorking();
		}
	}
}
