package com.ganzhenghao.arithmetic.排序;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 冒泡排序
 * 当一轮遍历后 没有元素发生交换 则证明已经排好序了
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/28 9:03
 */
public class 冒泡排序_v2 {


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
        for (int i = 1; i <= list.size() - 1; i++) {

            System.out.println("第 " + i + " 轮排序!");

            //当有元素交换后 将此改为false
            boolean flag = true;
            //计数 判断了几次
            int count = 0;
            //二层循环 每轮比较的次数实际上是 n - 轮数   这里的减一操作是因为索引从0开始
            for (int j = 0; j <= list.size() - i  - 1; j++) {
                count++;
                if (list.get(j) > list.get(j + 1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    //进入这里就代表铀元素进行交换
                    flag = false;
                }
            }
            System.out.println("此轮进行了 " + count + "次判断!");
            //如果没有元素发生交换 则代表排序好了 此时不用再次排序
            if (flag){
                break;
            }

        }

    };


    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>();

        while (set.size() < 10){

            set.add(RandomUtil.randomInt(100));

        }
        List<Integer> list = new ArrayList<>(set);
        System.out.println(list);

        冒泡排序_v2.sort(list);

        System.out.println(list);


        System.out.println("----------------- v1 和 v2 对比");

        List<Integer> arrayList1 = new ArrayList<>(List.of(1, 2, 3, 4, 10, 7, 5, 8, 6));
        List<Integer> arrayList2 = new ArrayList<>(List.of(1, 2, 3, 4, 10, 7, 5, 8, 6));

        冒泡排序_v1.sort(arrayList1);
        System.out.println(arrayList1);
        System.out.println("--");
        冒泡排序_v2.sort(arrayList2);
        System.out.println(arrayList2);


    }

}
