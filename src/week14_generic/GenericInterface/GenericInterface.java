package week14_generic.GenericInterface;

// 제네릭 인터페이스
public interface GenericInterface <T>{
    public void add(T item, int index);
    public T get(int index);
}
