package com.dsa.airtribedsa.StacksNQueues;

public class StackADT {
    public static void main(String[] args) {
//        Stack stack = new Stack();
        /*stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.display();
        stack.pop();
        stack.display();
        stack.peek();*/

        System.out.println(validParenthesis("(){[]}()"));


    }

    private static boolean validParenthesis(String s) {
        Stack<Character> stack = new Stack<>(5);
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.empty()) {
                    return false;
                } else {
                    if ((ch == ')' && stack.peek() == '(') || (ch == '}' && stack.peek() == '{') || (ch == ']' && stack.peek() == '[')) {
                        stack.pop();
                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }

}

class Stack<T> {
    private int top;
    private T[] stack;

    private int capacity;

    public Stack(int capacity) {
        this.top = -1;
        this.capacity = capacity;
        this.stack = (T[]) new Object[capacity];
    }

    public void push(T data) {
        if (top == capacity - 1) {
            System.out.println("Stack is full");
        } else {
            stack[++top] = data;
        }
    }

    public T pop() {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        return stack[top--];
    }

    public T peek() {
        if (top == -1) {
            System.out.println("Stack is empty");
        }
        return stack[top];
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("Stack elements:");
            for (int i = 0; i <= top; i++) {
                System.out.println(stack[i]);
            }
        }
    }

    public boolean empty() {
        return top == -1;
    }
}
