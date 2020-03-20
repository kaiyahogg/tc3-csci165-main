public class MyCircle{
    
    private MyPoint center = new MyPoint(0,0);
    private int radius = 1;

    //Constructors
    public MyCircle(){}

    public MyCircle(int x, int y, int rad){
        setRadius(rad);
        setCenterX(x);
        setCenterY(y);
    }

    public MyCircle(MyPoint center, int rad){
        setCenter(center);
        setRadius(rad);;
    }

    public MyCircle(int r){
        //setCenter(center);
        setRadius(r);
    }

    public MyCircle(MyCircle copy){
        this.center = new MyPoint(copy.center);
        setRadius(copy.radius);;
    }

    //Getters
    public int getRadius(){
        return radius;
    }

    public MyPoint getCenter(){
        return new MyPoint(center);
    }
    
    public int getCenterX(){
        return new MyPoint(center).getX();
    }

    public int getCenterY(){
        return new MyPoint(center).getY();
    }

    public int[] getCenterXY(){
        int[] origin = new int [2];
        origin[0] = getCenterX();
        origin[1] = getCenterY();
        
        return origin;
    }

    public double getArea(){
        double pi = Math.PI;
        double area = pi*Math.pow(radius,2);

        return Math.round(area*100)/100;
    }

    public double getCircumference(){
        double pi = Math.PI;
        double circumference = 2*pi*radius;

        return Math.round(circumference*100)/100;
    }

    //Setters
    public void setRadius(int rad){
        this.radius = rad;
    }

    public void setCenter(MyPoint center){
        this.center = new MyPoint(center);
    }

    public void setCenterX(int x){
        new MyPoint(center).setX(x);
    }

    public void setCenterY(int y){
        new MyPoint(center).setY(y);
    }

    public void setCenterXY(int x, int y){
        MyPoint origin = new MyPoint(x,y);
        new MyPoint(origin);
    }

    //Methods
    @Override
    public String toString(){
        String message = "Center: " + new MyPoint(center) + " Radius: " + radius;
        
        return message;
    }

    public double distance(MyCircle other){
        return this.center.distance(other.center); 
    }

    @Override
    public boolean equals(Object obj){
        MyCircle other = (MyCircle) obj;

        return radius == other.radius && center == other.center;
    }

    //Subclass
    public class Cylinder extends MyCircle{

        //Fields
        private double height;

        //Constructors
        public Cylinder(){
            super(center,radius);
            height = 1.0;
        }

        public Cylinder(double h){
            super(center,radius);
            setHeight(h);
        }

        public Cylinder(int r, double h){
            super(r);
            setHeight(h);
        }

        public Cylinder(int r, double h, MyPoint p){
            super(p,r);
            setHeight(h);
        }

        //Getters
        public double getHeight(){
            return height;
        }

        public double getVolume(){
            double v = getArea()*height;

            return v;
        }

        //Setters
        public void setHeight(double h){
            this.height = h;
        }

        //Methods
        public String toString(){
            return "Cylinder has surface: " + super.toString() + " Height: " + height + " Volume: " + getVolume();
        }
        
        @Override
        public boolean equals(Object obj){

            MyCircle.Cylinder other = (Cylinder) obj;
            return super.equals(other);
        }
        
    }   
}