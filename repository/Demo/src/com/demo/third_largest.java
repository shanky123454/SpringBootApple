package com.demo;

import java.util.Arrays;
import java.util.Scanner;

public class third_largest {

	public static void main(String[] args) {
		System.out.println("enter the size of the array");
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] a= new int[num];
      System.out.println("enter the elemnts of the array ");
      for(int i=0 ; i<num; i++)
      {
          a[i] = sc.nextInt();
      }
      int size = a.length;
      System.out.println("elemnts of the array is ");
      for (int i=0; i<size ; i++) {
          System.out.println(a[i]);
      }
      System.out.println("no. of elemnts present in array is:" + size);
      Arrays.sort(a);
      System.out.println(" array after sorted");
      for(int i=0; i<size;i++)
      {
    	  System.out.println(a[i]);
      }
    System.out.println("largest 3 element is:" + a[2]);
	}

}
