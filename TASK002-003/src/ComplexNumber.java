
public class ComplexNumber {

    private double Re;
    private double Im;

    public ComplexNumber(){
        this.Re = 0;
        this.Im = 0;
    }

    public ComplexNumber (double Re){
        this.Re = Re;
        this.Im = 0;
    }
    public ComplexNumber(double Re, double Im){
        this.Re = Re;
        this.Im = Im;
    }

    public void setRe(double Re) {
        this.Re = Re;
    }

    public void setIm(double Im) {
        this.Im = Im;
    }

    public double getRe() {
        return Re;
    }

    public double getIm(){
        return Im;
    }

    public ComplexNumber add(ComplexNumber number){
        double newRe = this.Re + number.Re;
        double newIm = this.Im + number.Im;
        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);

        return newComNum;
    }
    public void add2 (ComplexNumber number){
        this.Re = this.Re + number.Re;
        this.Im = this.Im + number.Im;

    }
    public ComplexNumber sub(ComplexNumber number){
        double newRe = this.Re - number.Re;
        double newIm = this.Im - number.Im;
        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);

        return newComNum;
    }
    public void sub2 (ComplexNumber number){
        this.Re = this.Re - number.Re;
        this.Im = this.Im - number.Im;

    }
    public ComplexNumber multNumber(double n){
        double newRe = this.Re * n;
        double newIm = this.Im * n;
        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);

        return newComNum;
    }
    public void multNumber2 (double n){
        this.Re = this.Re * n;
        this.Im = this.Im * n;

    }
    public ComplexNumber mult(ComplexNumber number){
//        double newRe = this.Re * number.Re - this.Im * number.Im;
//        double newIm = this.Re * number.Im + this.Im * number.Re;
//        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);
//
//        return newComNum;
        double newRe = getRe() * number.getRe() - getIm() * number.getIm();
        double newIm = getRe() * number.getIm() + getIm() * number.getRe();
        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);

        return newComNum;
    }
    public void mult2 (ComplexNumber number){
        this.Re = this.Re * number.Re - this.Im * number.Im;
        this.Im = this.Re * number.Im - this.Im * number.Re;

    }
    public ComplexNumber div(ComplexNumber number){
        double newRe = (this.Re * number.Re + this.Im * number.Im) / (number.Re * number.Re + number.Im * number.Im);
        double newIm = (this.Re * number.Im - this.Im * number.Re)/ (number.Re * number.Re + number.Im * number.Im);
        ComplexNumber newComNum = new ComplexNumber(newRe, newIm);

        return newComNum;
    }
    public void div2 (ComplexNumber number){
        this.Re = (this.Re * number.Re + this.Im * number.Im) / (number.Re * number.Re + number.Im * number.Im);
        this.Im = (this.Re * number.Im - this.Im * number.Re)/ (number.Re * number.Re + number.Im * number.Im);

    }
    public double length(){
        double mod = Math.sqrt(this.Re * this.Re + this.Im * this.Im);
        return mod;
    }
    public String toString(){
        String stroka = "" ;
        if(this.Im > 0){
            stroka = this.Re + " + " + this.Im + " * i";

        } else if (this.Im == 0){
            stroka = this.Re + "";

        } else {
            stroka = this.Re + " - " + this.Im * (-1) + " * i";

        }
        return stroka;
    }
    public double arg(){
        double argu = Math.atan(this.Im / this.Re);
        return argu;
    }
    public ComplexNumber pow(double n){
        double powRe = Math.pow(this.length(), n) * Math.cos(n * this.arg());
        double powIm = Math.pow(this.length(), n) * Math.sin(n * this.arg());
        ComplexNumber comNumPow = new ComplexNumber(powRe, powIm);
        return comNumPow;
    }
    public boolean equals(ComplexNumber number){
        boolean equal = false;
        if(this.Re == number.getRe() && this.Im == number.getIm()){
            equal = true;
        }
        return equal;

    }


}

