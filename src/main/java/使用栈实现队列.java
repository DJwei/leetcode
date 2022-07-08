
import java.util.Stack;

/**
 * 利用栈实现队列
 */
class Test43 {
    //建立两个栈
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Test43(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    //入栈方法
    public void push(int x){
        //将stack1中的元素弹出加入到stack2中
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        //这是入栈，是有新元素进栈的
        stack1.push(x);
        //最后将stack2中的元素压入stack1中
        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }
    //弹栈方法
    public int pop(){
        return stack1.pop();
    }
    //栈顶方法
    public int peek(){
        return stack1.peek();
    }
    //为空的方法
    public boolean empty(){
        if(stack1.isEmpty())return true;
        else return false;
    }
}

//第二种方法
class Test43_1{
    public static void main(String[] args) {
        Test43_1 myQueue = new Test43_1();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false 
    }
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public Test43_1(){
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    //进栈
    public void push(int x) {
        //将元素全部进入stack1中
        stack1.push(x);
    }
    //出栈
    public int pop() {
        //要判断看stack2有没有元素，没有元素就要把stack1中的元素倒入stack2中
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public int peek() {
        //这里也要判断的，我们需要看到stack2是否有元素，没有元素我们就要倒入stack2中
        /*if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        else {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
            return stack2.peek();
        }*/
        if(stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty()&&stack2.isEmpty();
    }
}