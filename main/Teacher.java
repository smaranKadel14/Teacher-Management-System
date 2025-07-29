public class Teacher{
   private String teacherAddress;
   private String teacherName;
   private String teacherWorkType;
   private String employmentStat;
   private int teacherID;
   private int teacherWorkingHour;
   
   /*Constructor to initialize the variables
      Using 'this' keyword to point to instance variables*/
   
   public Teacher(String teacherName, int teacherID, String teacherAddress, String teacherWorkType, String employmentStat){
       this.teacherName = teacherName;
       this.teacherID = teacherID;
       this.teacherAddress = teacherAddress;
       this.teacherWorkType = teacherWorkType;
       this.employmentStat = employmentStat;
   }
   
   //accessor method to get name
   
   public String getName(){
       return this.teacherName;
   }
   
   //accessor method to get ID
   
   public int getID(){
       return this.teacherID;
   }
   
   //accessor method to get address 
   
   public String getAddress(){
       return this.teacherAddress;
   }
   
   //accessor method to get work type
   
   public String getWorkType(){
       return this.teacherWorkType;
   }
   
   //accessor method to get employment stat
   
   public String getEmploymentStat(){
       return this.employmentStat;
   }
   
   //accessor method to get teacher working hour
   
   public int getWorkingHour(){
       return this.teacherWorkingHour;    
   }
   
   //setter method to set teacher working hour
   
   public void setWorkingHour(int teacherWorkingHour){
       this.teacherWorkingHour = teacherWorkingHour;
   }
   
   //display method to display teacher details
   
   public void display(){
       System.out.println("Name = " + this.teacherName);
       System.out.println("ID = " + this.teacherID);
       System.out.println("Address = " + this.teacherAddress);
       System.out.println("Work Type = " + this.teacherWorkType);
       System.out.println("Employment Status = " + this.employmentStat);
       
       if(this.teacherWorkingHour >= 0){
           System.out.println("Working Hour = " + this.teacherWorkingHour);
       }else{
           System.out.println("Teacher working hour is not assigned");
       }
   }
}