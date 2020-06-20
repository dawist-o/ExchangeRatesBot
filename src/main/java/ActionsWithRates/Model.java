package ActionsWithRates;

public class Model {

    private String time;
    private float USD_IN;
    private float USD_OUT;
    private float EUR_IN;
    private float EUR_OUT;

    public float getUSD_IN() {
        return USD_IN;
    }

    public float getUSD_OUT() {
        return USD_OUT;
    }

    public float getEUR_IN() {
        return EUR_IN;
    }

    public float getEUR_OUT() {
        return EUR_OUT;
    }

    public void setUSD_IN(float USD_IN) {
        this.USD_IN = USD_IN;
    }

    public void setUSD_OUT(float USD_OUT) {
        this.USD_OUT = USD_OUT;
    }

    public void setEUR_IN(float EUR_IN) {
        this.EUR_IN = EUR_IN;
    }

    public void setEUR_OUT(float EUR_OUT) {
        this.EUR_OUT = EUR_OUT;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}

