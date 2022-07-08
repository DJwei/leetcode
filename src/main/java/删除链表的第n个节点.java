import java.util.Stack;

/**
 *用迭代的思想
 */
class Test39 {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;
        Test39_2 test39 = new Test39_2();
        TestLinkedList.printLode(test39.removeNthFromEnd(listNode1,3));

    }

   /* public static int getlength(ListNode head){
        int length = 0;
        while (head != null){
            length++;
            head = head.next;
        }
        return length;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getlength(head);
        ListNode shaobin = new ListNode(-1,head);
        ListNode cur = shaobin;
        for(int i=0;i<l-n;i++) {//如果是删除第几个而不是倒数第几个的话i<n-1
            cur = cur.next;
        }
        cur.next = cur.next.next;
        return shaobin.next;
    }*/

    public static int getlength(ListNode head){
        int l = 0;
        while (head!=null){
            l++;
            head=head.next;
        }
        return l;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int l = getlength(head);
        ListNode shaobin = new ListNode(-1,head);
        ListNode cur = shaobin;

        for(int i=0;i<l-n;i++){//0 1 2
            cur = cur.next;//1 2 3
        }
        cur.next = cur.next.next;
        return shaobin.next;
    }
}

/**
 * 用栈的思想
 */
class Test39_1{
    public static void main(String[] args) {

    }

    public static int getlength(ListNode head){
        int l = 0;
        while (head!=null){
            l++;
            head=head.next;
        }
        return l;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode shaobin = new ListNode(-1,head);
        ListNode cur = shaobin;
        Stack<ListNode> stack = new Stack<>();
        while (cur!=null){//-1 1 2 3 4 5
            stack.push(cur);//1 2 3 4 5 null
            cur = cur.next;//1 2 3 4 5 null
        }
        for(int i=0;i<n;i++){
            stack.pop();
        }
        stack.peek().next = stack.peek().next.next;
        return shaobin.next;
    }
}

/**
 * 双指针法
 */
class Test39_2{
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode shaobin = new ListNode();
        shaobin.next = head;
        ListNode result1 = shaobin;
        ListNode result2 = result1;

        for(int i=0;i<n+1;i++){
            result1 = result1.next;//1 2 3 4 5 null
        }
        while (result1!=null){
            result1 = result1.next;
            result2 = result2.next;//1 2 3 4 5 null
        }
        result2.next = result2.next.next;

        return shaobin.next;
    }

}