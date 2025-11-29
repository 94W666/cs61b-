public class Stack {
    private static class Node {
        private int val;
        private Node next;

        public Node(int val,Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private int size;
    private int totalSum;
    private Node sentinel;

    public Stack() {
        size = 0;
        totalSum = 0;
        sentinel = new Node(0,null);
    }

    public void push(int val) {
        sentinel.next = new Node(val,sentinel.next);
        size += 1;
        totalSum += val;
    }

    public int pop() {
        if(size == 0) {
            return -1;
        }
        int temp = sentinel.next.val;
        sentinel.next = sentinel.next.next;
        size -= 1;
        totalSum -= temp;
        return temp;
    }

    public int size() {
        return size;
    }

    public int sum() {
        return totalSum;
    }
}
