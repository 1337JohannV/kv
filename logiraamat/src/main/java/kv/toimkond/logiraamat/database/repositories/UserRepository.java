package kv.toimkond.logiraamat.database.repositories;

import kv.toimkond.logiraamat.database.entities.ServiceUser;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<ServiceUser, Integer> {
    Optional<ServiceUser> findServiceUserByUsernameEquals(String username);
}
