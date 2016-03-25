
public class ComplexMatrix2x2 {

    private ComplexNumber [][] matrix = new ComplexNumber[2][2];

    ComplexMatrix2x2(){
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = new ComplexNumber();
            }
        }
    }

    ComplexMatrix2x2(ComplexNumber complexNumber){
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                this.matrix[i][j] = complexNumber;
            }
        }
    }
    ComplexMatrix2x2(ComplexNumber a,ComplexNumber b,ComplexNumber c,ComplexNumber d){
        matrix[0][0] = a;
        matrix[0][1] = b;
        matrix[1][0] = c;
        matrix[1][1] = d;
    }

    ComplexMatrix2x2 add(ComplexMatrix2x2 complexMatrix2x2){
        ComplexMatrix2x2 newMatrix=new ComplexMatrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = this.matrix[i][j].add(complexMatrix2x2.matrix[i][j]);
            }
        }
        return newMatrix;
    }

    public ComplexNumber getMatrix(int i, int j) {
        return matrix[i][j];
    }

    ComplexMatrix2x2 mult(ComplexMatrix2x2 complexMatrix2x2){
        ComplexMatrix2x2 newMatrix=new ComplexMatrix2x2();
        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                newMatrix.matrix[i][j] = new ComplexNumber();
                for (int k = 0; k <= 1; k++) {
                    ComplexNumber mult=this.matrix[i][k].mult(complexMatrix2x2.getMatrix(k, j));
                    newMatrix.matrix[i][j]=newMatrix.matrix[i][j].add(mult);
                }
            }
        }
        return newMatrix;
    }

    ComplexNumber det(){
        ComplexNumber det=(getMatrix(0,0).mult(getMatrix(1,1))).sub(getMatrix(0,1).mult(getMatrix(1,0)));
        return det;
    }
}
