package com.uiop07558.javalab3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in, "UTF-8");

    System.out.println("Введите ФИО:");
    String fullName = scanner.nextLine();

    System.out.println("Введите дату рождения (дд.мм.гггг):");
    String dateOfBirthInput = scanner.nextLine();

    String[] nameParts = fullName.split(" ");
    if (nameParts.length != 3) {
      System.out.println("Неполное ФИО");
      return;
    }

    String surname = nameParts[0];
    String name = nameParts[1];
    String patronymic = nameParts[2];

    String initials = surname + " " + name.charAt(0) + "." + patronymic.charAt(0) + ".";
    System.out.println("Инициалы: " + initials);

    String gender;
    if (patronymic.endsWith("ич")) {
      gender = "М";
    } else if (patronymic.endsWith("на")) {
      gender = "Ж";
    } else {
      gender = "ОПРЕДЕЛИТЬ_НЕ_УДАЛОСЬ";
    }
    System.out.println("Пол: " + gender);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    LocalDate birthDate = LocalDate.parse(dateOfBirthInput, formatter);
    LocalDate currentDate = LocalDate.now();

    long age = ChronoUnit.YEARS.between(birthDate, currentDate);

    String ageSuffix;
    if (age % 10 == 1 && age % 100 != 11) {
      ageSuffix = "год";
    } else if (age % 10 >= 2 && age % 10 <= 4 && (age % 100 < 10 || age % 100 >= 20)) {
      ageSuffix = "года";
    } else {
      ageSuffix = "лет";
    }

    System.out.println("Возраст: " + age + " " + ageSuffix);
  }
}
