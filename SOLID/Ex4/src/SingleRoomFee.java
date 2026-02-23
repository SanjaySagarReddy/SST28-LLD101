public class SingleRoomFee implements FeeComponent {

    @Override
    public Money monthly() {
        return new Money(14000.0);
    }
}