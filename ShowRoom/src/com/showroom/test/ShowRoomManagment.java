package com.showroom.test;

import java.util.Scanner;
import java.util.List;
import java.util.ListIterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

import com.showroom.Vehicle;
import com.showroom.Colors;
import custom_exception_handling.VehicleExceptionHandling;

import static utils.PopulateShowroom.populateVehicle;
import static utils.ValidateAllInputes.*;

public class ShowRoomManagment 
{
	public static void main(String[] args)
	{
		try(Scanner sc=new Scanner(System.in))
		{
			try
			{
				List<Vehicle> vList=new ArrayList<>();
				vList=populateVehicle();
				int choice;
				do
				{
					System.out.println("\n*****  welcome  *****\n");
					System.out.println("1. Display All Vehicle in Showroom");
					System.out.println("2. Add vehicle in Showroom");
					System.out.println("3. Get vehicle Details on ChasisNo");
					System.out.println("4. Delete vehicle on chasisNo");
					System.out.println("5. Delete vehicle on vehicle color");
					System.out.println("6. Sort the vehicle according to chasisNo ");
					System.out.println("7. Sort the vehicle according to mfgDate");
					System.out.println("8. Sort the vehicle according to netPrice");
					System.out.println("9. Sort the vehicle according to mfgDate and netPrice");
					System.out.println("0. Exit ");
					
					System.out.println("\nEnter your choice: ");
					choice=sc.nextInt();
					
					switch(choice)
					{
					case 1:
						System.out.println("***  List Of Vehicles ***\n");
						vList.forEach(v->System.out.println(v)); // using lambda Expression
						
						 
//						for(Vehicle v:vList)    // using forEach loop
//							System.out.println(v);
						
						
						// Using Iterator
						// attaching iterator 
//						Iterator<Vehicle> itr=vList.iterator();
//						while(itr.hasNext())
//						{
//							System.out.println(itr.next());
//						}
						
						break;
					
					case 2:
						System.out.println("Enter vehicle details");
						System.out.println("Enter vehicle details: chasisNo, vehicleColor, mfgDate(yyyy-mm-dd), basicPrice & company");
						String chasisNo=sc.next();
						String vehicleColor=sc.next();
						String mfgDate=sc.next();
						double basicPrice=sc.nextDouble();
						String company=sc.next();
						Vehicle newVehicle=validateAllInputs(chasisNo, vehicleColor, mfgDate, basicPrice, company, vList);
						vList.add(newVehicle);
						
						break;
					
					case 3:
						System.out.println("Enter ChasisNo");
						newVehicle=new Vehicle(sc.next());
						
						int index=vList.indexOf(newVehicle);
						
						if(index==-1)
							throw new VehicleExceptionHandling("Invalid chasisNo, No Vehicle found in Showroom...!!!");
						
						System.out.println(vList.get(index));
						
						break;
					case 4:
						System.out.println("Enter ChasisNo: ");
						newVehicle=new Vehicle(sc.next());
						index=vList.indexOf(newVehicle);
						if(index==-1)
							throw new VehicleExceptionHandling("Invalid chasisNo, No Vehicle found in Showroom...!!!");
						System.out.println(vList.remove(index));
						break;
					case 5:
						System.out.println("Enter vehicle Color to delete all vehicle from showroom");
						Colors vColor=parseAndValidateVehicleColor(sc.next());
						
						//Using forEach loop
//						for(Vehicle v:vList) // java.util.ConcurrentModificationException
//						{
//							if(v.getVehicleColor().equals(vColor))
//								System.out.println(vList.remove(v));		
//						}
						
						
						
						// Using Traditional loop
//						for(int i=0;i<vList.size();i++)   // check for white color incorect output
//						{
//							if(vList.get(i).getVehicleColor()==vColor)
//								System.out.println(vList.remove(i)); 
//						}
						// skip some elements in the list due to the shifting of 
						// elements as a result of removal.
						
						
						// Using Iterator
						// attaching iterator 
						Iterator<Vehicle> itr1=vList.iterator();
						while(itr1.hasNext())
						{
							if(itr1.next().getVehicleColor()==vColor)
								itr1.remove(); // removes last element retur by itr1.next()
						}
						
						
						//Using ListIterator
						//attaching ListIterator
//						ListIterator<Vehicle> listItr=vList.listIterator();
//						while(listItr.hasNext())
//						{
//							if(listItr.next().getVehicleColor()==vColor)
//								listItr.add(new Vehicle(null));
//						}
						
						break;
						
					case 6: 
						// java.util.Collections : public static void sort(List<T> list)
						Collections.sort(vList); //internally uses compareTo() method to sort
						// sorting on PK i.e natural sorting
						break;
						
						
					case 7:
						// java.util.Collections : public static void sort(List<T> list, Comparator<T>)
						
						// Using Anonymous inner class
//						Collections.sort(vList, new Comparator<Vehicle>() {
//							public int compare(Vehicle v1, Vehicle v2)
//							{
//								return v1.getManufacturingDate().compareTo(v2.getManufacturingDate());
//								// LocalDate class implements Comparable interface i.e natural ordering
//							}
//						} );
						
						
						// Using lambda expression
						// Collections.sort(vList, (v1, v2)->{return v1.getManufacturingDate().compareTo( v2.getManufacturingDate() ); });
						Collections.sort(vList, (v1, v2)->v1.getManufacturingDate().compareTo( v2.getManufacturingDate() ) );
						
						break;
					
					case 8:
						//Using Lambda Expression
						Collections.sort(vList, (v1, v2)-> { 
						if(v1.getNetPrice()>v2.getNetPrice())
							return 1;
						else if(v1.getNetPrice()<v2.getNetPrice())
							return -1;
						else
							return 0;
						} );
						break;
						
					case 9:
						//Using Lambda Expression
						Collections.sort(vList, (v1, v2)->{ 
							int ret=v1.getManufacturingDate().compareTo( v2.getManufacturingDate() );
							
							// when tie on mfgDate >> sort on netPrice
							if(ret==0)
							{
								if(v1.getNetPrice()>v2.getNetPrice())
									return 1;
								else if(v1.getNetPrice()<v2.getNetPrice())
									return -1;
								else 
									return 0;
							}
							return ret;
						} );
						break;
						
					case 0: 
						System.out.println("\n***   Thnak you visit again...!!!   ***");
						choice=0;
						break;
					}
					
				}while(choice!=0);
					
			}
			catch(Exception e)
			{
				e.printStackTrace();
				sc.nextLine();
				//read off pending tokens form the scanner's buffer
			}
			
		} // sc.close();
	}
}
