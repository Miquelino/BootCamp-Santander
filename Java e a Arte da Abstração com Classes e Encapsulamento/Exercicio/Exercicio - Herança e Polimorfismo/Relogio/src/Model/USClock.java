package Model;

public non-sealed class USClock extends Clock {

    private String periodIndicator;

    public String getPeriodIndicator() {
        return periodIndicator;
    }

    public void setPeriodIndicator(String periodIndicator) {
        this.periodIndicator = periodIndicator;
    }

    public void setAfterMidday() {
        this.periodIndicator = "PM";
    }

    public void setBeforeMidday() {
        this.periodIndicator = "AM";
    }

    @Override
    public void setHour(int hour) {
        if (hour >= 24) {
            this.hour = 0;
            this.periodIndicator = "AM";
        } else if (hour >= 12) {
            this.hour = (hour > 12) ? hour - 12 : 12;
            this.periodIndicator = "PM";
        } else {
            this.hour = hour;
            this.periodIndicator = "AM";
        }
    }

    @Override
    public Clock convert(Clock clock) {
        this.second = clock.getSecond();
        this.minute = clock.getMinute();

        switch (clock) {
            case USClock usClock -> {
                this.hour = usClock.getHour();
                this.periodIndicator = usClock.getPeriodIndicator();
            }

            case BRLClock brlClock -> this.setHour(brlClock.getHour());
        }

        return this;
    }

    @Override
    public String getTime() {
        return super.getTime() + " " + this.periodIndicator;
    }
}
