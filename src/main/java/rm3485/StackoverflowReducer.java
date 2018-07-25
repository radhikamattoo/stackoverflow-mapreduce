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

public class StackoverflowReducer extends Reducer<Text, Text, Text, NullWritable> {
  @Override
  public void reduce(Text key, Iterable<Text> values, Context context) throws IOException, InterruptedException{
    String output_string = key.toString();
    // float page_rank = 0.0f;
    // for(Text text: values){
    //   String[] data = text.toString().split(" ");
    //   if(data.length == 1){ //it's a page rank to add to sum
    //     page_rank += Float.parseFloat(data[0]);
    //   }else{ //it's part of the output string
    //     for(int i = 0; i < data.length-1; i++){ //excluse last 0
    //       output_string += " " + data[i];
    //     }
    //   }
    // }
    // output_string += " " + String.valueOf(page_rank);
    // context.write(new Text(output_string), NullWritable.get());
  }
}
