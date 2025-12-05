package com.workouts.problems.algorithms;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class MergeTwoSortedLists {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        List<Integer> list1 = new LinkedList<>();
        list1.add(1);
        list1.add(3);
        list1.add(6);
        list1.add(10);
        list1.add(12);
        list1.add(13);
        list1.add(17);
        List<Integer> list2 = new LinkedList<>();
        list2.add(4);
        list2.add(7);
        list2.add(9);
        list2.add(11);
        list2.add(16);
        list2.add(18);
        list2.add(20);
        System.out.println(usingTwoPointers(list1,list2));
    }

    public static List<Integer> usingTwoPointers(List<Integer> list1,List<Integer> list2) {
        List<Integer> list3 = new LinkedList<>();

        int j = 0;
        int i = 0;
        List<Integer> loopListBig = list1;
        List<Integer> loopListSmall = list2;
        if(list1.size() < list2.size()) {
            loopListBig = list2;
            loopListSmall = list1;
        }
        for(i=0;i<loopListBig.size();i++) {
            System.out.println("here3=="+i);
            System.out.println("here4=="+j);
            if(j < loopListSmall.size()) {
                if (loopListBig.get(i) < loopListSmall.get(j)) {
                    System.out.println("here1=="+i);
                    list3.add(loopListBig.get(i));
                    if(i == loopListBig.size()-1) {
                        list3.add(loopListSmall.get(j));
                        i--;
                        j++;
                        System.out.println("come in here1=="+i);
                    }
                } else {
                    System.out.println("here2=="+j);
                    list3.add(loopListSmall.get(j));
                    j++;
                    i--;
                    System.out.println("here5=="+i);
                    if(j == loopListSmall.size()-1) {
                        list3.add(loopListBig.get(i));

                        System.out.println("come in here2=="+i);
                    }
                }
            } else {
                list3.add(loopListBig.get(i));
            }
            System.out.println(list3);
        }
        return list3;
    }
}
