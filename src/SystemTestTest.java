import junit.framework.TestCase;


public class SystemTestTest extends TestCase {

    public void testMain() {
        SystemTest sys = new SystemTest();
        String[] args = {"ss", "rr"};
        sys.main(args);
    }

}
