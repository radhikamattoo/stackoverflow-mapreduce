// Radhika Mattoo, rm3485@nyu.edu
package rm3485;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.*;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class Stackoverflow {

  public static void main(String[] args) throws Exception {
    if (args.length != 2) {
        System.err.println("Usage: PageRank <input path> <output path>");
        System.exit(-1);
    }
    Job job = new Job();
    job.setJarByClass(Stackoverflow.class);
    job.setJobName("Stackoverflow");

    job.setNumReduceTasks(1);

    FileInputFormat.addInputPath(job, new Path(args[0]));
    FileOutputFormat.setOutputPath(job, new Path(args[1]));

    job.setMapperClass(StackoverflowMapper.class);
    job.setReducerClass(StackoverflowReducer.class);

    job.setMapOutputValueClass(Text.class);

    job.setOutputKeyClass(Text.class);
    job.setOutputValueClass(NullWritable.class);

    System.exit( job.waitForCompletion(true) ? 0 : 1 );
  }
}