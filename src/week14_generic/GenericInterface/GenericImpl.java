package week14_generic.GenericInterface;

// 제네릭 인터페이스를 구현한 클래스 또한 제네릭 타입이 됨
// GenericImpl 옆의 T는 여기서 T라는 제네릭 타입을 사용하겠다는 의미
public class GenericImpl<T> implements GenericInterface<T> {
    private T[] array;
    public GenericImpl(int capacity) {
        this.array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T item, int index) {
        array[index] = item;
    }

    @Override
    public T get(int index) {
        return array[index];
    }
}
