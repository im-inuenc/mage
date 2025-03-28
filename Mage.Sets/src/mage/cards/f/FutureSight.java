package mage.cards.f;

import mage.abilities.common.SimpleStaticAbility;
import mage.abilities.effects.common.continuous.PlayFromTopOfLibraryEffect;
import mage.abilities.effects.common.continuous.PlayWithTheTopCardRevealedEffect;
import mage.cards.CardImpl;
import mage.cards.CardSetInfo;
import mage.constants.CardType;
import mage.constants.Zone;

import java.util.UUID;

/**
 * @author Plopman
 */
public final class FutureSight extends CardImpl {

    public FutureSight(UUID ownerId, CardSetInfo setInfo) {
        super(ownerId, setInfo, new CardType[]{CardType.ENCHANTMENT}, "{2}{U}{U}{U}");

        // Play with the top card of your library revealed.
        this.addAbility(new SimpleStaticAbility(new PlayWithTheTopCardRevealedEffect()));

        // You may play lands and cast spells from the top of your library.
        this.addAbility(new SimpleStaticAbility(new PlayFromTopOfLibraryEffect()));
    }

    private FutureSight(final FutureSight card) {
        super(card);
    }

    @Override
    public FutureSight copy() {
        return new FutureSight(this);
    }
}
