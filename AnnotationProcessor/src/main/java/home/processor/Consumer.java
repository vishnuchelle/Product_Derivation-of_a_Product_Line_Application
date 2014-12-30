package home.processor;

public interface Consumer<T>
{
    public void accept(T t);
}
