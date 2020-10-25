package org.fedran.olympiad;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.time.Year.isLeap;

public class SplittingIntoDateIntervals {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        LocalDate start = LocalDate.parse(in.next());
        LocalDate end = LocalDate.parse(in.next());
        int year = start.getYear();
        long count = 0L;
        List<String> stringList = new ArrayList<>();
        switch (s) {
            case "WEEK":
                LocalDate endOfWeek;
                if (start.getDayOfWeek().equals(DayOfWeek.MONDAY)) {
                    endOfWeek = start.plusDays(6);
                } else if (start.getDayOfWeek().equals(DayOfWeek.TUESDAY)) {
                    endOfWeek = start.plusDays(5);
                } else if (start.getDayOfWeek().equals(DayOfWeek.WEDNESDAY)) {
                    endOfWeek = start.plusDays(4);
                } else if (start.getDayOfWeek().equals(DayOfWeek.THURSDAY)) {
                    endOfWeek = start.plusDays(3);
                } else if (start.getDayOfWeek().equals(DayOfWeek.FRIDAY)) {
                    endOfWeek = start.plusDays(2);
                } else if (start.getDayOfWeek().equals(DayOfWeek.SATURDAY)) {
                    endOfWeek = start.plusDays(1);
                } else {
                    endOfWeek = start;
                }
                for (LocalDate localDate = endOfWeek; localDate.isBefore(end); localDate = localDate.plusWeeks(1)) {
                    if (localDate.isEqual(endOfWeek)) {
                        stringList.add(start + " " + endOfWeek);
                        count++;
                    }
                    if (localDate.plusWeeks(1).isAfter(end)) {
                        stringList.add(localDate.plusDays(1) + " " + end);
                        count++;
                        break;
                    }
                    stringList.add(localDate.plusDays(1) + " " + localDate.plusWeeks(1));
                    count++;
                }
                System.out.println(count);
                stringList.forEach(System.out::println);
                break;
            case "MONTH":
                LocalDate endOfMonth = start.plusMonths(1).withDayOfMonth(1).minusDays(1);
                for (LocalDate localDate = endOfMonth; localDate.isBefore(end); localDate = localDate.plusMonths(1)) {
                    if (localDate.isEqual(endOfMonth)) {
                        stringList.add(start + " " + endOfMonth);
                        count++;
                    }
                    if (localDate.plusMonths(1).isAfter(end)) {
                        stringList.add(localDate.plusDays(1) + " " + end);
                        count++;
                        break;
                    }
                    stringList.add(localDate.plusDays(1) + " " + localDate.plusMonths(1));
                    count++;
                }
                System.out.println(count);
                stringList.forEach(System.out::println);
                break;
            case "QUARTER": {
                LocalDate endOfQrter;
                if (start.getMonthValue() == 1 || start.getMonthValue() == 2 || start.getMonthValue() == 3) {
                    endOfQrter = LocalDate.of(year, Month.MARCH, 31);
                } else if (start.getMonthValue() == 4 || start.getMonthValue() == 5 || start.getMonthValue() == 6) {
                    endOfQrter = LocalDate.of(year, Month.JUNE, 30);
                } else if (start.getMonthValue() == 7 || start.getMonthValue() == 8 || start.getMonthValue() == 9) {
                    endOfQrter = LocalDate.of(year, Month.SEPTEMBER, 30);
                } else {
                    endOfQrter = LocalDate.of(year, Month.DECEMBER, 31);
                }
                for (LocalDate localDate = endOfQrter; localDate.isBefore(end); localDate = localDate.plusMonths(3)) {
                    if (localDate.isEqual(endOfQrter)) {
                        stringList.add(start + " " + endOfQrter);
                        count++;
                    }
                    if (localDate.plusMonths(3).isAfter(end)) {
                        stringList.add(localDate.plusDays(1) + " " + end);
                        count++;
                        break;
                    }
                    stringList.add(localDate.plusDays(1) + " " + localDate.plusMonths(3));
                    count++;
                }
                System.out.println(count);
                stringList.forEach(System.out::println);
                break;
            }
            case "YEAR":
                LocalDate endOfYear = LocalDate.of(year, Month.DECEMBER, 31);
                for (LocalDate localDate = endOfYear; localDate.isBefore(end); localDate = localDate.plusYears(1)) {
                    if (localDate.isEqual(endOfYear)) {
                        stringList.add(start + " " + endOfYear);
                        count++;
                    }
                    if (localDate.plusYears(1).isAfter(end)) {
                        stringList.add(localDate.plusDays(1) + " " + end);
                        count++;
                        break;
                    }
                    stringList.add(localDate.plusDays(1) + " " + localDate.plusYears(1));
                    count++;
                }
                System.out.println(count);
                stringList.forEach(System.out::println);
                break;
            case "FEBRUARY_THE_29TH":
                LocalDate endOfPeriod;
                if (isLeap(year)) {
                    if (start.isAfter(LocalDate.of(year, Month.FEBRUARY, 28))) {
                        year++;
                        while (!isLeap(year)) {
                            year++;
                        }
                        endOfPeriod = LocalDate.of(year, Month.FEBRUARY, 28);
                    } else {
                        endOfPeriod = LocalDate.of(year, Month.FEBRUARY, 28);
                    }
                } else {
                    while (!isLeap(year)) {
                        year++;
                    }
                    endOfPeriod = LocalDate.of(year, Month.FEBRUARY, 28);
                }
                for (LocalDate localDate = endOfPeriod; localDate.isBefore(end); localDate = localDate.plusYears(4)) {
                    if (localDate.isEqual(endOfPeriod)) {
                        stringList.add(start + " " + endOfPeriod);
                        count++;
                    }
                    if (localDate.plusYears(4).isAfter(end)) {
                        stringList.add(localDate.plusDays(1) + " " + end);
                        count++;
                        break;
                    }
                    stringList.add(localDate.plusDays(1) + " " + localDate.plusYears(4));
                    count++;
                }
                System.out.println(count);
                stringList.forEach(System.out::println);
                break;
        }
    }
}

