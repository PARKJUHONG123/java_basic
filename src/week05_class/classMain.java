package week05_class;

/*
접근할 수 없는 클래스 (접근제어자)
- public : 없음 (class)
- protected : 자식 클래스가 아닌 다른 패키지에 소속된 클래스
- default : 다른 패키지에 소속된 클래스 (class)
- private : 모든 외부 클래스
 */


public class classMain {

    public static void main(String[] args) {
//        singletoneClass stc = new singletoneClass();
        singletonClass stc = singletonClass.getInstance();

        staticClass sc1 = new staticClass();
        staticClass sc2 = new staticClass();
        staticClass.globalPlus();
        sc1.countPrint();
        sc1.countPlus();
        sc1.countPrint();
        sc2.countPlus();
        sc1.countPrint();
    }

}

class singletonClass {
    private static singletonClass singleton = new singletonClass();
    private singletonClass() { }
    static singletonClass getInstance() {
        return singleton;
    }
}

class staticClass {
    static int count = 0;
    void countPlus() {
        count += 1;
    }
    static void globalPlus() {
        count += 1;
    }
    void countPrint() {
        System.out.println(count);
    }
}

