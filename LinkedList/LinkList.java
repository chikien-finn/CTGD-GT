package singleLink;

public class LinkList<T> {
    private Node<T> head;

    public LinkList(){
        this.head = null;
    }

    //duyet tung phan tu
    public void traverse(){
        Node<T> tmp = head;
        while (tmp != null) {
            System.out.println(tmp.getData());
            //chuyen den phan tu tiep theo
            tmp = tmp.getNext();
        }
    }
    //them vao dau danh sach
    public void addFirst(T item){
        Node<T> newNode = new Node<>(item, head);
        head = newNode;
    }

    //them vao cuoi danh sach
    public void addLast(T item){
        //neu chua co node nao
        if(head == null){
            addFirst(item);
        }else{
            //tạo node mới
            Node<T> newNode = new Node<>(item, null);
            //cho nó chạy liên tục tới khi nó = null thì lấy ra
            Node<T> tmp = head;
            while (tmp.getNext() != null) {
                tmp = tmp.getNext();
            }
            // lấy ra khi == null, lấy thằng next = thằng node mới
            tmp.setNext(newNode);
        }
    }

    //thêm vào 1 nút bất kì vào sau node
    public void insertAfter(T key, T toInsert){

        
        // tìm vị trí của node chứa key
        Node<T> tmp = head; 
        while (tmp != null && !tmp.getData().equals(key)) {
            tmp = tmp.getNext();
        }
        //có 2 tình huống, tìm ra được key hoặc đi đến cuối mà không có node
        //them vao khi tmp <> null
        if (tmp != null) {
            Node<T> newNode = new Node<>(toInsert, tmp.getNext());
            newNode.setNext(tmp.getNext());
            tmp.setNext(newNode);
        }
    }
    //xóa 1 node
    public void remove(T key){
        if(head == null)
            throw new RuntimeException("can not delete");
        //xóa nếu key ở vị trí đầu tiên
        if(head.getData().equals(key)){
            this.head = head.getNext();
         }
         //tạo biến tạm
         Node<T> prev = null;
         Node<T> cur = head;

         while(cur != null && !cur.getData().equals(key)){
            prev = cur;
            cur = cur.getNext();
         }
         if(cur == null)
            throw new RuntimeException("can not delete");
        //xóa node 
        prev.setNext(cur.getNext());
    }
}
