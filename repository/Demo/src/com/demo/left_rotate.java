package com.demo;

import java.util.Scanner;

public class left_rotate {
	public static void l_rotate(int[] b , int size,int n)
	{
		int i,j=0;
		for(i=0;i<n;i++)
		{
			int temp= b[0];
			for( j=0; j<size-1;j++)
			{
				b[j]= b[j+1];
			}
			b[j]=temp;
		}
		for(i=0;i<size;i++)
		{
			System.out.println(b[i]);
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
      System.out.println("enter the no of times to rotate the array\n");
      int n = sc.nextInt();
      l_rotate(a,size,n);
	}

}
