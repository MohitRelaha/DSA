import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void bfsHelp(int[][] adjM,boolean[] visited,Queue<Integer> q){
        
        while(q.size() > 0){
            	
            int current = q.poll();
        
            for(int i=0;i<adjM.length;i++){
                if(adjM[current][i]==1 && !visited[i]){
                    System.out.printf("%d ",i);
                	  visited[i] = true;
                    q.add(i);
                }   
            }   
        } 
      }
    
    public static void bfs(int[][] adjM){
        boolean visited[] = new boolean[adjM.length];
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<adjM.length;i++){
            if(!visited[i]){
                System.out.printf("%d ",i);
                visited[i] = true;
                q.add(i);
                bfsHelp(adjM,visited,q);
            }  	
        }
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
        
     bfs(adjM);
	}
}
