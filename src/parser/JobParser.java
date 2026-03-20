package parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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

        // 1. Convert String > Jason Object
        JsonObject root = JsonParser.parseString(json).getAsJsonObject();

        // 2. Get the "jobs" array
        JsonArray jobsArray = root.getAsJsonArray("jobs");

        for (int i = 0; i <jobsArray.size(); i++) {
            JsonObject jobObject = jobsArray.get(i).getAsJsonObject();

            String jobCompany = jobObject.get("company_name").getAsString();
            String jobDescription = jobObject.get("description").getAsString();
            String jobLocation = jobObject.get("candidate_required_location").getAsString();
            String jobSalary = jobObject.get("salary").getAsString();
            String jobURL = jobObject.get("url").getAsString();
            String jobTitle = jobObject.get("title").getAsString();
            String jobYearsOfExperience = jobObject.get("description").getAsString();


        }
    }

    private static int parseSalary(String salaryText) {
        //add logic here
        return 0;
    }

    private static boolean parseRemote(String locationText){
        //logic here
        return true;
    }

    private static int parseYearsOfExperience(String descriptionText){
        //logic here
        return 0;
    }
}
