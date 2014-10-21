package APT201;


public class CirclesCountry {
    public boolean isInside(int x, int y, int r, int j, int k){
        double distance = Math.sqrt((j-x)^2 + (k-y)^2);
        boolean i = distance <r ;
        return i;
    }
    
    public int leastBorders(int[] x, int[] y, int[] r,
                            int x1, int y1, int x2, int y2) {
        int count = 0;
        for (int i = 0; i<x.length; i++){
            boolean aisInside = isInside(x[i], y[i], r[i], x1, y1);
            boolean bisInside = isInside(x[i], y[i], r[i], x2, y2);
            if (aisInside != bisInside){
                count++;
            }
        }
        return count;
        
    }
        

}