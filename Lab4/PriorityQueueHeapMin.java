import java.util.Arrays;

public class PriorityQueueHeapMin<K> {
    protected Object[][] heap;
    private int size;

    public PriorityQueueHeapMin()  {
        this.heap = new Object[10][2];
        this.size = 0;
    }

    private void heapify(int index) {
        int smallest;
        int l = leftChild(index);
        int r = rightChild(index);
        if (l <= size && (Integer)heap[l][1] <= (Integer)heap[index][1]) {
            smallest = l;
        }
        else {
            smallest = index;
        }
        if (r <= size && (Integer)heap[r][1] <= (Integer)heap[smallest][1]) {
            smallest = r;
        }
        if (smallest != index) {
            swap(index, smallest);
            heapify(smallest);
        }
    }

    protected void insert(K item, int priority) {
        if (isFull() == true) {
            Object[][] temp = Arrays.copyOf(heap, size() * 2);
            heap = temp;
        }
        size++;
        Object[] pair = {item, priority};
        heap[size] = pair;
        int currPos = size;
        while (currPos > 1 && (Integer)heap[parent(currPos)][1] > (Integer)heap[currPos][1]) {
            swap(currPos, parent(currPos));
            currPos = parent(currPos);
        }
    }


    protected void heapDecrease(int index, int priority) {
        if (priority < (Integer)heap[index][1]) {
            
        }
        heap[index][1] = priority;
        while (index > 1 && (Integer)heap[parent(index)][1] >= (Integer)heap[index][1]) {
            swap(index, parent(index));
            index = parent(index);
        }
    }

    protected void minHeapInsert(K item, int priority) {
        if (isFull() == true) {
            Object[][] temp = Arrays.copyOf(heap, size() * 2);
            heap = temp;
        }
        size++;
        Object[] pair = {item, Integer.MAX_VALUE};
        heap[size] = pair;
        heapDecrease(size, priority);
    }

    protected K peek() {
        return (K)heap[1][0];
    }

    protected Integer peekPriority() {
        return (Integer)heap[1][1];
    }

    protected Object remove() {
        if (size() < 1) {
            return "Empty queue";
        }
        //System.out.println("old root:" + peek() + heap[1][1]);
        Object temp = heap[1][0];
        //System.out.println(size);
        heap[1] = heap[size];
        //System.out.println(":" + peek());
        size = size - 1;
        heapify(1);
       // System.out.println("new root:" + peek() + heap[1][1]);
        return temp;
    }

    protected void changePriority(K item, int priority) {
        int index = 0;
        for (int i = 1; i <= size; i++) {
            if (heap[i][0].equals(item)) {
                index = i;
                break;
            }
        }
        if (priority > (int)heap[index][1]) {
            return;
        }
        else {
            heap[index][1] = priority;
            while ((Integer)heap[parent(index)][1] < (Integer)heap[index][1]) {
                swap(index, parent(index));
                index = parent(index);
            }
        }
    }

    protected void buildHeap(int[][] arr) {
        for (int i = arr.length / 2; i >= 1; i--){
            heapify(i);
        }
    }
    
    protected void heapsort(int[][] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 2; i--) {
            swapSort(arr, i, 1);
            heapify(1);
        }
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
        return size() == heap.length - 1;
    }

    protected int size() {
        return this.size;
    }
    
    protected void print() {
        for (int i = size(); i > 0; i--) {
            System.out.print("[" + heap[i][0] + " " + heap[i][1] + "]" + " ");
        }
    }
}
