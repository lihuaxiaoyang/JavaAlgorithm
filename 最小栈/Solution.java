class MinStack {

    Deque<Integer> temStack = null;
    Deque<Integer> minStack = null;

    public MinStack() {
        temStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        temStack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        temStack.pop();
        minStack.pop();
    }

    public int top() {
        return temStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */