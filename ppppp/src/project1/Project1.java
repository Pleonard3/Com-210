/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project1;

public class Project1 {
    private int stackSize;
    private char[] stackArray;
    private int top;
 
public static void main(String args[]){
		try {
			String expression = "{(a+b)*(c+d)}";
			Project1 test = new Project1(expression.length());
			System.out.println("Right expression: " + test.DelimiterMatching(expression));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

     // constructor to create stack with size
     
    public Project1(int size) {
        this.stackSize = size;
        this.stackArray = new char[stackSize];
        this.top = -1;
    }
 
    
     // Adds new entry to the top of the stack
    
    public void push(char entry) throws Exception {
    	this.stackArray[++top] = entry;
    }
 
    
     //Removes an entry from the top of the stack.
     
    public char pop() throws Exception {
        if(this.StackEmpty()){
        	System.out.println("Stack underflow.");
        }
        return this.stackArray[top--];
    }
 
     //Returns top of the stack without removing it.
    
    public int Top() {
        return stackArray[top];
    }
 
     ///Returns true if the stack is empty
     
    public boolean StackEmpty() {
        return (top == -1);
    }
 
     //Returns true if the stack is full
     
    public boolean StackFull() {
        return (top == stackSize - 1);
    }
 
    public boolean DelimiterMatching(String inputExpr) throws Exception {        
        for (int j = 0; j < inputExpr.length(); j++) {
            char ch = inputExpr.charAt(j);
            switch (ch) {
            case '{':
            case '[':
            case '(':
                    push(ch);
                    break;
            case '}':
            case ']':
            case ')':
                    if (!StackEmpty()) {
                        char stackContent = pop();
                        if ((ch == '}' && stackContent != '{') 
                                || (ch == ']' && stackContent != '[')
                                || (ch == ')' && stackContent != '(')){
                            System.out.println("Mismatch found: " + ch + " at " + j);
                            return false;
                        }
                    } else {
                        System.out.println("Mismatch found: " + ch + " at " + j);
                        return false;
                    }
                    break;
            default: break;
            }
        }
        if (!StackEmpty()){
            System.out.println("Error: missing right delimiter");
            return false;
        }
        return true;
    }
 
    public String word(String word) throws Exception{        
        StringBuilder sb = new StringBuilder();
        int size = word.length();
        for(int i=0;i<size;i++){
            push(word.charAt(i));
        }
        while(!StackEmpty()){
            sb.append(pop());
        }
        return sb.toString();
    }
 	
}