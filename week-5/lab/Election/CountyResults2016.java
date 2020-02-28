//CountyResults class

public class CountyResults2016{

    public double demVotes;
    public double gopVotes;
    public double totalVotes;
    public double percentDem;
    public double percentGOP;
    public double difference;
    public String percentDifference;
    public String stateAbbreviation;
    public String county;
    public int fips;

    public CountyResults2016(){}

    public double getTotalVotes(){
       
        return this.totalVotes;
    }

    public double getDemVotes(){

        return this.demVotes;
    }

    public double getGOPVotes(){

        return this.gopVotes;
    }

    public double getDifference(){

        return this.difference;
    }

    public String getPercentDifference(){
        
        return this.percentDifference;
    }

    public String getState(){
        
        return this.stateAbbreviation;
    }

    public String getCounty(){

        return this.county;
    }

    @Override
    public String toString(){
        
        String results = ("Total: " + getTotalVotes() + "\nDem votes: " + getDemVotes() + 
        "\nGOP votes: " + getGOPVotes() + "\nDifference: " + getDifference() +  
        "\nPercentage of Difference: " + getPercentDifference() + "\nState: " 
        + getState() + "\nCounty: " + getCounty());

        return results;
    }
}