package customer.project.application;

import customer.project.Customer;
import customer.project.GoldCustomer;
import customer.project.VIPCustomer;

import java.util.ArrayList;

public class CustomerApplication {
    //<Customer>: 제네릭 -> ArrayList에 저장할 타입을 지정.
    //CustomerList에는 Customer 타입의 객체만 저장가능
    //ArrayList: 중복된 데이터 저장 가능, 순서대로 인덱스번호를 생성해 저장
    private static ArrayList<Customer> customerList = new ArrayList<>();

    public static void main(String[] args) {
        Customer customerLee = new Customer(10010, "이영광");
        Customer customerShin = new Customer(10020, "신사임당");
        Customer customerHong = new GoldCustomer(10030, "홍길동");
        Customer customerJeong = new GoldCustomer(10040, "정약용");
        Customer customerLee2 = new VIPCustomer(10050, "이율곡", 10201);

        //CustomerList에 고객 객체 저장
        customerList.add(customerLee);
        customerList.add(customerShin);
        customerList.add(customerHong);
        customerList.add(customerJeong);
        customerList.add(customerLee2);

        //arrayList 실습
        /*
        System.out.println("customerList 사이즈: " + customerList.size()); //배열의 length
        Customer getCustomer = customerList.get(2); //get(index 번호) 배열 2번 -> 홍길동 객체
        System.out.println("getCustomer" + getCustomer.getCustomerName());

        customerList.remove(0);
        Customer getCustomer2 = customerList.get(0); //홍길동 객체
        System.out.println(getCustomer2.getCustomerName());

         */
        showAllCustomer();
        //id로 찾은 고객의 실제 지불금액과 적립된 포인트 출력
        Customer customer =  findCustomer(10050);
        if (customer ==null){
            System.out.println("경고: 존재하지 않는 회원입니다.");
        } else {
            showPriceBonus(customer, 10000); //이율곡(10050) 고객은 1만원 상품 구매
        }
    }


    public static void showAllCustomer() {
        System.out.println("================모든 고객 정보 출력================");
        for (Customer customer : customerList) {
            System.out.println(customer.showCustomerInfo());
        }
    }

    //id로 고객 찾기
    public static Customer findCustomer(int customerID) {
        Customer resultCustomer = null;

        for (Customer customer : customerList) {
            if (customer.getCustomerID() == customerID) {
                resultCustomer = customer; //id가 같은 Customer 객체
                break; //id는 중복되지 않은 값, 1명밖에 없으므로 해당 id를 찾으면 반복문 종료
            }
        }
        return resultCustomer; //찾은 Cutomer 객체를 리턴
    }

    //찾은 고객의 실제지불금액과 포인트 출력
    public static void showPriceBonus(Customer customer, int price){
        System.out.println("=====" + customer.getCustomerName() + "고객의 지불금액과 포인트 내역 =====");
        System.out.println("지불 금액: " + customer.calcPrice(price));
        System.out.println("현재 보너스 포인트: " + customer.bonusPoint + "점");
    }

}