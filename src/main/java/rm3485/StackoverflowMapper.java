// Radhika Mattoo, rm3485@nyu.edu
package rm3485;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StackoverflowMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

  // @Override
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    String line = value.toString();
    if(!line.startsWith("?xml") && !line.startsWith("<posts>") && !line.startsWith("</posts>")){
      Document doc = Jsoup.parse(line, "", Parser.xmlParser());
      // for (Element e : doc.select("test")) {
      context.write(new Text(line.toString()), NullWritable.get());
      // }
    }

  }
}
