
/**
 * 迭代法
 */
class Test34 {
    public static void main(String[] args) {
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

        Test34_1 test34 = new Test34_1();
        //test34.reverseList(listNode1);
        TestLinkedList testLinkedList = new TestLinkedList();
        testLinkedList.printLode(listNode1);
        testLinkedList.printLode(test34.reverseList(listNode1));
    }

    public ListNode reverseList(ListNode head) {
        //定义双指针
        ListNode le = head;
        ListNode rp = null;

        while (le!=null){
            ListNode next = le.next;
            le.next = rp;

            rp = le;
            le = next;
        }
        return rp;
    }
}

/**
 * 递归法
 */
class Test34_1{
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode resthead = head.next;
        ListNode resveNode = reverseList(resthead);

        resthead.next = head;
        head.next = null;

        return resveNode;
    }
}
