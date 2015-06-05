package creational.factorymethod.withsimplefactory;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class Client {
    public static void main(String[] args) {
        PizzaStore store = new PizzaStore(new NYStyleFactory());
        store.orderPizza("NYCheesePizza");
        store.orderPizza("NYVeggiePizza");

        store.setFactory(new ChicagoStyleFactory());
        store.orderPizza("ChicagoVeggiePizza");
        store.orderPizza("ChicagoCheesePizza");
    }
}
