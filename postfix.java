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
public class postfix {
    public static void main(String[] sai){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the valid expression : ");
        String expr = sc.nextLine();
        Stack<Character> stk = new Stack<>();
        String output="";
        int len = expr.length();
        for(int i=0;i<len;i++){
            char ch = expr.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                output+=ch;
            }
            else if(ch=='('){
                stk.push('(');
            }
            else if(ch==')'){
                while(!stk.isEmpty() && stk.peek()!='('){
                    output+=stk.pop();
                }
                if(!stk.isEmpty() && stk.peek()!='('){
                    System.out.println("Invalid expression");
                    System.exit(0);
                }
                else{
                    stk.pop();
                }
            }
            else{
                while(!stk.isEmpty() && precendance(ch)<=precendance(stk.peek())){
                    if(stk.peek()=='('){
                        System.out.println("Invalid expression");
                        System.exit(0);
                    }
                    output+=stk.pop();
                }
                stk.push(ch);
            }
        }
        while(!stk.isEmpty()){
            if(stk.peek()=='('){
                System.out.println("Invalid expression");
                System.exit(0);
            }
            output+=stk.pop();
        }
        System.out.println(output);
    }
    static int precendance(char c){
        int prec;
        prec = -1;
        switch(c){
            case '+':
            case '-':
                prec=1;
                break;
            case '*':
            case '/':
                prec=2;
                break;
            case '^':
                prec=3;
                break;
        }
        return prec;
    }
}
