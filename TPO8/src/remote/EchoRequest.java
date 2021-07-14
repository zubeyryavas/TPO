package remote;

import java.io.Serializable;

public class EchoRequest implements Serializable {

    private static final long serialVersionUID= 1234567898756423L;

    private final String message;

    public EchoRequest(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
