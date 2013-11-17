
import java.util.Scanner;

public class Sudoku {
	public static final int SIZE = 9;
	public static final int SUBGRID = 3;
	private int[][] game;
	private int[][] originalGame;
	
	public Sudoku(Test board) {
		this.game = new int[9][9];
		this.originalGame = new int[9][9];
		for(int i = 0; i < SIZE; i++) {
			for(int j = 0; j < SIZE; j++) {
				this.game[i][j] = board.board[i][j];
				this.originalGame[i][j] = board.board[i][j];
			}
		}
	}
	
	public void setZero(int[] array) {
		for(int i = 0; i < array.length;i++) {
			array[i] = 0;
		}
	}
	
    public boolean rowsComplete(int[] valSeen) {     
        for(int rows = 0; rows < SIZE; rows++) {
        	for(int vals = 0; vals < SIZE; vals++) {
        		if(this.game[rows][vals]==-1 || valSeen[this.game[rows][vals]]==1) return false;
        		else valSeen[this.game[rows][vals]] = 1;
        	}
        	this.setZero(valSeen);
        }
        return true;
    }
    public boolean columnsComplete(int[] valSeen) {
    	for(int rows = 0; rows < SIZE; rows++) {
    		for(int vals = 0; vals < SIZE; vals++) {
    			if(this.game[vals][rows]==-1 || valSeen[this.game[vals][rows]]==1) return false;
    			else valSeen[this.game[vals][rows]] = 1;
    		}
        	this.setZero(valSeen);
    	}
        return true;
    }
    public boolean subgridsComplete(int[] valSeen) {
        for(int rowc = 0; rowc < SUBGRID; rowc++) {
        	for(int colc = 0; colc < SUBGRID; colc++) {
        		for(int row = 0; row < SUBGRID; row++) {
        			for(int col = 0; col < SUBGRID; col++) {
        				int rowval = rowc*SUBGRID + row;
        				int colval = colc*SUBGRID + col;
        				if(this.game[rowval][colval]==-1 || valSeen[this.game[rowval][colval]]==1) return false;
        				else valSeen[this.game[rowval][colval]] = 1;
        			}
        		}
            	this.setZero(valSeen);
        	}
        }
        return true;
    }
    
    public boolean isComplete() {
    	int[] valSeen = new int[SIZE+1];
    	if(this.rowsComplete(valSeen) 
    			&& this.columnsComplete(valSeen) 
    			&& this.subgridsComplete(valSeen)) return true;
    	else return false;
    }
	
	public String makeHeader() {
		String header = "-";
		for(char i = 'a'; i < 'a' + SIZE; i++) {
			header += " | " + i;
		}
		return header;
	}
	
	public void print() {
		System.out.println("\n" + this.makeHeader());
		
		for(int i = 0; i < SIZE; i++) {
			System.out.print("" + (char) ('a' + i));
			for(int j = 0; j < SIZE; j++) {
				String print = (this.game[i][j]>=0) ? "" + this.game[i][j] : "_";
				System.out.print(" | " + print);
			}
			System.out.println();
		}
	}
	
	public void move(String row, String col, int val) {
		if(this.originalGame[row.charAt(0) - 'a'][col.charAt(0) - 'a']>=0) {
			this.print();
			System.out.println("Fixed value - cannot change!");
		} else {
			this.game[row.charAt(0) - 'a'][col.charAt(0) - 'a'] = val;
			this.print();
			System.out.println("Move successful!");
		}
	}
	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);
		System.out.print("Which puzzle would you like to do? (0 for random): ");
		Test test = new Test(console.nextInt());
		Sudoku puzzle = new Sudoku(test);
		puzzle.print();
		int moves = 0;
		while(!puzzle.isComplete()) {
			System.out.println("Puzzle incomplete!");
			System.out.print("Enter new value <row col val> : ");
			
			String row = console.next();
			String col = console.next();
			int val = console.nextInt();
			puzzle.move(row, col, val);
			moves++;
		}
		console.close();
		System.out.println("\n** Puzzle complete! **");
		System.out.println("Congratulations! This puzzle took you " + moves + " moves!");
	}

}
