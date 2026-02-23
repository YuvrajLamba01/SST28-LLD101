import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final RoomPricingResolver roomResolver;
    private final AddOnPricing addOnPricing;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;
        this.roomResolver = new RoomPricingResolver();
        this.addOnPricing = new StandardAddOnPricing();
    }

    public HostelFeeCalculator(FakeBookingRepo repo, AddOnPricing addOnPricing) {
        this.repo = repo;
        this.roomResolver = new RoomPricingResolver();
        this.addOnPricing = addOnPricing;
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000)); // deterministic-ish
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        RoomPricingStrategy strategy = roomResolver.resolve(req.roomType);
        Money base = strategy.getMonthlyFee();

        Money addOnsTotal = new Money(0.0);
        for (AddOn addOn : req.addOns) {
            addOnsTotal = addOnsTotal.plus(addOnPricing.getPriceFor(addOn));
        }

        return base.plus(addOnsTotal);
    }
}
