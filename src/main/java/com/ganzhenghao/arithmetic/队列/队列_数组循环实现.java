package com.ganzhenghao.arithmetic.队列;

import cn.hutool.core.text.StrBuilder;

/**
 * 我的队列
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/25 18:43
 */

public class 队列_数组循环实现<T> {

    private Object[] array = {};
    private int first;
    private int last;

    /**
     * 我的队列的构造函数
     *
     * @param capacity 初始长度
     */
    public 队列_数组循环实现(int capacity) {
        this.array = new Object[capacity + 1];
    }

    /**
     * 入队
     *
     * @param element 元素
     * @return boolean
     */
    public boolean add(T element){
        //(队尾下标+1) % 数组长度 == 队头 代表队列满了
        // 因为队尾指向的位置永远是空位 所以队列实际长度比数组长度少1 所以在初始化数组时长度可以加一
        if ((last + 1) % array.length == first){
            throw new RuntimeException("队列已满");
        }
        array[last] = element;
        last = (last + 1) % array.length;
        return true;
    }

    /**
     * 出队
     *
     * @return {@link T}
     */
    public T remove(){
        //当队头 和 队尾长度一样时 代表为空
        // 因为不为空时 队尾不可能和队头相同

        if (last == first){
            throw new RuntimeException("队列为空");
        }

        T temp = (T) array[first];

        array[first] = null;


        //判断first是否等于数组长度-1 是的话则将下标改为 1 否则 下标加一
        first = first == array.length - 1 ? 0 : first + 1;

        return temp;
    }

    @Override
    public String toString() {
        StrBuilder sb = new StrBuilder();
        for (int i = first; i != last; i = (i+1) % array.length) {
            sb.append(array[i].toString() + "\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        队列_数组循环实现<Integer> queue = new 队列_数组循环实现<>(3);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        queue.add(4);


        System.out.println(queue);
    }

}
