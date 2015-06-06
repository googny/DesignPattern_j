package creational.singleton;

/**
 * mti1301
 * 2015/6/6.
 */
public class ChocolateBoilerSingletonWithThreadSafe {
    private static volatile ChocolateBoilerSingletonWithThreadSafe singleton;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSingletonWithThreadSafe() {
        // 初始化锅炉为空
        this.empty = true;
        this.boiled = false;
    }

    /**
     * 线程安全：是，但效率太低
     * 给获取单例的方法加锁，每次获取单例都得先获取对象锁，即使该单例已经存在
     * 同步块太大，只需给创建单例同步即可
     */
    public static synchronized ChocolateBoilerSingletonWithThreadSafe getSingletonOne() {
        if (singleton == null) {
            singleton = new ChocolateBoilerSingletonWithThreadSafe();
        }
        return singleton;
    }

    /**
     * 线程安全：否，两个线程（A，B）同时进入1区域，A线程先进入同步块创建对象，随后B线程进入同步块创建对象
     */
    public static ChocolateBoilerSingletonWithThreadSafe getSingletonTwo() {
        if (singleton == null) { // 1
            synchronized (ChocolateBoilerSingletonWithThreadSafe.class) { //2
                singleton = new ChocolateBoilerSingletonWithThreadSafe();
            }
        }
        return singleton;
    }

    /**
     * 线程安全：否，成功解决了上面解决方案的问题
     * 新问题：
     * 初始化一个对象时候，分为三步操作
     * ① 分配内存
     * ② 初始化内存
     * ③ 将内存引用指向singleton
     * 编译器会进行重排序，将第三步排序到第二步之前，因此可能返回的singleton实例是不能用的
     * C++ 里面会造成野指针
     */
    public static ChocolateBoilerSingletonWithThreadSafe getSingletonThree() {
        if (singleton == null) { // 1
            synchronized (ChocolateBoilerSingletonWithThreadSafe.class) {
                if (singleton == null) { //2
                    singleton = new ChocolateBoilerSingletonWithThreadSafe();
                }
            }
        }
        return singleton;
    }

    /**
     * 线程安全：是
     * 解决了重排序的问题
     */
    public static ChocolateBoilerSingletonWithThreadSafe getSingletonFour() {
        if (singleton == null) { // 1
            synchronized (ChocolateBoilerSingletonWithThreadSafe.class) {
                if (singleton == null) { //2
                    ChocolateBoilerSingletonWithThreadSafe temp = new ChocolateBoilerSingletonWithThreadSafe();
                    singleton = temp;
                }
            }
        }
        return singleton;
    }

    /**
     * 加料
     */
    public void fill() {
        if (isEmpty()) {
            /*
             锅炉里已经填东西了
             现在锅炉的状态时
             非空
             还没煮沸
              */
            empty = false;
            boiled = false;
        }
    }

    /**
     * 煮沸
     */
    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            // 如果锅炉非空，并且没煮沸，将锅炉煮沸
            boiled = true;
        }
    }

    /**
     * 排空
     */
    public void drain() {
        if (!isEmpty() && isBoiled()) {
            // 如果锅炉非空，并且煮沸，将锅炉排空
            empty = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
