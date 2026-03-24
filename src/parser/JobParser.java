package parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import model.Job;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class JobParser {

    public static ArrayList<Job> parseJobs(String json){

        //convert String > Jason Object
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        //get the "jobs" array
        JsonArray jobsArray = root.getAsJsonArray("jobs");

        ArrayList<Job> jobs = new ArrayList<>();

        //loop through each job provided in the JSON response
        for (int i = 0; i <jobsArray.size(); i++) {
            JsonObject jobObject = jobsArray.get(i).getAsJsonObject();

            String jobCompany = jobObject.get("company_name").getAsString();
            String jobDescription = jobObject.get("description").getAsString();
            String jobLocation = jobObject.get("candidate_required_location").getAsString();
            boolean parsedJobLocation = parseRemote(jobLocation);

            String jobSalary = jobObject.get("salary").getAsString();
            double parsedSalary = parseSalary(jobSalary);

            String jobURL = jobObject.get("url").getAsString();
            String jobTitle = jobObject.get("title").getAsString();

            int parsedYearsOfExperience = parseYearsOfExperience(jobDescription);

            //create a job with all the data
            Job job = new Job(
                    jobCompany,
                    jobDescription,
                    jobLocation,
                    parsedJobLocation,
                    parsedSalary,
                    jobURL,
                    jobTitle,
                    parsedYearsOfExperience
            );

            //add job to the jobs array list
            jobs.add(job);
        }
        return jobs;
    }

    private static double parseSalary(String salaryText) {
       try {
           salaryText = salaryText.replace("$", "")
                   .toLowerCase()
                   .replace(",", "")
                   .replace(".", "")
                   .replace("ote","")
                   .trim();

           if (salaryText.contains("-") && salaryText.contains("k")){
               salaryText = salaryText.replace("k", "");
               String[] parts = Arrays.stream(salaryText.split("-"))
                       .map(String::trim)
                       .toArray(String[]::new);

               double salary1 = Double.parseDouble(parts[0]);
               double salary2 = Double.parseDouble(parts[1]);
               double average = (salary1 + salary2) / 2;
               return average * 1000;

           } else if (salaryText.contains("-")){
               String[] parts = Arrays.stream(salaryText.split("-"))
                       .map(String::trim)
                       .toArray(String[]::new);

               double salary1 = Double.parseDouble(parts[0]);
               double salary2 = Double.parseDouble(parts[1]);
               return (salary1 + salary2) / 2;

           } else if (salaryText.contains("k")){
               salaryText = salaryText.replace("k", "");
               double salary1 = Double.parseDouble(salaryText);
               return salary1 * 1000;

           } else {
               return Double.parseDouble(salaryText);
           }
       } catch (NumberFormatException e) {
           return 0;
       }

    }

    private static boolean parseRemote(String locationText){

        locationText = locationText.toLowerCase()
                                    .trim();

        return locationText.contains("remote") || locationText.contains("usa");
    }

    private static int parseYearsOfExperience(String descriptionText){
        Pattern pattern = Pattern.compile("(\\d+)\\s*years");
        Matcher matcher = pattern.matcher(descriptionText);

        if (matcher.find()) {
            String yearsFound = matcher.group(1);
            return Integer.parseInt(yearsFound);
        }
        else {
            return 5;
        }

    }
}
