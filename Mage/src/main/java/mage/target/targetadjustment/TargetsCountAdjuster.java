package mage.target.targetadjustment;

import mage.abilities.Ability;
import mage.abilities.dynamicvalue.DynamicValue;
import mage.filter.Filter;
import mage.game.Game;
import mage.target.Target;

/**
 * @author TheElk801, notgreat
 */
public class TargetsCountAdjuster extends GenericTargetAdjuster {
    private final DynamicValue dynamicValue;

    /**
     * Modifies the target to be X targets, where X is the dynamic value.
     * If the ability's target has min targets of 0, it's treated as "up to X targets".
     * Otherwise, it's exactly "X targets".
     *
     * @param value The number of targets
     */
    public TargetsCountAdjuster(DynamicValue value) {
        this.dynamicValue = value;
    }

    @Override
    public void adjustTargets(Ability ability, Game game) {
        int count = dynamicValue.calculate(game, ability, ability.getEffects().get(0));
        ability.getTargets().clear();
        if (count <= 0) {
            return;
        }

        Target newTarget = blueprintTarget.copy();
        newTarget.setMaxNumberOfTargets(count);
        Filter filter = newTarget.getFilter();
        if (blueprintTarget.getMinNumberOfTargets() != 0) {
            newTarget.setMinNumberOfTargets(count);
            newTarget.withTargetName(filter.getMessage() + " (" + count + " targets)");
        } else {
            newTarget.withTargetName(filter.getMessage() + " (up to " + count + " targets)");
        }
        ability.addTarget(newTarget);
    }
}
