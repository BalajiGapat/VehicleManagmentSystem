package com.showroom;

public enum Colors 
{
	BLACK(2000), WHITE(3000), RED(4000), BLUE(5000), GRAY(6000), SILVER(7000);
	
	public int colorCost;
	
	// enum constructors are privates and can never be public
	private Colors(int colorCost)
	{
		this.colorCost=colorCost;
	}
	
	// getter 
	public int getColorCost()
	{
		return colorCost;
	}
	
	
	@Override
	public String toString()
	{
		return this.name()+"@"+this.colorCost;
	}
}
