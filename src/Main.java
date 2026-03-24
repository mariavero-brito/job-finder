import filter.JobFilter;
import model.Job;
import output.ConsolePrinter;
import parser.JobParser;
import ranking.JobRanker;
import scoring.JobScorer;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Job> jobArrayList = new ArrayList<>();

        // TEST JOBS
        Job job1 = new Job(
                "Stripe",
                "This is for juniors with Java knowledge",
                "Remote",
                true,
                125000.00,
                "https://www.stripe.com/careers/job1",
                "Software engineer",
                1);

        Job job2 = new Job(
                "Klarna",
                "This is for juniors with Python experience",
                "New York",
                false,
                85000.00,
                "https://www.klarna.com/careers/job1",
                "Software engineer",
                4);

        Job job3 = new Job(
                "Afterpay",
                "This is for juniors with Java experience",
                "Remote",
                true,
                102000.00,
                "https://www.afterpay.com/careers/job1",
                "junior software engineer",
                2);

        // ADDING TEST JOBS TO THE LIST
        jobArrayList.add(job1);
        jobArrayList.add(job2);
        jobArrayList.add(job3);

        JobParser jobParser = new JobParser();

        JobFilter jobfilter = new JobFilter();

        ArrayList<Job> filteredJobs = jobfilter.filterJobs(jobArrayList);

        JobScorer jobScorer = new JobScorer();
        jobScorer.scoreJobs(filteredJobs);

        JobRanker jobRanker = new JobRanker();
        jobRanker.rankJobs(filteredJobs);


        ConsolePrinter consolePrinter = new ConsolePrinter();
        consolePrinter.printJobs(filteredJobs);

        }

        }
