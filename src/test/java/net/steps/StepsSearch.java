package net.steps;


import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import gherkin.deps.com.google.gson.Gson;
import gherkin.deps.com.google.gson.JsonArray;
import gherkin.deps.com.google.gson.JsonElement;
import gherkin.deps.com.google.gson.JsonObject;
import http.HttpClientImplementation;
import model.Album;
import model.Artist;
import model.Track;
import org.junit.Assert;
import org.junit.Assert.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class StepsSearch {
    /*TODO add as env vars in a properties file*/
    private static final String host = "api.deezer.com";
    private static final String protocol = "http";
    private static final String user = "";
    private static final String key = "";
    private static final String port = "";
    private HttpClientImplementation httpClient;
    private List<Track> tracks;
    private List<Album> albums;
    private LinkedHashSet<Artist> artists;
    public String trackName;
    public ResponseEntity response;
    @Before
    public void setUp() throws MalformedURLException {
        httpClient = new HttpClientImplementation(protocol,user,key,host,port);
    }

    @After
    public void finish() throws Exception {
    }

    @Given("^I have a track name \"([^\"]*)\"$")
    public void iHaveATrackName(String trackName) throws Throwable {
        this.trackName = trackName;
    }

    @When("^I search using API Search method track$")
    public void iSearchUsingAPIMethodTrack() throws Throwable {
        response = httpClient.doRequest(HttpMethod.GET,"/search/track","?q="+trackName,String.class);

    }

    @Then("^I should receive a list of tracks related to that name$")
    public void iShouldReceiveAListOfSongsRelatedToThatName() throws Throwable {
        Gson gson = new Gson();
        JsonElement parsedResponse = gson.fromJson(response.getBody().toString(), JsonElement.class);
        JsonObject jsonRoot = parsedResponse.getAsJsonObject();
        JsonArray jsonData = jsonRoot.get("data").getAsJsonArray();
        //System.out.println(jsonData);
        tracks = new ArrayList<Track>();
        for(Integer i = 0;i<jsonData.size();i++) {
            tracks.add(gson.fromJson(jsonData.get(i).toString(), Track.class));
        }
    }

    @And("^The tracks should have title including the track name I searched$")
    public void theTracksShouldHaveTitleIncludingTheTrackNameISearched() throws Throwable {
        String[] array= trackName.split(" ");
        String lastWord =array[array.length-1];

        for(Integer i = 0;i<tracks.size();i++) {
            Assert.assertTrue("Track's title has the keyword within itself ",tracks.get(i).getTitle().contains(lastWord));
            System.out.println(tracks.get(i).getTitle());
        }
    }

    @And("^I can get the albums list where this track is present and print their title$")
    public void iCanGetTheAlbumsListWhereThisTrackIsPresentAndPrintTheirTitle() throws Throwable {
        albums = new ArrayList<Album>();
        for(Integer i = 0;i<tracks.size();i++) {
            albums.add(tracks.get(i).getAlbum());
            Assert.assertTrue("Album Title is different from null ",albums.get(i).getTitle()!= null);
            System.out.println(albums.get(i).getTitle());
        }
    }

    @And("^I can get the artist list related to this track and print their name$")
    public void iCanGetTheArtistListRelatedToThisTrackAndPrintTheirName() throws Throwable {
        artists = new LinkedHashSet<Artist>();
        for(Integer i = 0;i<tracks.size();i++) {
            artists.add(tracks.get(i).getArtist());
            Assert.assertTrue("Artist Name is different from null ",tracks.get(i).getArtist().getName() != null);
        }
        System.out.println(artists);
    }

    @And("^Their track id should not be null$")
    public void theirTrackIdShouldNotBeNull() throws Throwable {
        for(Integer i = 0;i<tracks.size();i++) {
            Assert.assertTrue("Track ID is different from null ",tracks.get(i).getId()!= null);
            System.out.println(tracks.get(i).getId());
        }
    }
}
