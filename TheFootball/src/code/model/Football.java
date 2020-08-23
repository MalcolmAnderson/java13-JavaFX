package code.model;

public class Football {
    private String league;
    private boolean laced;
    private String color;
    private float inflation;

    public Football(String league, boolean laced, String color, float inflation) {
        this.league = league;
        this.laced = laced;
        this.color = color;
        this.inflation = inflation;
    }

    public String DisplayStatus(){
        String lacedStatus = laced ? "laced" : "unlaced";
        String retVal = "A " + color + " and " + lacedStatus + " " + league + " football is ready at " + inflation + " psi";
        return retVal;
    }

    public void getHandoff(){}

}
