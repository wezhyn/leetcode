package com.examination.fourZeroNine.one;


import java.time.LocalTime;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()) {
            int n=scanner.nextInt();
            final String[] inputHour=scanner.next().split(":");
            int hour=Integer.parseInt(inputHour[0]);
            int minutes=Integer.parseInt(inputHour[1]);
            int preMinutes=scanner.nextInt();
            int route=preMinutes/(24*60);
            preMinutes=preMinutes - route*24*60;
            int preHours=preMinutes/60;
            int data=(n + 7 - route%7)%7;
            if (preHours > hour) {
                data=(n + 7 - route%7)%7 - 1;
                int minHour=preHours - hour;
                hour=24 - minHour;
                preMinutes=preMinutes - 60*preHours;
            }
            System.out.println(data);
            LocalTime time=LocalTime.of(hour, minutes);
            int preHour=preMinutes/60;
            time=time.minusHours(preHour);
            int preminutes=preMinutes - preHour*60;
            time=time.minusMinutes(preminutes);
            int dh=time.getHour();
            int dm=time.getMinute();
            System.out.printf("%s:%s\n", dh < 10 ? "0" + dh : dh, dm < 10 ? "0" + dm : dm);
        }
    }
}
