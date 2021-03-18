package week16_collectionFramework.collection.treeSet;

// import java.util.Comparator;

// Comparable 인터페이스, Comparator 인터페이스 : 정렬 대상이 되는 클래스가 구현해야 하는 인터페이스
public class Member implements Comparable<Member> { // implements Compartor<Member> 일 경우에는 CompareTo() 대신 compare() 메소드를 사용함
    private int id;
    private String name;

    public Member() {}
    public Member(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public String toString() {
        return name + " : " + id;
    }

    @Override
    public int hashCode() {
        return id % 11;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Member) {
            Member member = (Member) obj;
            return (id == member.getId());
        }
        return false;
    }

    @Override
    public int compareTo(Member member) { // 매개 변수와 객체 자신을 비교
        return (id - member.getId());
    }

    /*
    @Override
    public int compare(Member member1, Member member2) { // 두 개의 매개 변수를 비교함
        return (member1.getId() - member2.getId());
    }
    */
}
