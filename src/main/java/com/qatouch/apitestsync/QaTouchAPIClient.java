package com.qatouch.apitestsync;

	import java.io.BufferedReader;
	import java.io.InputStreamReader;
	import java.net.HttpURLConnection;
	import java.net.URL;

    //API Client	 
	public class QaTouchAPIClient {
	    public static String QA_TOUCH_API_TOKEN = "*********API TOKEN**************";
	    public static String QA_TOUCH_DOMAIN = "*******DOMAINNAME******************";
	    private static final String API_BASE_URL = "https://api.qatouch.com/api/v1/";

	    public static void addTestRunStatus(String test_run, String project, String run_result,String newStatus, String newComments) {
	        String s=  "{\"0\":{\"case\":\"CASE\",\"status\":\"value\"}}".replaceAll("CASE",run_result);
	        System.out.println("s: "+s);
	        String s1= s.replaceAll("value",newStatus);
	        System.out.println("s1: "+s1);
	       String addResultUrl =API_BASE_URL + "testRunResults/status/multiple?"+ "project=" + project + "&" + "test_run=" + test_run + "&" + "result=" + s1 + "&" + "comments=" + newComments;
	       
	        System.out.println("Add Result URL:"+addResultUrl);
	        String addResult = addTestResults(QA_TOUCH_API_TOKEN, QA_TOUCH_DOMAIN, addResultUrl);
	        System.out.println(addResult);
	    }

	    public static String addTestResults(String apiToken, String domain, String addResultUrl) {
	        try {
	            URL urlObj = new URL(addResultUrl);
	            HttpURLConnection connection = (HttpURLConnection) urlObj.openConnection();
	            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
	            connection.setRequestMethod("POST");
	            connection.setRequestProperty("api-token", apiToken);
	            connection.setRequestProperty("domain", domain);
	            connection.setRequestProperty("url", addResultUrl);

	            int responseCode = connection.getResponseCode();
	            System.out.printf("responseCode:"+responseCode);

	            if (responseCode == HttpURLConnection.HTTP_OK) {
	                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	                String inputLine;
	                StringBuilder response = new StringBuilder();
	                while ((inputLine = in.readLine()) != null) {
	                    response.append(inputLine);
	                }
	                in.close();
	                System.out.println("response:"+response);
	                return response.toString();

	            } else {
	                return "Error: " + responseCode;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return "Error: " + e.getMessage();
	        }
	    }

	}

