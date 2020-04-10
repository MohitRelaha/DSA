import java.util.Scanner;

public class Solution {

    public static boolean dfsFind(int[][] adjM,int v1,int v2,boolean[] visited){
        if(adjM[v1][v2] == 1)
            return true;
        
        
        for(int i=0;i<adjM.length;i++){
            if(adjM[v1][i] == 1 && !visited[i]){
                visited[v1] = true;
                boolean res =  dfsFind(adjM,i,v2,visited);
                if(res)
                    return res;
            }
        }

        return false;
        
    }
    
    public static boolean hasPath(int[][] adjM,int v1,int v2){
        
        boolean visited[] = new boolean[adjM.length];
        visited[v1] = true;
        return dfsFind(adjM,v1,v2,visited);
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
        
        int v1 = s.nextInt();
        int v2 = s.nextInt();
        
        System.out.println(hasPath(adjM,v1,v2));
	}
}
