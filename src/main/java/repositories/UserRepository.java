package repositories;

import entities.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Nikolay Shuvaev on 17.05.2017
 */
public interface UserRepository extends CrudRepository <User, Long> {
}
