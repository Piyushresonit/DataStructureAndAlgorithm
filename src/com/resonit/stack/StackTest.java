package com.resonit.stack;

import java.util.Stack;

public class StackTest {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);


        // Return distance from top of the stack if present, else -1
        int index = stack.search(30);
        System.out.println(index);

        for (Object st: stack) {
            System.out.println(st);
        }

        // check if the stack is empty
        System.out.println(stack.empty());
        System.out.println(stack.peek());
    }
}
