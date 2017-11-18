package controllers;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import org.junit.Test;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;

public class FibonacciNumbersControllerTest {
    private static final String BASE_URL = "http://localhost:9000";

    @Test
    public void getRequestWithoutParamsTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue( makeRequest( BASE_URL, "GET" ), JsonNode.class );
        String rightString = "Input parameters. Call localhost:9000/calc?number=...";
        String requestResult = jsonNode.get( "body" ).asText();
        assertEquals( rightString, requestResult );
    }

    @Test
    public void getRequestWithParamsTest() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=3"), "GET" ), JsonNode.class );
        String rightString ="[0,1,1]";
        ArrayNode requestResult = (ArrayNode) jsonNode.get( "body" );
        assertEquals( rightString, requestResult.toString() );

        jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=5"), "GET" ), JsonNode.class );
        rightString = "[0,1,1,2,3]";
        requestResult = (ArrayNode) jsonNode.get( "body" );
        assertEquals( rightString, requestResult.toString() );

        jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=20"), "GET" ), JsonNode.class );
        rightString = "[0,1,1,2,3,5,8,13,21,34,55,89,144,233,377,610,987,1597,2584,4181]";
        requestResult = (ArrayNode) jsonNode.get( "body" );
        assertEquals( rightString, requestResult.toString() );

        jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=0"), "GET" ), JsonNode.class );
        rightString = "Please enter a positive number";
        String requestResult1 = jsonNode.get( "body" ).asText();
        assertEquals( rightString, requestResult1 );

        jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=-1"), "GET" ), JsonNode.class );
        requestResult1 = jsonNode.get( "body" ).asText();
        assertEquals( rightString, requestResult1 );

        jsonNode = mapper.readValue( makeRequest( BASE_URL.concat("/calc?number=-30"), "GET" ), JsonNode.class );
        requestResult1 = jsonNode.get( "body" ).asText();
        assertEquals( rightString, requestResult1 );
    }

    public static String makeRequest( String myUrl, String httpMethod ) {   // для моего кода этого будет достаточно
        URL url = null;
        try {
            url = new URL( myUrl );
        } catch ( MalformedURLException e ) {
            e.printStackTrace();
        }
        HttpURLConnection conn = null;
        try {
            conn = ( HttpURLConnection ) url.openConnection();
        } catch ( IOException e ) {
            e.printStackTrace();
        }
        String inputString = null;
        try {
            conn.setRequestMethod( httpMethod );
            int respCode = conn.getResponseCode();
            if ( respCode != 200 ) {
                String error = inputStreamToString( conn.getErrorStream() );
                return error;
            }
            inputString = inputStreamToString( conn.getInputStream() );

        } catch ( IOException e ) {
            e.printStackTrace();
        }
        return inputString;
    }

    public static String inputStreamToString( InputStream is ) {
        BufferedReader br = null;
        StringBuilder sb = new StringBuilder();

        String line;
        try {
            br = new BufferedReader( new InputStreamReader( is ) );
            while ( ( line = br.readLine() ) != null ) {
                sb.append( line );
            }

        } catch ( IOException e ) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
        }

        return sb.toString();
    }
}

