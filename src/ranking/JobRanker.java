package ranking;

import model.Job;

import java.util.ArrayList;
import java.util.Collections;

public class JobRanker {
    public void rankJobs(ArrayList<Job> jobArrayList){

        jobArrayList.sort((jobA, jobB) ->
                Integer.compare(jobB.getScore(), jobA.getScore())
        );
    }
}
