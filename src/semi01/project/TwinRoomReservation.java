package semi01.project;

public class TwinRoomReservation extends RoomReservation {
    public TwinRoomReservation(String name, String roomGrade, int day) {
        super(name, roomGrade, day);
        super.roomGrade = "Twin";
        super.saleRatio = 0.1;
        price = 250000;
        maxPeople = 3;
        breakfast();
    }
    @Override
    public int calcPrice(int price) {
        return super.calcPrice(price);
    }

    @Override
    public void roomInfo() {
        super.roomInfo();
    }
}
