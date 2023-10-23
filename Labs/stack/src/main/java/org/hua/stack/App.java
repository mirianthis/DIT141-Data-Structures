package org.hua.stack;

import java.io.IOException;

public class App {
    
    public static void main(String args[]) throws IOException{
        
        
        
        int ch , top;
        boolean correct = true;
        //Stack<Integer> s = new ArrayStack();
        Stack<Integer> s = new LinkedStack();
        
        while((ch = System.in.read())!= -1){
            if(ch=='{' || ch == '('){
                s.push(ch);
            }else if (ch == ')'){
                if(s.isEmpty()) {
                    correct = false;
                    break;
                }
                top= s.pop();
                if(top!='(') {
                    correct = false;
                    break;
                }
            }else if (ch == '}'){
                if(s.isEmpty()) {
                    correct = false;
                    break;
                }
                top= s.pop();
                if(top!='{') {
                    correct = false;
                    break;
                    }
            }
        }
    }
}