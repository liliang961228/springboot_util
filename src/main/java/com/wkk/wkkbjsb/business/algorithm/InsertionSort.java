package com.wkk.wkkbjsb.business.algorithm;

import java.util.Arrays;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.algorithm
 * @Description : 插入排序
 * @Create on : 2021/7/14 11:21
 * @email : lgy961228@gamil.com
 **/
public class InsertionSort {

    public static void main(String[] args) {

        int[] a = new int[]{5, 9, 12, 3, 7, 8, 6};

        for (int i = 1; i < a.length; i++) {

            if (a[i] < a[i - 1]) {
                int j = i - 1;
                int number = a[i];
                while (j >= 0 && number < a[j]) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = number;
            }
        }

        System.out.println(Arrays.toString(a));
    }

}
