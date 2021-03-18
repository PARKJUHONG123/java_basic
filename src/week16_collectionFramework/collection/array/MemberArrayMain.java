package week16_collectionFramework.collection.array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import java.util.Queue;

public class MemberArrayMain {
    public static void main(String[] args) {
        // List Interface
        ArrayList<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.remove(0);

        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.pop();

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.remove();
    }
}
