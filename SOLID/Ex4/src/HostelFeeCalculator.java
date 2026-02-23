import java.util.*;

public class HostelFeeCalculator {
    private final FakeBookingRepo repo;
    private final Map<Integer, FeeComponent> roomPrices;
    private final Map<AddOn, FeeComponent> addOnPrices;

    public HostelFeeCalculator(FakeBookingRepo repo) {
        this.repo = repo;

        // OCP violation: switch + add-on branching + printing + persistence.

        roomPrices = new HashMap<>();
        roomPrices.put(LegacyRoomTypes.SINGLE, new SingleRoomFee());
        roomPrices.put(LegacyRoomTypes.DOUBLE, new DoubleRoomFee());
        roomPrices.put(LegacyRoomTypes.TRIPLE, new TripleRoomFee());
        roomPrices.put(LegacyRoomTypes.DELUXE, new DeluxeRoomFee());

        addOnPrices = new HashMap<>();
        addOnPrices.put(AddOn.MESS, new MessFee());
        addOnPrices.put(AddOn.LAUNDRY, new LaundryFee());
        addOnPrices.put(AddOn.GYM, new GymFee());
    }

    public void process(BookingRequest req) {
        Money monthly = calculateMonthly(req);
        Money deposit = new Money(5000.00);

        ReceiptPrinter.print(req, monthly, deposit);

        String bookingId = "H-" + (7000 + new Random(1).nextInt(1000));
        repo.save(bookingId, req, monthly, deposit);
    }

    private Money calculateMonthly(BookingRequest req) {
        List<FeeComponent> components = new ArrayList<>();

        FeeComponent roomFee = roomPrices.get(req.roomType);
        if (roomFee != null) {
            components.add(roomFee);
        }

        for (AddOn addOn : req.addOns) {
            FeeComponent addOnFee = addOnPrices.get(addOn);
            if (addOnFee != null) {
                components.add(addOnFee);
            }
        }

        Money total = new Money(0);
        for (FeeComponent c : components) {
            total = total.plus(c.monthly());
        }
        return total;
    }
}