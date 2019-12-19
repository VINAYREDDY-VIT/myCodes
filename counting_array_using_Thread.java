/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package practice;
import java.util.Scanner;

/**
 *
 * @author reddy
 */
class hundreed implements Runnable {
    private int[] a;
    private int count=0,start,end;
    public hundreed(int arr[],int start,int end){
       a=arr;
       this.start=start;
       this.end=end;
    }
    public void run(){
       for(int i=start;i<=end;i++){
           if(a[i]==100)
               count++;
       }
    }
    public int getValue(){
         return count;
     }
}
public class arraythread{
    public static void main(String[] krishna){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int half = n/2;
        int count=0;
        hundreed obj1 = new hundreed(arr,0,half);
        hundreed obj2 = new hundreed(arr,half+1,n-1);
        Thread t1 = new Thread(obj1);
        Thread t2 = new Thread(obj2);
        t1.start();
        t2.start();
        try{
            t1.join();
            t2.join();
        }
        catch(Exception e){
            //System.out.println(e);
            return;
        }
        count+=obj1.getValue();
        count+=obj2.getValue();
        System.out.println("Winners : "+count);
    }
}
