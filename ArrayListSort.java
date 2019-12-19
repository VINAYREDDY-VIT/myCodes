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
class Student{
    private int mo,m1,m2,m3;
    private String name;
    private double avg;
    //setter
    Student(int mo,int m1,int m2,int m3,String name){
        this.mo=mo;
        this.m1=m1;
        this.m2=m2;
        this.m3=m3;
        this.name=name;
    }
    //getters
    public String getName(){
        String str=name;
        if(str.length()!=10){
            while(str.length()<11)
                    str+=" ";
        }
        return str;
    }
    public int getId(){
        return mo;
    }
    public double getAvg(){
        //sum of all marks;
        int total = m1+m2+m3;
        return (double)total/3;
    }
    @Override
    public String toString() { 
        return String.format(getId() + " " + getName()+"  "+String.format("%.2f",getAvg())); 
    }
}
public class ArrayListSort {
    public static void main(String[] krishna){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Student> list = new ArrayList<>();
        //get student details
        while(n-->0){
            int mo = sc.nextInt();
            String name = sc.next();
            int m1 = sc.nextInt();
            int m2 = sc.nextInt();
            int m3 = sc.nextInt();
            Student st = new Student(mo,m1,m2,m3,name);
            list.add(st);
        }
        Comparator<Student> com =new Comparator<Student>(){
            public int compare(Student s1, Student s2) {
            double c1=s1.getAvg();
            double c2=s2.getAvg();
            if(c1>c2){
                return 1;
            }
            else if (c2>c1){
                return -1;
            }
            else{
                String str1=s1.getName();
                String str2=s2.getName();
                if(str1.equals(str2)){
                    int i1=s1.getId();
                    int i2=s2.getId();
                    if(i1<i2){
                        return -1;
                    }
                    else{
                        return 1;
                    }
                }
                else{
                    return str1.compareTo(str2);
                }
            }
            }
        };
        Collections.sort(list, com);
        System.out.println("Roll No       Name         Average");
        for(Student s : list){
            System.out.println(s.toString());
        }
    }
}
