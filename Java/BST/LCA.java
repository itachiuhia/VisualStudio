package BST;

public class LCA {
    static Node lca(Node tmp , int n1, int n2){
        while(tmp != null){
            if(tmp.key > n1 && tmp.key > n2){
                tmp = tmp.left;
            }else if (tmp.key < n1 && tmp.key < n2){
                tmp = tmp.right;
            }
            else
                break;
        }
        return tmp;
    }

    public static void main(String[] args) {
        Node root = new Node(20);
        root.left = new Node(8);
        root.right = new Node(22);
        root.left.left = new Node(4);
        root.left.right = new Node(12);
        root.right.left = new Node(10);
        root.right.right = new Node(14);

        int n1 = 10, n2 = 14;
        Node t = lca(root, n1, n2);
        System.out.println(t.key);
    }
}