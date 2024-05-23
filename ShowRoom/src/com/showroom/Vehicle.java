package com.showroom;

import java.time.LocalDate;

public class Vehicle implements Comparable<Vehicle>
{
	private String chasisNo;
	private Colors vehicleColor;
	private LocalDate manufacturingDate;
	private double netPrice;  // basePrice+colorCost
	private String company;
	private boolean isAvailable;  
	
	public Vehicle()
	{
		super();
	}
	
	// This constructor is only for wrapping PK into Vehicle Object
	public Vehicle(String chasisNo)
	{
		this.chasisNo=chasisNo;
	}
	
	public Vehicle(String chasisNo, Colors vehicleColor, LocalDate manufacturingDate, double netPrice, String company)
	{
		this.chasisNo=chasisNo;
		this.vehicleColor=vehicleColor;
		this.manufacturingDate=manufacturingDate;
		this.netPrice=netPrice;
		this.company=company;
		this.isAvailable=true;
	}
	
	// getters and  setters
	public Colors getVehicleColor() 
	{
		return vehicleColor;
	}

	public void setVehicleColor(Colors vehicleColor) 
	{
		this.vehicleColor = vehicleColor;
	}

	public LocalDate getManufacturingDate() 
	{
		return manufacturingDate;
	}

	public void setManufacturingDate(LocalDate manufacturingDate) 
	{
		this.manufacturingDate = manufacturingDate;
	}

	public double getNetPrice() 
	{
		return netPrice;
	}

	public void setNetPrice(double netPrice) 
	{
		this.netPrice = netPrice;
	}

	public String getCompany() 
	{
		return company;
	}

	public void setCompany(String company) 
	{
		this.company = company;
	}

	public boolean isAvailable() 
	{
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) 
	{
		this.isAvailable = isAvailable;
	}

	public String getChasisNo() 
	{
		return chasisNo;
	}
	
	@Override
	public String toString()
	{
		return "chasisNo: "+chasisNo+", vehicleColor: "+vehicleColor+", manufacturingDate: "+manufacturingDate+", netPrice: "+netPrice+", company: "+company+", isAvailable: "+isAvailable;			
	}
	
	@Override
	public boolean equals(Object obj) // checking equality on chasisNO i.e primary Key
	{
		if(obj instanceof Vehicle)
		{
			Vehicle temp= (Vehicle)obj; // down casting
			return this.chasisNo.equals(temp.chasisNo);
		}
		return false;
	}

	@Override
	public int compareTo(Vehicle obj)  // this is Vehicle class method
	{
		if(obj instanceof Vehicle)
		{
			Vehicle temp=(Vehicle)obj; // down casting
			
			return this.chasisNo.compareTo(temp.chasisNo); // No recursion this is java.lang.String class method
		}
		return 0;
	}
	
}
