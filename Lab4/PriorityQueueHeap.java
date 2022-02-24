import java.util.Arrays;

public class PriorityQueueHeap<T> {
    private Object[][] heap;
    private int size;

    public PriorityQueueHeap()  {
        this.heap = new Object[10][2];
        this.size = 0;
    }

    /*private void heapify(int index) {
        if (index > (size / 2) && index <= size) {
            return;
        }
        System.out.println(index);
        System.out.println(heap[index][1]);
        System.out.println(heap[leftChild(index)][1]);
        System.out.println(heap[rightChild(rightChild(index))][1]);
        if ((Integer)heap[index][1] < (Integer)heap[leftChild(index)][1] ||
            (Integer)heap[index][1] < (Integer)heap[rightChild(index)][1]) {
            if ((Integer)heap[leftChild(index)][1] > (Integer)heap[index][1]) {
                Object[] temp = heap[index];
                heap[index] = heap[leftChild(index)];
                heap[leftChild(index)] = temp;
                heapify(leftChild(index));
            }
            else {
                Object[] temp = heap[index];
                heap[index] = heap[rightChild(index)];
                heap[rightChild(index)] = temp;
                heapify(rightChild(index));
            }
        }
    }*/

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

    /*protected void insert(T item, int priority) {
        if (isFull()) {
            Object[][] temp = Arrays.copyOf(heap, size() * 2);
            heap = temp;
        }
        size++;
        Object[] pair = {item, priority};
        heap[size] = pair;
        int currPos = size;
        //System.out.println("ins" + heap[currPos][0]);
        //System.out.println("bool "+ ((Integer)heap[currPos][1] > (Integer)heap[(currPos/ 2)][1]));
        //System.out.println((currPos/ 2));
        while ((Integer)heap[currPos][1] > (Integer)heap[(currPos  / 2)][1]) {
            Object[] temp = heap[currPos];
            heap[currPos] = heap[currPos  / 2];
            heap[currPos  / 2] = temp;
            currPos = currPos / 2;
        }
    }*/

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

    /*protected Object remove() {
        Object temp = heap[0][0];
        heap[0] = heap[size--];
        heapify(0);
        return temp;
    }*/

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
        for (int i = 1; i < size; i++) {
            if (heap[i][0] == item) {
                index = i;
                break;
            }
        }
        if (priority < (int)heap[index][1]) {
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
        return size() == heap.length;
    }

    protected int size() {
        return this.size;
    }
}
