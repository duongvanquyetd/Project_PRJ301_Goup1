package Object;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import ultilies.DBUtils;

public class CityDAO {

    // Lấy danh sách các thành phố có khách sạn
    public List<CityDTO> getAllHotelByCity() {
        List<CityDTO> list = new ArrayList<>();
        String sql = "SELECT city FROM Hotel GROUP BY city";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {
            
            while (rs.next()) {
                String city = rs.getString("city");
                list.add(new CityDTO(city));  // Sửa lỗi ép kiểu sai
            }
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Lấy số lượng phòng theo từng thành phố
    public List<HotelDTO> getRoomCountByCity() {
        List<HotelDTO> list = new ArrayList<>();
        String sql = "SELECT h.city, COUNT(r.RoomID) AS room_count " +
                     " FROM Hotel h, Room r " +
                     " WHERE h.HotelID = r.HotelID " +
                     " GROUP BY h.city";

        try (Connection con = DBUtils.getConnection();
             PreparedStatement stm = con.prepareStatement(sql);
             ResultSet rs = stm.executeQuery()) {

            while (rs.next()) {
                String city = rs.getString("c"
                        + "ity");
                int roomCount = rs.getInt("room_count");
                list.add(new HotelDTO()); 
            }
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void main(String[] args) {
        CityDAO dt = new CityDAO();
        System.out.println(dt.getRoomCountByCity().get(0).getCity());
    }
}

