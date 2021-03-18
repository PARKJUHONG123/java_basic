package week16_collectionFramework;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class collectionMain {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("1");

        HashSet<String> hashset = new HashSet<>();
        hashset.add("1");
        hashset.add("2");
        hashset.add("3");

        Iterator<String> hashsetIt = hashset.iterator();
        while (hashsetIt.hasNext()) {
            String str = hashsetIt.next();
            System.out.println(str);
        }
    }
}
