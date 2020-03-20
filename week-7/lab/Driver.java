
public class Driver {
    public static void main(String[] args){
        
        //Point
        MyPoint point = new MyPoint(0,0);
        MyPoint p2 = new MyPoint(0,0);
        
        System.out.println("\n"+point);
        System.out.println(point.distance(-8,17));
        System.out.println(point.distance(p2));
        System.out.println(p2.distance());
        System.out.println(point.equals(p2));
        
        MyPoint[] graph = new MyPoint[10];
        for(int i = 1; i < 11; i++){
            
            graph[i-1] = (new MyPoint(i,i));
        }
        
        /*
        int i = 0;
        while(i<10){
            System.out.println(graph[i]);
            i++;
        }
        */
        
        //Circle
        MyPoint p3 = new MyPoint(0,0);
        MyPoint p4 = new MyPoint(3,4);
        MyCircle c = new MyCircle(p3,1);
        MyCircle c2 = new MyCircle(p4,1);
        System.out.println(c.distance(c2));
        System.out.println(c.equals(c2));
        

        MyCircle[] circles = new MyCircle[10];

        for(int j = 0; j < 10; j++){

            circles[j] = new MyCircle(graph[j],1);
        }
        /*
        int j = 0;
        while(j<10){
            System.out.println(circles[j]);
            j++;
        }
        */

        //Cylinder
        MyCircle.Cylinder cyl = new MyCircle().new Cylinder();
        
        MyCircle c1 = new MyCircle(4);
        //radius set at 4 via MyCircle
        MyCircle.Cylinder cyl2 = c1.new Cylinder();
        //Everything set through cylinder
        MyCircle.Cylinder cyl3 = c.new Cylinder(4,7,p4);
        //Height set through cylinder
        MyCircle.Cylinder cyl4 = c.new Cylinder(4);
        MyCircle.Cylinder cyl5 = c.new Cylinder(4,3);
        MyCircle.Cylinder cyl6 = c.new Cylinder(4);
        //Only height is set through cylinder subclass
        //Radius set through MyCircle
        MyCircle.Cylinder cyl7 = c1.new Cylinder(70);
        //Radius overloaded
        MyCircle.Cylinder cyl8 = c1.new Cylinder(7,70);

        System.out.println("\n1. " + cyl);
        System.out.println("\n2. " + cyl2);
        System.out.println("\n3. " + cyl3);
        System.out.println("\n4. " + cyl4);
        System.out.println("\n5. " + cyl5);
        System.out.println("\n6. " + cyl6);
        System.out.println("\n7. " + cyl7);
        System.out.println("\n8. " + cyl8);
        System.out.println("\nIs Equal: " + cyl4.equals(cyl6));
        System.out.println("\nIs Equal: " + cyl2.equals(cyl2));

        System.out.println("\n" + cyl.getArea() +"\n");
        System.out.println("\n(" + cyl3.getCenterXY()[0] + "," + cyl3.getCenterXY()[1] + ")\n");

        MyCircle[] circles2 = new MyCircle[10];

        for(int index = 0; index < 10; index++){
            if(index < 5) circles2[index] = new MyCircle();
            
            else circles2[index] = new MyCircle().new Cylinder();
        }

        int count = 0;
        while(count<10){
            System.out.println(circles2[count].toString());

            count++;
        }

        System.out.println("\n");
        //Compiler complains as method is only defined in Cylinder subclass
        //Cannot be called within MyCircle instance (MyCircle[])
        //Could be called in Cylinder[] though
        //System.out.print(circles2[5].getVolume());

        //Polymorphism foreshadow
        Object[] objList = new Object[8];

        for(int index = 0; index < 8; index++){
            if(index < 2) objList[index] = new MyPoint();
            
            else if(index < 4) objList[index] = new MyCircle();

            else if(index < 6) objList[index] = new MyCircle().new Cylinder();

            else if(index < 8)objList[index] = new Date(3,14,2020);
        }

        int count2 = 0;
        while(count2<8){
            System.out.println(objList[count2].toString());

            count2++;
        }

        //toString() is a method present in all Objects so it can be called
        //However methods that only exist within its subclasses cannot be called as they only
        //exist in those subclasses


    }   
}