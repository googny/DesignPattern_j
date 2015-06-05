package creational.abstractfactory;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class Client {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new NYPizzaIngredientFactory());
        store.orderPizza();
        store.setFactory(new ChicagoPizzaIngredientFactory());
        store.orderPizza();
    }
}
