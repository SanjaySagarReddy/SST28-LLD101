public class TripleRoomFee implements FeeComponent {

    @Override
    public Money monthly() {
        return new Money(12000.0);
    }
}