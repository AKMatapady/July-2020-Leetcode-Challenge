class Solution {
    public double angleClock(int hour, int minutes) {
        double ha = ((double)hour *  30) +((double)minutes*(0.5));
        double ma = (double)minutes*(6);
        return Math.min(Math.abs(ha-ma), 360-Math.abs(ha-ma));
    }
}