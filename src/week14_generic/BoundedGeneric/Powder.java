package week14_generic.BoundedGeneric;

public class Powder extends Material implements Ingredient {
	public String toString() {
		return "재료는 Powder 입니다";
	}

	@Override
	public void doPrinting() {
		System.out.println("Powder 로 프린트합니다");		
	}
	
	public boolean isLeft() {
		return true;
	}
}
