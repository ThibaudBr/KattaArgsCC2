package esgi.briandthibaud;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // -q 100 -t 'Hello World' -g 200 -h 300 -k 'hello world2'
        Args arg = new Args("q#,t*,g#,h#,k*", args);
        //boolean detach = arg.getBoolean('d');
        int port = arg.getInt('q');
        int port1 = arg.getInt('g');
        int port2 = arg.getInt('h');
        String hero = arg.getString('t');
        String hero2 = arg.getString('k');
        executeApplication(false, port, hero, port1, port2, hero2);

    }

    private static void executeApplication(boolean detach, int port, String hero, int port1, int port2, String hero2) {
        System.out.printf("detach is %s, port: %d, hero: %s, %d, %d, %s\n",detach, port, hero, port1, port2, hero2);
    }
}
