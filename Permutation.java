/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author reddy
 */
public class Permutation {
    public static void main(String[] sai) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        char[] arr = str.toCharArray();
        ArrayList<String> list = getpermutation(arr);
        for(String s : list){
            System.out.println(s);
        }
    }
    static ArrayList<String> getpermutation(char[] arr){
        Map<Character,Integer> map = new TreeMap<>();
        for(char c : arr){
            map.compute(c, (key, val) -> {
                if (val == null) {
                    return 1;
                } else {
                    return val + 1;
                }
            });
        }
        char[] str = new char[map.size()];
        int[] count = new int[map.size()];
        int index=0;
        for(Map.Entry<Character,Integer> entry : map.entrySet()){
            str[index]=entry.getKey();
            count[index++]=entry.getValue();
        }
        ArrayList<String> result = new ArrayList<>();
        char[] res = new char[arr.length];
        permuteutil(str,count,res,0,result);
        return result;
    }

    private static void permuteutil(char[] str, int[] count, char[] res, int depth, ArrayList<String> result) {
        if(res.length==depth){
            //System.out.println(res);
            result.add(new String(res));
            return;
        }
        for(int i=0;i<str.length;i++){
            if(count[i]==0){
                continue;
            }
            res[depth]=str[i];
            count[i]--;
            permuteutil(str,count,res,depth+1,result);
            count[i]++;
        }
    }
}
