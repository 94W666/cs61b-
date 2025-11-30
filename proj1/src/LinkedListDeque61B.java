import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T>{
    private class Node {
        private T val;
        private Node next;
        private Node prev;

        public Node(T val,Node prev,Node next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    private int size;
    private Node sentinel;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null,null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }
    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        Node node = new Node(x,sentinel,sentinel.next);
        sentinel.next.prev = node;
        sentinel.next = node;
        size += 1;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        Node node = new Node(x,sentinel.prev,sentinel);
        sentinel.prev.next = node;
        sentinel.prev = node;
        size += 1;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();
        Node current = sentinel.next;
        while(current != sentinel) {
            returnList.add(current.val);
            current = current.next;
        }
        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        if(isEmpty()) {
            return null;
        }
        T result = sentinel.next.val;
        sentinel.next.next.prev = sentinel;
        sentinel.next = sentinel.next.next;
        size -= 1;
        return result;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        if(isEmpty()) {
            return null;
        }
        T result = sentinel.prev.val;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size -= 1;
        return result;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        Node p = sentinel.next;
        for(int i = 0;i < index;i += 1) {
            p = p.next;
        }
        return p.val;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */

    /**
     * 自我的一点补充，对于有返回值的函数，我们在main函数里会引入变量来接收
     * 也就是说调用有返回值的函数，人的直觉是希望有一个变量来显示接收它的返回值的
     * 所以，在这里，我将代码改为每一层都定义一个result变量来显示接收下一层
     * 函数调用后的返回值，我认为这样更符合我的逻辑
     */
    @Override
    public T getRecursive(int index) {
        if(index < 0 || index >= size) {
            return null;
        }
        T result = getRecursiveHelper(sentinel.next,index);
        return result;
    }

    private T getRecursiveHelper(Node p,int index) {
        if(index == 0) {
            T result = p.val;
            return result;
        }
        T result = getRecursiveHelper(p.next,index-1);
        return result;
    }

    public static void main(String[] args) {
        Deque61B<Integer> lld = new LinkedListDeque61B<>();
        lld.addLast(0);   // [0]
        lld.addLast(1);   // [0, 1]
        lld.addFirst(-1); // [-1, 0, 1]
    }
}
