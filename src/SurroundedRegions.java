import java.util.Arrays;
import java.util.LinkedList;

public class SurroundedRegions {

    public void solve(char[][] board) {

        if(board == null) return;
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;
        if (n == 0) return;

        for(int i=0; i<n; i++){
            if(board[0][i]=='O'){
                findRegion(m,n,i,board);
            }
        }
        for(int i=1; i<m; i++){
            if(board[i][0]=='O'){
                findRegion(m,n,i*n,board);
            }
        }
        for(int i=1; i<n; i++){
            if(board[m-1][i]=='O'){
                findRegion(m,n,(m-1)*n + i,board);
            }
        }
        for(int i=1; i<m-1; i++){
            if(board[i][n-1]=='O'){
                findRegion(m,n,i*n + n-1,board);
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(board[i][j] == 'T')
                    board[i][j] = 'O';
                else board[i][j] = 'X';
            }
        }
    }

    public void findRegion(int h, int l, int p,char[][]board){
        LinkedList<Integer> queue = new LinkedList<Integer>();
        queue.push(p);
        while(!queue.isEmpty()) {
            int t = queue.pop();
            int m = t/l;
            int n = t%l;
            if(board[m][n] != 'O') continue;
            board[m][n] = 'T';
            if (m - 1 >= 0 && board[m - 1][n] == 'O')
                queue.push((m - 1)*l + n);
            if (n - 1 >= 0 && board[m][n - 1] == 'O')
                queue.push(m*l + n-1);
            if (m + 1 < h && board[m + 1][n] == 'O')
                queue.push((m + 1)*l + n);
            if (n + 1 < l && board[m][n + 1] == 'O')
                queue.push(m*l + n+1);
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char[][] b = new char[4][5];
        for(int i=0; i<b.length; i++)Arrays.fill(b[i],'X');
        b[2][1] = 'O';
        b[3][1] = 'O';
        b[1][3] = 'O';
        for(int i=0; i<=b.length-1; i++){
            for(int j=0; j<b[0].length; j++){
                System.out.print(b[i][j]);
                if(j==b[0].length-1)System.out.println();
            }
        }
        System.out.println();
        SurroundedRegions sr = new SurroundedRegions();
        sr.solve(b);

        for(int i=0; i<=b.length-1; i++){
            for(int j=0; j<b[0].length; j++){
                System.out.print(b[i][j]);
                if(j==b[0].length-1)System.out.println();
            }
        }
	}

}
