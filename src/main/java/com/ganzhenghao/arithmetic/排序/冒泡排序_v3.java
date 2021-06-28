package com.ganzhenghao.arithmetic.排序;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 冒泡排序
 * 当一轮遍历后 没有元素发生交换 则证明已经排好序了
 *
 * v3 : 实际有序区可能会比逻辑有序区大
 *         所以记录每一轮最后依次交换的位置
 *         该位置就是实际有序区的左边界
 *
 *         3 2 1 4 5 6
 *         第一轮交换: 变成 2 1 3 4 5 6
 *         逻辑有序区的大小 1 也就是最后
 *         而实际有序区的大小应该是 4 因为 3 4 5 6 都是有序的
 *         本轮最后一次交换是 3 和 1交换 因此左边界为 2 (索引从 1 开始)
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/28 9:03
 */
public class 冒泡排序_v3 {


    /**
     *  由小到大
     *
     * @param list 列表
     */
    public static void sort(List<Integer> list){

        if (ObjectUtil.isEmpty(list) || list.size() == 1){
            return;
        }

        // 1 2 3 4 5
        // 1 2 3 4
        // 1 2 3
        // 1 2
        // 1  只剩一个数的时候无需比较
        //第一层循环 有n个数  则需要比较 n-1 轮 注意: i从 1 开始

        //定义最后依次交换索引的变量
        int lastExchangeIndex = 0;
        //无序区的边界
        int sortBorder = list.size() - 1;
        for (int i = 1; i <= list.size() - 1; i++) {

            System.out.println("第 " + i + " 轮排序!");

            //当有元素交换后 将此改为false
            boolean flag = true;
            //计数 判断了几次
            int count = 0;
            for (int j = 0; j < sortBorder ; j++) {
                count++;
                if (list.get(j) > list.get(j + 1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    //进入这里就代表有元素进行交换
                    flag = false;
                    //记录 交换位置
                    lastExchangeIndex = j;
                }
            }
            System.out.println("此轮进行了 " + count + "次判断!");
            //如果没有元素发生交换 则代表排序好了 此时不用再次排序
            if (flag){
                break;
            }
            //将最后一次交换的值赋予有序区边界值
            sortBorder = lastExchangeIndex;

        }



    };


    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        while (set.size() < 10){

            set.add(RandomUtil.randomInt(100));

        }
        List<Integer> list = new ArrayList<>(set);
        System.out.println(list);

        冒泡排序_v3.sort(list);

        System.out.println(list);


        System.out.println("----------------- v1 和 v2 , v3对比");

        List<Integer> arrayList1 = new ArrayList<>(List.of(5,4,3,2,1,6,7,8,9,10));
        List<Integer> arrayList2 = new ArrayList<>(List.of(5,4,3,2,1,6,7,8,9,10));
        List<Integer> arrayList3 = new ArrayList<>(List.of(5,4,3,2,1,6,7,8,9,10));


        冒泡排序_v1.sort(arrayList1);
        System.out.println(arrayList1);
        System.out.println("--");
        冒泡排序_v2.sort(arrayList2);
        System.out.println(arrayList2);
        System.out.println("--");
        冒泡排序_v3.sort(arrayList3);
        System.out.println(arrayList2);

    }

}
