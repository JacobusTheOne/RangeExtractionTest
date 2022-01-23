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

        ArrayList<Integer> a = new ArrayList<Integer>(input);
        int[] args = a.stream().mapToInt(i->i).toArray();
        if(args.length == 1)
            return Integer.toString(args[0]);
        else if(args.length == 2)
            return Integer.toString(args[0]) + ", " + Integer.toString(args[1]);
        String completeString = "";
        int start = 0;
        int step1 = 0;
        int step2 = 1;
        int count = 0;
        int difference = 0;
        Boolean isDifference = false;
        while(start<args.length){
            while(step2<args.length){
                difference = Math.abs(args[step2]) - Math.abs(args[step1]);
                if(difference==-1 || difference==1){
                    step1++; step2++; count++;
                } else {
                    isDifference = true;
                    break;
                }
            }
            //We are at the end of the sequence and a range needs to be extracted with no difference
            if(step2 == args.length && count > 1 && isDifference == false){
                completeString += Integer.toString(args[start]) + "-" + Integer.toString(args[step2-1]);
                break;
            //We at end of the sequence and range needs to be extracted, with a difference
            } else if(step2 == args.length && count > 1) {
                completeString += Integer.toString(args[start]) + "-" + Integer.toString(args[step1]) + ", " +
                        Integer.toString(args[step2]);
                break;
            //End of sequence and no sequence needs to be extracted
            } else if(step2 == args.length && isDifference == true) {
                completeString += Integer.toString(args[start]) + ", " + Integer.toString(args[step2]);
                break;
            //Start is at the end of the sequence
            } else if(step2 == args.length){
                completeString += Integer.toString(args[start]);
                break;
            //Not end of sequence but range needs to be extracted
            } else if (count > 1) {
                completeString += Integer.toString(args[start]) + "-" + Integer.toString(args[step1]) + ", ";
                start = step2;
                step1 = start;
                step2 = start + 1;
                count = 0;
                isDifference = false;
                //Not end of sequence two numbers are in sequence
            }  else if (count == 1){
                completeString +=  Integer.toString(args[start]) + ", ";
                start = step1;
                count = 0;
                isDifference = false;
                //Not end of sequence
            } else {
                completeString += Integer.toString(args[start]) + ", ";
                start = step2; step1 = start; step2 = start + 1;
                count = 0;
                isDifference = false;
            }
        }
        return completeString;

    }
}
