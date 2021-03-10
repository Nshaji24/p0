package testpackage;

import com.enterprise.model.MetaTestData;
import com.enterprise.util.HashMap;
import com.enterprise.util.TestDiscovery;

import java.lang.reflect.Method;

public class Driver {
    public static void main(String[] args) throws Exception {
        HashMap<Method, MetaTestData> results = new TestDiscovery().runAndStoreTestInformation();
        System.out.println(results);
    }
}
