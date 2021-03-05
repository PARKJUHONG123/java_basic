package week14_generic.BoundedGeneric;

public class Plastic extends Material implements Ingredient {
	public String toString() {
		return "재료는 Plastic 입니다";
	}

	@Override
	public void doPrinting() {
		System.out.println("Plastic 으로 프린트합니다");
	}
	
	public boolean isLeft() {
		return false;
	}
}
