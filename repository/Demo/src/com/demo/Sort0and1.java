package com.demo;

import java.util.Scanner;

public class Sort0and1 {
			public static void sort(int[] b, int size)
			{
				int i=0;
				int j= size-1;
					while(i<j)
					{
						while(b[i]==0 && i<size )
						{
							i++;
							//j--;
						}
						if(b[i]==1 && b[j]==0)
						{
							int temp =0;
							temp =b[i];
							b[i]=b[j];
							b[j]=temp;
							i++;
							j--;
						}
						while(b[j]==1 && j<size)
						{
							j--;
						}
					}
					for(int k=0; k<size;k++)
					{
				System.out.println(b[k]);
					}
					
				/*int i=0;
				Arrays.sort(b);
				System.out.println("array after sorting 0&1");
				for(i=0; i<size;i++)
				{
				System.out.println(b[i]);
				}*/
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
     
      sort(a,size);
	
	}
	}


