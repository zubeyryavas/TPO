package remote;

import java.io.Serializable;
import java.math.BigInteger;

public class AddResponse implements Serializable {
    private static final long serialVersionUID= 561335353534534L;

    private final BigInteger sum;

    public AddResponse(AddRequest request){
        sum = request.getValue1().add(request.getValue2());
    }

    public BigInteger getSum() {
        return sum;
    }
}
