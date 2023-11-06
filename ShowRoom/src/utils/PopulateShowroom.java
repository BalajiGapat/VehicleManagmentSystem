package utils;

import java.util.List;

import com.showroom.Colors;
import com.showroom.Vehicle;

import custom_exception_handling.VehicleExceptionHandling;

import java.time.LocalDate;
import java.util.ArrayList;
import static utils.ValidateAllInputes.*;

public  class PopulateShowroom 
{
	public static List<Vehicle> populateVehicle() throws IllegalArgumentException, VehicleExceptionHandling
	{	
		List<Vehicle> vList=new ArrayList<>();

		vList.add(validateAllInputs("ABC-101", "black", "2023-02-26", 500000, "Honda", vList));
		vList.add(validateAllInputs("ABC-106", "white", "2023-04-12", 900000, "Honda", vList));
		vList.add(validateAllInputs("ABC-105", "white", "2023-04-12", 800000, "Honda", vList));
		vList.add(validateAllInputs("ABC-104", "red", "2023-03-16", 400000, "Honda", vList));
		vList.add(validateAllInputs("ABC-103", "black", "2023-05-03", 300000, "Honda", vList));
		vList.add(validateAllInputs("ABC-102", "blue", "2023-12-29", 700000, "Honda", vList));
		return vList;
	}
	
		
	
	
}
