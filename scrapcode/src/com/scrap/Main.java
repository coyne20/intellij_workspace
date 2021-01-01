package com.scrap;

import java.util.Arrays;

public class Main {

    private static String test1 = "100D1234";
    private static String test2 = "25W4321";
    private static String test3 = "5M2468";
    private static String test4 = "Y";
    private static String test5 = "A";

    public static void main(String args[]){

        System.out.println("Period: "+getPeriod(test1));
        System.out.println("Period Multiplier: "+getPeriodMultiplier(test1));
        System.out.println("Period: "+getPeriod(test2));
        System.out.println("Period Multiplier: "+getPeriodMultiplier(test2));
        System.out.println("Period: "+getPeriod(test3));
        System.out.println("Period Multiplier: "+getPeriodMultiplier(test3));
        System.out.println("Period: "+getPeriod(test4));
        System.out.println("Period Multiplier: "+getPeriodMultiplier(test4));
        System.out.println("Period: "+getPeriod(test5));
        System.out.println("Period Multiplier: "+getPeriodMultiplier(test5));

    }

    public static String getPeriod(String test){
        String period = new String();

        Character[] values = {'D', 'W', 'M', 'Y'}; // Change to enum maybe

        for(int i=0; i < test.length(); i++){
            if(Character.isLetter(test.charAt(i))){
                if(Arrays.asList(values).contains(test.charAt(i))){
                    period = String.valueOf(test.charAt(i));
                    break;
                }
            }
        }

        return period;
    }

    public static String getPeriodMultiplier(String test){
        Character[] values = {'D', 'W', 'M','Y'}; // Change to enum maybe
        int index = 0;
        //String period = "";

        for(int i=0; i < test.length(); i++){
            if(Character.isLetter(test.charAt(i))){
                if(Arrays.asList(values).contains(test.charAt(i))){
                    index = i;
                    //period = String.valueOf(test.charAt(i));
                    break;
                }
            }
        }

        return test.substring(0,index);
    }

}
