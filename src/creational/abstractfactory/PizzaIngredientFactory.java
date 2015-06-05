package creational.abstractfactory;

import creational.abstractfactory.ingredient.Cheese;
import creational.abstractfactory.ingredient.Clams;
import creational.abstractfactory.ingredient.Dough;
import creational.abstractfactory.ingredient.Sauce;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public interface PizzaIngredientFactory {
    Dough createDough();
    Sauce createSauce();
    Cheese createCheese();
    Clams createClam();
}
