public class RegularMember extends GymMember
{
    private final int attendanceLimit; //final keyword is used so that the value cannot be changed
    private boolean isEligibleForUpgrade;
    private String removalReason;
    private String referralSource;
    private String plan;
    private double price;
    
    //constructor
    public RegularMember(int id,String name,String location,String phone,String email,
    String gender,String DOB,String membershipStartDate, String referralSource)
    {
        //calling parent class constructor
        super(id, name, location, phone, email, gender, DOB, membershipStartDate);
        
        //initializing
        this.isEligibleForUpgrade=false;
        this.attendanceLimit=30;
        this.plan="basic";
        this.price=6500;
        this.removalReason="";
        this.referralSource=referralSource;
    }
    
    //getter methods
    public int getAttendanceLimit()
    {
        return this.attendanceLimit;
    }
    public boolean getIsEligibleForUpgrade()
    {
        return this.isEligibleForUpgrade;
    }
    public String getRemovalReason()
    {
        return this.removalReason;
    }
    public String getReferralSource()
    {
        return this.referralSource;
    }
    public String getPlan()
    {
        return this.plan;
    }
    public double getPrice()
    {
        return this.price;
    }
    
    @Override
    public void markAttendance()
    {
        attendance++;
        loyaltyPoints+=5;
        if(getAttendance()>=attendanceLimit)
        {
            isEligibleForUpgrade=true;
        }
    }
    
    public double getPlanPrice(String plan)
    {
        double x;
        switch(plan)
        {
            case "basic":
                return 6500;
            case "standard":
                return 12500;
            case "deluxe":
                return 18500;
            default:
                return -1;
        } /*no break statement because it directly returns 
        in java once return is executed, it skips the whole block*/
    }
    
    public String upgradePlan(String plan)
    {
        if (isEligibleForUpgrade!=true)//check eligibility
        {
            return "the member is not eligible for upgrade";
        }
        else//if member is eligible
        {
            if(this.plan==plan)//checks for same plan
            {
                return "the member has chosen the same plan";
            }
            else //if not same
            {
                if(getPlanPrice(plan)==-1)//check invalid plan
                {
                    return "the member has entered invalid plan";
                }
                else //all requirement matches
                {
                    this.plan=plan;
                    this.price=getPlanPrice(plan);
                    return ("plan upgraded to "+plan+"\n price= "+price);
                }
            }
        }
    }
    
    public void revertRegularMember(String removalReason)
    {
        super.resetMembership();
        this.isEligibleForUpgrade=false;
        this.plan="basic";
        this.price=6500;
        this.removalReason=removalReason;
    }
    
    @Override
    public void display()
    {
         super.display();
         System.out.println("plan: "+plan);
         System.out.println("price: "+price);
         if(removalReason!="")
         {
             System.out.println("removal reason: "+removalReason);
         }
    }
}
