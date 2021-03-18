package week16_collectionFramework.collection.treeSet;

public class MemberTreeSetMain {
    public static void main(String[] args) {

        // Set Interface
        MemberTreeSet<Member> memberTreeSet = new MemberTreeSet<>();
        memberTreeSet.addElement(new Member(100, "O")); // TreeSet (BST) 에 추가하려고 하면, 객체 간의 비교가 필요함 - 따라서 Member 에서 Comparable 을 구현해야 함
        memberTreeSet.addElement(new Member(200, "R"));
        memberTreeSet.addElement(new Member(200, "A")); // hashCode 와 equals 메소드를 통해 동일한 객체가 두 번 나왔음을 알 수 있음 - 같은 객체는 hash 에서 반영되지 않음
        memberTreeSet.addElement(new Member(300, "N"));
        memberTreeSet.showIter();
        
        memberTreeSet.removeElement(new Member(200, "R"));
        memberTreeSet.showFor();
    }
}
