/*
 * Name: Anirudh Annabathula
 * PID:  A17909461
 */

import java.util.NoSuchElementException;

/**
 * Title: dHeap Description: This program creates a Heap with d branching factor
 *
 * @author Anirudh Annabathula
 * @since 05/20/2024
 *
 * @param <T> the type of elements held in this collection
 */

public class dHeap<T extends Comparable<? super T>> implements HeapInterface<T> {
    private T[] heap;   // backing array
    private int d;      // branching factor
    private int nelems; // number of elements
    private boolean isMaxHeap; // indicates whether heap is max or min
    private static final int DEFAULT_SIZE = 10;

    /**
     * Initializes a binary max heap with capacity = 10
     */
    @SuppressWarnings("unchecked")
    public dHeap() {
        this(DEFAULT_SIZE);
    }

    /**
     * Initializes a binary max heap with a given initial capacity.
     *
     * @param heapSize The initial capacity of the heap.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int heapSize) {
        heap = (T[]) new Comparable[heapSize];
        d = 2;
        isMaxHeap = true;
        nelems = 0;
    }

    /**
     * Initializes a d-ary heap (with a given value for d), with a given initial
     * capacity.
     *
     * @param d         The number of child nodes each node in the heap should have.
     * @param heapSize  The initial capacity of the heap.
     * @param isMaxHeap indicates whether the heap should be max or min
     * @throws IllegalArgumentException if d is less than one.
     */
    @SuppressWarnings("unchecked")
    public dHeap(int d, int heapSize, boolean isMaxHeap) throws IllegalArgumentException {
        if (d < 1) {
            throw new IllegalArgumentException();
        }
        heap = (T[]) new Comparable[heapSize];
        this.d = d;
        this.isMaxHeap = isMaxHeap;
        nelems = 0;
    }


    /**
     * returns the size of the heap
     * @return the integer size
     */
    @Override
    public int size() {
        return nelems;
    }

    /**
     * removes the root element from the binary heap and reorders, returning root
     * @return the root of the heap
     * @throws NoSuchElementException if the data is null
     */
    @Override
    public T remove() throws NoSuchElementException {
        if (this.size() == 0) {
            throw new NoSuchElementException();
        }
        T root = heap[0];
        swap(0, nelems - 1);
        heap[nelems - 1] = null;
        nelems -= 1;
        trickleDown(0);
        return root;
    }

    /**
     * helper method that swaps two indices
     * @param ind1 first index
     * @param ind2 second index
     */
    private void swap(int ind1, int ind2) {
        T temp = heap[ind1];
        heap[ind1] = heap[ind2];
        heap[ind2] = temp;
    }

    /**
     * adds an element to the heap, maintaining the structure
     * @param item The element to add.
     * @throws NullPointerException when the input is null
     */
    @Override
    public void add(T item) throws NullPointerException {
        if (item == null) {
            throw new NullPointerException();
        }
        if (size() >= heap.length) {
            resize(); // resize array
        }
        nelems += 1;
        heap[size() - 1] = item;
        bubbleUp(size() - 1);
    }

    /**
     * empties the heap
     */
    @SuppressWarnings("unchecked")
    @Override
    public void clear() {
        nelems = 0;
    }

    /**
     * returns the root of the heap
     * @return the element at the root
     * @throws NoSuchElementException if the heap is empty
     */
    @Override
    public T element() throws NoSuchElementException {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return heap[0];
    }

    /**
     * helper method to return the parent of a child index
     * @param index of the child
     * @return the parent index
     */
    private int parent(int index) {
        return (int) (Math.ceil((double) index / d) - 1);
    }

    /**
     * Private method to bubble up added values
     * @param index of the node
     */
    private void bubbleUp(int index) {
        while (index > 0 && compareValue(this.heap[index], this.heap[parent(index)])) {
            int parentIndex = parent(index);
            swap(index, parentIndex);
            index = parentIndex;
        }
    }

    /**
     * private method to trickle down added values
     * @param index the current index that is being trickled down
     */
    private void trickleDown(int index) {
        int indexBacking = index;
        while (true) {
            for (int i = d * index + 1; i <= d * index + d; i++) {
                if (i > size() || heap[i] == null) {
                    swap(indexBacking, index);
                    return;
                }
                if (compareValue(heap[i], heap[indexBacking])) {
                    indexBacking = i;
                }
            } if (indexBacking == index) {
                return;
            }
            swap(indexBacking, index);
            index = indexBacking;
        }
    }

    /**
     * helper method to compare two nodes
     * if it is a max heap, we want to see if elem1 > elem2
     * if it is a min heap, we want to see if elem1 < elem2
     * @param elem1 the first element
     * @param elem2 the seocnd element
     * @return a boolean if the element is greater than the first one
     *
     */
    private boolean compareValue(T elem1, T elem2) {
        if (elem1 == null || elem2 == null) {
            return false;
        }
        if (isMaxHeap) {
            return elem1.compareTo(elem2) > 0;
        }
        return elem1.compareTo(elem2) < 0;
    }

    /**
     * Helper method that doubles the capacity of the heap
     */
    @SuppressWarnings("unchecked")
    private void resize() {
        T[] nheap = (T[]) new Comparable[heap.length * 2];
        for (int i = 0; i < this.size(); i++) {
            nheap[i] = heap[i];
        }
        heap = nheap;
    }

}
