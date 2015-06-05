package creational.factorymethod;

import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class NYPizzaStore extends AbstractPizzaStore {
    @Override
    public Pizza createPizza(String type) {
        Pizza pizza = null;
        if(type.equals("NYCheesePizza")){
            pizza = new NYCheesePizza();
        }else if(type.equals("NYVeggiePizza")){
            pizza = new NYVeggiePizza();
        }
        return pizza;
    }
}
