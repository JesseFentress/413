public class PriorityQueueHeap<T> {
    public Object[][] heap;
    private int size;

    public PriorityQueueHeap()  {
        this.heap = new Object[10][2];
        this.size = 0;
    }

    private void heapify(int index) {
        int largest;
        int l = leftChild(index);
        int r = rightChild(index);
        if (l <= size && (Integer)heap[l][1] > (Integer)heap[index][1]) {
            largest = l;
        }
        else {
            largest = index;
        }
        if (r <= size && (Integer)heap[r][1] > (Integer)heap[index][1]) {
            largest = r;
        }
        if (largest != index) {
            swap(index, largest);
            heapify(largest);
        }
    }

    protected void insert(T item, int priority) {
        size++;
        Object[] pair = {item, priority};
        heap[size] = pair;
        int currPos = size;
        while (currPos > 1 && (Integer)heap[parent(currPos)][1] < (Integer)heap[currPos][1]) {
            swap(currPos, parent(currPos));
            currPos = parent(currPos);
        }
    }

    protected Object peek() {
        return heap[1][0];
    }

    protected Object remove() {
        if (size() < 1) {
            return "Empty queue";
        }
        Object temp = heap[1][0];
        heap[1] = heap[size];
        heapify(1);
        size--;
        return temp;
    }

    protected void changePriority(T item, int priority) {
        int index = 0;
        for (int i = 1; i <= size; i++) {
            if (heap[i][0].equals(item)) {
                index = i;
                break;
            }
        }
        if (priority < (int)heap[index][1]) {
            return;
        }
        else {
            heap[index][1] = priority;
            while (index > 1 && (Integer)heap[parent(index)][1] < (Integer)heap[index][1]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    protected void buildHeap() {
        int size = heap.length;
        for (int i = (heap.length / 2); i >= 1; i--) {
            heapify(i);
        }
    }

    protected Object[][] heapsort() {
        buildHeap();
        for (int i = size; i >= 2; i--) {
            swap(1, i);
            size = size - 1;
            heapify(1);
        }
        return heap;
    }

    private void swapSort(int[][] arr, int index1, int index2) {
        int[] temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    private void swap(int index1, int index2) {
        Object[] temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    private int parent(int index) {
        return index / 2;
    }

    private int leftChild(int index) {
        return 2 * index;
    }

    private int rightChild(int index) {
        return 2 * index + 1;
    }

    protected boolean isEmpty() {
        return size() == 0;
    }

    protected boolean isFull() {
        return size() == heap.length;
    }

    protected int size() {
        return this.size;
    }

    protected void print() {
        for (int i = 1; i <= size(); i++) {
            System.out.print("[" + heap[i][0] + " " + heap[i][1] + "]");
        }
    }
}
