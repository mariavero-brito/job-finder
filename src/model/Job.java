package model;

public class Job {

    //Fields
    private String companyName;
    private String jobTitle;
    private String jobDescription;
    private String jobLocation;
    private boolean isJobRemote;
    private double salary;
    private String jobURL;
    private int score;
    private int yearsOfExperience;

    //Constructor
    public Job(String companyName,
               String jobDescription,
               String jobLocation,
               boolean isJobRemote,
               double salary,
               String jobURL,
               String jobTitle,
               int yearsOfExperience){
        this.companyName = companyName;
        this.jobDescription = jobDescription;
        this.jobLocation = jobLocation;
        this.isJobRemote = isJobRemote;
        this.salary = salary;
        this.jobURL = jobURL;
        this.jobTitle = jobTitle;
        this.yearsOfExperience = yearsOfExperience;
    }

    // Getters and Setters
    public String getCompanyName() {
        return companyName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public String getJobLocation() {
        return jobLocation;
    }

    public boolean isJobRemote() {
        return isJobRemote;
    }

    public double getSalary() {
        return salary;
    }

    public String getJobURL() {
        return jobURL;
    }

    public int getYearsOfExperience() {return yearsOfExperience;}

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getJobTitle() {
        return jobTitle;
    }
}
