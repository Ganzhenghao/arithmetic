package com.ganzhenghao.arithmetic.二叉堆;

import cn.hutool.core.util.ObjectUtil;

import java.util.*;

/**
 * 我的二叉堆 最大堆  根节点的元素是最大的
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/27 16:04
 */
public class MyBinaryHeap最小堆 {

    /*
    二叉堆实际上是顺序存储在数组中
    如:           1
            3          2
         6     5    7      8

      在数组中的存储则是  1 3 2 6 5 7 8
      所以任意一个非叶子节点
                其左孩子节点为 -  parent * 2 + 1
                其右孩子节点为 -  parent * 2 + 2
     */

    /**
     * 二叉堆 上浮调整 (最小堆)
     *
     * @param binaryHeap 二叉堆 数组存放 , 如果用集合会更舒服,不用纠结数组是否刚好填满
     */
    public static void up(List<Integer> binaryHeap){

        //健壮性判断
        if (ObjectUtil.isEmpty(binaryHeap) || binaryHeap.size() == 1) {
            //空二叉堆 或只有一个节点的二叉堆
            return;
        }
        //新插入二叉堆的元素一定在最后面
        int childNodeIndex = binaryHeap.size() - 1;
        // 二叉堆是完全二叉树
        // 子节点是 左还是右 需要判断
        // 如果数组长度或者集合size()是单数,此时已经不可能等于一,则一定为左节点
        // 反之则为右节点
        //  其左孩子节点为 -  parent * 2 + 1
        //  其右孩子节点为 -  parent * 2 + 2
        int parentNodeIndex;
        if (binaryHeap.size() % 2 == 0){
            //双数左节点
            parentNodeIndex = (childNodeIndex -1) / 2;

        }else{
            //单数右节点
            parentNodeIndex = (childNodeIndex - 2) / 2;
        }

        //构建一个临时变量 存储叶子节点值
        int temp = binaryHeap.get(childNodeIndex);

        //依次向上判断  最小堆的判断
        // 判断条件:  什么时候交换子节点和父节点的值
        //          1. 子节点比父节点小
        //          2. 子节点的索引大于0 也就是不是根节点

        while (childNodeIndex > 0 && temp < binaryHeap.get(parentNodeIndex)){

            //满足条件则更新 子节点比父节点小 则 将子节点和父节点的值交换
            // 可以优化 : 在子节点和父节点做连续交换时,并不一定要真正交换,
            //         只需要把交换的一方(子节点)的值存入temp 然后进行单项覆盖,
            //          循环结束后再把temp的值存入最终位置即可

            // 1. 将子节点的值设置为父节点的值
            binaryHeap.set(childNodeIndex, binaryHeap.get(parentNodeIndex));
            // 2. 把子节点索引更新为父节点索引
            childNodeIndex = parentNodeIndex;
            // 3. 根据新的子节点索引,计算出新的父节点索引
            if (binaryHeap.size() % 2 == 0){
                //左节点
                parentNodeIndex = (childNodeIndex -1) / 2;
            }else{
                //右节点
                parentNodeIndex = (childNodeIndex - 2) / 2;

            }

        }

        // 4.所有交换完后 则将temp存入最终位置
        binaryHeap.set(childNodeIndex, temp);

    }

    /**
     * 二叉堆 下沉调整 (最小堆)
     *
     * @param binaryHeap 二叉堆
     */
    public static void down(List<Integer> binaryHeap){

        if (ObjectUtil.isEmpty(binaryHeap) || binaryHeap.size() == 1){
            return;
        }

        //父节点的元素
        int temp = binaryHeap.get(0);
        int currentIndex = 0;


        while (true) {

            int leftChildIndex = currentIndex * 2 + 1;
            int rightChildIndex = currentIndex * 2 + 2;
            //判断父节点的元素是否大于左右两个孩子 如果大于 则和最小的孩子交换

            if (leftChildIndex >= binaryHeap.size()){
                //来到这里 代表 左孩子的索引已经超出二叉堆的大小 不再比较
                binaryHeap.set(currentIndex, temp);
                break;
            }else if (rightChildIndex >= binaryHeap.size()){
                //来到这里代表 左孩子存在 右孩子不存在  则只比较 temp和左孩子的大小
                // 如果比左孩子大 则交换 终止 , 否则在当前位置设置值 终止
                if (binaryHeap.get(leftChildIndex) < temp){
                    binaryHeap.set(currentIndex, binaryHeap.get(leftChildIndex));
                    binaryHeap.set(leftChildIndex, temp);
                }else{
                    binaryHeap.set(currentIndex, temp);
                }
                break;
            }else {
                //来到这里 代表 左孩子 右孩子都存在
                //比较两个孩子的大小 然后和最小的孩子交换
                int minIndex = binaryHeap.get(leftChildIndex) < binaryHeap.get(rightChildIndex) ? leftChildIndex : rightChildIndex;

                if (temp > binaryHeap.get(minIndex)){
                    //交换后继续调用
                    binaryHeap.set(currentIndex, binaryHeap.get(minIndex));
                    //无需真正交换 单向复制即可
                    //binaryHeap.set(minIndex, temp);
                    currentIndex = minIndex;

                }else {
                    //不交换
                    binaryHeap.set(currentIndex, temp);
                    break;
                }


            }
        }


    }


    /**
     * 构建二叉堆 从最后一个非叶子节点开始 依次做下沉调整
     *
     * @param binaryHeap 二叉堆
     */
    public static void buildBinaryHeap(List<Integer> binaryHeap){
        for (int i = (binaryHeap.size() -2) / 2; i >= 0 ; i--) {
            //todo
        }
    }

    /**
     * 打印二叉堆 横向顺序 也就是数组的顺序
     *  123456
     *  打印为 123456
     *
     * @param binaryHeap 二叉堆
     */
    public static void printBinaryHeapArray(List<Integer> binaryHeap){

        if (ObjectUtil.isEmpty(binaryHeap)){
            System.out.println();
        }

/*        if (binaryHeap.size() == 1){
            System.out.println(binaryHeap.get(0));
        }*/

        //当前索引
        int currentIndex = 0;
        //当前深度
        int currentHigh = 1;
        // 当前深度的最大索引
        int currentHighMaxIndex = binaryHeapMaxIndex(currentHigh);
        //当当前索引小于二叉堆的大小时才执行
        while (currentIndex < binaryHeap.size()){

            //判断条件  当前索引小于二叉堆的最大索引 并且 当前索引要小于等于当前深度的最大索引
            for (; currentIndex <= currentHighMaxIndex && currentIndex < binaryHeap.size(); currentIndex++) {

                System.out.print(binaryHeap.get(currentIndex) + "\t");
            }
            System.out.println();
            currentHigh ++;
            currentHighMaxIndex = binaryHeapMaxIndex(currentHigh);
        }

    }

    /**
     * 打印二叉堆
     * 打印二叉堆 二叉堆顺序顺序
     *          1
     *     3          2
     * 6     5    7      8
     * 打印为  1 3 2 6 5 7 8
     *
     * @param binaryHeap 二叉堆
     * @param childQueue 孩子的index队列
     */
    private static void printBinaryHeap(List<Integer> binaryHeap,Queue<Integer> childQueue){


        if (ObjectUtil.isEmpty(binaryHeap) || ObjectUtil.isEmpty(childQueue)){
            return;
        }

        //打印当前队列的所有数据 并生成新的数据存入新的队列中
        ArrayDeque<Integer> localQueue = new ArrayDeque<>();
        Integer currentNodeIndex = null;
        // poll()
        //检索并移除此队列的头部，如果此队列为空，则返回null 。
        //返回值：
        //此队列的头部，如果此队列为空，则为null

        //如果currentNodeIndex 为null 则代表队列取完了;
        while ( (currentNodeIndex = childQueue.poll()) != null){
            //如果当前索引大于二叉堆大小则退出
            if (currentNodeIndex >= binaryHeap.size()){
                break;
            }

            int leftChildIndex = currentNodeIndex  * 2 + 1;
            int rightChildIndex = currentNodeIndex  * 2 + 2;
            localQueue.add(leftChildIndex);
            localQueue.add(rightChildIndex);
            System.out.print(binaryHeap.get(currentNodeIndex) + "\t");
        }

        System.out.println();

        printBinaryHeap(binaryHeap, localQueue);

    }

    /**
     * 打印二叉堆
     * 打印二叉堆 二叉堆顺序顺序
     *          1
     *     3          2
     * 6     5    7      8
     * 打印为  1 3 2 6 5 7 8
     *
     * @param binaryHeap 二叉堆
     */
    public static void printBinaryHeap(List<Integer> binaryHeap){
        Queue<Integer> localChildQueue = new ArrayDeque<>();
        localChildQueue.add(0);
        printBinaryHeap(binaryHeap, localChildQueue);
    }


    /**
     * 计算二叉堆某个深度的最大索引
     *
     * @param high 二叉堆的深度
     * @return int 最大索引 返回的是已经减一后的值 所以以0开始的索引的集合或则数组可以直接使用
     */
    public static int binaryHeapMaxIndex(int high){
        int count = -1;
        for (int i = 0; i < high; i++) {
            count += Math.pow(2, i);
        }
        return count;
    }

    public static void main(String[] args) {
/*
        List<Integer> binaryHeap = List.of(1, 3, 2, 6, 5, 7, 8, 9, 10);
        printBinaryHeap(binaryHeap);

        List<Integer> newBinaryHeap = new ArrayList<>(List.of(1, 3, 2, 6, 5, 7, 8, 9, 10,0));
        up(newBinaryHeap);
        printBinaryHeap(newBinaryHeap);*/

        List<Integer> newBinaryHeap2 = new ArrayList<>(List.of(10, 3, 2, 6, 5, 7, 8, 9));
        down(newBinaryHeap2);
        printBinaryHeap(newBinaryHeap2);
    }

}
