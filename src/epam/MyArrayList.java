package epam;

import java.util.ArrayList;
import java.util.Arrays;

//Задание 2.1
public class MyArrayList <E> extends ArrayList <E>  {

    private int size;
    public int size() {
        return size;
    }
    transient Object[] elementData;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    //конструктор
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }


    E elementData(int index) {
        return (E) elementData[index];
    }

    //методы, которые не могу унаследовать, т.к. они приватные
    private void ensureCapacityInternal(int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        ensureExplicitCapacity(minCapacity);
    }
    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        // overflow-conscious code
        if (minCapacity - elementData.length > 0)
            grow(minCapacity);
    }
    private void grow(int minCapacity) {
        // overflow-conscious code
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0)
            newCapacity = minCapacity;
        if (newCapacity - MAX_ARRAY_SIZE > 0)
            newCapacity = hugeCapacity(minCapacity);
        // minCapacity is usually close to size, so this is a win:
        elementData = Arrays.copyOf(elementData, newCapacity);
    }
    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) // overflow
            throw new OutOfMemoryError();
        return (minCapacity > MAX_ARRAY_SIZE) ?
                Integer.MAX_VALUE :
                MAX_ARRAY_SIZE;
    }
    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    private void rangeCheck(int index) {
        if (index >= size)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
    }

    //переопределение методов
    @Override
    public E set(int index, E element) {
        rangeCheck(index);

        E oldValue = elementData(index);
        elementData[index] = element;
        return oldValue;
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);  // Increments modCount!!
        elementData[size++] = e;
        return true;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);

        ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = element;
        size++;
    }

    //не знаю нахрена мне его покрывать, но без него не пашет, почему тоже хз
    @Override
    public E get(int index) {
        rangeCheck(index);

        return elementData(index);
    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                '}';
    }
}
