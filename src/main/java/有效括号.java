
import java.util.Stack;

/**
 *  有效的括号用栈的思想
 */
class Test13 {
    public static void main(String[] args) {
        Test13 test13 = new Test13();
        String s = "([]){}{}";
        System.out.println(test13.isValid(s));
    }

    public boolean isValid(String s) {
        if (s.length() == 0) return false;
        Stack<Character> stack = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else if (stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}

/**
 * 用replace函数
 */
 class Test13_1 {
    public static void main(String[] args) {
        Test13_1 test13_1 = new Test13_1();
        //String s = "[()]";
        String s = "[{[]})";
        System.out.println(test13_1.isValid(s));
        System.out.println(s.length());
    }

    public boolean isValid(String s) {
        if(s.length()%2!=0)return false;
        int length = s.length() / 2;
        for (int i = 0; i < length; i++) {
            // System.out.println(s);  String s = "({()})";
            s = s.replace("()", "").replace("{}", "").replace("[]", "");
            //  System.out.println(s+"==");
            System.out.println(s.length()+"==");
        }
        return s.length() == 0;
    }

}

