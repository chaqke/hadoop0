package some.hack;

import java.io.IOException;
import java.util.logging.Logger;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class CountMapper extends Mapper<Object, Text, Text, LongWritable> {
	public final static LongWritable one = new LongWritable(1);
	public final static LongWritable two = new LongWritable(2);

	private Text word = new Text();

	public void map(Object key, Text value, Context context)
			throws IOException, InterruptedException {
		try{
		String[] rev = value.toString().split("\\-\\>\\|");
		String reason = rev[1];
		String comment = rev[3];
		 
		String merchant = rev[6];

		if ("Toys R Us".equals(merchant)) {
			boolean isAlert = "Safety Alert".equals(reason);
			String[] carr = comment.split("\\s");
			for (String s : carr) {
				word.set(s.trim());
				LongWritable l  = isAlert ? one : two;
				//System.out.println(isAlert  + " == " + l.get());
				context.write(word, l);
			}
		}
		}catch(Exception e){
			//System.out.println(value.toString());
			//throw new RuntimeException(e);
		}
	}

}
