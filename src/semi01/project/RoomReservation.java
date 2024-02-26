package semi01.project;

//싱글룸
public class RoomReservation {

    public String name; //고객명
    public String roomGrade; //예약할 룸
    public int day; //예약 일수
    public int people; //인원수
    public int maxPeople;
    public int price; //가격
    double saleRatio;

    public RoomReservation(String name, String roomGrade, int day) {
        this.name = name;
        this.roomGrade = roomGrade;
        this.day = day;
        initRoomReservation();
    }
    public RoomReservation(String roomGrade) {
        this.roomGrade = roomGrade;
        initRoomReservation();
    }
    private void initRoomReservation() {
        roomGrade = "single";
        price = 100000;
        maxPeople = 1;
    }
    public int calcPrice(int price){
        if(3 <= day && !roomGrade.equals("single")){
             price = (int) (price * (1 - saleRatio) * day);
            return price;
        }  else {
            return price * day;
        }
    }

    public boolean breakfast (){
        if(roomGrade.equals("sweet")){
            return true;
        } else{
            return false;
        }
    }


    public void roomInfo(){
        System.out.println(roomGrade + "룸 |" + " 금액: " + price +  "원 |" +  " 인원제한: " + maxPeople + "명");
    }
}

