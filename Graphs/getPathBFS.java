import java.util.*;

public class Solution {
	
    public static List<Integer> getPathHelp(int[][] adjM,int v1,int v2,boolean[] visited){
        HashMap<Integer,Integer> map = new HashMap<>();
        Queue<Integer> q = new LinkedList<Integer>();
        
        q.add(v1);
        visited[v1] = true;
        boolean found = false;
        
        while(q.size() > 0){
        	
            int current = q.poll();
            
            for(int i=0;i<adjM.length;i++){
                if(adjM[current][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i] = true;
                    map.put(i,current);
                    
                    if(i == v2){
                        found = true;
                        break;
                    }
                }
            }
            
            if(found)
                break;
        
        }
        
        List<Integer> list = new ArrayList<>();
        
        if(found){
            int current = v2;
            while(current != v1){
                list.add(current);
                current = map.get(current);
            }
            list.add(v1);
        }

        
        return list;
    }
    
    
    public static List<Integer> getPathBFS(int[][] adjM,int v1,int v2){
        boolean[] visited = new boolean[adjM.length];
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
        
        List<Integer> list = getPathBFS(adjM,v1,v2);
        
        if(list != null){
            for(int i : list){
                System.out.print(i + " ");
            }
        }
	}
}
