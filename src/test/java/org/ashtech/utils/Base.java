package org.ashtech.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Base {



    public RequestSpecification getRequestSpecification() throws FileNotFoundException {
        PrintStream stream = new PrintStream(new FileOutputStream(("api-logs.txt")));
        return new RequestSpecBuilder().setBaseUri("https://reqres.in").setContentType(ContentType.JSON).addQueryParam("page","2")
                .addFilter(RequestLoggingFilter.logRequestTo(stream))
                .addFilter(ResponseLoggingFilter.logResponseTo(stream))
                .build();

    }
    public ResponseSpecification getResponseSpecification(String statusCode){
        return new ResponseSpecBuilder().expectContentType(ContentType.JSON).expectStatusCode(Integer.valueOf(statusCode)).build();
    }
}
