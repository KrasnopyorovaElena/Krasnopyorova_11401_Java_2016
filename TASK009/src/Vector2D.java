/**
 * Created by Elena on 24.02.2016.
 */
public class Vector2D {

    private double x,y;

    public Vector2D(double x, double y){
        this.x=x;
        this.y=y;
    }

    public Vector2D() {}



    public double length(){
        return Math.sqrt(x*x+y*y);
    }


    public static Vector2D sumVectors(Vector2D v1, Vector2D v2){
        double x1= v1.getX()+v2.getX();
        double y1= v1.getY()+v2.getY();
        Vector2D v=new Vector2D(x1,y1);
        return v;
    }

    public boolean equals(Object v){
        try {
            Vector2D v2 = (Vector2D) v;
            return (x==v2.getX() && y==v2.getY());
        }
        catch (ClassCastException e){
            return false;
        }
    }



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
