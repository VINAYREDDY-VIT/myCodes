/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author reddy
 */
public class subsets {
    public static void main(String[] krishna){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        ArrayList<ArrayList<Integer>> subset = getsubsets(arr);
        for(ArrayList<Integer> list : subset){
            System.out.print("[ ");
            for(int a : list)
                System.out.print(a+" ");
            System.out.println("]");
        }
    }
    static ArrayList<ArrayList<Integer>> getsubsets(int[] arr){
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int size = (int)Math.pow(2,arr.length);
        for(int i=0;i<size;i++){
            String bin = binary(i,arr.length);
            ArrayList<Integer> sublist = new ArrayList<>();
            for(int j=0;j<bin.length();j++){
                char a = bin.charAt(j);
                if(a=='1')
                    sublist.add(arr[j]);
            }
            list.add(sublist);
        }
        return list;
    }
    static String binary(int num,int size){
        String str="";
        while(num>0){
            int a = num%2;
            str=a+str;
            num/=2;
        }
        while(str.length()!=size)
            str="0"+str;
        return str;
    }
}
