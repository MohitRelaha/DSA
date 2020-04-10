import java.util.*;

public class Solution {

    public static List<Integer> getPathHelp(int[][] adjM,int v1,int v2,boolean[] visited){
       
        visited[v1] = true;
        
        if(v1 == v2){
            List<Integer> list = new ArrayList<Integer>();
            list.add(v1);
            return list;
        }
        
        for(int i=0;i<adjM.length;i++){
            if(adjM[v1][i] == 1 && !visited[i]){
                List<Integer> smallAns = getPathHelp(adjM,i,v2,visited);
                if(smallAns != null){
                    smallAns.add(v1);
                    return smallAns;
                }
            }
        }
        return null;   
    }
    
    
    public static List<Integer> getPath(int[][] adjM,int v1,int v2){
        boolean visited[] = new boolean[adjM.length];
        return getPathHelp(adjM,v1,v2,visited);

    }  
    
    
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int V = s.nextInt();
		int E = s.nextInt();

		int adjM[][] = new int[V][V];
        
    for(int i=0;i<E;i++){
        int v1 = s.nextInt();
        int v2 = s.nextInt();

        adjM[v1][v2] = adjM[v2][v1] = 1;
     }
        
    int v1 = s.nextInt();
    int v2 = s.nextInt();

    List<Integer> path = getPath(adjM,v1,v2);

    if(path != null){
      for(int i : path){
          System.out.print(i + " ");
      }  
    }  
	 }
}
