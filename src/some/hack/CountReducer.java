package some.hack;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CountReducer extends Reducer <Text,LongWritable,Text,LongWritable>{
	private LongWritable result = new LongWritable();
	@Override
	public void reduce(Text key, Iterable<LongWritable> values, 
            Context context
            ) throws IOException, InterruptedException { 
		try{
		int sum1 = 0, sum2 = 0; 
		String[] parts = key.toString().split("_");
		if(parts.length>1){
			sum1 = Integer.parseInt(parts[0]);
			sum2 = Integer.parseInt(parts[1]);
			key.set(parts[2]);
		} 
		for (LongWritable val : values) {
			if (val.get() == 1L) {
				sum1 += 1;
			} else {
				sum2 += 1;
			} 
		}
		//long sum = (sum1 << 16) | sum2;
		result.set(1L);
		String s = sum1 + "_" + sum2 + "_" +  key.toString(); 
		key.set(s );
		context.write(key, result);
		}catch(Exception e){}
		}
 
}