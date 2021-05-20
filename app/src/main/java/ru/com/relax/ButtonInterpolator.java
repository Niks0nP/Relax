package ru.com.relax;

public class ButtonInterpolator implements android.view.animation.Interpolator{

    private double bAmplitude;
    private double bFrequency;

    public ButtonInterpolator(double bAmplitude, double bFrequency) {
        this.bAmplitude = bAmplitude;
        this.bFrequency = bFrequency;
    }

    @Override
    public float getInterpolation(float input) {
        return (float) (-1 * Math.pow(Math.E, - input / bAmplitude) *
                Math.cos(bFrequency * input) + 1);
    }
}
