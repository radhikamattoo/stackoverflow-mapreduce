```
mvn compile
mvn package
hadoop jar stackoverflow-1.0-SNAPSHOT-jar-with-dependencies.jar posts/* posts-clean

```

Afterwards, there should be a single part file with ~15 million lines, where each line is:

`Id, Score, Title, Tags, Body`

`1000000,17,Display Progress Bar at the Time of Processing,vb6 progress-bar,If I am getting data from the database from start time to end time, during that time (of processing / querying), I want to display a progress bar (something like, “Processing, please wait”). How can I do this?`

If there are several tags, they are separated by a space. This structure was set up so that if there are commas in the Body, we can still split by `","` for the row, take the first 4 elements, and know that the rest of the elements in the array must be the Body.
