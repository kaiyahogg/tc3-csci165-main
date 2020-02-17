public class Radio{

    // class features
    public static enum  Band{AM, FM};
    public static final int[] AM_SPECTRUM = {535, 1700};
    public static final int[] FM_SPECTRUM = {88, 108};

    // instance features
    //Object state
    //Class level
    private int     volume  = 0;
    private boolean on      = false;
    private Band    band    = Band.FM;
    private double  channel = FM_SPECTRUM[0];

    @Override
    public String toString(){
        
        //Local variables
        String state = "";
        if(on) state = (band == Band.FM  ? "FM: " : "AM: ") + channel + " Volume: " + volume;
        else   state = "Radio Off";
        return state;
    }
}