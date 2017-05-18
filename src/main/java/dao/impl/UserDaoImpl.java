package dao.impl;

import dao.UserDao;
import entities.User;
import org.springframework.stereotype.Repository;
import repositories.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by macbook on 03.01.17
 */
@Repository
public class UserDaoImpl extends BaseDao<UserRepository> implements UserDao {

    @Override
    public long save(String name, LocalDate birthday, String email) {
        User user = new User(-1L, name, birthday, email);
        User save = repository.save(user);
        return save.getId();
    }

    @Override
    public void remove(long id) {
        repository.delete(id);
    }

    @Override
    public User getById(long id) {
        return repository.findOne(id);

    }

    @Override
    public User getUserByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public List<User> getAll() {
        Iterable<User> all = repository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
    }

}
