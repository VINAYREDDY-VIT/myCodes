/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		while(test-->0){
		    int n = sc.nextInt();
		    int m = sc.nextInt();
		    ArrayList<HashSet<Integer>> list = new ArrayList<>();
		    for(int i=0;i<m;i++){
		        int v = sc.nextInt();
		        int u = sc.nextInt();
		        list = update(list,v,u);
		    }
		    int size = -1;
		    for(int i=0;i<list.size();i++){
		        if(list.get(i).size()>size){
		            size=list.get(i).size();
		        }
		    }
		    //print size prime number
		    for(int i=2;;i++){
		        if(prime(i)){
		            size--;
		            if(size==0){
		                System.out.println(i);
		                break;
		            }
		        }
		    }
		}
	}
	static ArrayList<HashSet<Integer>> update(ArrayList<HashSet<Integer>> list,int v,int u){
	    HashSet<Integer> l = new HashSet<>();
	    for(int i=0;i<list.size();i++){
	        HashSet<Integer> temp = list.get(i);
	        if(temp.contains(v) || temp.contains(u)){
	            l.addAll(temp);
	            list.remove(i);
	            i--;
	        }
	    }
	    l.add(v);
	    l.add(u);
        list.add(l);
	    return list;
	}
	static boolean prime(int n){
	    for(int i=2;i<=Math.sqrt(n);i++){
	        if(n%i==0){
	            return false;
	        }
	    }
	    return true;
	}
}
