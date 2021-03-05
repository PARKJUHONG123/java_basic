package week14_generic.BoundedGeneric;

public class GenericPrinterTest {
	public static void main(String[] args) {
		GenericPrinter<Powder> powderPrinter = new GenericPrinter<Powder>();		
		Powder powder = new Powder();
		powderPrinter.setMaterial(powder);
		System.out.println(powderPrinter);
		powderPrinter.printing();

		GenericPrinter<Plastic> plasticPrinter = new GenericPrinter<Plastic>();		
		Plastic plastic = new Plastic();
		plasticPrinter.setMaterial(plastic);
		System.out.println(plasticPrinter);

		plasticPrinter.printing();
		
		// Raw Type
		// 제네릭 타입에서 타입 매개변수를 전혀 사용하지 않았을 때를 의미함
		// 아예 제네릭 자료형을 선언하지 않고도 사용할 수도 있음 (꿘장되지 않음)
		// T 값에는 Object 클래스가 들어감
		GenericPrinter rawTypePrinter = new GenericPrinter(); 
		
	}
}
