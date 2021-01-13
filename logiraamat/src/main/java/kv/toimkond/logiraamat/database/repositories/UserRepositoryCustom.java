package kv.toimkond.logiraamat.database.repositories;

import kv.toimkond.logiraamat.database.entities.ServiceUser;
import kv.toimkond.logiraamat.models.UserModel;

import java.util.Optional;

public interface UserRepositoryCustom {

    Optional<ServiceUser> findMatchingUser(UserModel userModel);

}
