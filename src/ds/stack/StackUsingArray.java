package ds.stack;

class StackUsingArray {
    private int maxSize;
    private int top;
    private int a[];

    StackUsingArray(int size) {
        maxSize = size;
        a = new int[maxSize];
        top = -1;
    }

    boolean push(int x) {
        if (top >= (a.length - 1)) {
            System.out.println("Stack Overflow");
            return false;
        } else {
            a[++top] = x;
            System.out.println(x + " pushed into stack");
            return true;
        }
    }

    int pop() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            int x = a[top--];
            return x;
        }
    }

    int peek() {
        if (top < 0) {
            System.out.println("Stack is empty");
            return 0;
        } else {
            return a[top];
        }
    }

    void print() {
        for(int i = top;i>-1;i--)
            System.out.print(" "+ a[i]);
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize-1;
    }

    public int getSize() {
        return top+1;
    }

    public static void main(String args[]) {
        StackUsingArray s = new StackUsingArray(2);
        s.push(10);
        s.push(20);
        s.push(30);
        System.out.println(s.pop() + " Popped from stack");
        System.out.println("Top element is :" + s.peek());
        System.out.print("Elements present in stack :");
        s.print();
    }
}