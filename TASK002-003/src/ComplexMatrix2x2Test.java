import org.junit.Assert;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;



public class ComplexMatrix2x2Test {

    @Test
    public void ConstructorShouldHaveZeroElements(){
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2();

        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==0 && complexMatrix2x2.getMatrix(0,0).getRe()==0
                && complexMatrix2x2.getMatrix(0,1).getIm()==0 && complexMatrix2x2.getMatrix(0,1).getRe()==0
                && complexMatrix2x2.getMatrix(1,0).getIm()==0 && complexMatrix2x2.getMatrix(1,0).getRe()==0
                && complexMatrix2x2.getMatrix(1,1).getIm()==0 && complexMatrix2x2.getMatrix(1,1).getRe()==0);

    }

    @Test
    public void allElementsShouldHaveSameValue(){
        ComplexNumber complexNumber=mock(ComplexNumber.class);
        when(complexNumber.getIm()).thenReturn(4.0);
        when(complexNumber.getRe()).thenReturn(1.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber);

        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==4 && complexMatrix2x2.getMatrix(0,0).getRe()==1
                && complexMatrix2x2.getMatrix(0,1).getIm()==4 && complexMatrix2x2.getMatrix(0,1).getRe()==1
                && complexMatrix2x2.getMatrix(1,0).getIm()==4 && complexMatrix2x2.getMatrix(1,0).getRe()==1
                && complexMatrix2x2.getMatrix(1,1).getIm()==4 && complexMatrix2x2.getMatrix(1,1).getRe()==1);
    }

    @Test
    public void allElementsShouldHaveMyValue(){
        ComplexNumber complexNumber=mock(ComplexNumber.class);
        when(complexNumber.getIm()).thenReturn(1.0,2.0,3.0,4.0);
        when(complexNumber.getRe()).thenReturn(5.0,6.0,7.0,8.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber,complexNumber,complexNumber,complexNumber);

        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==1 && complexMatrix2x2.getMatrix(0,0).getRe()==5
                && complexMatrix2x2.getMatrix(0,1).getIm()==2 && complexMatrix2x2.getMatrix(0,1).getRe()==6
                && complexMatrix2x2.getMatrix(1,0).getIm()==3 && complexMatrix2x2.getMatrix(1,0).getRe()==7
                && complexMatrix2x2.getMatrix(1,1).getIm()==4 && complexMatrix2x2.getMatrix(1,1).getRe()==8);
    }


    @Test
    public void matrixAddShouldBeCorrect(){

        ComplexNumber cn1=new ComplexNumber(1.0,2.0);
        ComplexNumber cn2=new ComplexNumber(2.0,3.0);
        ComplexNumber cn3=new ComplexNumber(3.0,4.0);
        ComplexNumber cn4=new ComplexNumber(4.0,5.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(cn1,cn2,cn3,cn4);
        ComplexMatrix2x2 complexMatrix2x21=new ComplexMatrix2x2(cn4,cn3,cn2,cn1);
        ComplexMatrix2x2 newMatrix=complexMatrix2x2.add(complexMatrix2x21);


        Assert.assertTrue(newMatrix.getMatrix(0,0).getIm()==7.0 && newMatrix.getMatrix(0,0).getRe()==5.0
                && newMatrix.getMatrix(0,1).getIm()==7.0 && newMatrix.getMatrix(0,1).getRe()==5.0
                && newMatrix.getMatrix(1,0).getIm()==7.0 && newMatrix.getMatrix(1,0).getRe()==5.0
                && newMatrix.getMatrix(1,1).getIm()==7.0 && newMatrix.getMatrix(1,1).getRe()==5.0);


    }

    @Test
    public void matrixMultShouldBeCorrect(){

        ComplexNumber cn1=new ComplexNumber(1.0,2.0);
        ComplexNumber cn2=new ComplexNumber(2.0,3.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(cn1);
        ComplexMatrix2x2 complexMatrix2x21=new ComplexMatrix2x2(cn2);
        ComplexMatrix2x2 newMatrix=complexMatrix2x2.mult(complexMatrix2x21);


        Assert.assertTrue(newMatrix.getMatrix(0,0).getIm()==14.0 && newMatrix.getMatrix(0,0).getRe()==(-8.0)
                && newMatrix.getMatrix(0,1).getIm()==14.0 && newMatrix.getMatrix(0,1).getRe()==(-8.0)
                && newMatrix.getMatrix(1,0).getIm()==14.0 && newMatrix.getMatrix(1,0).getRe()==(-8.0)
                && newMatrix.getMatrix(1,1).getIm()==14.0 && newMatrix.getMatrix(1,1).getRe()==(-8.0));

    }

    @Test
    public void matrixDetShouldBeCorrect(){

        ComplexNumber cn1=new ComplexNumber(1.0,2.0);
        ComplexNumber cn2=new ComplexNumber(2.0,3.0);
        ComplexNumber cn3=new ComplexNumber(3.0,4.0);
        ComplexNumber cn4=new ComplexNumber(4.0,5.0);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(cn1,cn2,cn3,cn4);
        ComplexNumber det=complexMatrix2x2.det();


        Assert.assertTrue(det.getIm()==-4.0 && det.getRe()==0);


    }
}
