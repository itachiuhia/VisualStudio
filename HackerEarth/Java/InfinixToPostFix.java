package Java;

import java.util.Stack;

public class InfinixToPostFix {
    static int Prec(char ch){
        switch (ch) 
        { 
        case '+': 
        case '-': 
            return 1; 
       
        case '*': 
        case '/': 
            return 2; 
       
        case '^': 
            return 3; 
        } 
        return -1; 
    }

    static String infixToPostfix(String inf){
        char[] infArr = inf.toCharArray();
        String res = "";

        Stack<Character> st = new Stack<>();

        for(int i= 0;i< infArr.length ; i++){
            char c = infArr[i];
            if(Character.isLetterOrDigit(c)){
                res += c;
            }

            else if(c == '('){
                st.push(c);
            }
            
            else if(c == ')'){
                while(!st.isEmpty() && st.peek() != '(')
                    res += st.pop();
                st.pop();    
            }
            else{
                while(!st.isEmpty() && Prec(c) <= Prec(st.peek())){
                    res += st.pop();
                }
                st.push(c);
            }
            
        }
        System.out.println(res);
        while(!st.isEmpty()){
            if(st.peek() == '(')
                return "invalid Expression";
            res += st.pop();    
        }



        return res;
    }
    public static void main(String[] args) {
        String exp = "a+b*(c^d-e)^(f+g*h)-i"; 
        System.out.println(infixToPostfix(exp)); 
    }
}
