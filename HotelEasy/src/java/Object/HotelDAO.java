/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Object;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import ultilies.DBUtils;

/**
 *
 * @author Lenovo
 */
public class HotelDAO {

    public List<HotelDTO> getHotelDiscount() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "SELECT TOP(5) H.HotelID,H.City,H.District,H.Streets,H.NameHotel,H.RateHotel,R.Discount,R.Price "
                    + "FROM Hotel H,Room R\n"
                    + "WHERE H.HotelID =R.HotelID AND Approved != 0\n"
                    + "ORDER BY R.Discount  DESC";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelDTO> list = new ArrayList();
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");
                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");
                String rate = rs.getString("RateHotel");
                double discount = rs.getDouble("Discount");
                double price = rs.getDouble("Price");
                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);
            }
            con.close();
            return list;
        } catch (Exception e) {
        }
        return null;

    }

    public List<HotelDTO> getNotApproveHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "select HotelID,p.Name,City,District,Streets,NameHotel,RateHotel,Approved from hotel h, Person p\n"
                    + "where Approved = 0 and h.PersonID  =p.PersonID";
            PreparedStatement stm = con.prepareStatement(sql);

            List<HotelDTO> list = new ArrayList();

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                list.add(new HotelDTO(rs.getString("HotelID").trim(), rs.getString("Name"), rs.getString("City"), rs.getString("District"), rs.getString("Streets"), rs.getString("NameHotel"), rs.getString("RateHotel"), rs.getInt("Approved")));
            }
            return list;
        } catch (Exception e) {
        }

        return null;
    }

    public void AppvovedHotel(String HotelID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "update Hotel set Approved = 1 where HotelID =  ? ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, HotelID);
            stm.executeQuery();

        } catch (Exception e) {
        }

    }

    public int NumberOfHotel() {
        try {
            Connection con = DBUtils.getConnection();
            String sql = "Select count(HotelID)'NumberOfHotel' from Hotel where Approved =1 ";

            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                return rs.getInt("NumberOfHotel");
            }

        } catch (Exception e) {
        }
        return 0;
    }

    public HotelDTO getHotelByOwnerID(String PersonID) {
        try {
            Connection con = DBUtils.getConnection();
            String sql = " select * from Hotel where PersonID = ? ";

            PreparedStatement stm = con.prepareStatement(sql);
            stm.setString(1, PersonID);
            ResultSet rs = stm.executeQuery();
            String id = rs.getString("HotelID").trim();
            String city = rs.getString("City");
            String district = rs.getString("District");
            String streets = rs.getString("Streets");
            String nameHotel = rs.getString("NameHotel");
            String rate = rs.getString("RateHotel");
            double discount = rs.getDouble("Discount");
            double price = rs.getDouble("Price");
            HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
            return ht;
        } catch (Exception e) {
            System.out.println("Load hotel by owner id fail " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    public HotelDTO getHotelByID() {
        return null;
    }

    public void updateHotel(String hotelID, String city, String distric, String Strees, String nameHotel, String rateHotel) {
        String sql = " update Hotel set City = ?, District = ?, Streets = ?, NameHotel = ?, RateHotel = ? where HotelID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, city);
            stm.setString(2, distric);
            stm.setString(3, Strees);
            stm.setString(4, nameHotel);
            stm.setString(5, rateHotel);
            stm.setString(6, hotelID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Update hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void insertHotel(String hotelID, String personID, String city, String distric, String Strees, String nameHotel, String rateHotel) {
        String sql = " insert into Hotel values(?, ?, ?, ?, ?, ?, ?, 0) ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);
            stm.setString(2, personID);
            stm.setString(3, city);
            stm.setString(4, distric);
            stm.setString(5, Strees);
            stm.setString(6, nameHotel);
            stm.setString(7, rateHotel);

            stm.executeQuery();

            conn.close();

        } catch (Exception e) {
            System.out.println("Insert hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void deleteHotel(String hotelID) {
        String sql = " delete from Hotel where HotelID = ? ";
        try {
            Connection conn = DBUtils.getConnection();
            PreparedStatement stm = conn.prepareStatement(sql);

            stm.setString(1, hotelID);

            stm.executeUpdate();

            conn.close();

        } catch (Exception e) {
            System.out.println("Delete hotel fail " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<HotelDTO> getHotelBySearch(String search, String numberOfPerson,String sortcol) {
        try {
            Connection con = DBUtils.getConnection();
            List<HotelDTO> list = new ArrayList<>();;
            String sql = "select h.HotelID,PersonID,City,District,Streets,NameHotel,RateHotel,r.Discount,r.Price  \n"
                    + "from Hotel h, (select Min(price)'price' ,Max(Discount)'discount',HotelID  from room r group by HotelID )r\n"
                    + "\n"
                    + "where  h.HotelID = r.HotelID and  Approved = 1  ";
            if (search != null && !search.isEmpty() && numberOfPerson != null && !numberOfPerson.isEmpty()) {
                sql += " and ( City like ? or NameHotel like ? )  and h.hotelid in (select hotelid from room where CapacityAdult+CapacityChild >= ?) ";
            } else if (search != null && !search.isEmpty()) {
                sql += " and ( City like ? or NameHotel like ? ) ";
            } else if (numberOfPerson != null && !numberOfPerson.isEmpty()) {
                sql += "and h.hotelid in (select hotelid from room where CapacityAdult+CapacityChild >= ?)";
            }
            
            
            if(sortcol != null && !sortcol.isEmpty())
            {
                sql+=" order by "+sortcol+" asc";
            }
            PreparedStatement stm = con.prepareStatement(sql);

            if (search != null && !search.isEmpty() && numberOfPerson != null && !numberOfPerson.isEmpty()) {
                stm.setString(1, '%' + search + '%');
                stm.setString(2, '%' + search + '%');
                stm.setInt(3, Integer.parseInt(numberOfPerson));
            } else if (search != null && !search.isEmpty()) {
                stm.setString(1, '%' + search + '%');
                stm.setString(2, '%' + search + '%');
            } else if (numberOfPerson != null && !numberOfPerson.isEmpty()) {
                stm.setInt(1, Integer.parseInt(numberOfPerson));
            }

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");

                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");

                String rate = rs.getString("RateHotel");

                int discount = rs.getInt("Discount");
                double price = rs.getDouble("Price");

                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);

            }
            return list;

        } catch (Exception e) {
        }

        return null;
    }

    public String getImageHotel(String hotelID) {
        HotelImageDAO d = new HotelImageDAO();
        List<HotelImageDTA> l = d.getAllImgHotel();
        for (HotelImageDTA i : l) {
            if (i.getHotelID().equals(hotelID)) {
                return i.getImage().get(0);
            }
        }
        return null;

    }

    public String ChangeListTostrignN(String[] list) {
        String a = "";
        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1) {
                a += "N'" + list[i] + "'";
            } else {
                a += "N'" + list[i] + "',";
            }
        }
        return a;
    }

    public String ChangeListTostrign(String[] list) {
        String a = "";
        for (int i = 0; i < list.length; i++) {
            if (i == list.length - 1) {
                a += "'" + list[i] + "'";
            } else {
                a += "'" + list[i] + "',";
            }
        }
        return a;
    }

    public List<HotelDTO> getHotelbyListLocation(String[] location) {
        try {

            Connection con = DBUtils.getConnection();
            List<HotelDTO> list = new ArrayList<>();;
            String sql = "select h.HotelID,PersonID,City,District,Streets,NameHotel,RateHotel,r.Discount,r.Price  \n"
                        + "from Hotel h, (select Min(price)'price' ,Max(Discount)'discount',HotelID  from room r group by HotelID )r\n"
                        + "\n"
                        + "where  h.HotelID = r.HotelID and  Approved = 1 ";
            if (location != null && location.length != 0) {
                sql   += " and  h.Streets+','+h.District in (" + ChangeListTostrignN(location) + ")  ";

            }
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");

                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");

                String rate = rs.getString("RateHotel");

                int discount = rs.getInt("Discount");
                double price = rs.getDouble("Price");

                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);

            }
            return list;

        } catch (Exception e) {
        }
        return null;
    }

    public List<HotelDTO> getHotelbyListsosao(String[] sosao) {
        try {

            Connection con = DBUtils.getConnection();
            List<HotelDTO> list = new ArrayList<>();;
            String sql = "select h.HotelID,PersonID,City,District,Streets,NameHotel,RateHotel,r.Discount,r.Price  \n"
                        + "from Hotel h, (select Min(price)'price' ,Max(Discount)'discount',HotelID  from room r group by HotelID )r\n"
                        + "\n"
                        + "where  h.HotelID = r.HotelID and  Approved = 1 ";
            if (sosao != null && sosao.length != 0) {
                sql +="  and h.RateHotel in(" + ChangeListTostrign(sosao) + ")    ";

            }
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");

                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");

                String rate = rs.getString("RateHotel");

                int discount = rs.getInt("Discount");
                double price = rs.getDouble("Price");

                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);

            }
            return list;

        } catch (Exception e) {
        }
        return null;
    }

    public List<HotelDTO> getHotelbyListFeature(String[] feature) {
        try {

            Connection con = DBUtils.getConnection();
            List<HotelDTO> list = new ArrayList<>();;
            String sql = "select h.HotelID,PersonID,City,District,Streets,NameHotel,RateHotel,r.Discount,r.Price  \n"
                        + "from Hotel h, (select Min(price)'price' ,Max(Discount)'discount',HotelID  from room r group by HotelID )r\n"
                        + "\n"
                        + "where  h.HotelID = r.HotelID and  Approved = 1 ";
            if (feature != null && feature.length != 0) {
                sql+= " and h.hotelID in ( select HotelID from FeatureHotel where Feature in(" + ChangeListTostrignN(feature) + "))   ";

            }
            PreparedStatement stm = con.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");

                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");

                String rate = rs.getString("RateHotel");

                int discount = rs.getInt("Discount");
                double price = rs.getDouble("Price");

                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);

            }
            return list;

        } catch (Exception e) {
        }
        return null;
    }

    public List<HotelDTO> getHotelBySearchDay(String dateArrive) {
        try {
            Connection con = DBUtils.getConnection();
            List<HotelDTO> list = new ArrayList<>();
            String sql = "select h.HotelID,PersonID,City,District,Streets,NameHotel,RateHotel,r.Discount,r.Price  \n"
                        + "from Hotel h, (select Min(price)'price' ,Max(Discount)'discount',HotelID  from room r group by HotelID )r\n"
                        + "\n"
                        + "where  h.HotelID = r.HotelID and  Approved = 1 ";
            if (dateArrive != null && !dateArrive.isEmpty()) {
                sql += " and h.hotelid in  (select r.HotelID from Room r, Booking b where r.HotelID= b.HotelID and r.RoomID = b.RoomID \n"
                        + "and (ArriveDate < ? or  r.Status = 0 ))";
            }
            PreparedStatement stm = con.prepareStatement(sql);
            if (dateArrive != null && !dateArrive.isEmpty()) {

           
                stm.setDate(1, Date.valueOf(dateArrive));
            }
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {

                String id = rs.getString("HotelID").trim();
                String city = rs.getString("City");

                String district = rs.getString("District");
                String streets = rs.getString("Streets");
                String nameHotel = rs.getString("NameHotel");

                String rate = rs.getString("RateHotel");

                int discount = rs.getInt("Discount");
                double price = rs.getDouble("Price");

                HotelDTO ht = new HotelDTO(id, city, district, streets, nameHotel, rate, discount, price);
                list.add(ht);

            }
            return list;

        } catch (Exception e) {
        }

        return null;
    }

    public List<HotelDTO> searachAll(String nameLoca, String sorcol,String ArriveDate, String NumberOfPerson, String[] location, String[] sosao, String[] feature) {

        List<HotelDTO> list = new ArrayList<>();

        /////////////LIst search by number of person and name hotel or location 
        List<HotelDTO> namelocaAnNumber = getHotelBySearch(nameLoca, NumberOfPerson,sorcol);
        List<HotelDTO> searlocation = getHotelbyListLocation(location);
        List<HotelDTO> searchSosa = getHotelbyListsosao(sosao);
        List<HotelDTO> serachFeature = getHotelbyListFeature(feature);
        List<HotelDTO> searchBydate = getHotelBySearchDay(ArriveDate);
        
        for (HotelDTO hotelDTO : namelocaAnNumber) {
            
            int cout = 0 ;
             for (HotelDTO hotelDTO1 : searlocation) {
                if(hotelDTO1.getHotelID().equals(hotelDTO.getHotelID()))
                {
                    
                    cout++;
                }
            }
            
          
             for (HotelDTO hotelDTO1 : searchSosa) {
                if(hotelDTO1.getHotelID().equals(hotelDTO.getHotelID()))
                {
                    
                    cout++;
                }
            }
              for (HotelDTO hotelDTO1 : serachFeature) {
                if(hotelDTO1.getHotelID().equals(hotelDTO.getHotelID()))
                {
                   
                    cout++;
                }
            } for (HotelDTO hotelDTO1 : searchBydate) {
                if(hotelDTO1.getHotelID().equals(hotelDTO.getHotelID()))
                {
                  
                    cout++;
                }
            }
            if(cout==4)
            {
                list.add(hotelDTO);
            }
            
            
        }
        
        
        
        return list;
    }

    public static void main(String[] args) {
        HotelDAO d = new HotelDAO();
        String[] location = {"12 Lý Tự Trọng,Quận 1","11 Nguyễn Văn Cừ,Quận Gò Vấp","19 Võ Thị Sáu,Quận 6"};
        String [] sosao = {"image/Star/5sao.png","image/Star/1sao.png"};
        
        
        String [] feature ={"Dịch vụ giặt là","Karaoke","Bể bơi"};
        //2025-04-05
        //searachAll(null,null, null,null ,null, feature);
       List<HotelDTO> list = d.searachAll(null,"price",null,null,null,null,null);


System.out.println(list.size());

    }

}
