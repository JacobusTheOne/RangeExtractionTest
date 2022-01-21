package com.JacobusJacobs;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String temp = "1,3,6,7,8,12,13,14,15,21,22,23,24,31";
        RangeExtraction rangeExtraction = new RangeExtraction();
        ArrayList<Integer> arrayList = new ArrayList<Integer>(rangeExtraction.collect(temp));
        System.out.println(rangeExtraction.summarizeCollection(arrayList));
        System.out.println(temp.charAt(temp.length()-2));
    }
}
