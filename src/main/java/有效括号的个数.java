import java.util.Stack;

class Test26 {
    public static void main(String[] args) {
        Test26 test26 = new Test26();
        String s = "()(()";
        //String s = ")()())";
        System.out.println(test26.longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {//s = ")()())"
                                                 //))()()
        int n = 0;
        Stack<Character> stack = new Stack<>();
        for(int i=s.length()-1;i>-1;i--){
            stack.push(s.charAt(i));
        }
        if(stack.peek()=='('&&stack.isEmpty()){
            return 0;
        }
        for (int i=0;i<s.length();i++){
            if(stack.pop()=='('&&stack.peek()==')'){
                n = (n + 1);
            }
        }
        return n*2;
    }
}
