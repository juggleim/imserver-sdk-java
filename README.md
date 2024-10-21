# imserver-sdk-java
The Java SDK for JIM API

# example

```java

import com.juggle.im.shadow.RcJuggleIm;

import io.rong.models.response.TokenResult;
import io.rong.models.user.UserModel;

public class App 
{
    public static void main( String[] args )
    {
        RcJuggleIm sdk = new RcJuggleIm("appkey", "appsecret", "http://127.0.0.1:8082");
        try {
            TokenResult result = sdk.user.register(new UserModel("userid1", "user1", ""));

           System.out.println(result.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

```