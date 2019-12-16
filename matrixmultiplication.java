/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;
import java.util.*;

/**
 *
 * @author reddy
 */
class calculate implements Runnable {
    private int[][] a;
    private int[][] b;
    private int[][] c;
    private int row;
    private int col;
    private int acol;
    private int brow;
   public calculate(int[][] aa,int[][] bb,int[][] cc,int r,int co,int ac,int br){
       a=aa;
       b=bb;
       c=cc;
       row=r;
       col=co;
       acol=ac;
       brow=br;
   }
   public void run(){
       for(int i=0;i<acol;i++){
           for(int j=0;j<brow;j++){
               c[row][col]+=a[row][i]*b[j][col];
           }
       }
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
        int c[][] = new int[ar][bc];
        for(i=0;i<ar;i++){
            for(j=0;j<bc;j++){
                Runnable obj = new calculate(a,b,c,i,j,ac,br);
                Thread obj1 = new Thread(obj);
                obj1.start();
            }
        }
        for(i=0;i<ar;i++){
            for(j=0;j<bc;j++){
                System.out.print(c[i][j]+" ");
            }
            System.out.println();
        }
    }
}
