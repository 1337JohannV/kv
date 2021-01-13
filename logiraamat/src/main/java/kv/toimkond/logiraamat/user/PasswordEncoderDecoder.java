package kv.toimkond.logiraamat.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordEncoderDecoder {
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }


}
