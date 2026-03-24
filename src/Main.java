import api.JobApiClient;
import filter.JobFilter;
import model.Job;
import output.ConsolePrinter;
import parser.JobParser;
import ranking.JobRanker;
import scoring.JobScorer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        //call Remotive API to get json response with job data
        String json = JobApiClient.fetchJobs();

        //verify response is not null
        if (json == null){
            System.out.println("Failed to fetch jobs");
            return;
        }

        //job parser to clean API JSON data
        ArrayList<Job> jobArrayList = JobParser.parseJobs(json);

        System.out.println(jobArrayList.size());

        //job filter to remove unqualified jobs
        JobFilter jobfilter = new JobFilter();

        ArrayList<Job> filteredJobs = jobfilter.filterJobs(jobArrayList);

        System.out.println(jobArrayList.size());

        //job scorer to assign a score to each job
        JobScorer jobScorer = new JobScorer();
        jobScorer.scoreJobs(filteredJobs);

        System.out.println(filteredJobs);

        //job ranker to rank jobs from best to worst based on scores
        JobRanker jobRanker = new JobRanker();
        jobRanker.rankJobs(filteredJobs);

        //jobs array list printed to console
        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printJobs(filteredJobs);

        }

        }
