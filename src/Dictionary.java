import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.w3c.dom.Document;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.io.StringReader;

public class Dictionary {
    public static void main(String[] args) throws Exception {

        // Create a Scanner to read input from the user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String word = input.nextLine();

        // Look up the definition of the input word in the dictionary
        String url = "https://en.wiktionary.org/w/api.php?action=query&format=xml&prop=extracts&explaintext=true&titles=" + word;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        if (con.getInputStream()!= null){
            System.out.println("Word does exist");
        }else System.out.println("word doesn't exist");
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        //parse XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(response.toString())));
        NodeList extract = doc.getElementsByTagName("extract");
        System.out.println("Definition: " + extract.item(0).getTextContent());
    }
}




