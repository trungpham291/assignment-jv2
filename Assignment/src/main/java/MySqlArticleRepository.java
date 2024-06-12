import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class MySqlArticleRepository implements ArticleRepository {

    private final String MYSQL_CONNECTION_STRING = "jdbc:mysql://localhost:3306/article_notes";
    private final String MYSQL_USERNAME = "root";
    private final String MYSQL_PASSWORD = "";

    @Override
    public ArrayList<Article> findAll() {
        return null;
    }

    @Override
    public Article findByUrl(String url) {
        return null;
    }

    @Override
    public Article save(Article article) {
        try (Connection connection = DriverManager.getConnection(MYSQL_CONNECTION_STRING, MYSQL_USERNAME, MYSQL_PASSWORD)) {
            String prepareSql = "INSERT INTO article"+ "(baseUrl, title, description, content, thumbnail, createdAt, updatedAt, deletedAt, status)"+ "VALUES" +"(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(prepareSql);
            preparedStatement.setString(1, article.getBaseUrl());
            preparedStatement.setString(2, article.getTitle());
            preparedStatement.setString(3, article.getDescription());
            preparedStatement.setString(4, article.getContent());
            preparedStatement.setString(5, article.getThumbnail());
            preparedStatement.setString(6, article.getCreatedAt().toString());
            preparedStatement.setString(7, article.getUpdatedAt().toString());
            preparedStatement.setString(8, article.getDeletedAt().toString());
            preparedStatement.setInt(9, article.getStatus());
            preparedStatement.execute();
            System.out.println("Add new success");
            connection.close();
        } catch (SQLException e) {
            System.out.println("Error adding new order");
            e.printStackTrace();
        }
        return article;
    }

    @Override
    public Article update(Article article) {
        return null;
    }

    @Override
    public void deleteByUrl(String url) {

    }
}
