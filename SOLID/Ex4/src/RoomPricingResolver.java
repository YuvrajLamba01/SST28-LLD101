/**
 * Factory to get the appropriate RoomPricingStrategy based on room type.
 */
public class RoomPricingResolver {
    public static RoomPricingStrategy resolve(int roomType) {
        return switch (roomType) {
            case LegacyRoomTypes.SINGLE -> new SingleRoomPricing();
            case LegacyRoomTypes.DOUBLE -> new DoubleRoomPricing();
            case LegacyRoomTypes.TRIPLE -> new TripleRoomPricing();
            default -> new DeluxeRoomPricing();
        };
    }
}
