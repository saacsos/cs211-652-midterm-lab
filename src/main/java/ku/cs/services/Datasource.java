package ku.cs.services;

public interface Datasource<T> {
    T readData();
    void writeData(T data);
}
