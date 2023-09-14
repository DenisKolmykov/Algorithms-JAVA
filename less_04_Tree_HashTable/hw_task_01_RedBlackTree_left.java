package less_04_Tree_HashTable;
/*
Необходимо превратить собранное на семинаре дерево поиска 
в полноценное левостороннее красно-черное дерево. 
И реализовать в нем метод добавления новых элементов с балансировкой.

Красно-черное дерево имеет следующие критерии:
• Каждая нода имеет цвет (красный или черный)
• Корень дерева всегда черный
• Новая нода всегда красная
• Красные ноды могут быть только левым ребенком
• У краной ноды все дети черного цвета

Соответственно, чтобы данные условия выполнялись, 
после добавления элемента в дерево необходимо произвести балансировку, 
благодаря которой все критерии выше станут валидными. 
Для балансировки существует 3 операции – левый малый поворот, 
правый малый поворот и смена цвета.

*/

import java.util.ArrayList;
import java.util.List;

class BinaryTree{
    Node root;

    class Node{
        int value;
        Node left;
        Node right;
        Color color;
    }

    private enum Color{
        RED, BLACK;
    }

    public boolean find(int value){
        return find(root, value);
    }

    public boolean find(Node node, int value){
        if(node == null){
            return false;
        }
        if(node.value == value){
            return true;
        }
        if(node.value < value){
            return find(node.right, value);
        }else{
            return find(node.left, value);
        }
    }

    public boolean insert(int value){
        if(root != null){
            boolean result = insert (root, value);
            root = rebalance(root); // добавлена балансировка для/при изменении корня
            root.color = Color.BLACK;
            return result;
        } else {
            root = new Node();
            root.value = value;
            root.color = Color.BLACK;
            return true;
        }
    }

    // public boolean insert(Node node, int value) {
    //     if(node.value == value){
    //         return false;
    //     }

    //     if(node.value < value){
    //         if(node.right == null){
    //             node.right = new Node();
    //             node.right.value = value;
    //             node.right.color = Color.RED;
    //             rebalance(node.right);
    //             return true;
    //         }
    //         return insert(node.right, value);
    //         //rebalance();
    //     }else{
    //         if(node.left == null){
    //             node.left = new Node();
    //             node.left.value = value;
    //             node.left.color = Color.RED;
    //             rebalance(node.left);
    //             return true;
    //         }
    //         return insert(node.left, value);
    //         //rebalance();
    //     }
    // }

    private boolean insert(Node node, int value){
        if (node.value == value){
            return false;
        } else {
            if (node.value > value) {
                if (node.left != null) {
                    boolean result = insert(node.left, value);
                    node.left = rebalance(node.left);
                    return result;
                } else {
                    node.left = new Node();
                    node.left.color = Color.RED;
                    node.left.value = value;
                    return true;
                }
            } else {
                if (node.right != null) {
                    boolean result = insert(node.right, value);
                    node.right = rebalance(node.right);
                    return result;
                } else {
                    node.right = new Node();
                    node.right.color = Color.RED;
                    node.right.value = value;
                    return true;
                }
            }
        }
    }

    private Node rebalance(Node node){
        Node result = node;
        boolean needRebalance;

        do{
            needRebalance = false;
            if (result.right != null && result.right.color == Color.RED && 
            (result.left == null || result.left.color == Color.BLACK)){
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && 
                result.left.left != null && result.left.left.color == Color.RED) {
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.left != null && result.left.color == Color.RED && 
                result.right != null && result.right.color == Color.RED) {
                needRebalance = true;
                colorSwap(result);
            }
        } while (needRebalance);
        return result;
    }


    private Node rightSwap(Node node){
        Node rightChild = node.right;
        Node tempChild = rightChild.left;
        rightChild.left = node;
        node.right = tempChild;
        rightChild.color = node.color;
        node.color = Color.RED;

        return rightChild;
    }


    private Node leftSwap(Node node){
        Node leftChild = node.left;
        Node tempChild = leftChild.right;
        leftChild.right = node;
        node.left = tempChild;
        leftChild.color = node.color;
        node.color = Color.RED;

        return leftChild;
    }


    private void colorSwap(Node node){
        node.right.color = Color.BLACK;
        node.left.color = Color.BLACK;
        node.color = Color.RED;
    }

    public void printTree() { // с обходом в ширину
        List <Node> line = new ArrayList<>();
        line.add(root);
        System.out.println("--start--");
        while (line.size() > 0) {
            List<Node> nextLine = new ArrayList<>();
            for (Node node: line){
                if (node != null){
                    System.out.printf("|%d(%s)->", node.value, node.color);
                    if (node.left != null){
                        nextLine.add(node.left);
                        System.out.printf("l:%d(%s)", node.left.value, node.left.color);
                    } else {nextLine.add(null); System.out.print("l:-");}
                    if (node.right != null){
                        nextLine.add(node.right);
                        System.out.printf(",r:%d(%s)| ", node.right.value, node.right.color);

                    }else {nextLine.add(null);System.out.print(",r:-| ");}
                } else {
                    System.out.print("| - | ");
                }
            }
            System.out.println();
            line = nextLine;
        }
        System.out.println("---end---");
    }

}


public class hw_task_01_RedBlackTree_left {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        tree.insert(10);
        tree.insert(11);
        tree.insert(12);
        tree.insert(13);
        tree.insert(14);
        tree.insert(15);
        tree.insert(16);
        tree.insert(17);
        tree.insert(18);
        tree.insert(19);
        tree.insert(20);

        tree.printTree();

    }
}
