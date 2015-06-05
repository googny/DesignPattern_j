package creational.abstractfactory;

import creational.abstractfactory.ingredient.*;

/**
 * @author mti1301
 *         create date 2015/6/5.
 */
public class NYPizzaIngredientFactory implements PizzaIngredientFactory {
    @Override
    public Dough createDough() {
        return new ThickCrustDough();
    }

    @Override
    public Sauce createSauce() {
        return new PlumTomatoSauce();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Clams createClam() {
        return new FrozenClams();
    }

    @Override
    public String toString() {
        return "NYPizzaIngredientFactory";
    }
}
