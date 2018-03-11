package ua.kpi.tef;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private int minBarrier;
    private int maxBarrier;
    private int secretValue;
    private List<Integer> yourWay = new ArrayList<Integer>();

    public boolean checkMinBarrier (int value){
        if (value < GlobalConstants.PRIMARY_MIN_BARRIER || value >= GlobalConstants.PRIMARY_MAX_BARRIER - 1){
            return false;
        } else {
            this.minBarrier = value;
        }
        return true;
    }

    public boolean checkMaxBarrier (int value){
        if (value <= this.minBarrier +1 || value > GlobalConstants.PRIMARY_MAX_BARRIER){
            return false;
        } else {
            this.maxBarrier = value;
        }
        return true;
    }

    public boolean checkValue (int value){
        yourWay.add(value);
        if (value == secretValue){
            return true;
        } else if (value > secretValue){
            maxBarrier = value;
        } else {
            minBarrier = value;
        }
      return false;
    }

    public void setPrimaryBarrier(int minBarrier, int maxBarrier){
        this.minBarrier = minBarrier;
        this.maxBarrier = maxBarrier;
    }

    public void setSecretValue() {
        secretValue = (int)Math.ceil(Math.random() *
                (maxBarrier - minBarrier - 1) + minBarrier);
    }

    public int getSecretValue() {
        return secretValue;
    }

    public int getMinBarrier() {
        return minBarrier;
    }

    public int getMaxBarrier() {
        return maxBarrier;
    }

    public List<Integer> getYourWay() {
        return yourWay;
    }
}
