/**
 * 迭代法
 */
class Test38 {
    public static void main(String[] args) {
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(3);
        ListNode listNode13 = new ListNode(4);
        ListNode listNode21 = new ListNode(1);
        ListNode listNode22 = new ListNode(1);
        ListNode listNode23 = new ListNode(2);

        //创建当前节点的下一个节点
        listNode11.next = null;
        listNode12.next = listNode13;
        listNode13.next = null;
        listNode21.next = listNode22;
        listNode22.next = listNode23;
        listNode23.next = null;//最后一个

        Test38 test38 = new Test38();
        TestLinkedList.printLode(test38.mergeTwoLists(listNode11,listNode21));
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //定义一个哨兵节点，哨兵的next指向最终结果的头节点
        ListNode shaobin = new ListNode();

        ListNode prev = shaobin;

        //遍历两个链表
        while (list1!=null && list2!=null){
            if(list1.val <= list2.val){
                prev.next = list1;
                prev = list1;
                list1 = list1.next;
            }
            else {
                prev.next = list2;
                prev = list2;
                list2 = list2.next;
            }
        }
        prev.next = list1==null ? list2 : list1;
        //return prev;
        return  shaobin.next;
    }
}

class Test38_1{
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if ( l1 == null )
            return l2;
        else if ( l2 == null )
            return l1;
        if ( l1.val <= l2.val ){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
