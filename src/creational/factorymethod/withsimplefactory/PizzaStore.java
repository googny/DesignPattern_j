package creational.factorymethod.withsimplefactory;

import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class PizzaStore {

    private PizzaFactory factory;

    public PizzaStore(PizzaFactory factory) {
        this.factory = factory;
    }

    public void setFactory(PizzaFactory factory) {
        this.factory = factory;
    }

    public Pizza orderPizza(String type) {
        Pizza pizza = factory.createPizza(type);
        pizza.prepare();
        pizza.bake();
        pizza.cut();
        pizza.box();
        System.out.println("=========================");
        return pizza;
    }
}
