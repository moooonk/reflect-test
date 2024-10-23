import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class SimpleTest {

    public static void main(String[] args) {
        // prepare data
        List<Data> dataList = new ArrayList<Data>();
        for (int i = 0; i < 100; i++) {
            dataList.add(new Data());
        }
        List<DataWithClone> dataWithCloneList = new ArrayList<DataWithClone>();
        for (int i = 0; i < 100; i++) {
            dataWithCloneList.add(new DataWithClone());
        }

        // warnUp c2 compile
        System.out.println("starting warnUp");
        warnUp(dataList, dataWithCloneList);
        System.out.println("finish warnUp");

        // real test
        System.out.println("starting test");
        runTest(dataList, dataWithCloneList);
        System.out.println("finish test");
    }

    public static void warnUp(List<Data> dataList, List<DataWithClone> dataWithCloneList) {
        for (int i = 0 ; i < 200 ; i++) {
            case1(dataList, true);
            case2(dataWithCloneList, true);
            case3(dataWithCloneList, true);
        }
    }

    public static void runTest(List<Data> dataList, List<DataWithClone> dataWithCloneList) {
        case1(dataList, false);
        case2(dataWithCloneList, false);
        case3(dataWithCloneList, false);
    }

    private static void case1(List<Data> dataList, boolean warmUp) {
        int loopTime = warmUp ? 1 : 1000000;
        Method cloneMethod = null;
        try {
            cloneMethod = Object.class.getDeclaredMethod("clone");
            cloneMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopTime; i++) {
            for (int j = 0; j < dataList.size(); j++) {
                Data data = dataList.get(j);
                try {
                    Object clone = cloneMethod.invoke(data);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (!warmUp) {
            System.out.println("case1:" + (System.currentTimeMillis() - startTime));
        }
    }

    private static void case2(List<DataWithClone> dataList, boolean warmUp) {
        int loopTime = warmUp ? 1 : 1000000;
        Method cloneMethod = null;
        try {
            cloneMethod = Object.class.getDeclaredMethod("clone");
            cloneMethod.setAccessible(true);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopTime; i++) {
            for (int j = 0; j < dataList.size(); j++) {
                DataWithClone data = dataList.get(j);
                try {
                    Object clone = cloneMethod.invoke(data);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (!warmUp) {
            System.out.println("case2:" + (System.currentTimeMillis() - startTime));
        }
    }

    private static void case3(List<DataWithClone> dataList, boolean warmUp) {
        int loopTime = warmUp ? 1 : 1000000;
        Method cloneMethod = null;
        try {
            cloneMethod = DataWithClone.class.getDeclaredMethod("clone");
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < loopTime; i++) {
            for (int j = 0; j < dataList.size(); j++) {
                DataWithClone data = dataList.get(j);
                try {
                    Object clone = cloneMethod.invoke(data);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
        if (!warmUp) {
            System.out.println("case3:" + (System.currentTimeMillis() - startTime));
        }
    }

}
