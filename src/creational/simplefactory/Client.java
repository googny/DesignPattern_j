package creational.simplefactory;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class Client {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore();
        store.orderPizza("cheese");
        store.orderPizza("clam");
        store.orderPizza("veggie");
        store.orderPizza("pepperoni");
    }
}
