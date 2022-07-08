

class ListNode {
    //首先是当前节点的值
    int val;
    //下一节点的位置
    ListNode next;
    //生成构造方法
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(){

    }
}

/**
 * 创建链表
 */
class TestLinkedList{
    public static void main(String[] args) {
        //创建节点
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        //创建当前节点的下一个节点
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = null;//最后一个节点的下一个找不到，所以为null

        //调用打印方法
        printLode(listNode1);
    }

    //写个方法把链表打印出来
    public static void printLode(ListNode first){
        ListNode curNode = first;
        while (curNode != null){//如果节点的值不为空，就打印，我们这里只有5个值，到第6个值也就是第5节点的下一个节点的值为null
            //打印出当前节点的值
            System.out.print(curNode.val+"->");
            //当前节点打印完，我们要打印下一个节点，next
            curNode = curNode.next;
        }
        //最后一个元素为null，所以要加上
        System.out.println("null");
    }
}
