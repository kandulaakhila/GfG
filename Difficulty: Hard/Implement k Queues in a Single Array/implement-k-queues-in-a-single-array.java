class kQueues {
    private int[] arr;
    private int[] front;
    private int[] rear;
    private int[] next;
    private int free;
    private int n, k;

    kQueues(int n, int k) {
        // Initialize your data members
        this.n = n;
        this.k = k; 
        arr = new int[n];
        front = new int[k]; 
        rear = new int[k]; 
        next = new int[n];
        // initialize all queues as empty 
        for (int i = 0; i < k; i++) { 
            front[i] = -1;
            rear[i] = -1;
            } // initialize free list 
            for (int i = 0; i < n - 1; i++) { 
                next[i] = i + 1;
                } 
                next[n - 1] = -1;
                free = 0;
                }
    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        if (free == -1) { 
            return; // array full 
            }
            int insertAt = free; // take free slot
            free = next[insertAt]; // update free pointer
            if (front[i] == -1) { 
                front[i] = insertAt;
                } else {
                    next[rear[i]] = insertAt;
                    } 
                    next[insertAt] = -1;
                    rear[i] = insertAt;
                    arr[insertAt] = x;
                    }
    int dequeue(int i) {
        // dequeue element from queue number i
        if (front[i] == -1) {
            return -1; // queue empty 
            } int frontIndex = front[i];
            int result = arr[frontIndex];
            front[i] = next[frontIndex];
            if (front[i] == -1) { 
                rear[i] = -1;
                } // add freed index back to free list
                next[frontIndex] = free; 
                free = frontIndex;
                return result;
                }
    boolean isEmpty(int i) {
        // check if queue i is empty
        return front[i] == -1;
    }

    boolean isFull() {
        // check if array is full
        return free == -1;
    }
}
