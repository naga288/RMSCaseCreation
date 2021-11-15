package resources;

import java.lang.reflect.Method;

import org.testng.annotations.DataProvider;

public class dataproviders  {
	@DataProvider(name="testData")
    public Object[][] gettestData(Method m){
		switch(m.getName()) {
		case "PatientDetails":
		    return new Object[][] 
		        	{
		                { "Autotest ", "987456321","8/4/1990",
		                 "Times square street",
		                 "New York",
		                 "10001",
		                "9874563121"}
		            };
		case "ChooseRetrievalOptions":
			return new Object[][] 
			    	{
			            {"10/30/2021","Appointment","Chiranjivi, Konidela","New Patient Consultation"}
			        };
		case "uploadfiles":	        
			return new Object[][] 
			    	{
			            {"Records"}
			        };
		case "singleLocationProvider":	        
			return new Object[][] 
			    	{
			            {"360 TRUCKING LLC", "Illinois", "Chicago Ridge" ,"Records Template", "Images template", "Pathology template", "ImageLocation"}
			        };					
	
		}
		return null;
	}

		
}
