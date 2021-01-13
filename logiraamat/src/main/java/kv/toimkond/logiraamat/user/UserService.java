package kv.toimkond.logiraamat.user;


import kv.toimkond.logiraamat.database.entities.ServiceUser;
import kv.toimkond.logiraamat.database.repositories.UserRepository;
import kv.toimkond.logiraamat.models.Response;
import kv.toimkond.logiraamat.models.ResponseType;
import kv.toimkond.logiraamat.models.UserModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    @Autowired
    private PasswordEncoderDecoder encoderDecoder;

    @Autowired
    private UserRepository userRepository;

    public Response registerUser(UserModel userModel) {
        userModel.setPassword(encoderDecoder.encoder().encode(userModel.getPassword()));
        try {
            userRepository.save(ServiceUser.builder()
                    .password(userModel.getPassword()).username(userModel.getUsername()).build());
            return new Response(userModel, ResponseType.SUCCESS);
        } catch (Exception e) {
            return Response.builder().responseType(ResponseType.FAILED).responseUUID(UUID.randomUUID())
                    .message("Error registrating user. Username taken.").build();
        }
    }

    public Response login(UserModel userModel) {


        try {
            Optional<ServiceUser> foundUser = userRepository.findServiceUserByUsernameEquals(userModel.getUsername());
            return foundUser.isPresent() && encoderDecoder.encoder()
                    .matches(userModel.getPassword(), foundUser.get().getPassword()) ? Response.builder().message("Login success")
                    .responseUUID(UUID.randomUUID()).responseType(ResponseType.SUCCESS).build() : Response.builder()
                    .responseType(ResponseType.FAILED)
                    .responseUUID(UUID.randomUUID()).message("Login failed").build();
        } catch (Exception e) {
            return Response.builder().responseUUID(UUID.randomUUID())
                    .responseType(ResponseType.FAILED).message("Server failure").build();
        }

    }
}
