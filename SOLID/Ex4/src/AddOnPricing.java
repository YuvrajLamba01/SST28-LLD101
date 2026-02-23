/**
 * Abstraction for add-on pricing.
 */
public interface AddOnPricing {
    /**
     * Get the price for a given add-on.
     */
    Money getPriceFor(AddOn addOn);
}
