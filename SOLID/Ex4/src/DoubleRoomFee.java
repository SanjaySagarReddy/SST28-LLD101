public class DoubleRoomFee implements FeeComponent {

    @Override
    public Money monthly() {
        return new Money(15000.0);
    }
}