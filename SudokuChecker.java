import java.util.*;

/*
To Do :-
3x3 matrix validation in VerifySum()

sample Sudoku for program validation test.
*/

class SudokuChecker
{

static int[][] matrix = new int[9][9];
static int count = 0;
static int row_count = 0;
static int col_count = 0;


	public static void main(String args[])
	{
		System.out.println("Sudoku...\n");
		initMatrix();
		DisplayMatrix();
		FillMatrix();
		VerifySum();
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

/* get input from user */
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

			if( (row >= 0 && row < 10) && (col >= 0 && col < 10) && (value >= 1 && value <10) )
			{
				matrix[row-1][col-1] = value;
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
		ReferenceMatrix();
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

	/* Display reference of matrix */
	public static void ReferenceMatrix()
	{

		System.out.println();
		System.out.println("@------ Reference Matrix ------@");
		System.out.println();

		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9 ; j++)
			{
				System.out.print("	"+(i+1)+" "+(j+1) );
			}
			System.out.println();
			System.out.println();
		}

	}// e.o.f

	public static void VerifySum()
	{

		/* read ROW wise */
		for(int i = 0; i < 9; i++)
		{
			for(int j = 0; j < 9 ; j++)
			{
				System.out.println("row wise i->"+i+" j->"+j+" matrix : "+matrix[i][j]);
				count = count + matrix[i][j];
			}

			if(count != 1)
			{
				SudokuResult(false);
			}
			else
			{
				count = 0;
				row_count++;
			}

		}

		System.out.println("--------------> "+count);

/* reset value to 0 */
count = 0;

System.out.println("<<---------------->> "+count);

		/* read COLOUMN wise */
		for(int j = 0; j < 9; j++)
		{
			for(int i = 0 ; i < 9 ; i++)
			{
				System.out.println("col wise i->"+i+" j->"+j+" matrix : "+matrix[i][j]);
				count = count + matrix[i][j];
			}
			if(count != 1)
			{
				SudokuResult(false);
			}
			else
			{
				count = 0;
				col_count++;
			}

			/* row and coloumn vales are correct or not */
			if( row_count == 8 && col_count == 8 )
			{
				SudokuResult(true);
			}
			else
			{
				SudokuResult(false);
			}

		}

				System.out.println("<---------------- "+count);

	}

/* display result based on input */
	public static void SudokuResult(boolean flag)
	{
				if(flag == false)
				{
					System.out.println("Sorry ,Your solution denied!");
				}
				else
				{
					System.out.println("---------Congrats , Your solution is accepted !!");
				}

	}


}
