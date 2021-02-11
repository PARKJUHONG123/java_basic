package week05_class;

public class classClass {

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