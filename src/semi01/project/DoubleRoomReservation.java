package semi01.project;

public class DoubleRoomReservation extends RoomReservation {

    public DoubleRoomReservation(String name, String roomGrade, int day){
        super(name, roomGrade, day);
        super.roomGrade = "Double";
        super.saleRatio = 0.05;
        price = 200000;
        maxPeople = 2;
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
