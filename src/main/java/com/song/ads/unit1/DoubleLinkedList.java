package com.song.ads.unit1;

/**
 * Created by 00013708 on 2017/8/31.
 * head没有prev；tail没有next；
 * 每个node都有前后关系
 */
public class DoubleLinkedList<T> implements LinkedList<T> {

    private DLNode<T> head;

    private DLNode<T> tail;

    /**
     * 关系都没搞清楚，没建立起来，我R
     *
     * @param t
     */
    public void addBegin(T t) {
        if (head == null) {
            DLNode<T> newNode = new DLNode<T>(t);
            head = newNode;
            tail = newNode;
            head.setNext(tail);
            head.setPrev(null);
            tail.setPrev(head);
            tail.setNext(null);
            return;
        }
        DLNode<T> newNode = new DLNode<T>(t);
        newNode.setNext(head);
        head.setPrev(newNode);

        head = newNode;
    }

    public void addEnd(T t) {//之所以出现这种情况是因为java是引用类型的。
        if (tail == null) {
            DLNode<T> newNode = new DLNode<T>(t);
            head = newNode;
            tail = newNode;

            head.setPrev(null);
            head.setNext(tail);

            tail.setPrev(head);
            tail.setNext(null);

            return;
        }

        DLNode<T> newNode = new DLNode<T>(t);
        //原来的tail设置下一个元素
        tail.setNext(newNode);
        newNode.setPrev(tail);
        //设置新tail
        tail = newNode;
    }

    public void add(T t, int index) {
        if (index == 0) {
            addBegin(t);
            return;
        }
        //咦，这个插入要简单很多了，只需要遍历到目的节点，然后根据目的节点得到前，后节点
        //真TM 没搞清楚，我R，蛋疼的很，这个地方应该i=0，travelNode=head；index=0，得到head，然后替换head，index=5==size，这时尾部添加。
        DLNode<T> travelNode = head;
        for (int i = 0; i < index; i++) {//这个地方不对，
            travelNode = travelNode.getNext();
            if (travelNode == null) {//说明遍历结束
                if (i + 1 == index) {
                    addEnd(t);
                    return;
                } else {
                    throw new IndexOutOfBoundsException();
                }
            }
        }


        DLNode<T> prev = travelNode.getPrev();
        DLNode<T> nextNode = travelNode.getNext();//有可能是null

        //其实这里就是关系断裂了，而且我们要先维护旧的关系.???不对
        DLNode<T> newNode = new DLNode<T>(t);
        newNode.setPrev(prev);
        newNode.setNext(nextNode);

        prev.setNext(newNode);
        nextNode.setPrev(newNode);
        //到底是先设置，恢复prev和nextNode的关系，还是先建立newNode的关系？？
        //我发现问题不大，为什么？？因为我们作为一个Node本身，我们只关心和自己相关的东西。这个是个哲学范畴啊。
        //如果世界像程序这样，每个节点只关注自己的事情，维护好自己的关系，那么这个世界就不会像现在这样混乱了。
        //这个写链表，真TM好像做游戏啊，什么拆掉那个五连环什么的玩具。
    }

    /**
     * 这个TM的要测试下，看看另外的写法有什么问题
     *
     * @param index
     * @return
     */
    public T remove(int index) {
        //一样是遍历得到目标，然后破坏关系，重建关系。
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        T result = null;
        //其实这个应该可以不需要，直接遍历就行，如果是head，，
        if (index == 0) {
            if (head == null) {
                throw new IndexOutOfBoundsException();
            } else if (head.equals(tail)) {
                result = head.getT();
                head = null;
                tail = null;
                return result;
            } else {
                result = head.getT();
                DLNode<T> headNext = head.getNext();
                headNext.setPrev(null);
                head = headNext;
                return result;
            }
        }
        DLNode<T> travelNode = head;
        for (int i = 0; i < index; i++) {
            travelNode = travelNode.getNext();
            if (travelNode == null) {//遍历到尾部
                if (i < index) {
                    throw new IndexOutOfBoundsException();
                } else {
                    break;//代码还是太丑了，尼玛的。
                }
            }
        }
        result = travelNode.getT();
        if (travelNode.equals(tail)) {
            DLNode<T> tailPrev = tail.getPrev();
            tailPrev.setNext(null);
            tail = tailPrev;
        } else {
            DLNode<T> tPrev = travelNode.getPrev();
            DLNode<T> tNext = travelNode.getNext();

            tPrev.setNext(tNext);
            tNext.setPrev(tPrev);
        }

        return result;
    }

    public int remove(T t) {
        if (head == null) {
            System.out.println("empty list");
            return -1;
        }
        int result = 0;
        DLNode<T> travelNode = head;
        for (int i = 0; ; i++) {
            T tempT = travelNode.getT();
            if (tempT.equals(t)) {
                result = i;
                break;
            }
            travelNode = travelNode.getNext();
            if (travelNode == null) {//遍历结束
                System.out.println("not found");
                result = -1;
                break;
            }
        }

        DLNode<T> tPrev = travelNode.getPrev();
        DLNode<T> tNext = travelNode.getNext();

        tPrev.setNext(tNext);
        tNext.setPrev(tPrev);
        return result;
    }

    public void display() {
        if (head == null) {
            return;
        }
        DLNode<T> travelNode = head;
        for (int i = 0; ; i++) {
            T t = travelNode.getT();
            System.out.println(t);
            travelNode = travelNode.getNext();
            if (travelNode == null) {
                break;
            }
        }
    }

    public T removeEnd() {
        if (tail == null) {
            return null;
        }
        T result = tail.getT();
        if (tail.equals(head)) {
            tail = null;
            head = null;
            return result;
        }
        DLNode<T> tPrev = tail.getPrev();
        tPrev.setNext(null);
        tail = tPrev;
        return result;
    }
}

