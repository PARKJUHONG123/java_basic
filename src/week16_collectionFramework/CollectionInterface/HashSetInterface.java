package week16_collectionFramework.CollectionInterface;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetInterface<T> {
    HashSet<T> hashset;
    public HashSetInterface() {
        hashset = new HashSet<>();
    }

    public void addElement(T t) {
        hashset.add(t);
    }

    public boolean removeElement(T target) {
        Iterator<T> hashsetIt = hashset.iterator();
        while(hashsetIt.hasNext()) {
            T t = hashsetIt.next();
            if (t == target) {
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
    }

    public void showFor() {
        for (T t : hashset) {
            System.out.println(t);
        }
    }
}
