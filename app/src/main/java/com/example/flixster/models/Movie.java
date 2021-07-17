/**
 * Movie.java - a Plain Old Java Object (POJO) Class representing a movie
 */

package com.example.flixster.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.parceler.Parcel;

import java.util.ArrayList;
import java.util.List;

@Parcel
public class Movie {

    int movieId;
    String backdropPath; // for landscape view
    String posterPath;
    String title;
    String overview;
    double rating;

    // empty constructor required for Parceler
    public Movie() {}

    // Constructor - constructs the movie object from json object fields
    public Movie(JSONObject jsonObject) throws JSONException {
        movieId = jsonObject.getInt("id");
        backdropPath = jsonObject.getString("backdrop_path");
        posterPath = jsonObject.getString("poster_path");
        title = jsonObject.getString("title");
        overview = jsonObject.getString("overview");
        rating = jsonObject.getDouble("vote_average");
    }

    // iterates through the JSONArray and constructs each element in the array
    public static List<Movie> fromJsonArray(JSONArray movieJsonArray) throws JSONException {
        // initialize list of movies
        List<Movie> movies = new ArrayList<>();
        // add a movie at every position in the array
        for (int i = 0; i < movieJsonArray.length(); i++) {
            movies.add(new Movie(movieJsonArray.getJSONObject(i)));
        }
        return movies;
    }

    /** GETTERS **/

    public String getBackdropPath() {
        // about image usage: https://developers.themoviedb.org/3/getting-started/images
        return String.format("https://image.tmdb.org/t/p/w342/%s", backdropPath);
    }

    public String getPosterPath() {
        // about image usage: https://developers.themoviedb.org/3/getting-started/images
        return String.format("https://image.tmdb.org/t/p/w342/%s", posterPath);
    }

    public String getTitle() {
        return title;
    }

    public String getOverview() {
        return overview;
    }

    public double getRating() { return rating; }

    public int getMovieId() { return movieId; }
}
