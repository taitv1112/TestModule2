package service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();
    void save(T t);
    void edit(int index,T t);
    void delete(int index);
}
