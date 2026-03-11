package scoring;

import model.Job;

import java.util.ArrayList;

public class JobScorer {
    public void scoreJobs(ArrayList<Job> jobArrayList){

        for (Job job : jobArrayList) {
            int score = 0;

            score += calculateSalaryScore(job);
            score += calculateExperienceScore(job);
            score += calculateTechStackScore(job);

            job.setScore(score);
        }
    }

    private int calculateSalaryScore(Job job) {
        if (job.getSalary() >120000) return 50;
        if (job.getSalary() >100000) return 40;
        if (job.getSalary() >90000) return 30;
        if (job.getSalary() > 80000) return 20;

        return 10;
    }

    private int calculateExperienceScore(Job job){
        if (job.getYearsOfExperience() >=0 && job.getYearsOfExperience()<=2) return 25;
        if (job.getYearsOfExperience() >=1 && job.getYearsOfExperience()<=3) return 20;
        if (job.getYearsOfExperience() >= 3) return 10;

        return 0;
    }

    private int calculateTechStackScore(Job job){
        if(job.getJobDescription().toLowerCase().contains("java")) return 25;

        return 0;
    }
}
