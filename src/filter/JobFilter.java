package filter;

import java.util.ArrayList;
import model.Job;

public class JobFilter {

    public ArrayList<Job> filterJobs(ArrayList<Job> jobArrayList){

        ArrayList<Job> filteredJobs = new ArrayList<>();

        for (Job job : jobArrayList) {
            if(job.getSalary() >= 75000
                    && job.getJobTitle().toLowerCase().contains("software engineer")
                    && job.isJobRemote()
                    && job.getYearsOfExperience() <5) {
                filteredJobs.add(job);
            }
        }

        return filteredJobs;

    }


}
