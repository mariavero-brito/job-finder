package ranking;

import model.Job;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class JobRanker {
    public void rankJobs(List<Job> jobArrayList){

        jobArrayList.sort((jobA, jobB) ->
                Integer.compare(jobB.getScore(), jobA.getScore())
        );
    }
}
