package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/22.
 * 关键是这个tail和head的关系，需要在初始化的时候就说明吗？
 * 你自己好好想想，
 * 环形的就是tail的next指向head
 * <p>
 * 最后一个元素tail，data是有值的，next也是有值的，只是指向了head。
 * 遍历的话，遇到next是head的break掉
 */
public class CircularLinkedList<T> implements LinkedList<T> {
    private Node<T> head;

    private Node<T> tail;

    public void addBegin(T t) {
        Node<T> node = new Node<T>(t);
        if (head == null) {
            head = node;
            tail = node;//这样是不是得到了2个点？
            head.setNext(tail);
            tail.setNext(head);
        } else {
            node.setNext(head);
            head = node;

            tail.setNext(head);
        }
        //将tail的next设置为head
        //一直遍历，直到tail指向为head？但是这时，head已经变了
        //所以先搞出tail？还是说定义2个node比较好？但是一个head，一个tail
        //怎么将tail和head的关系建立起来？中间还隔着很多元素了
    }

    /**
     * 这里不对，应该是先判断tail，为什么？
     * 因为我们是从尾部添加的。
     *
     * @param t
     */
    public void addEnd(T t) {
        Node<T> node = new Node<T>(t);
        if (tail == null) {
            tail = node;
            head = tail;
            tail.setNext(head);
        } else {
            //如果tail有值，那么tail的下一个元素就不是head，而是新加的node
            tail.setNext(node);
            //这时node就变成了tail
            tail = node;
            //tail的next设置为head
            tail.setNext(head);
        }
    }

    /**
     * 在指定位置添加特定的元素
     * 这个如果知道size的话，可以用二分查找，
     * 或者不知道size，其实也可以，直接从两端开始找
     * 然后找到index了后，整体break掉。
     * 这个还是比较简单的，和单链表差不多
     * 其实尼玛单链表也很难啊啊啊
     *
     * @param t
     * @param index
     */
    public void add(T t, int index) {
        if (index < 0) {//我草，其实这个可以看做是倒着数。。。先简单做
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            addBegin(t);
            return;
        }
        if (head == null) {
            throw new IndexOutOfBoundsException();
        }
        Node<T> prevNode = null;
        Node<T> travelNode = head;
        //这里有个问题就是index很大。如果是负数的话，是倒着数的。。。-2肯定不等于+2，
        //先求出size?index很大一直遍历？没必要，取模就行了。。。但是还是要size的值
        //先按常规的来做，超过了，就抛异常
        for (int i = 0; i < index; i++) {
            prevNode = travelNode;
            travelNode = travelNode.getNext();
            //妈的，这样来判断，不好判断啊。。
            if (travelNode.equals(head)) {//遍历完了，
                if (i < index) {
                    throw new IndexOutOfBoundsException();
                }
            }
        }
        Node<T> node = new Node(t);
        node.setNext(travelNode);
        prevNode.setNext(node);
    }

    public T remove(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = null;
        if (index == 0) {
            result = head.getData();
            head = head.getNext();
            tail.setNext(head);
            return result;
        }
        Node<T> preNode = null;
        Node<T> travelNode = head;
        for (int i = 0; i < index; i++) {
            preNode = travelNode;
            travelNode = travelNode.getNext();
            if (travelNode.equals(head)) {
                if (i < index) {
                    throw new IndexOutOfBoundsException();
                }else{
                    break;
                }
            }
        }
        //如果index为4，那么
        //travelNode就是目标node，
        result = travelNode.getData();
        Node<T> travelNodeNext = travelNode.getNext();
        if(travelNode.equals(tail)){
            tail = preNode;
            tail.setNext(head);
            return result;
        }

        //这里有个问题，就是如果删除的是head，或者tail？
        //对啊，没考虑到啊，R啊。如果删除最后一个元素，要重新复制tail啊。。。
        //还是要size？对，太多了，这里head和tail是有2个度的，就是边，关系的。
        //所以先针对特殊情况进行处理，然后之后的做普通处理。
        //果然还是错了，新的tail没赋值。
        preNode.setNext(travelNodeNext);
        travelNode = null;
        return result;
    }

    /**
     * 从头开始遍历，得到匹配的一个元素，移除，
     * 出了head和tail，其他不影响。
     *
     * @param t
     * @return
     */
    public int remove(T t) {
        Node<T> preNode = null;
        Node<T> travelNode = head;
        //怎么搞？遍历，取出元素，判断？
        for (int i = 0; ; i++) {
            T temp = travelNode.getData();
            if (temp.equals(t)) {
                if (travelNode.equals(head)) {
                    head = travelNode.getNext();
                    tail.setNext(head);
                } else if (travelNode.equals(tail)) {
                    tail = preNode;
                    tail.setNext(head);
                } else {
                    preNode.setNext(travelNode.getNext());
                }
                break;
            } else {
                preNode = travelNode;
                travelNode = travelNode.getNext();
                if(travelNode.equals(head)){//说明遍历结束
                    System.out.println(t+" not found");
                }
            }
        }
        return 0;
    }

    public void display() {
        if (head == null) {
            return;
        }
        Node<T> travelNode = head;
        for (int i = 0; ; i++) {
            T t = travelNode.getData();
            System.out.println(t);
            travelNode = travelNode.getNext();
            if (travelNode.equals(head)) {
                break;
            }
        }
    }

    /**
     * 获取最后一个元素的值
     *
     * @return
     */
    public T getTailVal() {
        if (head == null) {
            return null;
        }
        Node<T> travelNode = head;
        T data = null;
        while ((data = travelNode.getData()) != null) {
            Node<T> travelNodeNext = travelNode.getNext();
            if (travelNodeNext.equals(head)) {
                break;
            }
        }
        return data;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}
