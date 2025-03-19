package Object;

public class CityDTO {
    private String city;

    public CityDTO(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "City: " + city;
    }
}
