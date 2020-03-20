public class MyPoint{
    
    //Fields
    private int x;
    private int y;

    //Constructors
    public MyPoint(){}

    public MyPoint(int x, int y){
        setXY(x, y);
    }

    public MyPoint(MyPoint copy){
        this.x = copy.x;
        this.y = copy.y;
    }
    
    //Getters
    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int[] getXY(){
        int[] point = new int[2];
        point[0] = x;
        point[1] = y; 
        return point;
    }

    //Setters
    public void setX(int x){
        this.x = x;
    }

    public void setY(int y){
        this.y = y;
    }

    public void setXY(int x, int y){
        setX(x);
        setY(y);
    }

    //Methods
    public String toString(){
        return "(" + getXY()[0] + ", " + getXY()[1] + ")";
    }

    public double distance(int x, int y){
        double dist = Math.sqrt(Math.pow(this.x-x,2) + Math.pow(this.y-y,2));

        return Math.round(dist*100)/100.0;
    }

    public double distance(MyPoint point){
        double dist = Math.sqrt(Math.pow(this.x-point.x,2) + Math.pow(this.y-point.y,2));

        return Math.round(dist*100)/100.0;
    }

    public double distance(){
        double dist = Math.sqrt(Math.pow(this.x,2) + Math.pow(this.y,2));

        return Math.round(dist*100)/100.0;
    }

    @Override
    public boolean equals(Object obj){
        
        //Down cast
        MyPoint other = (MyPoint) obj;
        
        //Comparing to down cast
        return x == other.x && y == other.y;
    }
}