package ActionsWithRates;

public class Calculator {

    public Calculator(Model newRate, Model prevRate) {
        this.USD_IN_NEW = newRate.getUSD_IN();
        this.USD_IN_PREV = prevRate.getUSD_IN();

        this.USD_OUT_NEW = newRate.getUSD_OUT();
        this.USD_OUT_PREV = prevRate.getUSD_OUT();

        this.EUR_IN_NEW = newRate.getEUR_IN();
        this.EUR_IN_PREV = prevRate.getEUR_IN();

        this.EUR_OUT_NEW = newRate.getEUR_OUT();
        this.EUR_OUT_PREV = prevRate.getEUR_OUT();
    }

    //current = 2.3520  prev = 2.3600
    public static String calculate_difference(float current, float previous) {
        float diff = ((previous - current) / previous) * 100;
        if(diff<0)
            return current + " (-" + String.format("%.2f", diff) + ")↘";
        return current + " (+" +  String.format("%.2f", diff) + ")↗";
    }

    private float USD_IN_PREV;
    private float USD_OUT_NEW;

    private float USD_OUT_PREV;
    private float USD_IN_NEW;

    private float EUR_IN_PREV;
    private float EUR_IN_NEW;

    private float EUR_OUT_PREV;
    private float EUR_OUT_NEW;

    public void setUSD_IN_PREV(float USD_IN_PREV) {
        this.USD_IN_PREV = USD_IN_PREV;
    }

    public void setUSD_OUT_NEW(float USD_OUT_NEW) {
        this.USD_OUT_NEW = USD_OUT_NEW;
    }

    public void setUSD_OUT_PREV(float USD_OUT_PREV) {
        this.USD_OUT_PREV = USD_OUT_PREV;
    }

    public void setUSD_IN_NEW(float USD_IN_NEW) {
        this.USD_IN_NEW = USD_IN_NEW;
    }

    public void setEUR_IN_PREV(float EUR_IN_PREV) {
        this.EUR_IN_PREV = EUR_IN_PREV;
    }

    public void setEUR_IN_NEW(float EUR_IN_NEW) {
        this.EUR_IN_NEW = EUR_IN_NEW;
    }

    public void setEUR_OUT_PREV(float EUR_OUT_PREV) {
        this.EUR_OUT_PREV = EUR_OUT_PREV;
    }

    public void setEUR_OUT_NEW(float EUR_OUT_NEW) {
        this.EUR_OUT_NEW = EUR_OUT_NEW;
    }

    public float getUSD_IN_PREV() {
        return USD_IN_PREV;
    }

    public float getUSD_OUT_NEW() {
        return USD_OUT_NEW;
    }

    public float getUSD_OUT_PREV() {
        return USD_OUT_PREV;
    }

    public float getUSD_IN_NEW() {
        return USD_IN_NEW;
    }

    public float getEUR_IN_PREV() {
        return EUR_IN_PREV;
    }

    public float getEUR_IN_NEW() {
        return EUR_IN_NEW;
    }

    public float getEUR_OUT_PREV() {
        return EUR_OUT_PREV;
    }

    public float getEUR_OUT_NEW() {
        return EUR_OUT_NEW;
    }
}
