package Caclulatings;

public class Calculator {
    //current = 2.3520  prev = 2.3600
    public static String calculate_difference(float current, float previous) {
        float diff = ((previous - current) / previous) * 100;
        if (diff < 0)
            return current + " (-" + String.format("%.2f", diff) + "%)↘";
        return current + " (+" + String.format("%.2f", diff) + "%)↗";
    }
}
