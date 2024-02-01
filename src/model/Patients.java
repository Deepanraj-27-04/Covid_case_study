package model;

public class Patients {
       private Integer id;
       private String name;
       private long aadharId;
       private int areaId;
       private int hospitalId;
       private String status; 

       public Patients(Integer id,String name,long aadharId,int areaId,int hospitalId,String status)
       {
        super();
        this.id=id;
        this.name=name;
        this.aadharId=aadharId;
        this.areaId=areaId;
        this.hospitalId=hospitalId;
        this.status=status;

       }

       public Integer getId() {
              return id;
       }

       public String getName() {
              return name;
       }

       public long getAadharId() {
              return aadharId;
       }

       public int getAreaId() {
              return areaId;
       }

       public int getHospitalId() {
              return hospitalId;
       }

       public String getStatus() {
              return status;
       }

       public void setId(Integer id) {
              this.id = id;
       }

       public void setName(String name) {
              this.name = name;
       }

       public void setAadharId(long aadharId) {
              this.aadharId = aadharId;
       }

       public void setAreaId(int areaId) {
              this.areaId = areaId;
       }

       public void setHospitalId(int hospitalId) {
              this.hospitalId = hospitalId;
       }

       public void setStatus(String status) {
              this.status = status;
       }
       
}
