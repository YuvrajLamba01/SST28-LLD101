/**
 * Abstraction for room pricing strategy.
 */
public interface RoomPricingStrategy {
    /**
     * Get the monthly fee for a room type.
     */
    Money getMonthlyFee();
    
    /**
     * Get the room type constant.
     */
    int getRoomType();
}
