import java.util.Scanner;

public class Solution {
	
    public static void dfs(int[][] adjM,int current,boolean[] visited){
        visited[current] = true;
        
        for(int i=0;i<adjM.length;i++){
            if(adjM[current][i]==1 && !visited[i])
                dfs(adjM,i,visited);
        }
    }
    
    public static boolean isConnected(int[][] adjM){
        boolean visited[] = new boolean[adjM.length];
        dfs(adjM,0,visited);
        
        for(boolean val : visited){
            if(val == false)
                return false;
        }
        return true;
    }
    
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

        int adjM[][] = new int[V][V];
        
		for(int i = 0 ; i < E ; i++){
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            
            adjM[v1][v2] = adjM[v2][v1] = 1 ;
        }
        
        System.out.println(isConnected(adjM));
	}
}
