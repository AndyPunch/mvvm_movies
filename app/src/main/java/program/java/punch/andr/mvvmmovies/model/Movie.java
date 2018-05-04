package program.java.punch.andr.mvvmmovies.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;


@Entity(tableName = "favourite_movies", indices = {@Index(value = {"movie_id"},
        unique = true)})
public class Movie {
    @PrimaryKey(autoGenerate = true)
    public Long id;
    @ColumnInfo(name = "movie_title")
    private String Title;
    @ColumnInfo(name = "movie_year")
    private String Year;
    @ColumnInfo(name = "movie_rated")
    private String Rated;
    @ColumnInfo(name = "movie_released")
    private String Released;
    @ColumnInfo(name = "movie_genre")
    private String Genre;
    @ColumnInfo(name = "movie_director")
    private String Director;
    @ColumnInfo(name = "movie_writer")
    private String Writer;
    @ColumnInfo(name = "movie_actors")
    private String Actors;
    @ColumnInfo(name = "movie_plot")
    private String Plot;
    @ColumnInfo(name = "movie_language")
    private String Language;
    @ColumnInfo(name = "movie_country")
    private String Country;
    @ColumnInfo(name = "movie_awards")
    private String Awards;
    @ColumnInfo(name = "movie_poster")
    private String Poster;
    @ColumnInfo(name = "movie_metascore")
    private String Metascore;
    @ColumnInfo(name = "movie_rating")
    private String imdbRating;
    @ColumnInfo(name = "movie_votes")
    private String imdbVotes;
    @ColumnInfo(name = "movie_id")
    private String imdbID;
    @ColumnInfo(name = "movie_type")
    private String Type;
    @ColumnInfo(name = "movie_response")
    private String Response;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getYear() {
        return Year;
    }

    public void setYear(String year) {
        Year = year;
    }

    public String getRated() {
        return Rated;
    }

    public void setRated(String rated) {
        Rated = rated;
    }

    public String getReleased() {
        return Released;
    }

    public void setReleased(String released) {
        Released = released;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public String getWriter() {
        return Writer;
    }

    public void setWriter(String writer) {
        Writer = writer;
    }

    public String getActors() {
        return Actors;
    }

    public void setActors(String actors) {
        Actors = actors;
    }

    public String getPlot() {
        return Plot;
    }

    public void setPlot(String plot) {
        Plot = plot;
    }

    public String getLanguage() {
        return Language;
    }

    public void setLanguage(String language) {
        Language = language;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getAwards() {
        return Awards;
    }

    public void setAwards(String awards) {
        Awards = awards;
    }

    public String getPoster() {
        return Poster;
    }

    public void setPoster(String poster) {
        Poster = poster;
    }

    public String getMetascore() {
        return Metascore;
    }

    public void setMetascore(String metascore) {
        Metascore = metascore;
    }

    public String getImdbRating() {
        return imdbRating;
    }

    public void setImdbRating(String imdbRating) {
        this.imdbRating = imdbRating;
    }

    public String getImdbVotes() {
        return imdbVotes;
    }

    public void setImdbVotes(String imdbVotes) {
        this.imdbVotes = imdbVotes;
    }

    public String getImdbID() {
        return imdbID;
    }

    public void setImdbID(String imdbID) {
        this.imdbID = imdbID;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getResponse() {
        return Response;
    }

    public void setResponse(String response) {
        Response = response;
    }

}
