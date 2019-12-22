package strategies;

import characters.heroes.Hero;

public abstract class Strategy implements StrategyInterface {
    private Hero owner;

    protected Strategy(Hero hero) {
        owner = hero;
    }

    protected Hero getOwner() {
        return owner;
    }

    @Override
    public void apply() {
        if (lowerHpCase()) {
            executeLowerHp();
        } else {
            if (middleHpCase()) {
                executeMiddleHp();
            }
        }
    }

    private boolean lowerHpCase() {
        return owner.getHP() < getLowerHpLimit();
    }

    private boolean middleHpCase() {
        return getLowerHpLimit() < owner.getHP() && owner.getHP() < getUpperHpLimit();
    }

    protected abstract float getLowerHpLimit();

    protected abstract float getUpperHpLimit();

    protected abstract void executeLowerHp();

    protected abstract void executeMiddleHp();

}
