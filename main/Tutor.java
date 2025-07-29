public class Tutor extends Teacher{
    private double salary;
    private String specialization;
    private String academicQualification;
    private int performanceIndex;
    private boolean isCertified;
    
    /*constructor for lecturer class
    'super' keyword is used to inherit the constructor from parent class.*/
    
    public Tutor(int teacherID, String teacherName, String teacherAddress, String teacherWorkType, String employmentStat, int teacherWorkingHour, double salary, String specialization, String academicQualification, int performanceIndex){
        super(teacherName, teacherID, teacherAddress, teacherWorkType, employmentStat);
        setWorkingHour(teacherWorkingHour);
        this.salary = salary;
        this.specialization = specialization;
        this.academicQualification = academicQualification;
        this.performanceIndex = performanceIndex;
        this.isCertified = false;
    }
    
    //accessor method to get salary
    
    public double getSalary(){
        return salary;
    }
    
    //accessor method to get specialization
    
    public String getSpecialization(){
        return specialization;
    }
    
    //accessor method to get academic qualification
    
    public String getAcademicQualification(){
        return academicQualification;
    }
    
    //accessor method to get performance index
    
    public int getPerformanceIndex(){
        return performanceIndex;
    }
    
    //accessor method to get the value of isCertified
    
    public boolean getIsCertified(){
        return isCertified;
    }
    
    //mutator method to set salary of Tutor
    
    public void setSalary(double salary, int performanceIndex){
        if(performanceIndex >= 5 && getWorkingHour() > 20){
            if(performanceIndex >= 5 && performanceIndex <= 7){ 
                this.salary = salary + (salary * 0.05);
            }else if(performanceIndex == 8 || performanceIndex == 9){
                this.salary = salary + (salary * 0.1);
            }else if(performanceIndex == 10){
                this.salary = salary + (salary * 0.2);
            }
            this.performanceIndex = performanceIndex;
            this.isCertified = true;
        }else{
            System.out.println("Cannot approve new salary because tutor has not been certified.");
        }
    }
    
    //method to remove tutor
    
    public void removeTutor(){
        if(this.isCertified == false){
            this.salary = 0;
            this.performanceIndex = 0;
            this.academicQualification = "";
            this.specialization = "";
            this.isCertified = false;
        }else{
            System.out.println("Tutor is certified cannot remove");
        }
    }
    
    //method to display details of tutor 

    public void display(){
        super.display();
        if(isCertified == true){
            System.out.println("Salary: " + this.salary);
            System.out.println("Specialization: " + this.specialization);
            System.out.println("Academic Qualifications: " + this.academicQualification);
            System.out.println("Performance Index: " + this.performanceIndex);
        }
    }
}