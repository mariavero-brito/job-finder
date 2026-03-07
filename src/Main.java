import model.Job;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Job> jobArrayList = new ArrayList<>();


        Job job1 = new Job(
                "Stripe",
                "This is for juniors",
                "Remote",
                true,
                125000.00,
                "https://www.stripe.com/careers/job1",
                "Software engineer");

        Job job2 = new Job(
                "Klarna",
                "This is for juniors",
                "New York",
                false,
                85000.00,
                "https://www.klarna.com/careers/job1",
                "Software engineer");

        Job job3 = new Job(
                "Afterpay",
                "This is for juniors",
                "Remote",
                true,
                97000.00,
                "https://www.afterpay.com/careers/job1",
                "junior software engineer");

        jobArrayList.add(job1);
        jobArrayList.add(job2);
        jobArrayList.add(job3);

        System.out.println(jobArrayList.size());

        for (Job job : jobArrayList){
            System.out.println(job.getCompanyName());
        }


        }
    }