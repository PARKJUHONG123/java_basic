package week16_collectionFramework.collection.treeSet;

import java.util.TreeSet;
import java.util.Iterator;

public class MemberTreeSet<T> {
    TreeSet<T> treeset;
    public MemberTreeSet() {
        treeset = new TreeSet<T>();
        // treeset = new TreeSet<T>(new T()); // Member가 Comparator를 implements 할 경우에는 이와 같이 TreeSet 생성자에 Comparator 가 구현된 객체를 매개변수로 전달
    }

    public void addElement(T t) {
        treeset.add(t);
    }

    public boolean removeElement(T target) {
        Iterator<T> hashsetIt = treeset.iterator();
        while(hashsetIt.hasNext()) {
            T t = hashsetIt.next();
            if (((Member) t).getId() == ((Member) target).getId()) {
                treeset.remove(t);
                return true;
            }
        }
        System.out.println("존재하지 않습니다.");
        return false;
    }

    public void showIter() {
        Iterator<T> hashsetIt = treeset.iterator();
        while (hashsetIt.hasNext()) {
            T t = hashsetIt.next();
            System.out.println(t);
        }    
        System.out.println();
    }

    public void showFor() {
        for (T t : treeset) {
            System.out.println(t);
        }
        System.out.println();
    }
}
