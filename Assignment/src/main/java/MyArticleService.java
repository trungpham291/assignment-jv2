import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class MyArticleService  {
    public static void main(String[] args) {
        Document doc = null;
        try {
            doc = Jsoup.connect("https://vnexpress.net/dong-luc-thuc-day-ong-zelensky-du-doi-thoai-shangri-la-4753540.html").get();
            String title = doc.select("h1.title-detail").text();
            String description = doc.select("p.description").text();
            String firstImageLink = doc.select("picture img[itemprop=contentUrl]").attr("data-src");
            String authorName = doc.select("article.fck_detail p.Normal[style=text-align:right;]").text();
            System.out.println(title);
            System.out.println(description);
            System.out.println(firstImageLink);
            System.out.println(authorName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
