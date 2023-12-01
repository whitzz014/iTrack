package com.example.itrack.math;

public class CalCalc {
    private int weight;
    private int height;
    private int age;
    private double tdee;
    private int totalCal;

    public CalCalc(int age, String gender, int height, int weight, int goalWeight, String activityLevel) {
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.tdee = calculateTDEE(gender, activityLevel);
        this.totalCal = calculateTotalCal(goalWeight);
    }

    private double calculateBMR(String gender) {
        if ("Male".equals(gender)) {
            return 10 * weight + 6.25 * height - 5 * age + 5;
        } else {
            return 10 * weight + 6.25 * height - 5 * age - 161;
        }
    }

    private double calculateTDEE(String gender, String activityLevel) {
        double bmr = calculateBMR(gender);

        switch (activityLevel) {
            case "Sedentary (little or no exercise)":
                return bmr * 1.2;
            case "Lightly active (light exercise/sports 1-3 days/week)":
                return bmr * 1.375;
            case "Moderately active (moderate exercise/sports 3-5 days/week)":
                return bmr * 1.55;
            case "Very active (hard exercise/sports 6-7 days a week)":
                return bmr * 1.725;
            case "Extremely active (very hard exercise/sports & physical job or 2x training)":
                return bmr * 1.9;
            default:
                throw new IllegalArgumentException("Invalid activity level: " + activityLevel);
        }
    }

    private int calculateTotalCal(int goalWeight) {
            if (weight > goalWeight) {
                return (int) (tdee - 500);
            } else if (weight < goalWeight) {
                return (int) (tdee + 500);
            } else {
                return (int) tdee;
        }
    }

    // Getters and other methods...

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getTdee() {
        return tdee;
    }

    public void setTdee(double tdee) {
        this.tdee = tdee;
    }

    public int getTotalCal() {
        return totalCal;
    }

    public void setTotalCal(int totalCal) {
        this.totalCal = totalCal;
    }

}
