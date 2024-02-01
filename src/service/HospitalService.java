package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import model.Hospital;

public class HospitalService implements iService.IHospitalService {
    @Override
    public Integer findNearByHospital(Double latitude,Double longitude)
    {
        Integer hospitalid=-1;
        Integer maxDistance=10;
        LinkedList<Hospital> hospitalList=getHospital();
        for (Hospital hospital : hospitalList) {
            double distance=calculateDistance(longitude, longitude, hospital.getLatitude(), hospital.getLongitude());
            if(distance<=maxDistance){
            hospitalid=hospital.getId();
            System.out.println("HospitalId "+hospitalid);
            break;
        }

        }
        return hospitalid;
    }
    private LinkedList<Hospital> getHospital(){
     LinkedList<Hospital> HospitalList= new LinkedList<Hospital>();
     String sql = "SELECT a.id, a.name, a.availableBed, b.latitude, b.longitude " +
     "FROM (SELECT id, name, availableBed, areaid FROM coviddb.hospital WHERE availableBed > 0) a " +
     "LEFT JOIN (SELECT id, latitude, longitude FROM coviddb.area) b ON a.areaid = b.id";


    try {
        Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3303/coviddb","root", "root");
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery(sql);
        while(resultSet.next())
        {
            Hospital hospital =new Hospital(resultSet.getInt("id"),resultSet.getString("name"),null,resultSet.getInt("availableBed")
            ,resultSet.getDouble("latitude"),resultSet.getDouble("longitude"));

            HospitalList.add(hospital);
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
     return HospitalList;
    }
    private Double calculateDistance(Double patientLat,Double patientLong, Double hospitalLat,Double hospitalLong)
    {
        Double latDifferce=patientLat-hospitalLat;
        Double longDifferce=patientLong-hospitalLong;

        return Math.sqrt(latDifferce*latDifferce-longDifferce*longDifferce);
        
    }
}
