package utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.showroom.Colors;
import com.showroom.Vehicle;

import custom_exception_handling.VehicleExceptionHandling;

public class ValidateAllInputes 
{
	public static Vehicle validateAllInputs(String chasisNo, String vehicleColor, String manufacturingDate, double basicPrice, String company, List<Vehicle> vList) throws VehicleExceptionHandling, IllegalArgumentException
	{
		checkForDuplication(chasisNo, vList);
		
		Colors vColor=parseAndValidateVehicleColor(vehicleColor); 
		
		LocalDate mfgDate=validateManuDate(manufacturingDate);
		
		double netPrice=basicPrice+vColor.getColorCost();
		
		return new Vehicle(chasisNo, vColor, mfgDate, netPrice, company);
	}
	
	public static void checkForDuplication(String chasisNo, List<Vehicle> vList) throws VehicleExceptionHandling
	{
		Vehicle newVehicle=new Vehicle(chasisNo); // wrapping PK into Vehicle Object
		
		if(vList.contains(newVehicle))
			throw new VehicleExceptionHandling("Duplicate chasisNo...!!!");
	
		System.out.println("No Duplicate chasisNo found...!!!");
	}
	
	
	public static Colors parseAndValidateVehicleColor(String vehicleColor) throws IllegalArgumentException
	{
		return Colors.valueOf(vehicleColor.toUpperCase());
	}
	
	public static LocalDate validateManuDate(String manufacturingDate) throws VehicleExceptionHandling
	{
		// IF date is in format: dd/MM/yyyy
		// LocalDate d=LocalDate.parse(manufacturingDate, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		LocalDate mfgDate=LocalDate.parse(manufacturingDate); 
		// parsing done GO for year validation
		
		//LocalDate java.time.LocalDate.of(int year, int month, int dayOfMonth)
		LocalDate beginYear=LocalDate.of(LocalDate.now().getYear(), 1, 1);
		
		if(mfgDate.isAfter(beginYear))
			return mfgDate;
		throw new VehicleExceptionHandling("Vehicle manufacture date is before 1st Jan of this current Year...!!!");
	}

}
