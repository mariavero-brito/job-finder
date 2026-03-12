package output;
import model.Job;
import java.util.List;

public class ConsolePrinter {

    private static final int MAX_RESULTS = 50;

    public void printJobs(List<Job> jobs){

        int limit = Math.min(MAX_RESULTS, jobs.size());

        for (int i = 0; i < limit; i++) {
            Job job = jobs.get(i);

            System.out.println("Job #" + (i + 1));
            System.out.println("Title: " + job.getJobTitle());
            System.out.println("Company: " + job.getCompanyName());
            System.out.println("Salary: $" + job.getSalary());
            System.out.println("Score: " + job.getScore());
            System.out.println("URL: " + job.getJobURL());
            System.out.println("--------------------------");

        }
    }
}
