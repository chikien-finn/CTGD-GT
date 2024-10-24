package singleLink;

public class Test {
    public static void main(String[] args) {
        LinkList<String> ll = new LinkList<>();
        ll.addFirst("vo chi kien");
        ll.addFirst("cau truc du lieu va giai thuat");
        ll.addFirst("ST23B");
        ll.addLast("tôi là ai");
        ll.insertAfter("ST23B", "không biết nữa");
        
        ll.traverse();
    }
}
