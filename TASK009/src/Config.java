
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
    @Bean
    public Matrix2x2 nullMatrix(){
        Matrix2x2 matrix2x2=new Matrix2x2();
        return matrix2x2;
    }

    @Bean
    public Matrix2x2 matrixWithSameValue(){
        Matrix2x2 matrix2x2=new Matrix2x2(3.0);
        return matrix2x2;
    }

    @Bean
    public Matrix2x2 matrixWithArray(){
        double [][] matrix={{1,2},
                {3,4}};
        Matrix2x2 matrix2x2=new Matrix2x2(matrix);
        return matrix2x2;
    }

    @Bean
    public Matrix2x2 matrixWithDifferentValue(){
        Matrix2x2 matrix2x2=new Matrix2x2(1,2,3,4);
        return matrix2x2;
    }

    @Bean
    public Matrix2x2 matrixWithDifferentValue2(){
        Matrix2x2 matrix2x2=new Matrix2x2(5,6,7,8);
        return matrix2x2;
    }

    @Bean
    public Vector2D vector2D(){
        Vector2D vector2D=new Vector2D(1,2);
        return vector2D;
    }

    @Bean
    public ComplexMatrix2x2 nullComplexMatrix(){
        ComplexMatrix2x2 matrix2x2=new ComplexMatrix2x2();
        return matrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithSameValue(){
        ComplexNumber complexNumber=new ComplexNumber(1,4);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber);
        return complexMatrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithDifferentValue(){
        ComplexNumber c1=new ComplexNumber(5,1);
        ComplexNumber c2=new ComplexNumber(6,2);
        ComplexNumber c3=new ComplexNumber(7,3);
        ComplexNumber c4=new ComplexNumber(8,4);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(c1,c2,c3,c4);
        return complexMatrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithDifferentValue1(){
        ComplexNumber c1=new ComplexNumber(1,2);
        ComplexNumber c2=new ComplexNumber(2,3);
        ComplexNumber c3=new ComplexNumber(3,4);
        ComplexNumber c4=new ComplexNumber(4,5);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(c1,c2,c3,c4);
        return complexMatrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithDifferentValue2(){
        ComplexNumber c1=new ComplexNumber(1,2);
        ComplexNumber c2=new ComplexNumber(2,3);
        ComplexNumber c3=new ComplexNumber(3,4);
        ComplexNumber c4=new ComplexNumber(4,5);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(c4,c3,c2,c1);
        return complexMatrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithSameValue1(){
        ComplexNumber complexNumber=new ComplexNumber(1,2);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber);
        return complexMatrix2x2;
    }

    @Bean
    public ComplexMatrix2x2 complexMatrixWithSameValue2(){
        ComplexNumber complexNumber=new ComplexNumber(2,3);
        ComplexMatrix2x2 complexMatrix2x2=new ComplexMatrix2x2(complexNumber);
        return complexMatrix2x2;
    }

}

