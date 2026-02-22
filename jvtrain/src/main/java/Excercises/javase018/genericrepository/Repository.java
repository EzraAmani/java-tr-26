package Excercises.javase018.genericrepository;

// Repository.java
import java.util.List;
import java.util.Optional;

public interface Repository<T extends Entity> {
    T save(T entity);

    Optional<T> findById(int id);

    List<T> findAll();

    T update(T entity);

    void delete(int id);

    boolean exists(int id);

    long count();
}