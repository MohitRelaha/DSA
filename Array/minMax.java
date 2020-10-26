class MinMax {
    private int min;
    private int max;
    
    MinMax(int elem1, int elem2) {
        min = Math.min(elem1,elem2);
        max = Math.max(elem1,elem2);
    }
    
    public static MinMax getMinMax(int arr[]) throws MinMaxException{
        if(arr.length == 0) {
            throw new MinMaxException("Empty array found");
        } else if (arr.length == 1) {
            return new MinMax(arr[0],arr[0]);
        }
        
        MinMax minMax = new MinMax(arr[0],arr[1]);
        
        for (int i=2; i<arr.length; i++) {
            if (arr[i] > minMax.max) {
                minMax.max = arr[i];
            } else if (arr[i] < minMax.min) {
                minMax.min = arr[i];
            }
        }
        
        return minMax;
    } 
    
    public void print() {
        System.out.print("Minimum : " + this.min + " , Maximum : " + this.max);
    }
}

class MinMaxException extends Exception{
    String msg;
    
    MinMaxException(String msg) {
        this.msg=msg;
   }
    public String toString(){ 
        return ("MinMaxException : " + msg) ;
   }
}

public class Test {
    public static void main(String args[]) {
        int arr[] = new int[]{5,-1,74,-32,47,84,67};
        try {
            MinMax minMax = MinMax.getMinMax(arr);
            minMax.print();
        } catch (MinMaxException exp) {
            System.out.println(exp);
        }
    }
}
