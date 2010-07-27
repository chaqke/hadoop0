package some.hack;

import java.io.IOException; 

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
 

public class CountMapper extends Mapper<Object, Text, Text, IntWritable>{
	private final static IntWritable one = new IntWritable(1);
	private final static IntWritable two = new IntWritable(2);
	
	private Text word = new Text();
	
	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
	String[] rev = 	value.toString().split("\\-\\>\\|");
	String reason = rev[1]; 
	String comment = rev[3];			
	String merchant = rev[6];
	if("Toys R Us".equals(merchant)){
		boolean isAlert = "Safety Alert".equals(reason );
		String[] carr= comment.split("\n");
		for(String s: carr){
			word.set(s);
			context.write(word, isAlert?one:two); 
		}
	} 
	}
}
