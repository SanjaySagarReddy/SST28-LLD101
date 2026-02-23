public class DeluxeRoomFee implements FeeComponent {

    @Override
    public Money monthly() {
        return new Money(16000.0);
    }
}