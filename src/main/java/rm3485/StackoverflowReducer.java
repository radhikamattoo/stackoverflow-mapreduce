// Radhika Mattoo, rm3485@nyu.edu
package rm3485;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.*;
import org.jsoup.*;

public class StackoverflowReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

  // @Override
  public void reduce(Text key, NullWritable values, Context context) throws IOException, InterruptedException{
    context.write(key, NullWritable.get());
  }
}
