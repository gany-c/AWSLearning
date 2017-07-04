package com.amazonaws.DynamoTrial;

import java.util.HashMap;

import com.amazonaws.AmazonClientException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

public class DynamoDbAccess {
	
    static AmazonDynamoDBClient dynamoDB;

	public static void main(String[] args) {

        AWSCredentials credentials = null;
        try {
            credentials = new ProfileCredentialsProvider("ramanan").getCredentials();
        } catch (Exception e) {
            throw new AmazonClientException(
                    "Cannot load the credentials from the credential profiles file. " +
                    "Please make sure that your credentials file is at the correct " +
                    "location (/Users/Ramanan/.aws/credentials), and is in valid format.",
                    e);
        }
        dynamoDB = new AmazonDynamoDBClient(credentials);
        Region region = Region.getRegion(Regions.US_EAST_2);
        //Region usWest2 = Region.getRegion(Regions.US_WEST_2);
        dynamoDB.setRegion(region);
        
        String tableName = "ProductCatalog";
        
        ScanRequest scanRequest = new ScanRequest(tableName);
        ScanResult scanResult = dynamoDB.scan(scanRequest);
        System.out.println("Result: " + scanResult);
        
		

	}

}
