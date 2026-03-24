package filter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Job;

public class JobFilter {

    public ArrayList<Job> filterJobs(List<Job> jobArrayList){

        ArrayList<Job> filteredJobs = new ArrayList<>();


        for (Job job : jobArrayList) {
            if(job.getSalary() >= 75000
                    && job.isJobRemote()
                    && isTitleMatch(job.getJobTitle())
                    && job.getYearsOfExperience() <= 5){
                filteredJobs.add(job);
            }
        }

        return filteredJobs;

    }

    private static boolean isTitleMatch(String jobTitleText){
        jobTitleText = jobTitleText.toLowerCase();

        List<String> keywords = Arrays.asList("software engineer", "software developer", "engineer", "developer");

        for (String keyword : keywords){
            if (jobTitleText.contains(keyword)) {
                return true;
            }
        } return false;
    }
}
