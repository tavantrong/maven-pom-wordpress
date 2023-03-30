package com.nopcommerce.data;

import java.io.File;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataJson {


public static DataJson getFile(String filename) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            return mapper.readValue(new File(filename), DataJson .class);
                } catch (Exception ex) {
                        ex.printStackTrace();
                        return null;
                }
}

        @JsonProperty("firstname")
        private String firstName;

        @JsonProperty("lastname")
        private String lastName;

        @JsonProperty("email")
        private String emailAddress;

        @JsonProperty("password")
        private String password;
        
        @JsonProperty("date")
        private String date;
        
        @JsonProperty("month")
        private String month;
        
        @JsonProperty("year")
        private String year;

        
        // Right click - Source - Generate Getters and Setters - Select Getters (Auto khởi tạo các hàm cho các tham số trên)
		public String getFirstName() {
			return firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public String getPassword() {
			return password;
		}

		public String getDate() {
			return date;
		}

		public String getMonth() {
			return month;
		}

		public String getYear() {
			return year;
		}


}