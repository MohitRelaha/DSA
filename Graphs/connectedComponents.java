import java.util.*;

public class Solution {
	
    public static void compHelp(int[][] adjM,int current,boolean[] visited,ArrayList<Integer> list){
        visited[current] = true;
        list.add(current);
        
        for(int i=0;i<adjM.length;i++){
            if(adjM[current][i]==1 && !visited[i])
                compHelp(adjM,i,visited,list);
        }
    }
    
    
    public static ArrayList<ArrayList<Integer> > connectedComps(int[][] adjM){
        boolean visited[] = new boolean[adjM.length];
        ArrayList<ArrayList<Integer> > list = new ArrayList<ArrayList<Integer> >();
        for(int i=0;i<visited.length;i++){
            if(!visited[i]){
                ArrayList<Integer> connected = new ArrayList<>();
                compHelp(adjM,i,visited,connected);
                Collections.sort(connected);
                list.add(connected);
            }
        }
        return list;
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
        
        ArrayList<ArrayList<Integer>> list = connectedComps(adjM);
        
        for(ArrayList<Integer> comp : list){
            for(int i : comp){
                System.out.print(i + " ");
            }
            System.out.println();
        }
	}
}
