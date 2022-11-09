public class rotatematrixby90 {

        public static void main(String[] args) {

            // main

            int[][] matrix = new int[][] {
                    new int[] { 1, 2, 3 },
                    new int[] { 4, 5, 6},
                    new int[] {7,8,9}
            };

            for(int i=0; i<matrix.length;i++){
                for (int j=i+1; j<matrix.length; j++){

                    int temp = matrix[i][j];


                    matrix[i][j] = matrix[j][i];

                    matrix[j][i] = temp;
                }
            }

            for(int i=0; i<matrix.length;i++){
                for(int j = 0; j<(matrix.length/2);j++){
                    int temp = matrix[i][j];

                    matrix[i][j] = matrix[i][matrix.length -  1 - i];
                    matrix[i][matrix.length-i-1] = temp;

                }
            }

            for (int i=0; i<matrix.length;i++){
                for(int j=0; j<matrix.length;j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.println();
            }


        }
}

