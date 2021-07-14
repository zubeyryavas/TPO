package remote;

import java.io.Serializable;

public class EchoResponse implements Serializable {

    private static final long serialVersionUID = 4568793214456L;

    private final String echoMessage;

    public EchoResponse(EchoRequest request) {
        echoMessage = request.getMessage();
    }

    public String getEchoMessage() {
        return echoMessage;
    }
}
