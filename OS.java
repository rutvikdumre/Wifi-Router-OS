import memory.MemoryManage;
import Process.ProcessManage;
import files.FileManage;
import java.util.*;
import java.io.IOException;

class Device
{
	String name; //Name of the device
	int nbits=0; //No of bits of downloads remaining.
	int size; //Storage available
  String[] fname=new String[10];
  int[] fsize=new int[10];
  int fctr=0;
}

class OS extends Device
{
  static int search(String arr[],String x)
{
  for(int i=0;i<arr.length;i++)
  {
    if(x.equals(arr[i]))
      return i;
  }
  return -1;
}

  static int search(Device arr[], String x)
  {
    for(int i=0;i<arr.length;i++)
    {
      if(x.equals(arr[i].name))
        return i;
    }
    return -1;
  }
  static void deleteObj(Device arr[], String x)
  {
    int n=arr.length;
    for(int i=0;i<n;i++)
    {
      if(arr[i].name==x)
      {
        for(int j=i;j<n-1;j++)
        {
          arr[j]=arr[j+1];
        }
      }
    }
  }
  public static void main(String arg[])
  {
    String fname[]=new String[100];
    int ctrf=0;
    int parg=1;
    int fargs=1;
    FileManage fobj=new FileManage();

    Device[] devices=new Device[10];
    for(int i=0;i<10;i++)
    {
      devices[i]=new Device();
    }
    int ctrdev=0;
    MemoryManage mobj=new MemoryManage();
    ProcessManage pobj=new ProcessManage();
    Scanner sc=new Scanner(System.in);
    boolean f=true;
    while(f)
    {
      System.out.println();
      System.out.println();
      System.out.println("Enter Choice:");
      System.out.println("1. Device Connection");//io
      System.out.println("2. Download");//PROCESS
      System.out.println("3. Create File");
      System.out.println("4. Router Config");
      System.out.println("5. Exit");
      int ch=mobj.input();

      switch(ch)
      {
        case 1:
          boolean f1=true;
          while(f1)
          {
            System.out.println();
            System.out.println();
          System.out.println("Enter Choice:");
          System.out.println("1. Connect");
          System.out.println("2. Disconnect");
          System.out.println("3. View connected devices");
          System.out.println("4. Exit");
          int ch1=mobj.input();
          switch(ch1)
          {
            case 1:
              if(ctrdev<=9)
                {
                  System.out.println("Enter Device name:");
                  String dname=sc.nextLine();
                  if(search(devices,dname)!=-1)
                  {
                    System.out.println("Select another device name");
                    break;
                  }
                  devices[ctrdev].name=dname;
                  System.out.println("Enter Storage size of Device:");
                  devices[ctrdev].size=mobj.input();
                  ctrdev++;
                }
              else
                System.out.println("Device limit reached");
              break;
            case 2:
                System.out.println("Enter Device name to be disconnected:");
                String s=sc.nextLine();
                if(search(devices,s)==-1)
                  System.out.println("Device not found");
                else
                {
                  deleteObj(devices,s);
									ctrdev--;
                }
                break;
            case 3:
              System.out.println("---------------Devices-----------");
              for(int i=0;i<ctrdev;i++)
              {
                System.out.println(devices[i].name);
              }
              break;
            case 4:
              f1=false;
              break;
            default:
              System.out.println("---------------Wrong input-----------");
              break;
          }
        }
        break;
        case 2:
        int dev=1;
        String arr[]=new String[10];
        int arr1[]=new int[10];
        int ctr=0;
        boolean f2=true;
        ctr=0;
        while(f2)
        {
          if(ctrdev!=0)
          {
            System.out.println("Select device:");
            for (int i=0;i<ctrdev;i++)
            {
              System.out.println((i+1)+". "+devices[i].name);
            }
            System.out.println((ctrdev+1)+". Exit");
            int s=mobj.input();
            if(s==(ctrdev+1))
              f2=false;
            else if(s>ctrdev)
              System.out.println("Wrong input");
            else
            {
              s--;
              System.out.println("Download size:");
              devices[s].nbits+=mobj.input();
            }
          }
          else{
            System.out.println("[No Devices Connected]");
            dev=0;
            break;
          }
        }
        for(int i=0;i<ctrdev;i++)
        {
          if(devices[i].nbits!=0)
            {
              arr[ctr]=devices[i].name;
              arr1[ctr]=devices[i].nbits;
              ctr++;
            }
        }
        if(dev!=0)
        switch(parg)
        {
          case 1:
          pobj.sjf(arr,arr1,ctr);
          break;
          case 2:
          pobj.rr(arr,arr1,ctr);
          break;
          case 3:
          pobj.fcfs(arr,arr1,ctr);
          break;
        }
        for(int i=0;i<10;i++)
        {
          devices[i].nbits=0;
        }
        break;
        case 3:
        f2=true;
        String[] narr=new String[ctrdev];
        int[] sarr=new int[ctrdev];
        while(f2)
        {
          System.out.println();
          System.out.println();
          System.out.println("Enter Choice:");
          System.out.println("1. Create");
          System.out.println("2. Delete");
          System.out.println("3. Show Files");
          System.out.println("4. Exit");
          int ch1=mobj.input();
          switch(ch1)
          {
            case 1:
            System.out.println();
            System.out.println();
              System.out.println("Enter File name:");
              String name=sc.nextLine();
              if(search(fname, name)!=-1)
              {
                System.out.println("File name already exists");
                break;
              }
              fname[ctrf]=name;
              System.out.println("Enter File size:");
              int size=mobj.input();
              for (int i=0;i<ctrdev;i++)
              {
                narr[i]=devices[i].name;
                sarr[i]=devices[i].size;
              }
              //for(int i=0;i<ctrdev;i++)
                //System.out.println(sarr[i]);
              String ans="";
              switch(fargs)
              {
                case 1:
                ans=mobj.best(size,ctrdev,narr,sarr);

                break;
                case 2:
                ans=mobj.worst(size,ctrdev,narr,sarr);
                break;
                case 3:
                ans=mobj.first(size,ctrdev,narr,sarr);
                //System.out.println("first");
                break;
              }

              if(ans!="null")
              {
                Device temp=devices[search(devices,ans)];
                temp.size-=size;
                temp.fname[temp.fctr]=name;
                temp.fsize[temp.fctr]=size;
                temp.fctr++;
                ctrf++;
              }

              break;
            case 3:
              System.out.println("-----------Files----------");
              for(int i=0;i<ctrdev;i++)
              {

                  System.out.println("Device: "+devices[i].name);
                  if(devices[i].fctr==0)
                    System.out.println("[No Files]");
                  for(int j=0;j<devices[i].fctr;j++)
                  {
                      System.out.println("File name: "+devices[i].fname[j]);
                      System.out.println("File size: "+devices[i].fsize[j]);
                  }
                  System.out.println("Space left: "+devices[i].size);
              }
              break;
            case 2:

            boolean f3=true;
            while(f3)
            {
              if(ctrf!=0)
              {
                System.out.println("Select Device:");
                for (int i=0;i<ctrdev;i++)
                {
                  if(devices[i].fctr!=0)
                    System.out.println((i+1)+" "+ devices[i].name);
                }
                int chd=mobj.input();
                try{
                  System.out.println("Select files:");
                  for(int j=0;j<devices[chd-1].fctr;j++)
                  {
                    System.out.println((j+1)+" "+ devices[chd-1].fname[j]);
                  }
                  int chf=mobj.input();
                  devices[chd-1].size+=devices[chd-1].fsize[chf-1];
                  devices[chd-1].fname[chf-1]=null;
                  devices[chd-1].fsize[chf-1]=0;
                  devices[chd-1].fctr--;
                  
                  ctrf--;

                  System.out.println("File deleted succesfully");
                  break;
                }
                catch(Exception e)
                {
                  System.out.println("Wrong Input");
                  break;
                }


              }
              else
              {
                System.out.println("No files saved on the network");
                break;
              }
            }
            break;
          case 4:
            System.out.println();
            f2=false;
            break;
          }
        }
        break;
        case 4:
          System.out.println("Enter login id:");
          String uid=sc.nextLine();
          System.out.println("Enter password:");
          String psw=sc.nextLine();
          if(uid.equals("admin") && psw.equals("pass@123"))
          {
            System.out.println("-------------WELCOME TO KERNEL MODE-----------");
            System.out.println("1. Change download preferences.");
            System.out.println("2. Change files preferences.");
            System.out.println("3. Exit Kernel mode");
            int kch=mobj.input();
            switch(kch)
            {
              case 1:
              System.out.println("1. Shortest Job First (SJF) [Default]");
              System.out.println("2. Round Robin (RR)");
              System.out.println("3. First Come First Serve (FCFS)");
              parg=mobj.input();
              System.out.println("[Changes Applied succesfully]");
              break;
              case 2:
              System.out.println("1. Best Fit [Default]");
              System.out.println("2. Next Fit");
              System.out.println("3. Worst Fit");
              fargs=mobj.input();
              System.out.println("[Changes Applied succesfully]");
              case 3:
              break;
              default:
              System.out.println("Wrong input");

            }
          }
          else
          {
            System.out.println("ACCESS DENIED");
          }
          break;
        case 5:
          f=false;
          break;
        default:
        System.out.println("Wrong Input");
      }
    }
  }
}
