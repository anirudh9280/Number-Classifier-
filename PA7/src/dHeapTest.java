import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

class dHeapTest {
    dHeap<Integer> intHeapMax;
    dHeap<String> stringHeapMin;
    dHeap<Integer> intHeapMin;
    dHeap<String> stringHeapMax;
    @BeforeEach
    public void setUp() {
        intHeapMax = new dHeap<Integer>(3, 10, true);
        stringHeapMin = new dHeap<String>(2, 10, false);
        intHeapMin = new dHeap<Integer>(5, 5, false);
        stringHeapMax = new dHeap<String>(4, 2, true);
    }
    @Test
    public void binaryHeap() {
        dHeap<Float> heap= new dHeap<Float>(10);
        assertEquals(heap.size(), 0);
        assertThrows(NoSuchElementException.class, heap::remove);
        assertThrows(NoSuchElementException.class, heap::element);
        dHeap<Double> heap1 = new dHeap<Double>(5);
        assertEquals(heap1.size(), 0);
        assertThrows(NoSuchElementException.class, heap1::remove);
        assertThrows(NoSuchElementException.class, heap1::element);
        dHeap<Boolean> heap2 = new dHeap<Boolean>(1);
        assertEquals(heap2.size(), 0);
        assertThrows(NoSuchElementException.class, heap2::remove);
        assertThrows(NoSuchElementException.class, heap2::element);
    }
    @Test
    public void binary() {
        dHeap<Float> heap = new dHeap<Float>();
        assertEquals(heap.size(), 0);
        assertThrows(NoSuchElementException.class, heap::remove);
        assertThrows(NoSuchElementException.class, heap::element);
        dHeap<Double> heap1 = new dHeap<Double>();
        assertEquals(heap1.size(), 0);
        assertThrows(NoSuchElementException.class, heap1::remove);
        assertThrows(NoSuchElementException.class, heap1::element);
        dHeap<Boolean> heap2 = new dHeap<Boolean>();
        assertEquals(heap2.size(), 0);
        assertThrows(NoSuchElementException.class, heap2::remove);
        assertThrows(NoSuchElementException.class, heap2::element);
    }
    @Test
    public void dHeapConstructor() {
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMax.remove();
        });
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMax.element();
        });
        assertEquals(intHeapMax.size(), 0);
        intHeapMax.add(2);
        intHeapMax.add(5);
        intHeapMax.add(10);
        assertEquals(intHeapMax.size(), 3);
        assertEquals(intHeapMax.remove(), 10);
        assertEquals(intHeapMax.element(), 5);
        intHeapMax.add(7);
        assertEquals(intHeapMax.size(), 3);
        assertEquals(intHeapMax.remove(), 7);
        assertEquals(intHeapMax.remove(), 5);
        assertEquals(intHeapMax.remove(), 2);
        assertEquals(intHeapMax.size(), 0);
        stringHeapMax.add("");
        stringHeapMax.add("A");
        stringHeapMax.add("D");
        stringHeapMax.add("AB");
        stringHeapMax.add("MAB");
        stringHeapMax.add("ABC");
        stringHeapMax.add("BB");
        stringHeapMax.add("AB");
        stringHeapMax.add("C");
        stringHeapMax.add("ACB");
        assertEquals(stringHeapMax.size(), 10);
        assertEquals(stringHeapMax.remove(), "MAB");
        assertEquals(stringHeapMax.remove(), "D");
        assertEquals(stringHeapMax.remove(), "C");
        assertEquals(stringHeapMax.remove(), "BB");
        assertEquals(stringHeapMax.remove(), "ACB");
        assertEquals(stringHeapMax.remove(), "ABC");
        assertEquals(stringHeapMax.remove(), "AB");
        assertEquals(stringHeapMax.remove(), "AB");
        assertEquals(stringHeapMax.remove(), "A");
        assertEquals(stringHeapMax.size(), 1);
    }

    @Test
    public void sizeTest() {
        assertEquals(stringHeapMax.size(), 0);
        stringHeapMax.add("b");
        stringHeapMax.add("d");
        assertEquals(stringHeapMax.size(), 2);
        stringHeapMax.remove();
        assertEquals(stringHeapMax.size(), 1);
        stringHeapMax.add("o");
        stringHeapMax.add("o");
        stringHeapMax.add("o");
        stringHeapMax.add("D");
        stringHeapMax.add("o");
        stringHeapMax.add("8");
        assertEquals(stringHeapMax.size(), 7);
        stringHeapMax.remove();
        stringHeapMax.remove();
        stringHeapMax.remove();
        assertEquals(stringHeapMax.size(), 4);
        stringHeapMax.remove();
        stringHeapMax.remove();
        stringHeapMax.remove();
        stringHeapMax.remove();
        assertEquals(stringHeapMax.size(), 0);
        assertThrows(NoSuchElementException.class, stringHeapMax::remove);
    }

    @Test
    public void removeTest() {
        assertThrows(NoSuchElementException.class, intHeapMax::remove);
        assertEquals(intHeapMax.size(), 0);
        intHeapMax.add(5);
        intHeapMax.add(900);
        intHeapMax.add(100);
        intHeapMax.add(80);
        intHeapMax.add(20);
        intHeapMax.add(40);
        assertEquals(intHeapMax.size(), 6);
        assertEquals(intHeapMax.element(), 900);
        assertEquals(intHeapMax.remove(), 900);
        assertEquals(intHeapMax.remove(), 100);
        assertEquals(intHeapMax.size(), 4);
        assertEquals(intHeapMax.remove(), 80);
        assertEquals(intHeapMax.remove(), 40);
        assertEquals(intHeapMax.remove(), 20);
        assertEquals(intHeapMax.remove(), 5);
        assertThrows(NoSuchElementException.class, () -> {
          intHeapMax.remove();
        });
        assertEquals(intHeapMax.size(), 0);
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMin.remove();
        });
        assertEquals(stringHeapMin.size(), 0);
        stringHeapMin.add("a");
        assertEquals(stringHeapMin.size(), 1);
        assertEquals(stringHeapMin.remove(), "a");
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMin.remove();
        });
        assertEquals(stringHeapMin.size(), 0);
        stringHeapMin.add("b");
        assertEquals(stringHeapMin.size(), 1);
        assertEquals(stringHeapMin.remove(), "b");
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMin.remove();
        });
        assertEquals(stringHeapMin.size(), 0);
        stringHeapMin.add("d");
        assertEquals(stringHeapMin.size(), 1);
        assertEquals(stringHeapMin.remove(), "d");
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMin.remove();
        });
        assertEquals(stringHeapMin.size(), 0);
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMin.remove();
        });
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMax.remove();
        });
        assertEquals(0, stringHeapMax.size());
        stringHeapMax.add("bat");
        stringHeapMax.add("cat");
        stringHeapMax.add("rat");
        stringHeapMax.add("mat");
        stringHeapMax.add("fat");
        stringHeapMax.add("apple");
        stringHeapMax.add("gummy");
        assertEquals(7, stringHeapMax.size());
        assertEquals("rat", stringHeapMax.remove());
        assertEquals(6, stringHeapMax.size());
        assertEquals("mat", stringHeapMax.remove());
        assertEquals(5, stringHeapMax.size());
        assertEquals("gummy", stringHeapMax.remove());
        assertEquals(4, stringHeapMax.size());
        assertEquals("fat", stringHeapMax.remove());
        assertEquals(3, stringHeapMax.size());
        assertEquals("cat", stringHeapMax.remove());
        assertEquals(2, stringHeapMax.size());
        assertEquals("bat", stringHeapMax.remove());
        assertEquals(1, stringHeapMax.size());
        assertEquals("apple", stringHeapMax.remove());
        assertEquals(0, stringHeapMax.size());
    }

    @Test
    public void addTest() {
        intHeapMax.add(10);
        intHeapMax.add(20);
        intHeapMax.add(30);
        assertEquals(intHeapMax.element(), 30);
        assertEquals(intHeapMax.size(), 3);
        assertThrows(NullPointerException.class, () -> {
            intHeapMax.add(null);
        });
        intHeapMax.add(200);
        assertEquals(intHeapMax.element(), 200);
        assertEquals(intHeapMax.size(), 4);
        intHeapMax.add(55);
        assertEquals(intHeapMax.element(), 200);
        assertEquals(intHeapMax.size(), 5);
        intHeapMax.add(201);
        assertEquals(intHeapMax.element(), 201);
        assertEquals(intHeapMax.size(), 6);
        intHeapMax.add(199);
        assertEquals(intHeapMax.element(), 201);
        assertEquals(intHeapMax.size(), 7);
        intHeapMin.add(1);
        assertEquals(intHeapMin.size(), 1);
    }

    @Test
    public void clear() {
        assertEquals(0, intHeapMax.size());
        intHeapMax.add(100);
        intHeapMax.add(50);
        intHeapMax.add(70);
        intHeapMax.add(30);
        assertEquals(4, intHeapMax.size());
        assertEquals(100, intHeapMax.element());
        assertEquals(100, intHeapMax.remove());
        assertEquals(3, intHeapMax.size());
        assertEquals(70, intHeapMax.element());
        intHeapMax.clear();
        assertEquals(0, intHeapMax.size());
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMax.remove();
        });
        assertEquals(0, stringHeapMin.size());
        assertThrows(NoSuchElementException.class, () -> {
            stringHeapMin.remove();
        });
        stringHeapMin.clear();
        assertEquals(0, stringHeapMin.size());
        intHeapMin.add(0);
        intHeapMin.add(1);
        intHeapMin.clear();
        assertEquals(0, intHeapMin.size());
        intHeapMin.clear();
        assertEquals(0, intHeapMin.size());
        intHeapMin.add(1);
        intHeapMin.add(2);
        intHeapMin.add(5);
        intHeapMin.add(1);
        intHeapMin.remove();
        intHeapMin.remove();
        assertEquals(2, intHeapMin.size());
        intHeapMin.clear();
        assertEquals(0, intHeapMin.size());
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMin.element();
        });
    }

    @Test
    public void element() {
        assertThrows(NoSuchElementException.class, () -> {
          intHeapMin.element();
        });
        intHeapMin.add(1);
        assertEquals(1, intHeapMin.element());
        intHeapMin.add(7);
        assertEquals(1, intHeapMin.element());
        intHeapMin.add(0);
        assertEquals(0, intHeapMin.element());
        intHeapMin.add(5);
        intHeapMin.add(5);
        intHeapMin.add(5);
        assertEquals(0, intHeapMin.element());
        intHeapMin.add(4);
        assertEquals(0, intHeapMin.element());
        intHeapMin.remove();
        assertEquals(1, intHeapMin.element());
        intHeapMin.remove();
        assertEquals(4, intHeapMin.element());
        intHeapMin.remove();
        assertEquals(5, intHeapMin.element());
        intHeapMin.remove();
        assertEquals(5, intHeapMin.element());
        intHeapMin.remove();
        assertEquals(5, intHeapMin.element());
        intHeapMin.clear();
        assertThrows(NoSuchElementException.class, () -> {
            intHeapMin.element();
        });
        stringHeapMax.add("b");
        assertEquals("b", stringHeapMax.element());
        stringHeapMax.add("a");
        assertEquals("b", stringHeapMax.element());
        stringHeapMax.add("z");
        assertEquals("z", stringHeapMax.element());
        stringHeapMax.add("w");
        assertEquals("z", stringHeapMax.element());
        stringHeapMax.add("f");
        assertEquals("z", stringHeapMax.element());
        stringHeapMax.remove();
        assertEquals("w", stringHeapMax.element());
        stringHeapMax.remove();
        assertEquals("f", stringHeapMax.element());
        stringHeapMax.remove();
        assertEquals("b", stringHeapMax.element());
        stringHeapMax.remove();
        assertEquals("a", stringHeapMax.element());
        stringHeapMax.remove();
        assertThrows(NoSuchElementException.class, () -> {
          stringHeapMax.element();
        });
    }
}
