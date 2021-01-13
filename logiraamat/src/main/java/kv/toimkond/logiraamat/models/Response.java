package kv.toimkond.logiraamat.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Response {
    private ResponseType responseType;
    private Object message;
    private UUID responseUUID;

    public Response(Object message, ResponseType responseType) {
        this.message = message;
        this.responseType = responseType;
        this.responseUUID = UUID.randomUUID();
    }
}
