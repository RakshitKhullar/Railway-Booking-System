package clg;

import java.util.*;

public class Train {

	cabin s[] = new cabin[5];
	int noOfSeats,cabinNumber;
	
	public Train() {
			for(int i = 0;i<5;i++) {
				s[i] = new cabin();
			}
	}

	Stack<Integer> booking(int noOfSeats,int cabinNumber){
		this.noOfSeats=noOfSeats;
		this.cabinNumber = cabinNumber;
		
	Stack<Integer> a = new Stack() ;
	a.addAll(s[cabinNumber-1].bookseats(noOfSeats));
	return a;
		
	}
	
	
	
	Stack<Integer> delete(Stack<Integer> st,int Cabin){
		
	Stack<Integer> a = 	new Stack();
	a.addAll(s[Cabin].delete(st));
	return a;
		
	}
}




class cabin{
	Scanner sc = new Scanner(System.in);
	 String seatNo[][] = new String[16][4];
     boolean seats[][] = new boolean[16][4];
    
 private Stack<Integer> SeatNo = new Stack<>();

 cabin(){
	 int seatnumber = 1;
		for(int i = 0;i<seats.length; i++) {
			for(int j = 0;j<4;j++) {
			
				String nn = String.valueOf(seatnumber);
				if(seatnumber<10) {
				seatNo[i][j] ="0"+nn+"E" ;
				}
				else {
					seatNo[i][j] = nn+"E" ;
				}
				seatnumber++;
				
			}
			
		}
 }
  
  Stack<Integer> bookseats(int noOfSeats) {
	  SeatNo.clear();
	  System.out.println();
	     System.out.print("SW"+"         "); System.out.print("U"+"       "); 
	     System.out.print("M"+"       ");  System.out.print("L");
		
	     System.out.println();
		for(int i = 0;i<seats.length; i++) {
			for(int j = 0;j<4;j++) {
				if( j ==0 ) {
					System.out.print(seatNo[i][j]+"       ");
				}else {
					System.out.print(seatNo[i][j]+"     ");
				}
				
			}System.out.println();
			if(i%2 != 0) {
				System.out.println("---------------------------------");
			}
		}
		
		
		System.out.println(); System.out.println();System.out.println();
		
		
		
		System.out.println("-----------------------------------------------");
		
	 	 System.out.println("You can enter the seat number you want to select");
	 	 
	 	 for(int i = 0;i<noOfSeats;i++) {
	 		 boolean y = false;
	 		 while(y != true) {
			
	 			 SeatNo.push(sc.nextInt());
	 			 if(SeatNo.peek() > 0 && SeatNo.peek() < 65) {
	 	  
	 	int a =0,b =0;
	 		
	 		if(SeatNo.peek()%4 ==0) {
	 			b = 3;
	 		}else {
	 			b = SeatNo.peek()%4-1;
	 		}
	 		
	 		if(SeatNo.peek()%4 ==0) {
	 			a =SeatNo.peek()/4-1 ;
	 		}else {
	 			a = SeatNo.peek()/4;
	 		}
	 		
	 		if(seats[a][b] == false) {
	 			seats[a][b] = true;
	 			String nn = String.valueOf(SeatNo.peek());
	 			if(SeatNo.peek()<10) {
					seatNo[a][b] ="0"+nn+" " ;
					}
					else {
						seatNo[a][b] = nn+" " ;
					}
	 			y = true;
	 		}else{
	 			System.out.println("--------- THIS SEAT IS UNAVAILABLE PLEASE SELECT ANOTHER ONE ---------");
	 			 System.out.println();
	 			SeatNo.pop();
	 		}
	 			 }
	 			 else {
	 				 SeatNo.pop();
	 				 System.out.println("--------- PLEASE ENTER A VALID SEAT NUMBER ---------");
	 				 System.out.println();
	 			 }
	 		
	 	
	 	}
	 	 }
	 	 System.out.println("--------- CONGRATS ALL OF YOUR SEATS ARE BOOKED ---------");
	 	 System.out.println();	System.out.println();
	 	
	     System.out.print("SW"+"         "); System.out.print("U"+"       "); 
	     System.out.print("M"+"       ");  System.out.print("L");
	     System.out.println();
	     
	 	for(int i = 0;i<seats.length; i++) {
			for(int j = 0;j<4;j++) {
				if( j ==0 ) {
					System.out.print(seatNo[i][j]+"       ");
				}else {
					System.out.print(seatNo[i][j]+"     ");
				}
				
			}System.out.println();
			if(i%2 != 0) {
				System.out.println("---------------------------------");
			}
		}System.out.println();
		return SeatNo;	
		
  }
  
  
  
  
  
  Stack<Integer> delete(Stack<Integer> st) {
	  System.out.println("--------- WRITE THE NO OF SEATS THAT YOU WANT TO CANCEL ---------");
	  int toRemove = sc.nextInt();
	  
	  if(toRemove == 0) {
		  System.out.println("---------- NO SEAT DELETED ----------");System.out.println();
		  return st;
	  }
	  
	  if(toRemove <=  st.size() && toRemove >0) {
		  
		  System.out.println("-----------------------------------------------");
			
		 	 System.out.println("You can enter the seat number you want to select");
		  
	  while(toRemove-- > 0){
		  boolean y = false;
	 		 while(y != true) {
			
	    	int removeElement = sc.nextInt();
	 	  if(st.contains(removeElement)) {
	 		int bb =  st.search(removeElement);
	 		st.remove(st.size() - bb);
	 	int a =0,b =0;
	 		
	 		if(removeElement % 4 == 0) {
	 			b = 3;
	 		}else {
	 			b = removeElement % 4 - 1;
	 		}
	 		
	 		if(removeElement % 4 == 0) {
	 			a =removeElement/4-1 ;
	 		}else {
	 			a =removeElement/4;
	 		}
	 		String nn = String.valueOf(removeElement);
	 		
	 			seats[a][b] = false;
	 			if(st.peek()<10) {
					seatNo[a][b] ="0"+nn+"E" ;
					}
					else {
						seatNo[a][b] = nn+"E" ;
					}
	 			y = true;
	 		
	 		
	 	  }else {
       System.out.println("--------- THIS SEAT WAS NOT BOOKED BY YOU PLEASE SELECT ANOTHER ONE ---------");System.out.println();
	 	  }
	 	}

		  
	  }
	  
	  System.out.println("--------- THE SEATS THAT YOU ASKED FOR ARE CANCELED ---------");	System.out.println();
	  } else {
		  System.out.println("--------- WRONG INPUT ---------");System.out.println();
	  }
	  
	return st;
	  
	}   
}
