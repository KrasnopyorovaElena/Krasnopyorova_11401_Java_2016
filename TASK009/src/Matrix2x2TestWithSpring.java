import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by Elena.
 */
public class Matrix2x2TestWithSpring {


        @Test
        public void ConstructorShouldHaveZeroElements(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("nullMatrix");
            Assert.assertTrue(0==matrix2x2.getMatrix(0,0)&& 0==matrix2x2.getMatrix(0,1)&&
                    0==matrix2x2.getMatrix(1,0)&&0==matrix2x2.getMatrix(1,1));

        }

        @Test
        public void allElementsShouldHaveSameValue(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithSameValue");
            Assert.assertTrue(3==matrix2x2.getMatrix(0,0)&& 3==matrix2x2.getMatrix(0,1)&&
                    3==matrix2x2.getMatrix(1,0)&& 3==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void allElementsShouldHaveValueFromArray(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithArray");
            Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                    3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void allElementsShouldHaveMyValue(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                    3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void AllElementsShouldHaveValueFromArray(){
            double [][] matrix={{1,2},
                    {3,4}};
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("nullMatrix");
            matrix2x2.setMatrix(matrix);
            Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&& 2==matrix2x2.getMatrix(0,1)&&
                    3==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void elementShouldHaveTheCorrectValue(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Assert.assertTrue(3==matrix2x2.getMatrix(1,0));
        }

        @Test
        public void matrixAddShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            Matrix2x2 newMatrix=matrix2x2.add(matrix2x21);
            Assert.assertTrue(6 == newMatrix.getMatrix(0, 0) && 8 == newMatrix.getMatrix(0, 1) &&
                    10 == newMatrix.getMatrix(1, 0) && 12 == newMatrix.getMatrix(1, 1));
        }

        @Test
        public void matrixAddShouldBeCorrect2(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            matrix2x2.add2(matrix2x21);
            Assert.assertTrue(6==matrix2x2.getMatrix(0,0)&& 8==matrix2x2.getMatrix(0,1)&&
                    10==matrix2x2.getMatrix(1,0)&& 12==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void matrixSubShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            Matrix2x2 newMatrix=matrix2x21.sub(matrix2x2);
            Assert.assertTrue(4 == newMatrix.getMatrix(0, 0) && 4 == newMatrix.getMatrix(0, 1) &&
                    4 == newMatrix.getMatrix(1, 0) && 4 == newMatrix.getMatrix(1, 1));
        }

        @Test
        public void matrixSubShouldBeCorrect2(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            matrix2x21.sub2(matrix2x2);
            Assert.assertTrue(4 == matrix2x21.getMatrix(0, 0) && 4 == matrix2x21.getMatrix(0, 1) &&
                    4 == matrix2x21.getMatrix(1, 0) && 4 == matrix2x21.getMatrix(1, 1));
        }

        @Test
        public void matrixMultNumberShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 newMatrix=matrix2x2.multNumber(5);
            Assert.assertTrue(5 == newMatrix.getMatrix(0, 0) && 10 == newMatrix.getMatrix(0, 1) &&
                    15 == newMatrix.getMatrix(1, 0) && 20 == newMatrix.getMatrix(1, 1));
        }

        @Test
        public void matrixMultNumberShouldBeCorrect2(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            matrix2x2.multNumber2(5);
            Assert.assertTrue(5 == matrix2x2.getMatrix(0, 0) && 10 ==matrix2x2.getMatrix(0, 1) &&
                    15 == matrix2x2.getMatrix(1, 0) && 20 == matrix2x2.getMatrix(1, 1));
        }

        @Test
        public void matrixMultShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            Matrix2x2 newMatrix= matrix2x2.mult(matrix2x21);
            Assert.assertTrue(19 == newMatrix.getMatrix(0, 0) && 22 == newMatrix.getMatrix(0, 1) &&
                    43 == newMatrix.getMatrix(1, 0) && 50 == newMatrix.getMatrix(1, 1));
        }

        @Test
        public void matrixMultShouldBeCorrect2(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 matrix2x21 = (Matrix2x2) context.getBean("matrixWithDifferentValue2");
            matrix2x2.mult2(matrix2x21);
            Assert.assertTrue(19 == matrix2x2.getMatrix(0, 0) && 22 == matrix2x2.getMatrix(0, 1) &&
                    43 == matrix2x2.getMatrix(1, 0) && 50 == matrix2x2.getMatrix(1, 1));
        }

        @Test
        public void matrixDetShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Assert.assertTrue(-2==matrix2x2.det());
        }

        @Test
        public void matrixTransponShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            matrix2x2.transpon();
            Assert.assertTrue(1==matrix2x2.getMatrix(0,0)&&3==matrix2x2.getMatrix(0,1)&&
                    2==matrix2x2.getMatrix(1,0)&&4==matrix2x2.getMatrix(1,1));
        }

        @Test
        public void InverseMatrixShouldBeCorrect() throws ZeroDetException {
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 inverseMatrix= matrix2x2.inverseMatrix();
            Assert.assertTrue(-2 == inverseMatrix.getMatrix(0, 0) && 1 == inverseMatrix.getMatrix(0, 1) &&
                    1.5 == inverseMatrix.getMatrix(1, 0) && -0.5 == inverseMatrix.getMatrix(1, 1));
        }

        @Test(expected = ZeroDetException.class)
        public void inverseMatrixWithZeroDet() throws ZeroDetException{
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("nullMatrix");
            Matrix2x2 inverseMatrix=matrix2x2.inverseMatrix();
        }

        @Test
        public void EquivalentMatrixShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Matrix2x2 equivMatrix = matrix2x2.equivalentDiagonal();
            Assert.assertTrue(1==equivMatrix.getMatrix(0,0)&&0==equivMatrix.getMatrix(0,1)&&
                    0==equivMatrix.getMatrix(1,0)&& -2==equivMatrix.getMatrix(1,1));
        }

        @Test
        public void matrixMultVectorShouldBeCorrect(){
            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
            Matrix2x2 matrix2x2 = (Matrix2x2) context.getBean("matrixWithDifferentValue");
            Vector2D vector2D = (Vector2D) context.getBean("vector2D");
            Vector2D newVector=matrix2x2.multVector(vector2D);
            Assert.assertTrue(5==newVector.getX()&&11==newVector.getY());
        }
    }
