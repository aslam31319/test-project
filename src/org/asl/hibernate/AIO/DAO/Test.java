package org.asl.hibernate.AIO.DAO;

import java.util.Scanner;

import org.asl.hibernate.AIO.DTO.AioDTO;

public class Test {

	public static void main(String[] args) {
		boolean ch = true;
		Scanner in = new Scanner(System.in);
		while (ch) {
			System.out.println("Enter 1 for save()");
			System.out.println("Enter 2 for get()");
			System.out.println("Enter 3 for load()");
			System.out.println("Enter 4 for update");
			System.out.println("Enter 5 for delete()");
			System.out.println("Enter 6 for showAllHql()");
			System.out.println("Enter 7 for selectHql");
			System.out.println("Enter 8 for updateHql()");
			System.out.println("Enter 9 for deleteHql()");
			// System.out.println("Enter 10 for delete()");
			int c;
			
			c = in.nextInt();

			// in.close();
			switch (c) {
			case 1: {
				AioDTO r1 = new AioDTO();
				// Scanner in1=new Scanner(System.in);
				System.out.println("Enter Name:");
				String s1 = in.next();
				// s1=in.next();
				r1.setName(s1);
				System.out.println("Enter Phone");
				// s1=in.nextLine();
				s1 = in.next();
				r1.setPhone(s1);
				in.close();
				DAO.save(r1);
				break;
			}
			case 2:
				System.out.println("Enter ID");
				int i = in.nextInt();
				DAO.get(i);
				break;
			case 3:
				System.out.println("Enter ID");
				i = in.nextInt();
				DAO.load(i);
				break;
			case 4:
				System.out.println("Enter id");
				i = in.nextInt();
				System.out.println("Enter column no");
				int col = in.nextInt();
				System.out.println("Enter detail");
				String dt = in.next();
				DAO.update(i, col, dt);
				break;
			case 5:
				System.out.println("Enter id");
				i = in.nextInt();
				DAO.delete(i);
				break;
			case 6:
				DAO.showAllHql();
				break;
			case 7:
				System.out.println("Enter id");
				i = in.nextInt();
				DAO.selectHql(i);
				break;
			case 8:
				System.out.println("Enter id");
				i = in.nextInt();
				System.out.println("Enter column no");
				col = in.nextInt();
				System.out.println("Enter detail");
				dt = in.next();
				DAO.updateHql(i, col, dt);
				break;
			case 9:
				System.out.println("Enter id");
				i = in.nextInt();
				DAO.deleteHql(i);
				break;

			default:
				break;
			}
		
			
				in.reset();
				//in.close();	
			
			
			//ch = false;
			// cont();
		}
	}

	public static boolean cont() {
		System.out.println("Do you want to continue?yes or no");
		Scanner si = new Scanner(System.in);
		String an = si.next();
		an = si.next();
		si.close();
		if (an.equalsIgnoreCase("yes")) {
			return true;
		} else if (an.equalsIgnoreCase("no")) {
			return false;
		} else {
			System.out.println("Invalid!!");
			cont();
		}
		return false;
	}

}
