package Design;

import sun.misc.LRUCache;

import java.util.*;

public class lc146 {

    /**
     插入： 1.不存在  --> 判断capacity -->1. head == null/ head != null  return -1
           2.存在  --> 重新排序

     取出： 1.不存在  --> return -1
           2.存在   --> 重新排序

     key、value  --> hashMap
     O(1)+插入删除 --> double linkedList
     */

    class Node{
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public lc146(int capacity){
        map = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null ;
    }

    public int get(int key){
        Node node = map.get(key);
        if (node == null){
            return -1;
        }
        if (node != tail){
            if (node == head){
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value){
        Node node = map.get(key);
        if (node != null){
            node.value = value;
            //判断是否在尾部，在尾部就不需要改变顺序
            if (node != tail){
                if (node == head){
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            Node newNode = new Node(key,value);
            //容量满了 --> 删除头结点
            if (capacity == 0){
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            //容量为空
            if (head == null && tail == null){
                head = newNode;
            } else {//容量存在 但是未满
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key,newNode);
            capacity--;
        }
    }


}
