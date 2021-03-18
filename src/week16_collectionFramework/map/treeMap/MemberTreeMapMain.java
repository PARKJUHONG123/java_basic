package week16_collectionFramework.map.treeMap;

public class MemberTreeMapMain {
    public static void main(String[] args) {

        // Set Interface
        MemberTreeMap memberTreeMap = new MemberTreeMap();
        memberTreeMap.addElement(new Member(100, "O"));
        memberTreeMap.addElement(new Member(200, "R"));
        memberTreeMap.showIter();
        memberTreeMap.addElement(new Member(200, "A")); // TreeMap 내부 구현된 hashCode 와 equals 메소드를 통해 동일한 객체가 두 번 나왔음을 알 수 있음 - 정보를 바꿈
        memberTreeMap.showIter();
        memberTreeMap.addElement(new Member(300, "N"));
        memberTreeMap.showIter();
        
        memberTreeMap.removeElement(new Member(200, "R").getId());
        memberTreeMap.showIter();
    }
}
