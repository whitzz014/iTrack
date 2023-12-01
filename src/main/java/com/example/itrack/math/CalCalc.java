package com.example.itrack.math;

public class CalCalc {

    double maleBmr;
    double femaleBmr;

    public  CalCalc(int age, String gender, int height, int weight, int goalWeight){
        switch (gender){
            case "Male":
                // checks age of user
                if (age < 18){
                    //checks goal -> weight > gWeight (cut), weight == gWeight (maintain), Weight < gWeight (Bulk)
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                         maleBmr = 10 * weight + 6.25 * height - 5 * age + 5;
                    }
                } else if (age < 30) {
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                        maleBmr = 10 * weight + 6.25 * height - 5 * age + 5;
                    }
                }else if (age < 60){
            if (weight > goalWeight){

                    } else if (weight< goalWeight) {

                    }else{
                    maleBmr = 10 * weight + 6.25 * height - 5 * age + 5;
                    }
                }else{
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                         maleBmr = 10 * weight + 6.25 * height - 5 * age + 5;
                    }
                }
                break;
            case "Female":
                if (age < 18){
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                         femaleBmr = 10 * weight + 6.25 * height - 5 * age - 161;

                    }
                } else if (age < 30) {
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                        femaleBmr = 10 * weight + 6.25 * height - 5 * age - 161;
                    }
                }else if (age < 60){
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                        femaleBmr = 10 * weight + 6.25 * height - 5 * age - 161;
                    }
                }else{
                    if (weight > goalWeight){

                    } else if (weight < goalWeight) {

                    }else{
                        femaleBmr = 10 * weight + 6.25 * height - 5 * age - 161;
                    }
                }
                break;
        }
    }
}
