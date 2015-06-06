package creational.singleton;

/**
 * 单例模式
 * ① 延迟加载（首次使用才加载）
 * ② 多线程不支持（多线程环境下会生成多个对象）
 * <p/>
 * mti1301
 * 2015/6/6.
 */
public class ChocolateBoilerSingletonWithoutThreadSafe {
    private static ChocolateBoilerSingletonWithoutThreadSafe singleton;
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSingletonWithoutThreadSafe() {
        // 初始化锅炉为空
        this.empty = true;
        this.boiled = false;
    }

    public static ChocolateBoilerSingletonWithoutThreadSafe getSingleton() {
        if (singleton == null) {
            singleton = new ChocolateBoilerSingletonWithoutThreadSafe();
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
