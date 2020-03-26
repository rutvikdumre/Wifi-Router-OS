package io;
import java.util.*;
public class lab8
{
  static void bubbleSort(int arr[])
  {
      int n = arr.length;
      for (int i = 0; i < n-1; i++)
          for (int j = 0; j < n-i-1; j++)
              if (arr[j] > arr[j+1])
              {

                  int temp = arr[j];
                  arr[j] = arr[j+1];
                  arr[j+1] = temp;
              }
  }
  static void deleteElement(int arr[], int n, int x)
    {
        for(int i=0;i<n;i++)
        {
          if(arr[i]==x)
          {
            for(int j=i;j<n-1;j++)
            {
              arr[j]=arr[j+1];
            }
          }
        }
    }
  static void disp(int n,int arr[])
  {
    System.out.println();
    for(int i=0;i<n;i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
  static int input()
  {
    Scanner sc=new Scanner(System.in);
    int x;
    while(true)
    {
    try
    {
      x=sc.nextInt();
      break;
    }
    catch(Exception e)
    {
      System.out.println("Wrong input try again:");
      sc.next();
    }
    }
    return x;
  }
  public int index(int arr[],int n)
  {
    for(int i=0;i<arr.length;i++)
    {
      if(arr[i]==n)
        return i;
    }
    return -1;
  }
  void ele(int arr[],int start,int n)
  {

    int seek=0;
    int ctr=0;
    int i=index(arr,start);
    int temp=arr[i];
    if(i==-1)
    System.out.println("Start does not exist");
    System.out.println("Elevator seek time first:");
    int a=arr[0];
    int b=arr[n-1];
    if(temp-a<=b-temp)
    {
      while(ctr!=n)
      {
        if(i<0)
        break;
        if(i>0)
        seek+=arr[i]-arr[i-1];
        temp=arr[i];
        System.out.println(arr[i]);
        i--;
        ctr++;
        deleteElement(arr,n,temp);
      }
      i++;
      while(ctr!=n)
      {
        if(i<n-1)
        seek+=arr[i+1]-arr[i];
        temp=arr[i];
        System.out.println(arr[i]);
        ctr++;
        deleteElement(arr,n,temp);
      }
    }
    else
    {
      while(ctr!=n)
      {
        if(i<n)
        seek+=arr[i+1]-arr[i];
        if(ctr==b-temp)
        break;
        int temp1=arr[i];
        System.out.println(arr[i]);
        ctr++;
        deleteElement(arr,n,temp1);
      }
      i=n-ctr-1;
      while(ctr!=n)
      {

        temp=arr[i];
        System.out.println(arr[i]);
        i--;
        ctr++;
        deleteElement(arr,n,temp);
      }
    }

    System.out.println("Seek time: "+ seek);
  }
  void Short(int arr[], int start,int n)
  {
    int temp=-1;
    int seek=0;
    int ctr=0;
    int i=index(arr,start);
    if(i==-1)
    System.out.println("Start does not exist");
    System.out.println("Shortest seek time first:");
    while(ctr!=n)
    {
      temp=arr[i];
      System.out.println(arr[i]);
      if(i==0)
      {
        seek+=arr[i+1]-temp;
      }
      else if(i==n-1)
      {
        seek+=temp-arr[i-1];
        i--;
      }
      else
      {
        int a=temp-arr[i-1];
        int b=arr[i+1]-temp;
        if(a<=b)
        {
          seek+=a;
          i--;
        }
        else
        {
          seek+=b;
        }
      }
      ctr++;
      deleteElement(arr,n,temp);
    }
    System.out.println("Seek time: "+ seek);
  }
  public static void main(String args[])
  {
    int start;
    lab8 o=new lab8();
    int n=-1;
    while(n<0)
    {
      System.out.println("Enter no of memory loactions:");
      n=input();
      if(n<0)
      System.out.println("Wrong Input");
    }
    int arr[]=new int[n];
    int temp[]=new int[n];
    System.out.println("Enter Sequence:");
    for(int i=0;i<n;i++)
    {
      arr[i]=input();
      temp[i]=arr[i];
    }
    System.out.println("Enter Start:");
    start=input();
    bubbleSort(arr);
    disp(n,arr);
    o.Short(arr,start,n);
    disp(n,temp);
    o.ele(temp,start,n);

  }
}
