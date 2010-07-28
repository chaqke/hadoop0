package some.hack;

import java.io.*;
import java.util.*;

public class P {
	static String path = "/Users/michael/development/data/huge/rev_main";
	static String result = "/Users/michael/development/data/huge/rev_frm";
	public static void main(String[] a) throws Exception{
		FileOutputStream out = new FileOutputStream(new File(result));

		Scanner sc = new Scanner(new File(path)).useDelimiter("\\-\\>\\|\\|\\<\\-");
		StringBuilder sb = new StringBuilder();
		while(sc.hasNext()){
			String s = sc.next().replaceAll("\\s+", " " );
			sb.append(s).append('\n');
			
		}
		
	}
}
