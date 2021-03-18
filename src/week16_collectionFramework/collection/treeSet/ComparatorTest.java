package week16_collectionFramework.collection.treeSet;

import java.util.Comparator;
import java.util.TreeSet;

// 이미 Comparable 이 구현된 경우 COmparator 를 이용하여 다른 정렬 방식을 정의할 수 있음
class MyCompare implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.compareTo(s2) * (-1);
    }    
}

public class ComparatorTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>(new MyCompare());
        treeSet.add("O");
        treeSet.add("R");
        treeSet.add("A");
        
        for (String str : treeSet) {
            System.out.println(str);
        }
    }

}
