package week15_lambda.innerClass;

public class InnerTest {
    public static void main (String[] args) {
        // [Instance Inner Class]
        OutClass outClass = new OutClass();
        outClass.useInTest();
        OutClass.InClass outInClass = outClass.new InClass(); 
        outInClass.inTest();

        // [Static Inner Class]        
        OutClass.InStaticClass sOutInClass = new OutClass.InStaticClass();
        sOutInClass.inTest();
        OutClass.InStaticClass.sInTest();

        // [Local Inner Class]
        Runnable runnable = outClass.getRunnable(50);
        runnable.run(); // 언제든지 호출할 수 있음

        // [Anonymous Inner Class]
        Runnable anonymousRunnable = outClass.getAnonymousRunnable(50);
        anonymousRunnable.run(); 
    }
}

class OutClass {
    private int outNum = 10;
    private static int sOutNum = 20;
    private InClass inClass;

    public OutClass() {
        System.out.println("[Out Class]");
        inClass = new InClass();
    }

    // [Instance Inner Class]
    class InClass { // Instance Inner Class (인스턴스 내부 클래스)
        // Outer 클래스가 생성되어야지 InClass 를 생성할 수 있음
        int iInNum = 100;
        // static int sInNum = 200; // static class 가 아니므로 사용할 수 없음

        public InClass() {
            System.out.println("[Instance Inner Class]");
        }

        void inTest() {
            System.out.println(outNum + " " + iInNum + " " + sOutNum);
        }
    }

    public void useInTest() {
        inClass.inTest();
    }

    
    // [Static Inner Class]
    static class InStaticClass { // Static Inner Class (정적 내부 클래스)
        // Outer 클래스가 만들어지지 않아도 사용할 수 있음
        int iInNum = 100;
        static int sInNum = 200;

        public InStaticClass() {
            System.out.println("[Static Inner Class]");   
        }

        void inTest() {
            System.out.println(iInNum + " " + sOutNum + " " + sInNum);            
        }

        static void sInTest() {
            System.out.println(sInNum + " " + sOutNum);
        }
    }

    
    // [Local Inner Class]
    Runnable getRunnable(int i) { // Runnable 한 객체를 반환하는 메소드
        int lNum = 100; // 지역 변수 (메소드 내에서 선언되었음)

        class InRunnable implements Runnable {  // Local Inner Class (지역 내부 클래스)
            public InRunnable() {
                System.out.println("[Local Inner Class]");   
            }
    
            @Override
            public void run() {                
                // 메소드가 호출되서 끝날 때까지 지역변수와 매개변수는 유효함
                // inRunnable 객체가 반환하게 되면 (= getRunnable 메소드가 끝나게 되면), run() 메소드를 언제든지 호출할 수 있게 됨
                // 그럼 getRunnable 의 지역변수와 매개변수가 유효하지 않은 상태에서 run() 메소드를 통해 지역변수와 매개변수를 변경하게 되면 에러가 발생하게 됨
                // 따라서 지역변수와 매개변수는 final 즉 참조는 할 수 있지만 변경할 수 없는 상수가 되어야 함

                // lNum += 10; // 지역변수 (final) 이기 때문에 변경 불가
                // i = 200; // 매개변수 (final) 이기 때문에 변경 불가

                System.out.println(lNum + " " + outNum + " " + OutClass.sOutNum);
            }
        }
        return new InRunnable();
    }


    // [Anonymous Inner Class]
    Runnable getAnonymousRunnable(int i) { // Runnable 한 객체를 반환하는 메소드
        int lNum = 100; // 지역 변수 (메소드 내에서 선언되었음)
        System.out.println("[Anonymous Inner Class]");   

        return new Runnable(){ // 위의 Local Inner Class 내부의 InRunnable 클래스는 내부에서 밖에 쓰이지 않으므로 필요하지 않음
            // 이름을 생략한 익명 내부 클래스

            @Override
            public void run() {
                System.out.println(lNum + " " + outNum + " " + OutClass.sOutNum);
            }
        };
    }

}