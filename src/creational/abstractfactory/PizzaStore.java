package creational.abstractfactory;

import creational.factorymethod.ChicagoCheesePizza;
import creational.factorymethod.NYCheesePizza;
import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class PizzaStore {
    PizzaIngredientFactory factory;

    public PizzaStore(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    public void setFactory(PizzaIngredientFactory factory) {
        this.factory = factory;
    }

    private Pizza createPizza() {
        System.out.println("create Pizza use " + factory);
        System.out.println("add ingredient " + factory.createCheese());
        System.out.println("add ingredient " + factory.createClam());
        System.out.println("add ingredient " + factory.createDough());
        System.out.println("add ingredient " + factory.createSauce());
        System.out.println("Pizza created!!");

        Pizza pizza = null;
        if (factory instanceof ChicagoPizzaIngredientFactory) {
            pizza = new ChicagoCheesePizza();
        } else if (factory instanceof NYPizzaIngredientFactory) {
            pizza = new NYCheesePizza();
        }
        return pizza;
    }

    public Pizza orderPizza() {
        Pizza pizza = createPizza();
        if (pizza != null) {
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            System.out.println("===================");
        }
        return pizza;
    }
}
