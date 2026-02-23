/**
 * Default implementation of AddOnPricing.
 */
public class StandardAddOnPricing implements AddOnPricing {
    @Override
    public Money getPriceFor(AddOn addOn) {
        return switch (addOn) {
            case MESS -> new Money(1000.0);
            case LAUNDRY -> new Money(500.0);
            case GYM -> new Money(300.0);
        };
    }
}
