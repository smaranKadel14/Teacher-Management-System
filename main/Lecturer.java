public class Lecturer extends Teacher{
    private String department;
    private int yrsOfExperience;
    private int gradedScore;
    private boolean hasGraded;
    
    /*constructor for lecturer class
    'super' keyword is used to inherit the constructor from parent class.*/
    
    public Lecturer(String department, int yrsOfExperience, String teacherName, int teacherID, String teacherAddress, String teacherWorkType, String employmentStat, int teacherWorkingHour){
        super(teacherName, teacherID, teacherAddress, teacherWorkType, employmentStat);
        setWorkingHour(teacherWorkingHour);
        this.department = department;
        this.yrsOfExperience = yrsOfExperience;
        gradedScore = 0;
        hasGraded = false;
    }
    
    //accessor method to get department 
    
    public String getDepartment(){
        return this.department;
    }
    
    //accessor method to get years of experience
    
    public int getYrsOfExperience(){
        return this.yrsOfExperience;
    }
    
    //accessor method to get graded score
    
    public int getGradedScore(){
        return this.gradedScore;
    }
    
    //accessor method to get has graded 
    
    public boolean getHasGraded(){
        return this.hasGraded;
    }
    
    //mutator method to set graded score 
    
    public void setGradedScore(int gradedScore){
        this.gradedScore = gradedScore;
    }
    
    //method to grade assignment
    public void gradeAssignment(int gradedScore, String department, int yrsOfExperience){
        if(yrsOfExperience >= 5 && department.equals(this.department)){
            if(gradedScore >= 70){
                System.out.println("Your Grade: A");
            }else if(gradedScore >= 60){
                System.out.println("Your Grade: B");
            }else if(gradedScore >= 50){
                System.out.println("Your Grade: C");
            }else if(gradedScore >= 40){
                System.out.println("Your Grade: D");
            }else{
                System.out.println("Your Grade: E");
            }
            this.hasGraded = true;
        }else{
            System.out.println("Lecturer has not graded the assignment");
        }
    }
    
    //method to display the all the details.
    
    public void display(){
            super.display();
            System.out.println("Department: " + this.department);
            System.out.println("Years of experience: " + this.yrsOfExperience);
            System.out.println("Graded Score: " + this.gradedScore);
        if(this.hasGraded == false){
            System.out.println("Not Graded!");
        }
    }
}