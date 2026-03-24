import api.JobApiClient;
import filter.JobFilter;
import model.Job;
import output.ConsolePrinter;
import parser.JobParser;
import preferences.UserPreferences;
import ranking.JobRanker;
import scoring.JobScorer;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        //preferences used to collect user preferences for filtering
        UserPreferences userPreferences = new UserPreferences();
        userPreferences.collectPreferences();

        //call Remotive API to get json response with job data
        String json = JobApiClient.fetchJobs();

        //verify response is not null
        if (json == null) {
            System.out.println("Failed to fetch jobs");
            return;
        }

        //job parser to clean API JSON data
        ArrayList<Job> jobArrayList = JobParser.parseJobs(json);

        //job filter to remove unqualified jobs
        JobFilter jobfilter = new JobFilter();

        ArrayList<Job> filteredJobs = jobfilter.filterJobs(jobArrayList, userPreferences);

        //job scorer to assign a score to each job
        JobScorer jobScorer = new JobScorer();
        jobScorer.scoreJobs(filteredJobs, userPreferences.getTechStack());

        //job ranker to rank jobs from best to worst based on scores
        JobRanker jobRanker = new JobRanker();
        jobRanker.rankJobs(filteredJobs);

        //jobs array list printed to console
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printJobs(filteredJobs);

    }

}
