import java.util.Stack;

class CNode{
    CNode left, right;
    char val;
    CNode(char val){
        this.val = val;
        right = left = null;
    }
}

public class ExpressionTree {
    public static void main(String[] args) {

        String postfix = "ab+ef*g*-";
        char[] cArray = postfix.toCharArray();
        CNode root =  constructTree(cArray);
        inorder(root);
        
    }

    private static void inorder(CNode root) {
        if(root == null)
            return;
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);    
    }


    private static CNode constructTree(char[] cArray) {
        Stack<CNode> st = new Stack<CNode>();
        CNode t, t1, t2;

        for(int i=0; i<cArray.length; i++){
            if(!isOperator(cArray[i])){
                t = new CNode(cArray[i]);
                st.push(t);
            }else{
                t = new CNode(cArray[i]);

                t1 = st.pop();
                t2= st.pop();

                t.right = t1;
                t.left = t2;
                st.push(t);
            }
        }

        t = st.peek();
        st.pop();

        return t;
    }

    private static boolean isOperator(char c) {
        if(c == '+' || c =='-' || c=='/' || c == '*' || c=='^'){
            return true;
        }
        return false;
    }
    
}