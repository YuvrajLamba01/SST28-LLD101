public class DoubleRoomPricing implements RoomPricingStrategy {
    @Override
    public Money getMonthlyFee() {
        return new Money(15000.0);
    }

    @Override
    public int getRoomType() {
        return LegacyRoomTypes.DOUBLE;
    }
}
