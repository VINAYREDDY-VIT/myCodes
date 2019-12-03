class Solution {
    public int romanToInt(String s) {
        int num=0;
        for(int i=0;i<s.length();i++){
            char a = s.charAt(i);
            switch(a){
                case 'M':
                    if(i==0)
                        num+=1000;
                    else{
                        if(s.charAt(i-1)=='C')
                            num+=800;
                        else
                            num+=1000;
                    }
                    break;
                case 'D':
                    if(i==0)
                        num+=500;
                    else{
                        if(s.charAt(i-1)=='C')
                            num+=300;
                        else
                            num+=500;
                    }
                    break;
                case 'C':
                    if(i==0)
                        num+=100;
                    else{
                        if(s.charAt(i-1)=='X')
                            num+=80;
                        else
                            num+=100;
                    }
                    break;
                case 'L':
                    if(i==0)
                        num+=50;
                    else{
                        if(s.charAt(i-1)=='X')
                            num+=30;
                        else
                            num+=50;
                    }
                    break;
                case 'X':
                    if(i==0)
                        num+=10;
                    else{
                        if(s.charAt(i-1)=='I')
                            num+=8;
                        else
                            num+=10;
                    }
                    break;
                case 'V':
                    if(i==0)
                        num+=5;
                    else{
                        if(s.charAt(i-1)=='I')
                            num+=3;
                        else
                            num+=5;
                    }
                    break;
                case 'I':
                    num+=1;
                    break;
            }
        }
        return num;
    }
}
