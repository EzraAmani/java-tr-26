package Excercises.javase018.genericrepository;

// InMemoryRepository.java
import java.util.*;

public class InMemoryRepository<T extends Entity> implements Repository<T> {
    private final Map<Integer, T> storage = new HashMap<>();
    private int currentId = 1;

    @Override
    public T save(T entity) {
        if (entity.getId() == 0) {
            entity.setId(currentId++);
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public Optional<T> findById(int id) {
        return Optional.ofNullable(storage.get(id));
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }

    @Override
    public T update(T entity) {
        if (entity.getId() == 0 || !storage.containsKey(entity.getId())) {
            throw new IllegalArgumentException("Entity not found for update");
        }
        storage.put(entity.getId(), entity);
        return entity;
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public boolean exists(int id) {
        return storage.containsKey(id);
    }

    @Override
    public long count() {
        return storage.size();
    }
}