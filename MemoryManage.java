
package memory;
import java.util.*;
public class MemoryManage
{
  static String mem[]={"\nAddress:Partition #1 (size=1)\n","\nAddress:Partition #2(size=100)\n","\nAddress:Partition #3(size=150)\n","\nAddress:Partition #4(size=50)\n","\nAddress:Partition #5(size=25)\n"};
  static int left[]={1,100,150,50,25};
  static String p[]={"has the following size of processes","has the following size of processes","has the following size of processes","has the following size of processes","has the following size of processes"};

      void bubbleSort(int arr[], String arr1[], String arr2[])
      {
          int n = arr.length;
          for (int i = 0; i < n-1; i++)
              for (int j = 0; j < n-i-1; j++)
                  if (arr[j] > arr[j+1])
                  {

                      int temp = arr[j];
                      arr[j] = arr[j+1];
                      arr[j+1] = temp;
                      String t = arr1[j];
                      arr1[j] = arr1[j+1];
                      arr1[j+1] = t;
                      t = arr2[j];
                      arr2[j] = arr2[j+1];
                      arr2[j+1] = t;
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
  static void disp(int n,String arr[])
  {
    System.out.println();
    for(int i=0;i<n;i++)
    {
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }
  public int input()
  {
    Scanner sc=new Scanner(System.in);
    int x;
    while(true)
    {
    try
    {
      x=sc.nextInt();
      if(x<0)
      {
        System.out.println("Wrong input enter again:");
        x=input();
      }

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
  public String first(int arr, int n,String mem[],int left[])
  {
    int ctr=0,flag=0;
    int j;
      flag=0;
      for(j=0;j<5;j++)
      {
        if(arr<=left[ctr])
        {
          p[ctr]+="\n"+ arr;
          left[ctr]=left[ctr]-arr;
          flag=1;
          ctr=(ctr+1)%5;
          break;
        }
        ctr=(ctr+1)%5;
      }
      if(flag==0)
      {
        System.out.println("Not enough memory for "+arr);
        return "null";
      }
      else
      {
        System.out.println("File saved at: " + mem[j]);
        return mem[j];
      }



  }
  public String best(int arr,int n,String mem[],int left[])
  {

    MemoryManage obj=new MemoryManage();
    //obj.bubbleSort(left,mem,p);
    for (int i = 0; i < n-1; i++)
        for (int j = 0; j < n-i-1; j++)
            if (left[j] > left[j+1])
            {

                int temp = left[j];
                left[j] = left[j+1];
                left[j+1] = temp;
                String t = mem[j];
                mem[j] = mem[j+1];
                mem[j+1] = t;

            }



      int j;
      int flag=0;
      //disp(n,mem);
      for (j=0;j<n;j++)
      {
        if(arr<=left[j])
        {
          p[j]+="\n"+ arr;
          left[j]=left[j]-arr;
          flag=1;
          break;
        }
      }
      if(flag==0)
      {
        System.out.println("Not enough memory for "+arr);
        return "null";
      }

      else
      {
        System.out.println("File saved at: " + mem[j]);
        return mem[j];
      }


  }
  public String worst(int arr,int n,String mem[],int left[])
  {
    MemoryManage obj=new MemoryManage();
    obj.bubbleSort(left,mem,p);

      int flag=0,j;
      for (j=n-1;j>=0;j--)
      {
        if(arr<=left[j])
        {
          p[j]+="\n"+ arr;
          left[j]=left[j]-arr;
          flag=1;
          obj.bubbleSort(left,mem,p);
          break;
        }
      }
      if(flag==0)
      {
        System.out.println("Not enough memory for "+arr);
        return "null";
      }
      else
      {
        System.out.println("File saved at "+ mem[j]);
        return (mem[j]);
      }
  }
}
