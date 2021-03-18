package week16_collectionFramework.collection.hashSet;

public class MemberHashSetMain {
    public static void main(String[] args) {

        // Set Interface
        MemberHashSet<Member> memeberHashSet = new MemberHashSet<>();
        memeberHashSet.addElement(new Member(100, "O"));
        memeberHashSet.addElement(new Member(200, "R"));
        memeberHashSet.addElement(new Member(200, "A")); // hashCode 와 equals 메소드를 통해 동일한 객체가 두 번 나왔음을 알 수 있음 - 같은 객체는 hash 에서 반영되지 않음
        memeberHashSet.addElement(new Member(300, "N"));
        memeberHashSet.showIter();
        
        memeberHashSet.removeElement(new Member(200, "R"));
        memeberHashSet.showFor();
    }
}
