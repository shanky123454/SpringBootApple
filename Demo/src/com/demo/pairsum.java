package com.demo;

import java.util.Scanner;

public class pairsum {
				public static void pair(int[] b, int size, int sum)
				{
					//outerloop:
					for(int i=0 ;i<size;i++)
					{
						for(int j=i+1; j<size; j++)
						{
							for(int k=j+1; k<size;k++)
							{
							if(b[i]+b[j]+b[k]== sum)
							  {
								System.out.println(b[i] + "+" + b[j]+"+" + b[k] + "="+ sum);
								//break outerloop;
							  }
						   }
						}
					}
				}
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
      System.out.println("enter the sum to be required ");
      int sum =sc.nextInt();
      pair(a,size,sum);
	
	}

}
