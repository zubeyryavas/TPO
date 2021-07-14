public final class Configuration {

    public static int PORT = 3114;

    private static final String ADDING_REMOTE_NAME = "AddingRemote";
    private static final String ECHOING_REMOTE_NAME = "EchoingRemote";

    public static final String ADDING_REMOTE_URI =uri(PORT,ADDING_REMOTE_NAME);
    public static final String ECHOING_REMOTE_URI = uri(PORT,ECHOING_REMOTE_NAME);

    private static String uri(int port, String name){
        return String.format("rmi://localhost:%d/%s",port,name);
    }
}