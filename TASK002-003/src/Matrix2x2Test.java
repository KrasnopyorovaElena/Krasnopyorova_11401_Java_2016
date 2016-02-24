import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Elena on 25.02.2016.
 */
public class Matrix2x2Test {

    @Test
    public void ConstructorShouldHaveZeroElements(){
        Matrix2x2 matrix2x2=new Matrix2x2();
        Assert.assertTrue(0==matrix2x2.getMatrix(0,0)&& 0==matrix2x2.getMatrix(0,1)&&
                0==matrix2x2.getMatrix(1,0)&&0==matrix2x2.getMatrix(1,1));

    }

    @Test
    public void allElementsShouldHaveSameValue(){
        Matrix2x2 matrix2x2=new Matrix2x2(3);
        Assert.assertTrue(3==matrix2x2.getMatrix(0,0)&& 3==matrix2x2.getMatrix(0,1)&&
                3==matrix2x2.getMatrix(1,0)&& 3==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void allElementsShouldHaveValueFromArray(){
        double [][] matrix={{1,2},
                            {3,4}};
        Matrix2x2 matrix2x2=new Matrix2x2(matrix);
        Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void allElementsShouldHaveMyValue(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void AllElementsShouldHaveValueFromArray(){
        double [][] matrix={{1,2},
                            {3,4}};
        Matrix2x2 matrix2x2=new Matrix2x2();
        matrix2x2.setMatrix(matrix);
        Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void elementShouldHaveTheCorrectValue(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,5,3,6);
        Assert.assertTrue(3==matrix2x2.getMatrix(1,0));
    }

    @Test
    public void matrixAddShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        Matrix2x2 newMatrix=matrix2x2.add(matrix2x21);
        Assert.assertTrue(6 == newMatrix.getMatrix(0, 0) && 8 == newMatrix.getMatrix(0, 1) &&
                10 == newMatrix.getMatrix(1, 0) && 12 == newMatrix.getMatrix(1, 1));
    }

    @Test
    public void matrixAddShouldBeCorrect2(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        matrix2x2.add2(matrix2x21);
        Assert.assertTrue(6==matrix2x2.getMatrix(0,0)&& 8==matrix2x2.getMatrix(0,1)&&
                10==matrix2x2.getMatrix(1,0)&& 12==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void matrixSubShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        Matrix2x2 newMatrix=matrix2x21.sub(matrix2x2);
        Assert.assertTrue(4 == newMatrix.getMatrix(0, 0) && 4 == newMatrix.getMatrix(0, 1) &&
                4 == newMatrix.getMatrix(1, 0) && 4 == newMatrix.getMatrix(1, 1));
    }

    @Test
    public void matrixSubShouldBeCorrect2(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        matrix2x21.sub2(matrix2x2);
        Assert.assertTrue(4 == matrix2x21.getMatrix(0, 0) && 4 == matrix2x21.getMatrix(0, 1) &&
                4 == matrix2x21.getMatrix(1, 0) && 4 == matrix2x21.getMatrix(1, 1));
    }

    @Test
    public void matrixMultNumberShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 newMatrix=matrix2x2.multNumber(5);
        Assert.assertTrue(5 == newMatrix.getMatrix(0, 0) && 10 == newMatrix.getMatrix(0, 1) &&
                15 == newMatrix.getMatrix(1, 0) && 20 == newMatrix.getMatrix(1, 1));
    }

    @Test
    public void matrixMultNumberShouldBeCorrect2(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        matrix2x2.multNumber2(5);
        Assert.assertTrue(5 == matrix2x2.getMatrix(0, 0) && 10 ==matrix2x2.getMatrix(0, 1) &&
                15 == matrix2x2.getMatrix(1, 0) && 20 == matrix2x2.getMatrix(1, 1));
    }

    @Test
    public void matrixMultShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        Matrix2x2 newMatrix= matrix2x2.mult(matrix2x21);
        Assert.assertTrue(19 == newMatrix.getMatrix(0, 0) && 22 == newMatrix.getMatrix(0, 1) &&
                43 == newMatrix.getMatrix(1, 0) && 50 == newMatrix.getMatrix(1, 1));
    }

    @Test
    public void matrixMultShouldBeCorrect2(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 matrix2x21=new Matrix2x2(5,6,7,8);
        matrix2x2.mult2(matrix2x21);
        Assert.assertTrue(19 == matrix2x2.getMatrix(0, 0) && 22 == matrix2x2.getMatrix(0, 1) &&
                43 == matrix2x2.getMatrix(1, 0) && 50 == matrix2x2.getMatrix(1, 1));
    }

    @Test
    public void matrixDetShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Assert.assertTrue(-2==matrix2x2.det());
    }

    @Test
    public void matrixTransponShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        matrix2x2.transpon();
        Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&&3==matrix2x2.getMatrix(0,1)&&
                            2==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
    }

    @Test
    public void InverseMatrixShouldBeCorrect() throws ZeroDetException {
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 inverseMatrix= matrix2x2.inverseMatrix();
        Assert.assertTrue(-2 == inverseMatrix.getMatrix(0, 0) && 1 == inverseMatrix.getMatrix(0, 1) &&
                1.5 == inverseMatrix.getMatrix(1, 0) && -0.5 == inverseMatrix.getMatrix(1, 1));
    }

    @Test(expected = ZeroDetException.class)
    public void inverseMatrixWithZeroDet() throws ZeroDetException{
        Matrix2x2 matrix2x2=new Matrix2x2();
        Matrix2x2 inverseMatrix=matrix2x2.inverseMatrix();
    }

    @Test
    public void EquivalentMatrixShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Matrix2x2 equivMatrix = matrix2x2.equivalentDiagonal();
        Assert.assertTrue(1==equivMatrix.getMatrix(0,0)&&0==equivMatrix.getMatrix(0,1)&&
                0==equivMatrix.getMatrix(1,0)&& -2==equivMatrix.getMatrix(1,1));
    }

    @Test
    public void matrixMultVectorShouldBeCorrect(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        Vector2D vector2D=new Vector2D(1,2);
        Vector2D newVector=matrix2x2.multVector(vector2D);
        Assert.assertTrue(5==newVector.getX()&&11==newVector.getY());
    }
}
