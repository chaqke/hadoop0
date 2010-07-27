package some.hack;
//http://webcache.googleusercontent.com/search?q=cache:51rdfvc2GgMJ:www.muine.org/~minhqt/Nax_website/c/bitwise1.html+java+bitwise+operators+extract+upper+word&cd=4&hl=en&ct=clnk&gl=us&client=firefox-a
//http://www.google.com/search?hl=en&client=firefox-a&rls=org.mozilla%3Aen-US%3Aofficial&q=java+bitwise+operators+extract+upper+word&aq=f&aqi=&aql=&oq=&gs_rfai=
public class ShiftCount {
/*
 * unsigned grayscale(unsigned w)
{	unsigned b = w & 0xFF;
	unsigned g = (w >> 8) & 0xFF;
	unsigned r = (w >> 16) & 0xFF;
	unsigned alpha = w & 0xFF000000;
	unsigned gray = (r+g+b)/3;
	return alpha | (gray << 16) | (gray << 8) | gray;
}
*/
	public static void main(String[] a){
		long l1 = 1000000L;
		int low  =(int) l1 & 0xFFFF; 
		int upper = (int) (l1>>16) & 0xFFFF;
		 
		log(upper);
		log(low);
		
		
		
		long numb = (upper<<16) | low;
		log(numb);
		log(">>>>>>>>>>>>>>>>>");
		 
		log(numb = ((upper+1)<<16 ) | (low+1));
		
		log((int) numb & 0xFFFF); 
		log((int) (numb>>16) & 0xFFFF);
		
		
//		long l2 = l1 <<8;
//		log(l2);
	}


	static void log(Object o){
		System.out.println(o);
	}
}

