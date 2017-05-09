package ispservices;

import java.util.Scanner;

public class ISPServiceBilling {

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);

		// Variables and constants
		
		int serviceSpeed;
		int downloadLimit;
		int contractTerm;
		int serviceSpeedCost = 0;
		int downloadLimitCost = 0;
		int modemRentalCost = 10;
		int discountPercentage = 0;
		double monthlyServiceCost;
		double lessDiscount;
		double monthlyDiscountedCost;
		double pstCalculation;
		double gstCalculation;
		double totalMonthlyCost;
		final double PST_TAX = 0.07;
		final double GST_TAX = 0.05;
		String percentSign = "%";
		String dollarSign = "$";
		
		// Asking for input
		// Terminating if the input is incorrect
		     
		System.out.print("Enter Service Speed (10,50,100 Mbps): ");
		serviceSpeed = keyboard.nextInt();

		if(serviceSpeed != 10 && serviceSpeed != 50 && serviceSpeed != 100)
		{
			System.out.println("Incorrect Service Speed: " + serviceSpeed);
			System.exit(0);
		}
		
		System.out.print("Enter Download Limit (50,100,500 Gbs): ");
		downloadLimit = keyboard.nextInt();
		
		if(downloadLimit != 50 && downloadLimit != 100 && downloadLimit != 500)
		{
			System.out.println("Incorrect Download Limit: " + downloadLimit);
			System.exit(0);
		}
				
		System.out.print("Enter contract term (1,2,3 years): ");
		contractTerm = keyboard.nextInt();
		
		if(contractTerm != 1 && contractTerm != 2 && contractTerm != 3)
		{
			System.out.println("Incorrect Contact Term: " + contractTerm);
			System.exit(0);
		}
		
		// Defining dependencies
		
		switch(serviceSpeed)
		{
		case 10:
			serviceSpeedCost = 30;
			break;
		case 50:
			serviceSpeedCost = 50;
			break;
		case 100:
			serviceSpeedCost = 75;
			break;
		}
		
		switch(downloadLimit)
		{
		case 50:
			downloadLimitCost = 0;
			break;
		case 100:
			downloadLimitCost = 20;
			break;
		case 500:
			downloadLimitCost = 50;
			break;
		}
		
		switch(contractTerm)
		{
		case 1:
			discountPercentage = 0;
			break;
		case 2:
			discountPercentage = 10;
			break;
		case 3:
			discountPercentage = 25;
			break;
		}
		
		// Final calculations
		
		monthlyServiceCost = serviceSpeedCost + downloadLimitCost + modemRentalCost;
		lessDiscount = (serviceSpeedCost + downloadLimitCost + 
				modemRentalCost) * discountPercentage / 100;
		monthlyDiscountedCost = monthlyServiceCost - lessDiscount;
		pstCalculation = monthlyDiscountedCost * PST_TAX;
		gstCalculation = monthlyDiscountedCost * GST_TAX;
		totalMonthlyCost = monthlyDiscountedCost + pstCalculation + gstCalculation;

		// Final output
		
		System.out.print("\n======= Service Summary =======");
		System.out.printf("\nService Speed (mbps): %7d", serviceSpeed);
		System.out.printf("\tCost: %5s%d", dollarSign, serviceSpeedCost);
		System.out.printf("\nDownload Limit (GBs): %7d", downloadLimit);
		System.out.printf("\tCost: %5s%d", dollarSign, downloadLimitCost);
		System.out.print("\nModem Rental:\t\t");
		System.out.printf("\tCost: %5s%d", dollarSign, modemRentalCost);
		System.out.printf("\nContract Term (yrs): %8d", contractTerm);
		System.out.printf("\tDiscount: %s%d", percentSign, discountPercentage);
		System.out.print("\n\n======= Billing Summary =======");
		System.out.printf("\nMonthly Service Cost: %4s%6.2f", dollarSign, monthlyServiceCost);
		System.out.printf("\n\tLess Discount: %3s%6.2f", dollarSign, lessDiscount);
		System.out.printf("\nMonthly Discounted Cost: %s%6.2f", dollarSign, monthlyDiscountedCost);
		System.out.printf("\n\tPST: %13s%6.2f", dollarSign, pstCalculation);
		System.out.printf("\n\tGST: %13s%6.2f", dollarSign, gstCalculation);
		System.out.printf("\nTotal Monthly Cost: %6s%6.2f", dollarSign, totalMonthlyCost);
	}
}