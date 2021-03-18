package week16_collectionFramework.map.hashMap;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {
    private HashMap<Integer, Member> hashMap;

    public MemberHashMap() {
        hashMap = new HashMap<>();
    }

    public void addElement(Member member) {
        hashMap.put(member.getId(), member); // HashMap 에 Pair 을 넣을 때 put 사용
    }

    public boolean removeElement(int id) {
        if (hashMap.containsKey(id)) {
            hashMap.remove(id);
            return true;
        }
        System.out.println("회원 번호가 없습니다.");
        return false;
    }

    public void showIter() {
        Iterator<Integer> it = hashMap.keySet().iterator(); // hashMap의 key 를 기준으로 순회할 iterator 생성
        while (it.hasNext()) {
            int key = it.next();
            Member member = hashMap.get(key); // Hashmap 에서 key 에 해당하는 value 를 가져올 때 get 사용
            System.out.println(member);
        }
        System.out.println();
    }
}
