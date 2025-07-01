public abstract class GymMember
{
    protected int id;
    protected int attendance;
    protected String name;
    protected String location;
    protected String phone;
    protected String email;
    protected String gender;
    protected String DOB;
    protected String membershipStartDate;
    protected double loyaltyPoints;
    protected boolean activeStatus;
    
    //constructor
    public GymMember(int id,String name,String location,String phone,String email,
    String gender,String DOB,String membershipStartDate)    
    {
        //assigning
        this.id=id;
        this.name=name;
        this.location=location;
        this.phone=phone;
        this.email=email;
        this.gender=gender;
        this.DOB=DOB;
        this.membershipStartDate=membershipStartDate;
        
        //initializing
        this.attendance=0;
        this.loyaltyPoints=0;
        this.activeStatus=false;
    }
    
    //accessor methods
    public int getId()
    {
        return this.id;
    }
    public int getAttendance()
    {
        return this.attendance;
    }
    public String getName()
    {
        return this.name;
    }
    public String getLocation()
    {
        return this.location;
    }
    public String getPhone()
    {
        return this.phone;
    }
    public String getEmail()
    {
        return this.email;
    }
    public String getGender()
    {
        return this.gender;
    }
    public String getDOB()
    {
        return this.DOB;
    }
    public String getMembershipStartDate()
    {
        return this.membershipStartDate;
    }
    public double getLoyaltyPoints()
    {
        return this.loyaltyPoints;
    }
    public boolean getActiveStatus()
    {
        return this.activeStatus;
    }
    
    public abstract void markAttendance();
    
    public void activateMembership()
    {
        activeStatus=true;
    }
    
    public void deactivateMembership()
    {
        if(activeStatus)//checking if its active or not
        {
            activeStatus=false;
        }
        else
        {
            System.out.println("It seems like active status is already inactive");
        }
    }
    public void resetMembership()
    {
        activeStatus=false;
        attendance=0;
        loyaltyPoints=0;
    }
    public void display()
    {
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Location: "+location);
        System.out.println("Phone: "+phone);
        System.out.println("Email: "+email);
        System.out.println("Gender: "+gender);
        System.out.println("DOB: "+DOB);
        System.out.println("Membership Start Date: "+membershipStartDate);
        System.out.println("Attendance: "+attendance);
        System.out.println("Loyalty points: "+loyaltyPoints);
        System.out.println("Active Status: "+(activeStatus?"active":"inactive"));
    }
}

