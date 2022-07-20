import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

//You must create your own code at www.imdb-api.com

public class IMDB_Web_Scrapping {
    public static void main(String[] args) throws Exception {
        //url where is the json file
        var url = "https://api.mocki.io/v2/549a5d8b/NASA-APOD-JamesWebbSpaceTelescope";
        URI uri = URI.create(url);
        var client = HttpClient.newHttpClient();
        var request=HttpRequest.newBuilder(uri).GET().build();
        
        //get JSON
        HttpResponse<String> response=client.send(request, BodyHandlers.ofString());
        String body = response.body();
        
        //print JSON
        System.out.println(body);

        //extract valuable data (title, poster, classification)
        var parser = new JsonParser();
        List<Map<String,String>> imagesList = parser.parse(body);
        
        //Print List Size
        //System.out.println(list_of_movies.size());

        //Print a specific item;
        //System.out.println(imagesList.get(0));

        //Show and Manipulate Data
        for (Map<String,String> picture:imagesList){

            String urlImage = picture.get("hdurl");
            String title = picture.get("title");

            InputStream inputFig = new URL(urlImage).openStream();
            String archiveName = title + ".png";

            var maker = new Sticker_maker();
            maker.create(inputFig, archiveName);

            System.out.println(picture.get("title"));
            System.out.println();

        }

    }
}
