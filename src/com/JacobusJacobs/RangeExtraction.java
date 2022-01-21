package com.JacobusJacobs;
import java.util.ArrayList;
import java.util.Collection;

public class RangeExtraction implements NumberRangeSummarizer {

    @Override
    public Collection<Integer> collect(String input) {
        ArrayList<Integer> listOfNumbers = new ArrayList<Integer>();
        if(input.length()==0)
            return listOfNumbers;
        String[] listOfStrings = input.split("[,]");
        for(int i = 0; i < listOfStrings.length; i++){
            listOfNumbers.add(Integer.valueOf(listOfStrings[i]));
        }
        System.out.println(listOfNumbers);
        return listOfNumbers;
    }

    @Override
    public String summarizeCollection(Collection<Integer> input) {
        int firstOne = 0;
        int thirdOne = 2;
        int lastNum = 0;
        ArrayList<Integer> a = new ArrayList<Integer>(input);
        int[] args = a.stream().mapToInt(i->i).toArray();
        String comString = "";
        if(args.length == 1)
            return Integer.toString(args[0]);
        else if(args.length == 2)
            return comString = Integer.toString(args[0]) + ", " + Integer.toString(args[1]);
        while(firstOne < args.length && thirdOne < args.length){
            if((Math.abs(args[firstOne])-Math.abs(args[thirdOne-1])== 1 ||
                    Math.abs(args[firstOne])-Math.abs(args[thirdOne-1])== -1) &&
                    (Math.abs(args[thirdOne-1])-Math.abs(args[thirdOne])== 1 ||
                            Math.abs(args[thirdOne-1])-Math.abs(args[thirdOne])== -1))
            {
                lastNum = thirdOne;
                while(thirdOne<args.length)
                {
                    if((Math.abs(args[thirdOne-1])- Math.abs(args[thirdOne]))==1 ||
                            (Math.abs(args[thirdOne-1])- Math.abs(args[thirdOne]))==-1 ){
                        lastNum = thirdOne;
                        thirdOne++;
                    } else {
                        break;
                    }
                }
                comString += Integer.toString(args[firstOne])  + "-" + Integer.toString(args[lastNum]) + ", ";
                firstOne = lastNum + 1;
                thirdOne = lastNum + 3;
                if((args.length-firstOne)==2){
                    comString += Integer.toString(args[firstOne]) + ", " + Integer.toString(args[firstOne+1]);
                    break;
                } else if ((args.length-firstOne)==1){
                    comString += Integer.toString(args[firstOne]);
                    break;
                }
            } else {
                comString += Integer.toString(args[firstOne]) + ", ";
                firstOne++;
                thirdOne++;
                if((args.length-firstOne)==2){
                    comString += Integer.toString(args[firstOne]) + ", " + Integer.toString(args[firstOne+1]);
                    break;
                } else if ((args.length-firstOne)==1){
                    comString += Integer.toString(args[firstOne]);
                    break;
                }
            }
        }
        String checkComma = "";
        if(comString.length()!=0)
         checkComma = comString.substring(comString.length()-2);
        if(checkComma.contains(", ")) {
            return comString.substring(0, comString.length() - 2);
        }
        return comString.substring(0,comString.length());
    }
}
