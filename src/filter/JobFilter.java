package filter;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Job;
import preferences.UserPreferences;

public class JobFilter {

    public ArrayList<Job> filterJobs(List<Job> jobArrayList, UserPreferences userPreferences) {

        ArrayList<Job> filteredJobs = new ArrayList<>();

        for (Job job : jobArrayList) {
            if (job.getSalary() >= userPreferences.getMinSalary()
                    && job.isJobRemote()
                    && isTitleMatch(job.getJobTitle(), userPreferences)
                    && job.getYearsOfExperience() <= 5) {
                filteredJobs.add(job);
            }
        }

        return filteredJobs;

    }

    private static boolean isTitleMatch(String jobTitleText, UserPreferences userPreferences) {
        jobTitleText = jobTitleText.toLowerCase();

        ArrayList<String> keywords = new ArrayList<>(Arrays.asList("software engineer", "software developer", "engineer", "developer"));
        keywords.add(userPreferences.getTitleKeyword());

        for (String keyword : keywords) {
            if (jobTitleText.contains(keyword)) {
                return true;
            }
        }
        return false;
    }
}
