package week05_class;

/*
- int 값을 가지고 있는 이진 트리를 나타내는 Node 라는 클래스를 정의하세요.
- int value, Node left, right를 가지고 있어야 합니다.
- BinrayTree라는 클래스를 정의하고 주어진 노드를 기준으로 출력하는 bfs(Node node)와 dfs(Node node) 메소드를 구현하세요.
- DFS는 왼쪽, 루트, 오른쪽 순으로 순회하세요.
 */

import java.util.*;

public class BinaryTree {
    Node root;

    BinaryTree() {
        this.root = null;
    }

    void add(int value) {
        root = addRecursive(root, value);
    }

    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        else {
            return current;
        }
        return current;
    }

    List<Integer> dfsInorder(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Node current = node;
        stack.push(node);

        while (!stack.isEmpty()) {
            while (current.left != null) {
                current = current.left;
                stack.push(current);
            }
            current = stack.pop();
            result.add(current.value);
            if (current.right != null) {
                current = current.right;
                stack.push(current);
            }
        }
        return result;
    }

    List<Integer> dfs(Node node) {
        Stack<Node> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Node current;
        stack.push(node);

        while (!stack.isEmpty()) {
            current = stack.pop();
            result.add(current.value);
            if (current.left != null) {
                stack.push(current.left);
            }
            if (current.right != null) {
                stack.push(current.right);
            }
        }
        return result;
    }

    List<Integer> bfs(Node node) {
        Queue<Node> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if (node == null) {
            return result;
        }
        Node current;
        queue.add(node);

        while (!queue.isEmpty()) {
            current = queue.remove();
            result.add(current.value);
            if (current.left != null) {
                queue.add(current.left);
            }
            if (current.right != null) {
                queue.add(current.right);
            }
        }
        return result;
    }
}

class Node {
    int value;
    Node left, right;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
    }
}
