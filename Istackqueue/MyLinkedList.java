package Queue;

public class MyLinkedList implements Istackqueue {
    public class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;   
            
        }
    }

    // Có 2 thao tác chính: thêm phần tử vào đầu linked list (push) và xóa phần tử cuối của linked list (pop)
    Node headNode;
    Node tailNode;

    MyLinkedList() {
        headNode = tailNode = null;
    }

    @Override
    public boolean push(int value) {
        if (isFull()) {
            return false;
        }

        Node newNode = new Node(value);
        if (isEmpty()) {
            headNode = tailNode = newNode;
        } else   
 { // thêm node vào cuối linked list
            tailNode.next = newNode;
            tailNode = newNode;
        }
        // always keep tracking tail pointer
        return true;
    }
    public int pop() {
        if (isEmpty()) {
            return -1; // Nên thay thế bằng việc ném ngoại lệ NoSuchElementException
        }

        int value = headNode.value;
        headNode = headNode.next;
        if (headNode == null) {
            tailNode = null;
        }
        return value;
    }
}
