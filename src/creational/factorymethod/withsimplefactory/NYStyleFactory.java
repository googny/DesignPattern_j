package creational.factorymethod.withsimplefactory;

import creational.factorymethod.NYCheesePizza;
import creational.factorymethod.NYVeggiePizza;
import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class NYStyleFactory implements PizzaFactory {
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
