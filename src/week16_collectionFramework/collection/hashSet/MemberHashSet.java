package week16_collectionFramework.collection.hashSet;

import java.util.HashSet;
import java.util.Iterator;

public class MemberHashSet<T> {
    HashSet<T> hashset;
    public MemberHashSet() {
        hashset = new HashSet<T>();
    }

    public void addElement(T t) {
        hashset.add(t);
    }

    public boolean removeElement(T target) {
        Iterator<T> hashsetIt = hashset.iterator();
        while(hashsetIt.hasNext()) {
            T t = hashsetIt.next();
            if (((Member) t).getId() == ((Member) target).getId()) {
                hashset.remove(t);
                return true;
            }
        }
        System.out.println("존재하지 않습니다.");
        return false;
    }

    public void showIter() {
        Iterator<T> hashsetIt = hashset.iterator();
        while (hashsetIt.hasNext()) {
            T t = hashsetIt.next();
            System.out.println(t);
        }    
        System.out.println();
    }

    public void showFor() {
        for (T t : hashset) {
            System.out.println(t);
        }
        System.out.println();
    }
}
