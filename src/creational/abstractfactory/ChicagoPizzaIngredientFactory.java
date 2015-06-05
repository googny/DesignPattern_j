package creational.abstractfactory;

import creational.abstractfactory.ingredient.*;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class ChicagoPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThinCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new MarinaraSauce();
    }

    @Override
    public Cheese createCheese() {
        return new ReggianoCheese();
    }

    @Override
    public Clams createClam() {
        return new FreshClams();
    }

    @Override
    public String toString() {
        return "ChicagoPizzaIngredientFactory";
    }
}
