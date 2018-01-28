package com.assignment.challenge1;

import java.util.Scanner;

public class ArrayOfInterface{
	
	/**
	 * This method takes input as string and returns relevant class object
	 * If No class found of entered string its throws an NullPointerException
	 * @param String
	 * @return Object of type Instrument interface
	 * */
	
	public static Instrument getObject(String type)
	{
		if(type.equalsIgnoreCase("piano"))
			return new Piano();
		else if(type.equalsIgnoreCase("flute"))
			return new Flute();
		else if(type.equalsIgnoreCase("guitar"))
			return new Guitar();
		else
			throw new NullPointerException();
	}

	public static void main(String[] args) {

		System.out.println("\t\t Choose the instruments \nPiano \nFlute \nGuitar \n\n\t\t for 10 times");
		
		//create array of size 10
		Instrument arr[]= new Instrument[10];
		
		//Scanner
		Scanner sc= new Scanner(System.in);
		
		//loop for input value
		for(int limit=0; limit<10; limit++){
			System.out.println("Enter " + (limit+1)+ " Instrument name: ");
			String type= sc.next();
			try{
				Instrument obj= getObject(type);		// super class holding child class object
				arr[limit]= obj;
			} catch(NullPointerException e){
				System.out.println("Inavlid input can't process");
				break;
			}
		}
		
		
		//display Array of interface
		
		for(Instrument i:arr){
			try{
				i.play();
			}catch(NullPointerException e){
				System.out.println("No output because of wrong i/p");
				break;
			}
		}sc.close();
	}
}
