//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//This class file will define all the parameters on new user register page
//Default value for all the parameters set to NULL
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

public class RegisterNewUserTestData {
	public String firstName = null;
	public String lastName = null;
	public String title = null;
	public String email = null;
	public String phoneNumber = null;
	public String businessName = null;
	public String addressLine1 = null;
	public String addressLine2 = null;
	public String city = null;
	public String state = null;
	public String zip = null;


	public void declaireTestData()
	{
		try {
			this.firstName  = "testFirstName";
			this.lastName = "testLastName";
			this.title = "testTitle";
			this.email = "test@gmail.com";
			this.phoneNumber = "555-555-5555";
			this.businessName = "testBusinessName";
			this.addressLine1 = "test add line1";
			this.addressLine2 = "test add line2";
			this.city = "testCity";
			this.state = "OR";
			this.zip = "55555";
		}

		catch (Exception e){
			System.out.println(e);
		}
	}	
}
