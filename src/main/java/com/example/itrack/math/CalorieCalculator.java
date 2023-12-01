//package com.example.itrack.math;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Files;
//import java.util.List;
//
//public class CalorieCalculator {
//
//        int totalCalories;
//        int userAge;
//        int userHeight;
//        int userWeight;
//        int userGoalWeight;
//        String userGender;
//
//    public CalorieCalculator(int age, String gender, int height, int weight, int goalWeight) {
//        String[] info = new String[6];
//
//        String age = readCertainLine("person_info.txt", 2);
//        String gender = readCertainLine("person_info.txt", 3);
//        String height = readCertainLine("person_info.txt", 4);
//        String weight = readCertainLine("person_info.txt", 5);
//        String gWeight = readCertainLine("person_info.txt", 6);
//
//        System.out.println(age + "\n" + gender +"\n" + height +"\n" + weight +"\n" + gWeight);
//
//        userAge = Integer.parseInt(age);
//        userGoalWeight = Integer.parseInt(gWeight);
//        userWeight = Integer.parseInt(weight);
//        userHeight = Integer.parseInt(height);
//        userGender = gender;
//
//
//        //checks gender
//        switch (gender){
//            case "Male":
//                // checks age of user
//              if (Integer.parseInt(age) < 18){
//                  //checks goal -> weight > gWeight (cut), weight == gWeight (maintain), Weight < gWeight (Bulk)
//                  if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                  } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                  }else{
//                      double maleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge + 5;
//                  }
//              } else if (Integer.parseInt(age) < 30) {
//                  if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                  } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                  }else{
//                      double maleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge + 5;
//                  }
//              }else if (Integer.parseInt(age) < 60){
//                  if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                  } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                  }else{
//                      double maleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge + 5;
//                  }
//              }else{
//                  if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                  } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                  }else{
//                      double maleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge + 5;
//                  }
//              }
//                break;
//            case "Female":
//                if (Integer.parseInt(age) < 18){
//                    if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                    } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                    }else{
//                        double femaleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge - 161;
//
//                    }
//                } else if (Integer.parseInt(age) < 30) {
//                    if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                    } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                    }else{
//                        double femaleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge - 161;
//
//                    }
//                }else if (Integer.parseInt(age) < 60){
//                    if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                    } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                    }else{
//                        double femaleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge - 161;
//
//                    }
//                }else{
//                    if (Integer.parseInt(weight) > Integer.parseInt(gWeight)){
//
//                    } else if (Integer.parseInt(weight) < Integer.parseInt(gWeight)) {
//
//                    }else{
//                        double femaleBmr = 10 * userWeight + 6.25 * userHeight - 5 * userAge - 161;
//
//                    }
//                }
//                break;
//        }
//        System.out.println(info[3]);
//    }
//
////interchangeable if more files are created
//    private static String readCertainLine(String fileName, int lineNumber){
//        File file = new File(fileName);
//        try{
//            List<String> lines = Files.readAllLines(file.toPath());
//            if (lineNumber >= 1 && lineNumber<=lines.size()){
//                return lines.get(lineNumber-1);
//            }
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        return null;
//    }
//
//
//    public static void main(String[] args) {
//        System.out.println(new CalorieCalculator());
//
//
//    }
//}
