package less_03_List;

// разворот односвязного списка

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}

class Answer {
    Node head;

    public void reverse() {
        // Введите свое решение ниже
        if (head != null && head.next != null){
            Node temp = head;
            //reverse (head.next, head);
            reverse_iter ();
            temp.next = null;
        }
    }

    // private void reverse(Node current, Node prev){
    //     if (current.next == null){
    //         head = current;
    //     } else {
    //         reverse (current.next, current); 
    //     }
    //     current.next = prev;
    //     //prev.next = null;
    // }

    // разворот лучше делать итеративным (без рекурсии), 
    // т.к. на больших списках может быть переполенени стека
    private void reverse_iter(){
        Node current = head.next;
        Node prev = head;

        while (current != null){
            Node temp2 = current.next;
            current.next = prev;
            prev = current;
            current = temp2;
        };
        
        head = prev;
    }
}


public class hw_task_02_reverse {
    public static void main(String[] args) {
        // Создаем связанный список 1 -> 2 -> 3 -> 4
        Node head;
        if (args.length == 0) {
            head = new Node(1);
            head.next = new Node(2);
            head.next.next = new Node(3);
            head.next.next.next = new Node(4);

        } else {
            head = new Node(Integer.parseInt(args[0]));
            head.next = new Node(Integer.parseInt(args[1]));
            head.next.next = new Node(Integer.parseInt(args[2]));
            head.next.next.next = new Node(Integer.parseInt(args[3]));
        }

        // Сохраняем голову списка в поле класса Answer
        Answer ans = new Answer();
        ans.head = head;
        // Инвертируем порядок элементов списка
        ans.reverse();

        // Выводим инвертированный порядок элементов списка
        Node current = ans.head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}
