package controllers;

import com.fasterxml.jackson.databind.JsonNode;
import models.FibonacciNumbers;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.Utils;

import java.util.ArrayList;

public class FibonacciNumbersController extends Controller {
    public Result calc( int number ) {
        ArrayList<Integer> result =  FibonacciNumbers.calcFibonacciNumbers( number );
        if ( result.isEmpty() ) {
            return badRequest(Utils.createResponse( "Please enter a positive number", false ) );
        }

        JsonNode jsonNode = Json.toJson(result);
        return ok( Utils.createResponse( jsonNode, true ) );
    }

    public Result getInfo() {
        return ok( Utils.createResponse( "Input parameters. Call localhost:9000/calc?number=...", true ) );
    }
}
