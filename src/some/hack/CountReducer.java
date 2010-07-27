package some.hack;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.lang.Long;

public class CountReducer extends Reducer {
    private LongWritable result = new LongWritable();
    public void reduce(Text word, IntWritable value, Context context) {

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

        result.set(numb);
        context.write(word, result);
    }
    
    static void log(Object o){
        System.out.println(o);
    }
}