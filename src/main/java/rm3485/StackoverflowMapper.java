// Radhika Mattoo, rm3485@nyu.edu
package rm3485;

import org.jsoup.Jsoup;
import org.jsoup.parser.Parser;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Attribute;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.io.*;
import java.io.*; 
public class StackoverflowMapper extends Mapper<LongWritable, Text, Text, NullWritable> {

  @Override
  public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
    String line = value.toString();
    if(!line.startsWith("?xml") && !line.startsWith("<posts>") && !line.startsWith("</posts>")){
      Document doc = Jsoup.parse(line, "", Parser.xmlParser());
      Element row = doc.getElementsByTag("row").first();
      Attributes attributes = row.attributes();
      String postType = attributes.get("PostTypeId");
      if(postType.equals("1")){
        String id = attributes.get("Id");
        String score = attributes.get("Score");
        String title = attributes.get("Title");
        String tags = attributes.get("Tags");
        String body = Jsoup.parse(attributes.get("Body"),"", Parser.xmlParser()).text();
        if(tags.length() > 0){
          tags = tags.replaceAll("<", "").replaceAll(">", " ").trim();
          if(id.length() != 0 && score.length() != 0 && title.length() != 0 && body.length() != 0 && !title.contains(",")){
            String output = id + "," + score + "," + title + "," + tags + "," + body + "\n";
            context.write(new Text(output), NullWritable.get());
          }
        }
      }
    }

  }
}
