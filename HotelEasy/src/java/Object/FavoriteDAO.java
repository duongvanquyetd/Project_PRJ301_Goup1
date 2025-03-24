package Object;



import Object.FavoriteDTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ultilies.DBUtils;

public class FavoriteDAO {

    public List<FavoriteDTO> getInfoFavorite(String userId) {
        List<FavoriteDTO> list = new ArrayList<>();

        String sql = "SELECT * from Favorite where PersonID = ?";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, userId); // truyền ID người dùng
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                FavoriteDTO favorite = new FavoriteDTO();
                favorite.setHotelID(rs.getString("HotelID"));
                
                list.add(favorite);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
    
    
    public  boolean isFavorite(String userId, String hotelId) {
        String sql = "SELECT * FROM Favorite WHERE PersonID = ? AND HotelID = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, hotelId);
            ResultSet rs = ps.executeQuery();
            return rs.next(); // true nếu có
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public  void addFavorite(String userId, String hotelId) {
    if (!isFavorite(userId, hotelId)) {
        String sql = "INSERT INTO Favorite (PersonID, HotelID) VALUES (?, ?)";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, hotelId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


    public  void removeFavorite(String userId, String hotelId) {
        String sql = "DELETE FROM Favorite WHERE PersonID = ? AND HotelID = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, userId);
            ps.setString(2, hotelId);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    public static void main(String[] args) {
        String userID = "vangia" ;
        FavoriteDAO dao = new FavoriteDAO() ;
        List<FavoriteDTO> list = dao.getInfoFavorite(userID);
        
        System.out.println("Số khách sạn thích" + list.size());
    }
}
