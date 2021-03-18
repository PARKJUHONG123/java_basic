package week16_collectionFramework.map.treeMap;

import java.util.Iterator;
import java.util.TreeMap;

public class MemberTreeMap {
    private TreeMap<Integer, Member> treeMap;

    public MemberTreeMap() {
        treeMap = new TreeMap<>();
    }

    public void addElement(Member member) {
        treeMap.put(member.getId(), member); // treeMap 에 Pair 을 넣을 때 put 사용
    }

    public boolean removeElement(int id) {
        if (treeMap.containsKey(id)) {
            treeMap.remove(id);
            return true;
        }
        System.out.println("회원 번호가 없습니다.");
        return false;
    }

    public void showIter() {
        Iterator<Integer> it = treeMap.keySet().iterator(); // treeMap의 key 를 기준으로 순회할 iterator 생성
        while (it.hasNext()) {
            int key = it.next();
            Member member = treeMap.get(key); // treeMap 에서 key 에 해당하는 value 를 가져올 때 get 사용
            System.out.println(member);
        }
        System.out.println();
    }
}
