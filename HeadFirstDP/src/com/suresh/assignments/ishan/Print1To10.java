package com.suresh.assignments.ishan;

public class Print1To10 {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            if(i % 2 == 1){
                System.out.println("Odd:"+i);
            } else {
                System.out.println("Even:"+i);
            }
        }
    }

}
