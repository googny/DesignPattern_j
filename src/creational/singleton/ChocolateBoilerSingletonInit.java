package creational.singleton;

/**
 * 在类加载的过程中进行初始化操作
 * mti1301
 * 2015/6/6.
 */
public class ChocolateBoilerSingletonInit {
    private static ChocolateBoilerSingletonInit singleton = new ChocolateBoilerSingletonInit();
    private boolean empty;
    private boolean boiled;

    private ChocolateBoilerSingletonInit() {
        // 初始化锅炉为空
        this.empty = true;
        this.boiled = false;
    }

    public static ChocolateBoilerSingletonInit getSingleton() {
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
