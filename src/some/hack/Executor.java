package some.hack;

import org.apache.hadoop.conf.Configuration; 
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.fs.Path;

public class Executor {
	public static void main(String [] args) throws Exception{
		Configuration conf = new Configuration();
	    String inPath = "/temp/in";
	    String outPath = "/temp/out";//TODO
	     
	    Job job = new Job(conf, "word count");
	    job.setJarByClass(WordCount.class);
	    job.setMapperClass(CountMapper.class);
	    job.setCombinerClass(CountReducer.class);//TODO
	    job.setReducerClass(CountReducer.class);
	    job.setOutputKeyClass(Text.class);
	    job.setOutputValueClass(IntWritable.class);
	    FileInputFormat.addInputPath(job, new Path(inPath));
	    FileOutputFormat.setOutputPath(job, new Path(outPath));
	    System.exit(job.waitForCompletion(true) ? 0 : 1);
	}
}
