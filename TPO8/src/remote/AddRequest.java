package remote;

import java.io.Serializable;
import java.math.BigInteger;

public final class AddRequest implements Serializable {

    private static final long serialVersionUID = 6575464554748564575L;

    private final BigInteger value1;
    private final BigInteger value2;

    public AddRequest(BigInteger value1, BigInteger value2){
        this.value1=value1;
        this.value2=value2;
    }


    public BigInteger getValue1() {
        return value1;
    }

    public BigInteger getValue2() {
        return value2;
    }
}
