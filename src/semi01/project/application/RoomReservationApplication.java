package semi01.project.application;

import org.w3c.dom.ls.LSOutput;
import semi01.project.DoubleRoomReservation;
import semi01.project.RoomReservation;
import semi01.project.SweetRoomReservation;
import semi01.project.TwinRoomReservation;

import java.util.ArrayList;
import java.util.Scanner;

public class RoomReservationApplication {
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<RoomReservation> roomList = new ArrayList<>();
    public static void main(String[] args) {

        boolean run = true;
        while (run) {
            System.out.println("------------------------------------------------------------");
            System.out.println("1. 예약 | 2. 모든 룸의 정보 보기 | 3. 모든 고객의 예약 정보 보기 | " +
                    "4. 특정 고객의 예약 정보 보기 | 5. 프로그램 종료");
            System.out.println("------------------------------------------------------------");

            System.out.print("선택: ");
            int select = scanner.nextInt();

            switch (select) {
                case 1:
                    reservation();
                    break;
                case 2:
                    roomInfo();
                    break;
                case 3:
                    reservationInfo();
                    break;
                case 4:
                    searchReservation();
                    break;
                case 5:
                    run = false;
                    break;
            }
        }
        System.out.println("프로그램 종료");
    }

    //1.예약 + 지불금액 + 내역
    public static void reservation() {
        System.out.println("------------------------");
        System.out.println("예약");
        System.out.println("------------------------");
        System.out.print("예약자명:");
        String name = scanner.next();
        System.out.print("예약일수:");
        int day = scanner.nextInt();
        System.out.println("예약할 룸: single | double | twin | sweet");
        String roomGrade = scanner.next();
        RoomReservation room = null;
        System.out.print("인원: ");
        int people = scanner.nextInt();
        switch (roomGrade){
            case "single": room =  new RoomReservation(name, roomGrade, day);
                if(room.maxPeople < people){
                System.out.println("제한인원이 초과되었습니다. 제한인원은: " + room.maxPeople);
                break;
            } else{
                    roomList.add(room);
                    System.out.println("예약이 완료되었습니다.");
                    System.out.println("결제 금액은: " + room.calcPrice(room.price));
                    System.out.println("예약 내역: " + roomGrade + "룸 | " + day + "일 | " + " 인원: " + people + "명" + " | 조식여부: " + room.breakfast()  );
                }
                break;
            case "double": room = new DoubleRoomReservation(name, roomGrade,day);
                if(room.maxPeople < people){
                    System.out.println("제한인원이 초과되었습니다. 제한인원은: " + room.maxPeople);
                    break;
                } else{
                    roomList.add(room);
                    System.out.println("예약이 완료되었습니다.");
                    System.out.println("결제 금액은 :" + room.calcPrice(room.price) + "원");
                    System.out.println("예약 내역: " + roomGrade + "룸 | " + day + "일 | " + " 인원: " + people + "명" + " | 조식여부: " + room.breakfast()  );
                }
                break;
            case "twin": room = new TwinRoomReservation(name, roomGrade,day);
                if(room.maxPeople < people){
                    System.out.println("제한인원이 초과되었습니다. 제한인원은: " + room.maxPeople);
                    break;
                } else{
                    roomList.add(room);
                    System.out.println("예약이 완료되었습니다.");
                    System.out.println("결제 금액은 :" + room.calcPrice(room.price));
                    System.out.println("예약 내역: " + roomGrade + "룸 | " + day + "일 | " + " 인원: " + people + "명" + " | 조식여부: " + room.breakfast()  );
                }
                break;
            case "sweet": room = new SweetRoomReservation(name, roomGrade,day);
                roomList.add(room);
                System.out.println("예약이 완료되었습니다.");
                System.out.println("결제 금액은 :" + room.calcPrice(room.price));
                System.out.println("예약 내역: " + roomGrade + "룸 | " + day + "일 | " + " 인원: " + people + "명" + " | 조식여부: " + room.breakfast()  );
                break;
        }
    }
    //2.모든 룸의 정보 보기

    public static void roomInfo(){
        RoomReservation Single = new RoomReservation("1", "single", 2);
        Single.roomInfo();
        RoomReservation Double = new DoubleRoomReservation("1","double",1);
        Double.roomInfo();
        RoomReservation Twin = new TwinRoomReservation("1","twin",3);
        Twin.roomInfo();
        RoomReservation Sweet = new SweetRoomReservation("1","sweet",3);
        Sweet.roomInfo();
    }

    //3.모든 고객의 예약 정보 보기
    public static void reservationInfo(){
        for(RoomReservation room: roomList)  {

            System.out.println("예악자명: " + room.name + " | 예약한 룸: " + room.roomGrade + " | 일수: " + room.day + " | 조식여부: " + room.breakfast());
        }
    }
    //4.스캐너로 입력받은 예약자명으로 특정 고객의 예약 정보 보기(룸이름, 예약 일수, 조식제공여부)
    public static void searchReservation(){
        System.out.print("예약정보를 확인 할 고객명을 입력해주세요: ");
        String search = scanner.next();
        for(RoomReservation room: roomList){
            if(search.equals(room.name)){
                System.out.println("예악자명: " + room.name + " | 예약한 룸: " + room.roomGrade + " | 일수: " + room.day + " | 조식여부: " + room.breakfast());
                break;
            }else{
                System.out.println("일치하는 예약정보가 없습니다. 다시 확인해주세요.");
            }
        }
    }
}
