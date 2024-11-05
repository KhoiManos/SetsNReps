package io.github.khoimanos;

public class Session {
    private String excersizeOne;
    private String excersizeTwo;
    private String excersizeThree;
    private String excersizeFour;

    public Session(String excersizeOne, String excersizeTwo, String excersizeThree, String excersizeFour) {
        this.excersizeOne = excersizeOne;
        this.excersizeTwo = excersizeTwo;
        this.excersizeThree = excersizeThree;
        this.excersizeFour = excersizeFour;
    }

    public String getExcersizeOne() {
        return excersizeOne;
    }

    public String getExcersizeTwo() {
        return excersizeTwo;
    }

    public String getExcersizeThree() {
        return excersizeThree;
    }

    public String getExcersizeFour() {
        return excersizeFour;
    }

}