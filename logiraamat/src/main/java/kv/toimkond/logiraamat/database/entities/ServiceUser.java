package kv.toimkond.logiraamat.database.entities;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "service_user")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ServiceUser {

    @Id
    @GeneratedValue
    UUID id;
    @Column(unique = true, nullable = false)
    String username;
    @Column(nullable = false)
    String password;

}
