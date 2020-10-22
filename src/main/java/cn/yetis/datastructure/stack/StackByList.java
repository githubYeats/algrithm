package cn.yetis.datastructure.stack;

/**
 * 自定义实现“栈stack”————用链表实现
 * 实现stack的常用方法：
 * 1.create	创建一个空stack
 * 2.push	存放数据到stack顶端，并更新stack
 * 3.pop	从stack的顶端取数据，并更新stack
 * 4.empty	判断stack是否为空，空则返回true
 * 5.full	判断stack是否已满，已满则返回true
 *
 * @author fyyang
 * @since 2020-10-22
 */
public class StackByList {

    /**
     * 指向Stack底端的指针
     */
    private Node front;

    /**
     * 指向Stack顶端的指针
     */
    private Node rear;

    /**
     * stack的大小，即stack包含有多少个元素
     */
    private int size;


    public StackByList() {

    }

    /**
     * 返回stack的大小
     *
     * @return stack中包含的元素个数
     */
    public int size() {
        return size;
    }

    /**
     * 判断Stack是否为空
     *
     * @return stack为空，返回true；否则，返回false。
     */
    public boolean isEmpty() {
        return front == null;
    }

    /**
     * 向stack顶端添加一个数据
     *
     * @param data 将要被添加到stack顶端的数据
     */
    public void push(Object data) {
        Node newNode = new Node(data);
        if (this.isEmpty()) {
            front = newNode;
        } else {
            rear.next = newNode;
        }
        rear = newNode;
        size++;
    }

    /**
     * 从stack顶端弹出一个数据
     *
     * @return 出栈的数据对象
     */
    public Object pop() {
        if (this.isEmpty()) {
            return "The stack is empty.";
        } else {
            size--;
            return rear.data;
        }
    }

    /**
     * 打印stack中的所有数据，如果stack不为空的话。
     */
    public void print() {
        if (this.isEmpty()) {
            System.out.println("The stack is empty.");
        }
        Node current = front;
        while (null != current) {
            System.out.println(current.data + ",");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackByList stack = new StackByList();
        System.out.println(stack.isEmpty());

        stack.push(123);
        stack.push(new Node("abc"));
        stack.push("hello");

        System.out.println(stack.isEmpty());
        System.out.println(stack.size);
        stack.print();

        System.out.println("==========");
        System.out.println(stack.pop());
        System.out.println(stack.size);
    }
}

class Node {
    Object data;
    Node next;

    public Node(Object data) {
        this.data = data;
        this.next = null;
    }
}
