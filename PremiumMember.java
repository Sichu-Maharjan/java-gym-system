public class PremiumMember extends GymMember
{
    final double premiumCharge;
    String personalTrainer;
    boolean isFullPayment;
    double paidAmount;
    double discountAmount;
    public PremiumMember(int id, String name, String location, String phone, String 
    email, String gender, String DOB, String membershipStartDate, String personalTrainer)
    {
        //calling parent class constructor
        super(id,name,location,phone,email,gender,DOB,membershipStartDate);
        
        //initializing
        this.premiumCharge=50000;
        this.paidAmount=0;
        this.isFullPayment=false;
        this.discountAmount=0;
        this.personalTrainer=personalTrainer;
    }
    
    //accessor/getter methods
    public double getPremiumCharge()
    {
        return this.premiumCharge;
    }
    public String getPersonalTrainer()
    {
        return this.personalTrainer;
    }
    public boolean getIsFullPayment()
    {
        return this.isFullPayment;
    }
    public double getPaidAmount()
    {
        return this.paidAmount;
    }
    public double getDiscountAmount()
    {
        return this.discountAmount;
    }
    
    public String payDueAmount(double paidAmount)
    {
        if(this.paidAmount==premiumCharge)
        {
            this.isFullPayment=true;
        }
        if(this.isFullPayment)
        {
            System.out.println("full payment has been done");
            return "the member has already paid full amount";
        }
        else
        {
            this.paidAmount+=paidAmount;
            if(this.paidAmount>premiumCharge)
            {
                this.paidAmount-=paidAmount;//get back the paid amount before it was excceded
                System.out.println("the member has paid more than premiumCharge.");
                return "please pay the correct amount";
            }
            else
            {
            System.out.println("payment was successful");
            return "remaining Amount="+(premiumCharge-this.paidAmount);
            }
        }
    }
    public void calculateDiscount()
    {
        if(this.isFullPayment)
        {
            this.discountAmount=(10.0/100)*premiumCharge;
            System.out.println("discount is calculated. discount amount= "+this.discountAmount);
        }
        else
        {
            System.out.println("Discount is not available");
        }
    }
    
    public void revertPremiumMember()
    {
        super.resetMembership();
        this.personalTrainer="";
        this.isFullPayment=false;
        this.paidAmount=0;
        this.discountAmount=0;
    }
    
    @Override
    public void markAttendance()
    {
        attendance++;
        loyaltyPoints+=10;
    }
    
    @Override
    public void display()
    {
        super.display();
        System.out.println("personal trainer= "+personalTrainer);
        System.out.println("paid amount= "+paidAmount);
        System.out.println("is the amount fully paid= "+(isFullPayment?"yes":"no"));
        if(this.isFullPayment)
        {
            System.out.println("discount amount= "+discountAmount);
        }
        else if(this.paidAmount<premiumCharge)
        {
            System.out.println("remaining Amount="+(premiumCharge-this.paidAmount));
        }
    }
}
