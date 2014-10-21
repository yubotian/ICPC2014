package APT201;

import java.util.Arrays;




public class OlympicCandles{
   public int numberOfNights(int[] candles){
	   return nights(candles,0);	   
   }

private int nights(int[] candles, int n) {
	// TODO Auto-generated method stub
	
	Arrays.sort(candles);
	if (n == candles.length) return n;
	if (candles[candles.length -1 - n]==0) return n;
	
	for(int i = 0; i <= n ; i++ ){
		candles[candles.length -1 - i] --;	
	}
	return nights(candles, n + 1);
}
   
}





