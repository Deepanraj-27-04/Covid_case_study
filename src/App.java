import java.util.Random;
import java.util.Scanner;

import iService.IHospitalService;
import service.HospitalService;

public class App {
    public static void main(String[] args)  {
     Scanner sc = new Scanner(System.in);
     IHospitalService hospitalService= new HospitalService();
    // Patient patient = new Patient();
    System.out.println("Enter the name : ");
    String name = sc.nextLine();
    System.out.println("Enter the aadhar number: ");
    Long aadharId = sc.nextLong();
    System.out.println("Enter the latitude : ");
    Double latitude = sc.nextDouble();
    System.out.println("Enter the longitude : ");
    Double longitude = sc.nextDouble();
    sc.close();


        Random random = new Random();
        boolean isPositive=true;
        //boolean isPositive=(random.nextInt(1,10)<5)? true: false;
        if(isPositive){
            System.out.println("person has  covid positive");
            Integer hospitalid=hospitalService.findNearByHospital(latitude, longitude);
            if(hospitalid>0)
            System.out.println("found hospital");

            else
            System.out.println("Hospital not found in your area");

        }
        else
            System.out.println("person has  covid negative");
    }

  
}
