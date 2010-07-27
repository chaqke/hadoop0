package some.hack;

import java.io.*;
import java.util.*;

public class Parser {
	
	public static void main(String[] a) throws Exception{
		String inp = "/Users/michael/development/data/huge/rev_small";
		parse(inp);
	}
	static  void parse(String path) throws IOException{
		Scanner scanner = new Scanner(new File(path)).useDelimiter("\\-\\>\\|\\|\\<\\-");
		log(scanner.next());
		while(scanner.hasNext()){
			String[] rev = scanner.next().split("\\-\\>\\|");
			String reason = rev[1];
			String status = rev[2];
			String comment = rev[3];			
			String mercant = rev[6];
			log(rev);
		}
	}
	static void log(Object o){
		System.out.println(o);
	}
}
