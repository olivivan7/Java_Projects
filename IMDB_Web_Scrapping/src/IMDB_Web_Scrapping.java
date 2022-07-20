import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.List;
import java.util.Map;

//You must create your own code at www.imdb-api.com

public class IMDB_Web_Scrapping {
    public static void main(String[] args) throws Exception {
        //acessar url
        var url = "https://imdb-api.com/en/API/Top250Movies/imdb-api-code";
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
        List<Map<String,String>> list_of_movies = parser.parse(body);
        
        //Print List Size
        System.out.println(list_of_movies.size());

        //Print a specific item;
        System.out.println(list_of_movies.get(0));

        //Show and Manipulate Data
        for (Map<String,String> movie:list_of_movies){
            System.out.println(movie.get("Title"));
            System.out.println(movie.get("image"));
            System.out.println(movie.get("imDbRating"));
            System.out.println();

        }

    }
}
