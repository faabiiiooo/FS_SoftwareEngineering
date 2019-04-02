package lesson7_genericLinkedList;

public class SinglyLinkedList<T> {
    private SinglyLinkedElement<T> head = null;

    public SinglyLinkedList(){

    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void add(int position, T data){
        SinglyLinkedElement<T> newElement = new SinglyLinkedElement<>(data);

        if(position == 0){
            newElement.next = head;  //always set reference to second element firs!
            head = newElement;  //else all old elements would be lost
        } else {
            SinglyLinkedElement<T> cursor = head;
            int actual = 0;
            while(actual < position -1){
                if(cursor.next == null) return;
                else {
                    cursor = cursor.next;
                    actual++;

                }
            }
            newElement.next = cursor.next;
            cursor.next = newElement;
        }
    }

    public T get(int position){
        SinglyLinkedElement<T> cursor = head;
        int actual = 0;
        while(actual < position){
            if(cursor.next == null){
                return null;
            } else {
                cursor = cursor.next;
                actual++;
            }
        }
        return cursor.getData();
    }
}
