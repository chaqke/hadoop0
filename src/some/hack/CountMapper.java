package some.hack;

import java.io.IOException; 
import java.util.logging.Logger;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountMapper extends Mapper<Object, Text, Text, IntWritable> {
	public final static IntWritable one = new IntWritable(1);
	public final static IntWritable two = new IntWritable(2);

	private Text word = new Text();

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		String[] rev = value.toString().split("\\-\\>\\|");
		String reason = rev[1]; 
	String comment = rev[3];
	try{
	String merchant = rev[6];
	
	if("Toys R Us".equals(merchant)){
		boolean isAlert = "Safety Alert".equals(reason );
		String[] carr= comment.split(" ");
		for(String s: carr){
			word.set(s);
			context.write(word, isAlert?one:two); 
		}
	}
}catch(Exception e){
	Logger.getAnonymousLogger().info(value.toString());
	throw new RuntimeException(e);
	}
	}
	
}
