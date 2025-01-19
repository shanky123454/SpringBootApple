package com.demo;

import java.util.Scanner;

public class desceding {
	public static void desc(int[] b, int size)
	{
		int temp=0;
		//int max = b[0];
		for(int i=0; i<b.length; i++)
		{
			for(int j=i+1; j<b.length;j++)
			{
			if(b[j]> b[i])
			  {
				temp=b[i];
				b[i]=b[j];
				b[j]= temp;
			  }
		    }
	    }
		for(int j=0; j<b.length;j++)
		{
			System.out.println(b[j]);
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
      desc(a,size);
	}

}
