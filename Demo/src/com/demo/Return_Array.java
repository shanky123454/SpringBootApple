package com.demo;
import java.util.*;

public class Return_Array {
	public static int[] frequencycount(int[] a, int size)
    {
        int[] b = new int[size];
        b=a.clone();
        int ans=0;
        int i;
        int visited=-1;
        int temp=0;
        for( i=0; i<size;i++)
        {
             int count=1;
            for(int j =i+1; j<size;j++)
            {
                if(b[i]== b[j])
                {
                    b[j]=visited;
                    count++;
                }
            }
            if(b[i]!=visited)
               {
                 b[i]=count;
               }
        }
         
          return b; 
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
      System.out.println();
      int[] arr = new int[2] ;
     int [] c= frequencycount(a,size);
     for(int l=0; l<c.length; l++)
     {
    	 if(c[l]==2) 
    	 {
    	 arr[l]= a[l];
    	 
    	 } 
     }
     System.out.print(Arrays.toString(arr));
     
  }
	}



