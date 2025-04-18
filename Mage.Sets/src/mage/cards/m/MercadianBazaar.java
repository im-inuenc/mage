
package mage.cards.m;

import java.util.UUID;
import mage.Mana;
import mage.abilities.Ability;
import mage.abilities.common.EntersBattlefieldTappedAbility;
import mage.abilities.common.SimpleActivatedAbility;
import mage.abilities.costs.common.RemoveVariableCountersSourceCost;
import mage.abilities.costs.common.TapSourceCost;
import mage.abilities.dynamicvalue.common.CountersSourceCount;
import mage.abilities.dynamicvalue.common.GetXValue;
import mage.abilities.effects.common.counter.AddCountersSourceEffect;
import mage.abilities.mana.DynamicManaAbility;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;
import mage.counters.CounterType;

/**
 *
 * @author anonymous
 */
public final class MercadianBazaar extends CardImpl {

    public MercadianBazaar(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId,setInfo,new CardType[]{CardType.LAND},"");

        // Mercadian Bazaar enters the battlefield tapped.
        this.addAbility(new EntersBattlefieldTappedAbility());
        // {tap}: Put a storage counter on Mercadian Bazaar.
        this.addAbility(new SimpleActivatedAbility(new AddCountersSourceEffect(CounterType.STORAGE.createInstance()), new TapSourceCost()));
        // {tap}, Remove any number of storage counters from Mercadian Bazaar: Add {R} for each storage counter removed this way.
        Ability ability = new DynamicManaAbility(
                Mana.RedMana(1),
                GetXValue.instance,
                new TapSourceCost(),
                "Add {R} for each storage counter removed this way",
                true, new CountersSourceCount(CounterType.STORAGE));
        ability.addCost(new RemoveVariableCountersSourceCost(CounterType.STORAGE,
                "Remove any number of storage counters from {this}"));
        this.addAbility(ability);
    }

    private MercadianBazaar(final MercadianBazaar card) {
        super(card);
    }

    @Override
    public MercadianBazaar copy() {
        return new MercadianBazaar(this);
    }
}
