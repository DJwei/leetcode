import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * LRU缓存是由双相链表和hashmap构成
 */

/**
 * 用LinkedHashMap来解决
 */
class LRUCache extends LinkedHashMap<Integer, Integer>{
        //定义缓存容量
        private int capacity;

        public LRUCache(int capacity) {
            super(capacity,0.75f,true);
            this.capacity = capacity;
        }

        //get方法
        public int get(int key){
            if(super.get(key)==null)return -1;
            return super.get(key);
        }

        //put方法
        public void put(int key,int value){
            super.put(key,value);
        }

        //重写删除操作
        @Override
        protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
            return size()>capacity;
        }

        public static void main(String[] args) {
            LRUCache lRUCache = new LRUCache(2);
            lRUCache.put(1, 1); // 缓存是 {1=1}
            lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
            System.out.println(lRUCache.get(1));    // 返回 1
            lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
            System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
            lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
            System.out.println(lRUCache.get(1));   // 返回 -1 (未找到)
            System.out.println(lRUCache.get(3));    // 返回 3
            System.out.println(lRUCache.get(4));   // 返回 4
        }
}

/**
 * 自定义哈希表+双向链表
 */
class LRUCache_1{
    //定义双向链表节点类
    class Node{
        int key;
        int value;
        Node next;//指向下一个
        Node prev;//指向前一个

        //建立哨兵节点
        public Node() {
        }

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    //建立哈希表
    private HashMap<Integer,Node> map = new HashMap<>();
    //定义容量
    private int capacity;
    //定义已经有的容量
    private int size;
    //定义头尾指针
    private Node head,tail;

    public LRUCache_1(int capacity) {
        this.size = 0;
        this.capacity = capacity;

        //双节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    //定义get方法
    public int get(int key){
        if(map.get(key)==null)return -1;
        //如果查到了那么就要移到末尾去
        moveTail(map.get(key));
        return map.get(key).value;
    }
    //定义put方法
    public void put(int key,int value){
        //添加操作之前先要查找key是否存在，如果存在就要把key移到末尾并且把值换了
        if(map.get(key)!=null) {
            map.get(key).value = value;
            moveTail(map.get(key));
        }
        //如果添加的是不存在的值，那么就要判断，size是否是小于容量小于容量的话话存在值前移，末尾为添加值
        if(map.get(key)==null){
            Node node = new Node(key,value);
            //保存到哈希表中
            map.put(key,node);
            addTail(node);
            size++;
            //如果超出容量，要删除头节点
            if(size>capacity){
                Node head = removeHead();
                map.remove(head.key);
                size--;
            }
        }
    }
    //对自定义的方法进行一个实现
    //删除头节点，把头节点放入末尾
    private void moveTail(Node node){
        removeNode(node);
        addTail(node);
    }
    //通用方法，删除表中的某个节点
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //在链表结尾增加节点
    private void addTail(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
    //删除头节点
    private Node removeHead(){
        Node newhead = head.next;
        removeNode(newhead);
        return newhead;
    }

    public static void main(String[] args) {
        LRUCache_1 lRUCache = new LRUCache_1(2);
        lRUCache.put(1, 1); // 缓存是 {1=1}
        lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // 返回 -1 (未找到)
        lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lRUCache.get(1));   // 返回 -1 (未找到)
        System.out.println(lRUCache.get(3));    // 返回 3
        System.out.println(lRUCache.get(4));   // 返回 4
    }
}

