import java.util.Arrays;
public class Fifteen {
	static int[] findZero(int[][] m) {
		int[] result = new int[2];
		for(int i = 0; i < m.length; i++) {
			for(int n = 0; n < m[i].length; n++) {
				if (m[i][n] == 0) {
				result[1] = n;
				result[0] = i;
				}
			}
		}
		return result;
	}

	public static void main(String arg[])
	throws java.io.IOException {
		int matrix[][] = { //Matrix where all squares on their places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 0}
		};
		int intricateMatrix[][] = { //Matrix where almost all squares on wrong places
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 0},
			{13, 14, 15, 12}
		};
		int zero[] = findZero(intricateMatrix); //Position of empty square (1/16)

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
