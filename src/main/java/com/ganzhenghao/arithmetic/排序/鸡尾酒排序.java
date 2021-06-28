package com.ganzhenghao.arithmetic.排序;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * 冒泡排序的升级排序
 * 第一轮左往右排序
 * 第二轮从有往左排序 ...
 *
 *              2 3 4 5 6 7 8 1
 *  第一轮排序: 最后 1和8交换位置  2 3 4 5 6 7 1 8
 *  第二轮排序: 从右往左 8已经排好序了 所以从1开始 最终 1 2 3 4 5 6 7 8
 *
 *  鸡尾酒排序优势场景,大部分元素已经有序的情况
 *
 * 此版本的代码是原始实现 冒泡排序的有序区也可以用于优化此排序
 *
 * @author Ganzhenghao
 * @version 1.0
 * @date 2021/6/28 20:42
 */
public class 鸡尾酒排序 {

    public static void sort(List<Integer> list){
        int temp = 0;
        for (int i = 0; i < list.size() /2; i++) {
            //有序标记 每一轮的初始值都是true
            boolean isSorted = true;
            //奇数轮从左往右比
            for (int j = 1; j < list.size()-i-1; j++) {
                if (list.get(j) > list.get(j + 1)){
                    temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j + 1, temp);
                    //进入这里就代表有元素进行交换
                    isSorted = false;
                }
            }

            if (isSorted){
                break;
            }

            //偶数轮 将isSorted重置为true
            isSorted = true;
            //偶数轮从右往左比
            for (int j = list.size()-i-1; j > i; j--) {
                if (list.get(j) < list.get(j - 1)){
                    temp = list.get(j);
                    list.set(j, list.get(j-1));
                    list.set(j - 1, temp);
                    //进入这里就代表有元素进行交换
                    isSorted = false;
                }
            }

            if (isSorted){
                break;
            }


        }

    }


    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(List.of(2,3,4,5,6,7,8,1));
        sort(arrayList);
        System.out.println(arrayList);
    }

}
