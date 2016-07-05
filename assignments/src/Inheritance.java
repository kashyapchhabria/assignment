class Maruthi
{
	public void swiftPrice()
	{
		System.out.println("The car price is Rs.800000/-");
	}
}

class Discount extends Maruthi
{
	public void discountRate()
	{
		System.out.println("10% Discount amoounts to Rs.720000/-");
	}
}

interface TubelessTyres
{
	public void tyres();
}
interface AbsBraking
{
	public void braking();  	
}

interface Colors extends TubelessTyres
{
	public void colors();
}

interface StereoSystem extends TubelessTyres
{
	public void Stereo();
}

class HybridImplementation implements Colors,StereoSystem
{
	public void colors()
	{
		System.out.println("Many colors are avaliable");
	}
	public void Stereo()
	{
		System.out.println("Jbl Stereo System");
	}
	public void tyres()
	{
		System.out.println("Tubleless Tyres");
	}
}


class Speed extends Discount implements TubelessTyres,AbsBraking
{
	public void speed()
	{
		System.out.println("Maximum Speed is 180kmph");
	}
	
	public void tyres()
	{
		System.out.println("Swift has tubeless tyres // Multiple inheritance");
	}
	
	public void braking()
	{
		System.out.println("Swift has an effcient braking system // multiple inheritance");
	}
	
}

class Mileage extends Maruthi
{
	public Mileage()
	{
		System.out.println("The mileage of the car is 25kmpl ");
	}
}

class Versions extends Maruthi
{
	public  Versions()
	{
		System.out.println("The car is having Diesel And Petrol Versions too ");
	}
}



public class Inheritance
{
	public static void main(String args[])
	{
		System.out.println("Single level Inheritance ");
		Discount obj= new Discount();
		obj.swiftPrice();
		obj.discountRate();
		
		Speed object=new Speed();
		System.out.println("Multilevel Inheritance");
		object.swiftPrice();
		System.out.println("Multiple Inheritance");
		object.speed();
		object.tyres();
		object.braking();
		
		System.out.println("Hierarchial Inheritance");
		Discount objDiscount=new Discount();
		Mileage objMileage=new Mileage();
		Versions objVersions=new Versions();
		objDiscount.swiftPrice();
		objMileage.swiftPrice();
		objVersions.swiftPrice();
		
		System.out.println("Hybrid Inheritance");
		HybridImplementation objHybrid=new HybridImplementation();
		objHybrid.colors();
		objHybrid.Stereo();
		objHybrid.tyres();
	}
}
