// Radhika Mattoo, rm3485@nyu.edu
package rm3485;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import java.io.IOException;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.*;
// import org.jsoup.*;
import java.io.*;
public class StackoverflowReducer extends Reducer<Text, NullWritable, Text, NullWritable> {

  @Override
  public void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException{
    context.write(new Text("HELLO WORLD"), NullWritable.get());
  }
}
