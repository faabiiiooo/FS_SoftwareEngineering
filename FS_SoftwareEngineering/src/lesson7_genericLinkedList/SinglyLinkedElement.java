package lesson7_genericLinkedList;

public class SinglyLinkedElement<T> {

    private final T data;
    SinglyLinkedElement<T> next = null;

    protected SinglyLinkedElement(T data){
        this.data = data;

    }

    protected  T getData(){ return this.data; }

}
