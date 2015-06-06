package creational.singleton;

/**
 * mti1301
 * 2015/6/6.
 */
public class ChocolateBoiler {
    private boolean empty;
    private boolean boiled;

    public ChocolateBoiler(boolean empty, boolean boiled) {
        this.empty = empty;
        this.boiled = boiled;
    }

    public void fill() {
        if (isEmpty()) {
            empty = false;
            boiled = false;
        }
    }

    public void drain() {
        if (!isEmpty() && !isBoiled()) {
            empty = true;
        }
    }

    public void boil() {
        if (!isEmpty() && !isBoiled()) {
            boiled = true;
        }
    }

    public boolean isEmpty() {
        return empty;
    }

    public boolean isBoiled() {
        return boiled;
    }
}
