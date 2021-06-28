package com.ganzhenghao.arithmetic.队列;

import cn.hutool.core.util.ObjectUtil;
import com.ganzhenghao.arithmetic.二叉堆.MyBinaryHeap最小堆;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * 优先队列
 * 本质时二叉堆
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/28 8:47
 */
@Getter
public class 优先队列_最小优先 {

    private List<Integer> queue = new ArrayList<>();


    /**
     * 添加
     *
     * @param element 元素
     * @return boolean
     */
    public boolean add(Integer element){

        // todo 扩容逻辑
        queue.add(element);
        MyBinaryHeap最小堆.up(queue);
        return true;
    }

    /**
     * 取出元素
     *
     * @return {@link Integer}
     */
    public Integer takeOut(){

        // 1. 拿出根节点的值

        if (ObjectUtil.isEmpty(queue)){
            return null;
        }
        if (queue.size() == 1){
            int temp = queue.get(0);
            queue.remove(0);
            return temp;
        }
        int temp = queue.get(0);

        // 2. 将最后一个元素放到根节点位置
        queue.set(0, queue.get(queue.size() - 1));
        // 删除最后一个元素
        queue.remove(queue.size() - 1);


        // 3. 下沉

        MyBinaryHeap最小堆.down(queue);

        return temp;
    }


    public static void main(String[] args) {

        优先队列_最小优先 priorityQueue = new 优先队列_最小优先();

        priorityQueue.add(1);
        priorityQueue.add(3);
        priorityQueue.add(2);
        priorityQueue.add(4);
        priorityQueue.add(7);
        priorityQueue.add(9);
        priorityQueue.add(8);

        MyBinaryHeap最小堆.printBinaryHeap(priorityQueue.getQueue());

        priorityQueue.add(0);
        MyBinaryHeap最小堆.printBinaryHeap(priorityQueue.getQueue());

        Integer out = priorityQueue.takeOut();
        System.out.println("out = " + out);
        MyBinaryHeap最小堆.printBinaryHeap(priorityQueue.getQueue());


        Integer out1 = priorityQueue.takeOut();
        System.out.println("out = " + out1);
        MyBinaryHeap最小堆.printBinaryHeap(priorityQueue.getQueue());
    }


}
