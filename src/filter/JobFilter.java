package filter;

import java.util.ArrayList;
import model.Job;

public class JobFilter {

    public ArrayList<Job> filterJobs(ArrayList<Job> jobArrayList){

        ArrayList<Job> filteredJobs = new ArrayList<>();

        for (Job job : jobArrayList) {
            if(job.getSalary() >= 100000
                    && job.getJobTitle().contains("software engineer")
                    && job.isJobRemote()
                    && job.getJobDescription().contains("java")) {
                filteredJobs.add(job);
            }
        }

        return filteredJobs;

    }


}
