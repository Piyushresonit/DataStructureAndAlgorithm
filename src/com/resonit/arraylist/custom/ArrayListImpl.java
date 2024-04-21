package com.resonit.arraylist.custom;

public class ArrayListImpl {

    static class ArrayList {

        private static final int defaultCapacity = 10;
        Object[] array;
        private int size;
        private int capacity;

        public ArrayList() {
            this(defaultCapacity);
        }

        public ArrayList(int initialCapacity) {
            array = new Object[initialCapacity];
            this.size = 0;
            this.capacity = initialCapacity;
        }

        public void add(int element) {
            if (size == capacity) {
                resize(capacity >> 1);
            }
            array[size++] = element;
        }

        private void resize(int minCapacity) {
            int newCapacity = capacity + minCapacity;

            Object[] temp = new Object[newCapacity];
            for (int i = 0; i < size; i++) {
                temp[i] = array[i];
            }
            array = temp;
            capacity = newCapacity;
        }

        public Object remove(Object element){
            for (int i = 0; i < size; i++) {
                if(element.equals(array[i]))
                   return removeAtIndex(i);
            }
            return null;
        }

        public Object removeAtIndex(int index) {
            if (size == 0) {
                throw new RuntimeException("Array is Empty");
            }
            Object data = array[index];
            if (index >= 0 && index <= size - 1) {
                Object[] temp = new Object[size - 1];
                for (int i = 0; i < index; i++) {
                    temp[i] = array[i];
                }
                for (int i = index; i < temp.length; i++) {
                    temp[i] = array[i + 1];
                }
                array = temp;
            }
            size--;
            if (size == capacity / 2) {
                resize(-(capacity >> 1));
            }
            return data;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println(" | Size is: " + size + " | Capacity is: " + capacity);
        }
    }
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList();

        System.out.print("Added 10 : ");
        arrayList.add(10);
        arrayList.print();
        System.out.print("Added 20 : ");
        arrayList.add(20);
        arrayList.print();
        System.out.print("Added 30 : ");
        arrayList.add(30);
        arrayList.print();
        System.out.print("Added 40 : ");
        arrayList.add(40);
        arrayList.print();
        System.out.print("Added 50 : ");
        arrayList.add(50);
        arrayList.print();
        System.out.print("Added 60 : ");
        arrayList.add(60);
        arrayList.print();
        System.out.print("Added 70 : ");
        arrayList.add(70);
        arrayList.print();
        System.out.print("Added 80 : ");
        arrayList.add(80);
        arrayList.print();
        System.out.print("Added 90 : ");
        arrayList.add(90);
        arrayList.print();
        System.out.print("Added 100 : ");
        arrayList.add(100);
        arrayList.print();
        System.out.print("Added 110 : ");
        arrayList.add(110);
        arrayList.print();
        System.out.println("*******************************************************************************");
        System.out.print("Removed " + arrayList.remove(50) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(10) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(20) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(30) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(40) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(60) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(70) + ": ");
        arrayList.print();
        System.out.print("Removed " + arrayList.remove(80) + ": ");
        arrayList.print();
    }
}
