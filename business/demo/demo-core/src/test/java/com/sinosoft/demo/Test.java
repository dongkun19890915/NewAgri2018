package com.sinosoft.demo;

import java.util.ArrayList;

public class Test {
    @org.junit.Test
    public void test() throws InterruptedException {
        ArrayList<TestDto> list = new ArrayList<>();
        for(int i=0;i<1000000;i++){
            TestDto dto = new TestDto(getString(),"0001",20);
            list.add(dto);
          Thread.sleep(1);
        }
    }
    public String getString(){
        return "张三asdhaohdaahoah" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +"xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +"xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "xauhdaoshdaipudhasidhaisduhapsdiuhasdiuahdiasuhd" +
                "aihdasudhaisudhhdoahasdasdasdasdasdasdasdasdadash" +
                "asdasdasdasdadpahdaopihdaiuhdaisdhapidhaiudasdasdasd" +
                "asdasdasdssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "sssssssssssssssssssssssssssssssssssssssssssssssssssss" +
                "ssssssssssssssssssssssssssssssssssssssssssssssssssssss" +


                "sssss";
    }
}
