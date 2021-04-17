package JDBC.Gun2;

import JDBC._Parent;
import org.testng.annotations.Test;


import java.sql.ResultSet;
import java.sql.SQLException;

public class _01_SqlExample extends _Parent {


    @Test
    public void relativeExample() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.relative(5);  // en son bulunulan eyrden 5 adım ilerdeki satırın bilgisini aldık
        String cityName = rs.getString(2);
        System.out.println(cityName);

        rs.relative(6); // en bulunulan yerden 6 adım ilerdeki row a gitti.
        cityName = rs.getString(2);
        System.out.println(cityName);
    }

    @Test
    public void lastFirstKeyword() throws SQLException {
        ResultSet rs = statement.executeQuery("select * from city");

        rs.last(); // en son row a gidiyor.
        String cityName=rs.getString("city");
        int countryId = rs.getInt("country_id");

        System.out.println(cityName+" -- "+ countryId);

        rs.first();
        cityName=rs.getString("city");
        countryId = rs.getInt("country_id");

        System.out.println(cityName+" -- "+ countryId);
    }

    // address tablosundaki teki disrict alanını önce 10.satırdakini sonra, 22.satırdaki,
    // sonra en son satırdaki bilgisini yazdırınız.

    @Test
    public void task1() throws SQLException {
        ResultSet rs= statement.executeQuery("select district from address");

        rs.absolute(10);
        String district=rs.getString(1);
        System.out.println(district);

        rs.relative(12); // rs.absolute(22);
        district=rs.getString(1);
        System.out.println(district);

        rs.last(); // rs.absolute(22);
        district=rs.getString(1);
        System.out.println(district);
    }









}
