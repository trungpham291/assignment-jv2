import java.util.ArrayList;

public interface ArticleService {
    //Cho phep lay danh sach link tu mot nguon
    ArrayList<String> getLinks(String url);
    //Cho phep lay thong tin chi tiet tu mot link bai viet chi tiet
    Article getArticle(String url);
}
