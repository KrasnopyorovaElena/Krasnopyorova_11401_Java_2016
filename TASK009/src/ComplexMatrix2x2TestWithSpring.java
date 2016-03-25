import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class ComplexMatrix2x2TestWithSpring {

    @Test
    public void ConstructorShouldHaveZeroElements(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("nullComplexMatrix");
        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==0 && complexMatrix2x2.getMatrix(0,0).getRe()==0
                && complexMatrix2x2.getMatrix(0,1).getIm()==0 && complexMatrix2x2.getMatrix(0,1).getRe()==0
                && complexMatrix2x2.getMatrix(1,0).getIm()==0 && complexMatrix2x2.getMatrix(1,0).getRe()==0
                && complexMatrix2x2.getMatrix(1,1).getIm()==0 && complexMatrix2x2.getMatrix(1,1).getRe()==0);

    }

    @Test
    public void allElementsShouldHaveSameValue(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("complexMatrixWithSameValue");

        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==4 && complexMatrix2x2.getMatrix(0,0).getRe()==1
                && complexMatrix2x2.getMatrix(0,1).getIm()==4 && complexMatrix2x2.getMatrix(0,1).getRe()==1
                && complexMatrix2x2.getMatrix(1,0).getIm()==4 && complexMatrix2x2.getMatrix(1,0).getRe()==1
                && complexMatrix2x2.getMatrix(1,1).getIm()==4 && complexMatrix2x2.getMatrix(1,1).getRe()==1);
    }

    @Test
    public void allElementsShouldHaveMyValue(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("complexMatrixWithDifferentValue");
        Assert.assertTrue(complexMatrix2x2.getMatrix(0,0).getIm()==1 && complexMatrix2x2.getMatrix(0,0).getRe()==5
                && complexMatrix2x2.getMatrix(0,1).getIm()==2 && complexMatrix2x2.getMatrix(0,1).getRe()==6
                && complexMatrix2x2.getMatrix(1,0).getIm()==3 && complexMatrix2x2.getMatrix(1,0).getRe()==7
                && complexMatrix2x2.getMatrix(1,1).getIm()==4 && complexMatrix2x2.getMatrix(1,1).getRe()==8);
    }


    @Test
    public void matrixAddShouldBeCorrect(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("complexMatrixWithDifferentValue1");
        ComplexMatrix2x2 complexMatrix2x21 = (ComplexMatrix2x2) context.getBean("complexMatrixWithDifferentValue2");

        ComplexMatrix2x2 newMatrix=complexMatrix2x2.add(complexMatrix2x21);


        Assert.assertTrue(newMatrix.getMatrix(0,0).getIm()==7.0 && newMatrix.getMatrix(0,0).getRe()==5.0
                && newMatrix.getMatrix(0,1).getIm()==7.0 && newMatrix.getMatrix(0,1).getRe()==5.0
                && newMatrix.getMatrix(1,0).getIm()==7.0 && newMatrix.getMatrix(1,0).getRe()==5.0
                && newMatrix.getMatrix(1,1).getIm()==7.0 && newMatrix.getMatrix(1,1).getRe()==5.0);


    }

    @Test
    public void matrixMultShouldBeCorrect(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("complexMatrixWithSameValue1");
        ComplexMatrix2x2 complexMatrix2x21 = (ComplexMatrix2x2) context.getBean("complexMatrixWithSameValue2");
        ComplexMatrix2x2 newMatrix=complexMatrix2x2.mult(complexMatrix2x21);


        Assert.assertTrue(newMatrix.getMatrix(0,0).getIm()==14.0 && newMatrix.getMatrix(0,0).getRe()==(-8.0)
                && newMatrix.getMatrix(0,1).getIm()==14.0 && newMatrix.getMatrix(0,1).getRe()==(-8.0)
                && newMatrix.getMatrix(1,0).getIm()==14.0 && newMatrix.getMatrix(1,0).getRe()==(-8.0)
                && newMatrix.getMatrix(1,1).getIm()==14.0 && newMatrix.getMatrix(1,1).getRe()==(-8.0));

    }

    @Test
    public void matrixDetShouldBeCorrect(){

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) context.getBean("complexMatrixWithDifferentValue1");
        ComplexNumber det=complexMatrix2x2.det();


        Assert.assertTrue(det.getIm()==-4.0 && det.getRe()==0);


    }
}
