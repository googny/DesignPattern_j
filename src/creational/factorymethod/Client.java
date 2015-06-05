package creational.factorymethod;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class Client {
    public static void main(String[] args) {
        AbstractPizzaStore nyPizzaStore = new NYPizzaStore();
        nyPizzaStore.orderPizza("NYCheesePizza");
        nyPizzaStore.orderPizza("NYVeggiePizza");

        AbstractPizzaStore chicagoPizzaStore = new ChicagoPizzaStore();
        chicagoPizzaStore.orderPizza("ChicagoCheesePizza");
        chicagoPizzaStore.orderPizza("ChicagoVeggiePizza");
    }
}
