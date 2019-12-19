/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package practice;
import java.util.*;

/**
 *
 * @author reddy
 */
class calculate extends Thread {
    private int[][] a;
    private int[][] b;
    private int val=0;
    private int row;
    private int col;
    private int acol;
    private int brow;
   public calculate(int[][] aa,int[][] bb,int r,int co,int ac,int br){
       a=aa;
       b=bb;
       row=r;
       col=co;
       acol=ac;
       brow=br;
   }
   public void run(){
       for(int i=0;i<acol;i++){
           for(int j=0;j<brow;j++){
               val+=a[row][i]*b[j][col];
           }
       }
   }
    public int get(){
        return val;
    }
}
public class matrixmultiplication{
    public static void main(String[] krishna){
        Scanner sc = new Scanner(System.in);
        int ar = sc.nextInt();
        int ac = sc.nextInt();
        int br = sc.nextInt();
        int bc = sc.nextInt();
        int a[][] = new int[ar][ac];
        int b[][] = new int[br][bc];
        int i,j;
        for(i=0;i<ar;i++){
            for(j=0;j<ac;j++){
                a[i][j]=sc.nextInt();
            }
        }
        for(i=0;i<br;i++){
            for(j=0;j<bc;j++){
                b[i][j]=sc.nextInt();
            }
        }
        calculate list[][] = new calculate[ar][bc];
        Thread thread[][] = new Thread[ar][bc];
        for(i=0;i<ar;i++){
            for(j=0;j<bc;j++){
                calculate obj = new calculate(a,b,i,j,ac,br);
                Thread obj1 = new Thread(obj);
                list[i][j]=obj;
                thread[i][j]=obj1;
                obj1.start();
            }
        }
        for(i=0;i<ar;i++){
            for(j=0;j<bc;j++){
                try{
                    thread[i][j].join();
                }
                catch(Exception e){}
                System.out.print(list[i][j].get()+" ");
            }
            System.out.println();
        }
    }
}
