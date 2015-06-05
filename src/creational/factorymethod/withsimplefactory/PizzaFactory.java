package creational.factorymethod.withsimplefactory;

import creational.simplefactory.Pizza;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public interface PizzaFactory {
    Pizza createPizza(String type);
}
