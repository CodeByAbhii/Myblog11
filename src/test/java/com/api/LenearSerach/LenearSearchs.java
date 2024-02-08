package com.api.LenearSerach;

import java.util.Scanner;

public class LenearSearchs {
    public static void main(String[] args) {

        Scanner scan= new Scanner(System.in);
        int size=scan.nextInt();
        int[] number=new int[size];

        //for input

        for (int i = 0; i <size ; i++) {
            number[i]=scan.nextInt();
        }

        // for Output

        int x= scan.nextInt();
        for (int i = 0; i < size; i++) {
            if(number[i]==x){
                System.out.println("x found is index :"+i);
            }
        }

    }
}
