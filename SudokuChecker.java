import java.util.*;

class SudokuChecker
{

static int[][] matrix = new int[9][9];

	public static void main(String args[])
	{
		System.out.println("Sudoku...\n");
		initMatrix();
		FillMatrix();
		DisplayMatrix();
	}

	/* initialize all matrix element values to 0 */
	public static void initMatrix()
	{

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9 ; j++)
			{
				matrix[i][j] = 0;
			}
		}

	}// e.o.f

	public static void FillMatrix()
	{
		Scanner in = new Scanner(System.in);
		int remaining = 80;
		int row,col;
		int value;

		while( 81 != remaining )
		{
			System.out.print("Enter row :");
			row = in.nextInt();

			System.out.println();

			System.out.print("Enter col :");
			col = in.nextInt();

			System.out.print("\nEnter value :");
			value = in.nextInt();

			if( (row >=0 && row < 9) && (col >= 0 && col < 9) && (value >= 1 && value <10) )
			{
				matrix[row][col] = value;
				remaining++;
				System.out.println("\nremaining elements : "+(80-remaining) );
			}
			else
			{

				System.out.println("Error : row/col values \n row-col-value between 1-9 \ntry again!");
			}


		}


		DisplayMatrix();
	}


	/* Display current status of matrix */
	public static void DisplayMatrix()
	{

		System.out.println();
		System.out.println();

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9 ; j++)
			{
				System.out.print("	"+matrix[i][j]);
			}
			System.out.println();
			System.out.println();
		}

	}// e.o.f


}
