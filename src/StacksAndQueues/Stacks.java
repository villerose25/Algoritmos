package StacksAndQueues;

import java.util.Stack;

/*
    Stacks has the order of LIFO: Last In First Out
    POP O(1)
    if stack is empty
        return

    data = stack[top]
    top = top -1
    return data

    PUSH O(1)
    TOP O(1)
    if stack is empty
        return

    return stack[top]
 */
public class Stacks {
    Stack st;
    void push(int x) {
        this.st.push(x);
    }

    void pop() {
       this.st.pop();
    }

    Integer top() {
        if(st.size() == 0)
            return null;
        return (Integer) this.st.peek();
    }

    int getLen() {
        return this.st.size();
    }
}
