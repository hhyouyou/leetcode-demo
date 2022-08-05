package com.djx.demo.leetcode.struct;

/**
 * day	[622]设计循环队列	44.5%	Medium	0.0%
 * <p>
 * MyCircularQueue(k): 构造器，设置队列长度为 k 。
 * Front: 从队首获取元素。如果队列为空，返回 -1 。
 * Rear: 获取队尾元素。如果队列为空，返回 -1 。
 * enQueue(value): 向循环队列插入一个元素。如果成功插入则返回真。
 * deQueue(): 从循环队列中删除一个元素。如果成功删除则返回真。
 * isEmpty(): 检查循环队列是否为空。
 * isFull(): 检查循环队列是否已满
 *
 * @author dongjingxi
 * @date 2022/8/2
 */
public class MyCircularQueue {

    /**
     *解答失败: 测试用例:["MyCircularQueue","enQueue","deQueue","enQueue","enQueue","deQueue","isFull","isFull","Front","deQueue","enQueue","Front","enQueue","enQueue","Rear","Rear","deQueue","enQueue","enQueue","Rear","Rear","Front","Rear","Rear","deQueue","enQueue","Rear","deQueue","Rear","Rear","Front","Front","enQueue","enQueue","Front","enQueue","enQueue","enQueue","Front","isEmpty","enQueue","Rear","enQueue","Front","enQueue","enQueue","Front","enQueue","deQueue","deQueue","enQueue","deQueue","Front","enQueue","Rear","isEmpty","Front","enQueue","Front","deQueue","enQueue","enQueue","deQueue","deQueue","Front","Front","deQueue","isEmpty","enQueue","Rear","Front","enQueue","isEmpty","Front","Front","enQueue","enQueue","enQueue","Rear","Front","Front","enQueue","isEmpty","deQueue","enQueue","enQueue","Rear","deQueue","Rear","Front","enQueue","deQueue","Rear","Front","Rear","deQueue","Rear","Rear","enQueue","enQueue","Rear","enQueue"]
     *  [[81],[69],[],[92],[12],[],[],[],[],[],[28],[],[13],[45],[],[],[],[24],[27],[],[],[],[],[],[],[88],[],[],[],[],[],[],[53],[39],[],[28],[66],[17],[],[],[47],[],[87],[],[92],[94],[],[59],[],[],[99],[],[],[84],[],[],[],[52],[],[],[86],[30],[],[],[],[],[],[],[45],[],[],[83],[],[],[],[22],[77],[23],[],[],[],[14],[],[],[90],[57],[],[],[],[],[34],[],[],[],[],[],[],[],[49],[59],[],[71]]
     *  测试结果:[null,true,true,true,true,true,false,false,0,true,true,0,true,true,45,45,true,true,true,27,27,24,27,27,true,true,88,true,88,88,88,88,true,true,88,true,true,true,88,false,true,47,true,88,true,true,88,true,true,true,true,true,28,true,84,false,28,true,28,true,true,true,true,true,47,47,true,false,true,45,87,true,false,87,87,true,true,true,23,87,87,true,false,true,true,true,57,true,57,94,true,true,34,59,34,true,34,34,true,true,59,true]
     *  期望结果:[null,true,true,true,true,true,false,false,12,true,true,28,true,true,45,45,true,true,true,27,27,13,27,27,true,true,88,true,88,88,24,24,true,true,24,true,true,true,24,false,true,47,true,24,true,true,24,true,true,true,true,true,53,true,84,false,53,true,53,true,true,true,true,true,66,66,true,false,true,45,17,true,false,17,17,true,true,true,23,17,17,true,false,true,true,true,57,true,57,87,true,true,34,92,34,true,34,34,true,true,59,true]
     *
     * @param args
     */

    public static void main(String[] args) {
        MyCircularQueue myCircularQueue = new MyCircularQueue(3);
        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isFull());

        System.out.println(myCircularQueue.enQueue(1));
        System.out.println(myCircularQueue.enQueue(2));
        System.out.println(myCircularQueue.enQueue(3));
        System.out.println(myCircularQueue.enQueue(4));

        System.out.println(myCircularQueue.Rear());


        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isFull());

        System.out.println(myCircularQueue.deQueue());

        System.out.println(myCircularQueue.isEmpty());
        System.out.println(myCircularQueue.isFull());


        System.out.println(myCircularQueue.enQueue(4));
        System.out.println(myCircularQueue.enQueue(5));

        System.out.println(myCircularQueue.Rear());


    }


    private final int[] array;

    private int size;

    private int front;

    private int rear;

    public MyCircularQueue(int k) {

        array = new int[k];
        size = 0;
        front = 0;
        rear = 0;
    }

    public boolean enQueue(int value) {

        if (isFull()) {
            return false;
        }

        if (!isEmpty()) {
            rear = (rear + 1) % (array.length);
        }
        array[rear] = value;

        size++;
        return true;
    }

    public boolean deQueue() {

        if (isEmpty()) {
            return false;
        }

        array[front] = 0;
        front = (front + 1) % (array.length);

        size--;
        return true;
    }

    public int Front() {

        if (isEmpty()) {
            return -1;
        }
        return array[front];
    }

    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        return array[rear];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }
}
