import java.util.ArrayList;
import java.util.List;

class Node {
    int data;
    Node right;
    Node left;

    Node(int d) {
        data = d;
        right = left = null;
    }
}

public class BTree {
    public static int i = 0;

    static Node buildTree(int[] d) {
        if (d[i] == -1) {
            i++;
            return null;
        }
        Node root = new Node(d[i]);
        i++;
        root.left = buildTree(d);
        root.right = buildTree(d);
        return root;
    }

     static void printLevelOrderTraversal(Node root) {
         List<Node> queue = new ArrayList<>();
         queue.add(root);
         queue.add(null);
         while (!queue.isEmpty()){
             Node temp = queue.get(0);
             queue.remove(0);
             if(temp==null){
                 System.out.println();
                 if(!queue.isEmpty()) {
                     queue.add(null);
                 }
             }
             else{
                 System.out.print(temp.data);
                 if(temp.left!=null){
                     queue.add(temp.left);
                 }
                 if(temp.right!=null){
                     queue.add(temp.right);
                 }
             }
         }

     }

    public static void main(String[] args) {
        int[] nodes = {1, 2, 4, -1, -1, 5, 7, -1, -1, -1, 3, -1, 6, -1, -1};
        Node a = buildTree(nodes);
        printLevelOrderTraversal(a);
    }
}
