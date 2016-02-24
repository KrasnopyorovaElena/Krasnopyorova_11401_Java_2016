public class Main {

    public static void main(String [] args) {
//        ComplexNumber complexNumber=new ComplexNumber(1,2);
//        ComplexNumber complex1=new ComplexNumber(3,4);
//        ComplexNumber res=complexNumber.mult(complex1);
//        System.out.println(res.toString());
//
//
//        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber,complex1,complex1,complexNumber);

        ComplexNumber cn1=new ComplexNumber(1.0,2.0);
        ComplexNumber cn2=new ComplexNumber(2.0,3.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(cn1);
        ComplexMatrix2x2 complexMatrix2x21=new ComplexMatrix2x2(cn2);


        ComplexMatrix2x2 newMatrix=complexMatrix2x2.mult(complexMatrix2x21);
        System.out.println(newMatrix.getMatrix(0,0)+ " "+
                newMatrix.getMatrix(0,1)+ " "+
                newMatrix.getMatrix(1,0)+ " "+
                newMatrix.getMatrix(1,1)+ " ");

    }
}
