package some.hack;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class CountReducer extends Reducer <Text,LongWritable,Text,LongWritable>{
	private LongWritable result = new LongWritable();

	public void reduce(Text key, Iterable<IntWritable> values, Context context)
			throws IOException, InterruptedException {
		int sum1 = 0, sum2 = 0;
		for (IntWritable val : values) {
			if (val.get() == 1) {
				sum1 += 1;
			} else {
				sum2 += 1;
			}
			long sum = (sum1 << 16) | sum2;
			result.set(sum);
			context.write(key, result);
		}
	}
 
}