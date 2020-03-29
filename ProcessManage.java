package Process;
import memory.*;
import java.util.*;
public class ProcessManage
{
  public static void fcfs(String arr[], int time[],int n)
  {

  int wt=0;
  int sum=0;
  System.out.println("-------------FCFS--------------");
    for(int i=0;i<n;i++)
  {
    System.out.println("Device "+ arr[i] +" Size: "+ time[i]+" Wait time: "+wt);
    wt+=time[i];
    sum+=(time[i]+wt);
  }
  //System.out.print("\nAvg waiting time: "+wt/n+" Avg Tat: "+sum/n);
  }
   static void bubbleSort(String arr[],int time[], int n)
    {
        for (int i = 0; i < n-1; i++)
            for (int j = 0; j < n-i-1; j++)
                if (time[j] > time[j+1])
                {
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
          int temp1 = time[j];
                    time[j] = time[j+1];
                    time[j+1] = temp1;
                }
    }
  public static void sjf(String arr[], int time[],int n)
  {
  int wt=0;int sum=0;
    bubbleSort(arr,time,n);
  System.out.println("-------------SJF--------------");
  for(int i=0;i<n;i++)
  {
    System.out.println("Device "+ arr[i] +" Download size: "+ time[i]+" Wait time: "+wt);
    wt+=time[i];
    sum+=(time[i]+wt);
  }
  //System.out.print("\nAvg waiting time: "+wt/n+" Avg Tat: "+sum/n);
  }
  public static void rr(String arr[],int time[], int n)
  {
  int x[]=new int[n];
  for (int i=0;i<n;i++)
    x[i]=0;
  int ttime[]=new int[n];
  for (int i=0;i<n;i++)
    ttime[i]=time[i];

  System.out.println("-------------RR--------------");
  int i=0;
  int wt=0;
  int ctr=0;
  int sum=0;
  int qt=2;
  int flag=0;
  int temp;
  int temp1=0;
  while(true)
  {

    if(ttime[i]!=0)
    {
    ttime[i]-=qt;
    if(ttime[i]<0)
    {
      temp1=-ttime[i];
      temp=ttime[i];
      ttime[i]=0;
      flag=1;
    }
    else
    temp=ttime[i]-qt;

    System.out.println("Device "+ arr[i] +" Size: "+ time[i]+" Wait time: "+wt+" Download size left: "+ ttime[i]);
    if(flag==1)
    wt+=(qt-temp1);
    else
    wt+=(qt);
    }
    else
    ctr++;
    i=(i+1)%n;
    sum+=(time[i]+wt);
    int flag1=0;
    for(int k=0;k<n;k++)
    {
      if (ttime[k]!=x[k])
        flag1=1;
    }
    if(flag1==0)
    break;
  }
//System.out.print("Finished");
   }
  public static void main(String args[])
  {
  int n;
  int sum=0;
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter no of Processes: ");
  n=sc.nextInt();
  String arr[]=new String[n];
  int time[]=new int[n];
  for (int i =0;i<n;i++)
  {
    System.out.println("Enter Processe: ");
    arr[i]=sc.next();
    System.out.println("Enter Time: ");
    time[i]=sc.nextInt();
    sum+=time[i];
  }
  int ch=-1;
  while(ch!=0)
  {
  System.out.println("1)FCFS\n2)SJF\n3)RR\n0)EXIT");
  ch=sc.nextInt();
  switch(ch)
  {
  case 1:
  fcfs(arr,time,n);
  break;
  case 2:
  sjf(arr,time,n);
  break;
  case 3:
  rr(arr,time,n);
  break;
  case 0:
  break;
  default:
  System.out.println("WRONG INPUT");
  }
  System.out.println("\n\n----------------	THANK YOU 	---------------");
  }
}
}
