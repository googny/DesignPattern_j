package creational.factorymethod;

import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class ChicagoPizzaStore extends AbstractPizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("ChicagoCheesePizza")){
            pizza = new ChicagoCheesePizza();
        }else if(type.equals("ChicagoVeggiePizza")){
            pizza = new ChicagoVeggiePizza();
        }
        return pizza;
    }
}
