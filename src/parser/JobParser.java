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

    public static void main(String[] args){
        String json = "{\n" +
                "  \"0-legal-notice\": \"Remotive API Legal Notice\",\n" +
                "  \"job-count\": 1,\n" +
                "  \"jobs\": [\n" +
                "    {\n" +
                "      \"id\": 123,\n" +
                "      \"url\": \"https://remotive.com/remote-jobs/product/lead-developer-123\",\n" +
                "      \"title\": \"Lead Developer\",\n" +
                "      \"company_name\": \"Remotive\",\n" +
                "      \"company_logo\": \"https://remotive.com/job/123/logo\",\n" +
                "      \"category\": \"Software Development\",\n" +
                "      \"job_type\": \"full_time\",\n" +
                "      \"publication_date\": \"2020-02-15T10:23:26\",\n" +
                "      \"candidate_required_location\": \"Worldwide\",\n" +
                "      \"salary\": \"$40,000 - $50,000\",\n" +
                "      \"description\": \"The full HTML job description here\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";

    }

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
        salaryText = salaryText.replace("$", "")
                                .replace(",", "")
                                .replace(".", "")
                                .trim();

        if (salaryText.contains("-")){
            String[] parts = Arrays.stream(salaryText.split("-"))
                                        .map(String::trim)
                                        .toArray(String[]::new);

            double salary1 = Double.parseDouble(parts[0]);
            double salary2 = Double.parseDouble(parts[1]);
            return (salary1 + salary2) / 2;
            }

        else {
            return Double.parseDouble(salaryText);
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
