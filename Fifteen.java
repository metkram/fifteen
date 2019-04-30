import java.util.Arrays;
public class Fifteen {
	public static void main(String arg[])
	throws java.io.IOException {
		int matrix[][] = { //Matrix where all squares on their places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 0}
		};
		int intricateMatrix[][] = { //Matrix where all squares on their places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 0}
		};
		int zero[] = {0, 0}; //Position of empty square (1/16)

		for(int i = 0; i < matrix.length; i++) {
			for(int n = 0; n < matrix[i].length; n++) {
				if (matrix[i][n] == 0) {
				zero[0] = i;
				zero[1] = n;
				}
			}
		}

		System.out.println("Zero point at " + (zero[0] + 1) + " line and " + (zero[1] + 1) + " column");
		for(int i = 0; i < matrix.length; i++) {
			for(int n = 0; n < matrix[i].length; n++) {
				System.out.print(((matrix[i][n] < 10) ? "0" : "") + matrix[i][n] + " ");
			}
			System.out.println();
		}
		for(int i = 0; i < intricateMatrix.length; i++) {
			for(int n = 0; n < intricateMatrix[i].length; n++) {
				System.out.print(((intricateMatrix[i][n] < 10) ? "0" : "") + intricateMatrix[i][n] + " ");
			}
			System.out.println();
		}
		System.out.println("Is pazzle solved? " + Arrays.deepEquals(matrix, intricateMatrix));
	}
}
