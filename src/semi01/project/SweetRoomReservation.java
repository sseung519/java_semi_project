package semi01.project;

public class SweetRoomReservation extends RoomReservation{
    String maxPeople;
    public SweetRoomReservation(String name, String roomGrade, int day) {
        super(name, roomGrade, day);
        super.roomGrade = "sweet";
        super.saleRatio = 0.05;
        price = 500000;
        maxPeople = "인원제한: 없음";
        breakfast();
    }
    @Override
    public int calcPrice(int price) {
        return super.calcPrice(price);
    }

    @Override
    public void roomInfo() {
        System.out.println(roomGrade + "룸 |" + " 금액: " + price + "원 | " +  maxPeople + "조식여부: " + breakfast()) ;
    }
}
