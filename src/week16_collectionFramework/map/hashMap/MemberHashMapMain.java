package week16_collectionFramework.map.hashMap;

public class MemberHashMapMain {
    public static void main(String[] args) {

        // Set Interface
        MemberHashMap memberHashMap = new MemberHashMap();
        memberHashMap.addElement(new Member(100, "O"));
        memberHashMap.addElement(new Member(200, "R"));
        memberHashMap.showIter();
        memberHashMap.addElement(new Member(200, "A")); // HashMap 내부 구현된 hashCode 와 equals 메소드를 통해 동일한 객체가 두 번 나왔음을 알 수 있음 - 정보를 바꿈
        memberHashMap.showIter();
        memberHashMap.addElement(new Member(300, "N"));
        memberHashMap.showIter();
        
        memberHashMap.removeElement(new Member(200, "R").getId());
        memberHashMap.showIter();
    }
}
