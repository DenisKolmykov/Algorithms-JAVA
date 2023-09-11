package less_03_List;

class List{
    Node head;
    public class Node{
        int value;
        Node next;
    }

    public void push_back(int value){
        Node node = new Node();
        node.value = value;

        if(head == null){
            head = node;
        }else {
            Node cur = head;
            while (cur.next != null) {
                cur = cur.next;
            }
            cur.next = node;
        }
    }

    public void pop_back(){
        if(head != null){
            if(head.next == null){
                head = null;
            }else {
                Node cur = head;
                while (cur.next.next != null) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
    }

    public void print(){
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public Node find(int value){
        Node cur = head;
        while (cur != null) {
            if(cur.value == value){
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }
}

class dList{
    Node head;
    Node tail;
    public class Node{
        int value;
        Node next;
        Node prev;
    }

    public void push_front(int value){
        Node node = new Node();
        node.value = value;
        node.next = head;
        if(head != null) {
            head.prev = node;
        }else{
            tail = node;
        }
        head = node;
    }
    public void push_back(int value){
        Node node = new Node();
        node.value = value;
        node.prev = tail;
        if(tail != null) {
            tail.next = node;
        }else{
            head = node;
        }
        tail = node;
    }

    public void pop_front(){
        if(head != null) {
            head = head.next;
            if(head != null) {
                head.prev = null;
            }else{
                tail = null;
            }
        }
    }

    public void pop_back(){
        if(tail != null) {
            tail = tail.prev;
            if(tail != null) {
                tail.next = null;
            }else{
                head = null;
            }
        }
    }

    public void print(){
        Node cur = head;
        while (cur != null) {
            System.out.printf("%d ", cur.value);
            cur = cur.next;
        }
        System.out.println();
    }

    public Node find(int value){
        Node cur = head;
        while (cur != null) {
            if(cur.value == value){
                return cur;
            }
            cur = cur.next;
        }

        return null;
    }

    public void sort(){
        boolean sorted = false;
        do{
            sorted = true;

            Node node = head;
            while(node != null && node.next != null){
                if(node.value > node.next.value){
                    Node before = node.prev;
                    Node cur = node;
                    Node next = node.next;
                    Node after = next.next;

                    cur.next = after;
                    cur.prev = next;
                    next.next = cur;
                    next.prev = before;

                    if(before != null) {
                        before.next = next;
                    }else{
                        head = next;
                    }

                    if(after != null) {
                        after.prev = cur;
                    }else{
                        tail = cur;
                    }

                    sorted = false;
                }
                node = node.next;
            }

        }while(!sorted);
    }
}
public class examples {
    public static void main(String[] args) {
        dList list = new dList();
        for(int i= 10; i >=1; i--){
            list.push_back(i);
        }
        list.print();
        dList.Node node = list.find(5);
        System.out.println(node);
        list.pop_back();
        list.print();
        node = list.find(5);
        System.out.println(node);


        list.push_front(10);
        list.push_back(11);

        list.print();

        list.pop_front();
        list.pop_back();

        list.print();

        list.sort();

        list.print();

    }
}
