// Radhika Mattoo, rm3485@nyu.edu
package rm3485;

import java.io.IOException;
import org.jsoup.*;
import org.jsoup.helper.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.ArrayWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class StackoverflowMapper extends Mapper<LongWritable, Text, Text, Text> {

  @Override
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    String[] data = value.toString().split(" ");
    // int page_total = data.length - 2; // Total number of outbound links for the page
    // String linking_page = data[0];
    // float linking_page_rank = Float.parseFloat( data[data.length-1] );
    //
    // // Loop through linked pages and output its page rank for this specific linking page
    // String linked_to = "";
    // for(int i = 1; i < data.length - 1; i++){
    //   String linked_page = data[i];
    //   float page_rank = linking_page_rank/page_total;
    //   linked_to += linked_page + " ";
    //   context.write(new Text(linked_page), new Text(String.valueOf(page_rank)));
    // }
    // linked_to += "0"; // Adding in case there's only one page it links to.
    // context.write(new Text(linking_page), new Text(linked_to));
  }
}
