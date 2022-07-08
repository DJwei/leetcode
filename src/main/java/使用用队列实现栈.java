import java.util.LinkedList;
import java.util.Queue;

/**
 *利用两个队列实现栈
 */
class Test42 {
    public static void main(String[] args) {

    }

    Queue<Integer> queue1;
    Queue<Integer> queue2;

    public Test42() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    //入栈操作
    public void push(int x){
        //把x保存到queue2中去,这里最好用offer如果用add遇到失败会抛出异常，而offer不会抛出异常
        queue2.offer(x);
        //将queue1中的元素依次弹出到queue2中去,这里最好用pull，用remove的话遇到删除失败的话会抛异常
        while (!queue1.isEmpty()) {//queue1.poll()!=null
            queue2.offer(queue1.poll());
        }
        //交换两个队列，利用指针指向
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    //出栈操作
    public int pop(){
        return queue1.poll();
    }
    //栈顶元素
    public int top(){
        return queue1.peek();
    }
    //判断为空的操作
    public boolean empty(){
       return queue1.isEmpty();
    }
}

/**
 * 利用一个队列来实现
 */
class Test42_1{

    Queue<Integer> queue;

    public Test42_1(){
        queue = new LinkedList<>();
    }
    //入栈操作
    public void push(int x){
        int l = queue.size();
        queue.offer(x);
        int i = 0;
        while (i<l){
            queue.offer(queue.poll());
            i++;
        }
    }
    //栈顶操作
    public int top(){
        return queue.peek();
    }
    //弹栈操作
    public int pop(){
        return queue.poll();
    }
    //判断为空元素
    public boolean empty(){
        return queue.isEmpty();
    }
}