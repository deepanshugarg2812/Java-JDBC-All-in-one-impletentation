package com.jdbcDemoo;

import java.sql.Date;
import java.util.Scanner;

public class Main {

	public static Date getDateOfString(String date) {
		return Date.valueOf(date);
	}

	public static void main(String[] args) {
		boolean nextValue = true;
		Scanner scan = new Scanner(System.in);
		JdbcMethods jm = new JdbcMethods();
		
		while(nextValue==true) {
			System.out.println("Press 1 for insert 2 for search and 3 for delete");
			int input = scan.nextInt();
			
			if(input==1) {
				System.out.println("Enter name , height , weight , date of joinging in YYYY-MM-DD format , date of leaving in YYYY-MM-DD format , fees paid");
				GYMMember gm = new GYMMember(scan.next(), scan.nextDouble(), scan.nextDouble(), Main.getDateOfString(scan.next()),Main.getDateOfString(scan.next()), scan.nextInt());
				jm.insertMember(gm);
			}else if(input==2) {
				System.out.println("Enter the name to search");
				jm.searchMemberByName(scan.next());
			}else if(input==3) {
				System.out.println("Enter the id to delete");
				jm.deleteById(scan.nextInt());
			}
			else {
				break;
			}
			
			System.out.println("If you have more values type yes else type no");
			
			String str = scan.next();
			if(str.equals("yes")) {
				nextValue = true;
			}
			else {
				nextValue = false;
			}
		}
	}

}
