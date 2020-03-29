package files;
import java.util.*;
public class FileManage
{
  Scanner sc=new Scanner(System.in);
  int n=100,ctr,s;
  int start[]=new int[n];
  String chain[]=new String[n];
  String fat[]= new String[34];
  int files[]= new int[n];
  String name[]=new String[n];
  static void deleteIndex(int arr[], int n, int x)
    {
        for(int i=0;i<n;i++)
        {
          if(i==x)
          {
            for(int j=i;j<n-1;j++)
            {
              arr[j]=arr[j+1];
            }
          }
        }
    }
  public static void deleteElement(int arr[], int n, int x)
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
    public static void deleteElement(String arr[], int n, String x)
      {
          for(int i=0;i<n;i++)
          {
            if(arr[i].equals(x))
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
void ins()
{

  System.out.println("Enter no of files");
  while(true)
  {
    n=input();
    if(n>=0)
    break;
    System.out.println("Enter non negative no");
  }

  for(int i=0;i<n;i++)
  {
    System.out.println("Enter file name:");
    name[i]=sc.nextLine();
    System.out.println("Enter file length:");
    files[i]=input();
  }

  for (int i=0;i<34;i++)
  {
    fat[i]="0";
  }
  for(int i=0;i<n;i++)
  { System.out.println("---------Process "+name[i]+"--------");
    ctr=0;
    s=0;
    chain[i]="";
    while(ctr<files[i]&&s<34)
    {
      if(fat[s]=="0")
      {
        chain[i]=chain[i]+" "+s;
        ctr++;
        fat[s]=name[i];
      }
      s++;
    }
    if(ctr<files[i])
    System.out.println("Not enough memory");
  }
  System.out.println("-----DISK----");
  for (int i=0;i<34;i++)
  {
    if((i)%4!=0)
    System.out.print(fat[i]+" ");
    else
    {System.out.println();
      System.out.print(fat[i]+" ");
    }
  }
  System.out.println();
  System.out.println("-----------Fat Table--------");
  for(int i=0;i<n;i++)
  {
      System.out.println("Process name:"+name[i]);
      System.out.println("Blocks Used: "+chain[i]);
      System.out.println("length: " + files[i]);
      System.out.println("------------------------");
  }
}
public int index(String arr[],String n)
{
  for(int i=0;i<arr.length;i++)
  {
    if(n.equals(arr[i]))
      return i;
  }
  return -1;
}
void delete()
{

  System.out.println("Enter name of the process to be deleted:");
  String p=sc.nextLine();
  System.out.println("Process to be deleted: "+p);
  int flag=0;
  for (int i=0;i<n;i++)
  {
    if(name[i].equals(p))
    flag=1;
  }
  if(flag==0)
  {
    System.out.println("Process not found");
  }
  else
  {
    for (int i=0;i<34;i++)
    {
      if(p.equals(fat[i]))
      fat[i]="0";
    }
    deleteIndex(files,n,index(name,p));
    deleteElement(chain,n,chain[index(name,p)]);
    deleteElement(name,n,p);
    n--;
  }
    System.out.println();
    System.out.println("-----DISK----");
    for (int i=0;i<34;i++)
    {
      if((i)%4!=0)
      System.out.print(fat[i]+" ");
      else
      {System.out.println();
        System.out.print(fat[i]+" ");
      }
    }
    System.out.println();
    System.out.println("-----------Fat Table--------");
    for(int i=0;i<n;i++)
    {
        System.out.println("Process name:"+name[i]);
        System.out.println("Blocks Used: "+chain[i]);
        System.out.println("length: " + files[i]);
        System.out.println("------------------------");
    }
  }

public static void main(String args[])
{
  lab9 o=new lab9();
  o.ins();
  o.delete();
}
}
