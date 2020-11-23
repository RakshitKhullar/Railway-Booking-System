# Railway-Booking-System
// Our railway booking system consist of almost all the functions that a railway app follows .
//We have created our own graph with help of Adjacency Linked List .
//Adjacency Linked List has also been used to store the trains that pass through the particular 
//station including train number, arrival and departure and direction of each node in the list. 
//The minimum path is shown through Bfs algorithm used in graph and seats are booked using oops concepts along with two 2-D arrays. 

package clg;
import java.util.*;
import Graphs.*;
public class DsInJava {
    protected static Map<String, seatbooking> RailId = new HashMap<>();
    protected static Map<String, String> RailId1 = new HashMap<>();
   	 static Scanner sc = null;
     static Map<Integer,String> name = new HashMap<>();
	 static Map<Integer,Train> object = new HashMap<>();
	 static boolean y = true;
	protected static Map<String,Integer> map = new HashMap<>();
	
	
	static {
		name.put(1000,"Amrapali Express");        name.put(1010,"Kota Express");				name.put(1020,"Swaraj Express"); 
		name.put(1001,"Amrapali Express");        name.put(1011,"Kota Express"); 				name.put(1021,"Swaraj Express"); 
		
		name.put(1002,"Jhelum Express");		  name.put(1012,"Firozabad-Kota Express"); 	
		name.put(1003,"Jhelum Express");		  name.put(1013,"Firozabad-Kota Express"); 
		
		name.put(1004,"Jodhpur Express");		  name.put(1014,"Hisagar Express"); 	
		name.put(1005,"Jodhpur Express");		  name.put(1015,"Hisagar Express"); 
		
		name.put(1006,"Janta Express");			  name.put(1016,"Farakka Express"); 
		name.put(1007,"Janta Express");           name.put(1017,"Farakka Express"); 
		
		name.put(1008,"Sameh Express");			  name.put(1018,"Salsar Express"); 
		name.put(1009,"Sameh Express");			  name.put(1019,"Salsar Express"); 
		
		 for(Integer a:name.keySet()) {
			 Train nn = new Train();
			 object.put(a,nn);
			   }
		  
		 
		 map.put("NewDelhi", 16);             map.put("Biwani", 26);          map.put("Alwar", 14);         map.put("Jodhpur", 28);		 map.put("Dausa", 3);
		 map.put("OldDelhi", 15);             map.put("Hisar", 27);           map.put("Jaipur", 13);        map.put("Fataebad", 21);	 	
		 map.put("Sabzimandi",35);           map.put("Jind", 32);            map.put("Tonk", 12);          map.put("Sirsa", 20);			
		 map.put("Sonipat", 36);              map.put("Kaithal", 31);         map.put("Bundi", 2);          map.put("Bhind", 6);
		 map.put("Panipat", 37);              map.put("Noida", 11);           map.put("Kota", 1);			map.put("Pehowa", 34);
		 map.put("Karnal", 38);               map.put("Aligadh", 10);         map.put("Gurugram", 18); 		map.put("Geong", 33);
		 map.put("Kurushetra", 39);           map.put("Mathura", 9);          map.put("Rewari", 19);		map.put("Mansa", 30);
		 map.put("Ambala", 40);               map.put("Agra", 8);             map.put("Mahendargadh", 22);  map.put("Sangrur", 29);
		 map.put("Jhajjar", 17);              map.put("Firozabad",7);         map.put("Churu", 23); 	    map.put("Dhaulapur", 5);
		 map.put("Rohtak", 25);               map.put("Etawah", 0);           map.put("Bikaner", 24);		map.put("Karauli",4);	
		 
		 
		 
		 seatbooking RA13022001 = new seatbooking("RakshitKhullar","RA13022001","rakshitkhullar1331@gmail.com");
		 seatbooking SA23082000 = new seatbooking("SahilYadav","SA23082000","sahilyadav96000@gmail.com");
					
		    
		    RailId.put("RakshitKhullar",RA13022001);
		    RailId.put("SahilYadav",SA23082000);
					
		    RailId1.put("RakshitKhullar","RA13022001");
		    RailId1.put("SahilYadav","SA23082000");
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		
	    System.out.println("------------------- WELCOME TO INDAIN RAILWAY -------------------");
	    System.out.println();System.out.println();
	    loop();
		System.out.println();
		System.out.println("============ THANKS FOR USING OUR SERVICES :) ============");
		
		
	   }
	
	
	
	
	
	static void loop() {
		sc = new Scanner(System.in);
		String idName  = "";
	      String pass  = "";
	      
		
		 do {
			 if( y == false) break;
				System.out.println("========= ENTER 1 FOR NEW RAILWAY Id ELSE ENTER ANY LETTER TO CONTINUE =========");
					String ca = sc.next();
				System.out.println();
				if(ca.charAt(0) == '1') {
					newLogin();
					System.out.println("============ PLEASE LOGIN ONCE TO CONFIRM YOUR DETAILS ============");
					System.out.println();
				} 
			    System.out.println("Enter Your Id ============");
			    idName = sc.next();
			    System.out.println();
			    System.out.println("Enter Your Password ============");
			    
			    pass = sc.next();
			    
			    
			    if(RailId1.containsKey(idName) && RailId1.get(idName).equals(pass) ) {
			             RailId.get(idName).menu();
			    	 
			    	
			   }else {System.out.println();
				   System.out.println("============ SORRY WE CAN'T LOGIN AS YOU HAVE ENTERED WRONG ENTITES, PLEASE TRY AGAIN! ============");
				   System.out.println();
			   }
				
				
			}while(!( RailId1.containsKey(idName) && RailId1.get(idName).equals(pass)));
		 
			
	}
	
	
	static void bbb() {
		sc = new Scanner(System.in);
		
		System.out.println("============ IF YOU WANT TO LOGIN AGAIN THEN PLS ENTER Y OTHERWISE N ============");
		
    	do {
    		String r = sc.next();
    		System.out.println();
    	char r1 = r.charAt(0);
    	if(r1 == 'Y') {
    		loop();
    		break;
    	}else if(r1 == 'N'){
    		y = false;
    		break;
    	}else {
      y = false;
      System.out.println("============ YOU HAVE ENTERED WRONG ENTITY PLEASE ENTER AGAIN ============");
    	}
    	}while(y != true);
	}
	
	
	
	static void newLogin() {
		 sc = new Scanner(System.in);
	  	System.out.println("ENTER YOUR IDNAME , PASSWORD AND EMAIL ADDRESS");
	  	String Idname = sc.next();
	  	String Password = sc.next();
	  	String email = sc.next();
	  	
	
	     seatbooking nn = new seatbooking(Idname,Password,email);

	     RailId.put(Idname,nn);
	     RailId1.put(Idname,Password);
}
	
	
	}	 
	
	 
   

    class seatbooking extends DsInJava{
	  String IdName ,email,destination, source,password,sourceMain,destinationMain;
       int noOfSeats;	  
       
       private boolean cda = false;
       
       Stack<Integer> SeatNo = new Stack<>();
       
     seatbooking(String IdName, String password,String email){
		  this.email = email;   this.IdName = IdName; this.password = password ;  
		   
	  }
     
     void menu() {
    	 char option = '\0';
     	
     	
     	System.out.println("Welcome Sir/Mam");System.out.println();
     	
     	System.out.println("Your Id is "+ IdName);System.out.println();
     	
     	
     	
     	do {
     		
     		System.out.println();
     		
     		System.out.println("==================================================================");
         	
         	System.out.println("A : Check Trains Between stations");
         	
         	System.out.println("B : Check Travelling Amount And Path Of The Train");
         	
         	System.out.println("C : Book Train");
         	
         	System.out.println("D : Booked Seats/Remove Seats");
         	
         	System.out.println("E : Delete Account");
         	
         	System.out.println("F : Exit");System.out.println();
     		
     		
     		
    		System.out.println("==================================================================");
    		
    		System.out.println("Enter an option");
    		
    		System.out.println("==================================================================");
    		
    		option = sc.next().charAt(0);
    		
    		System.out.println();
    		
    		
    		switch(option) {
    	
    	case 'A' :

    		if(cda == true) {
				System.out.println("YOUR ACCOUNT HAS ALREADY BEEN DELETED , PRESS F TO EXIT");
				break;
			}
    		
    			System.out.println();
        		
        		System.out.println("Enter Source");
        		
        		System.out.println("==========================");
        		source = sc.next();
        		
        		 if(!map.containsKey(source)) {System.out.println();
        			 System.out.println("====== INVALID ENTRY ======");
        			 System.out.println();
        			break;
        		 }

        		System.out.println();
        		
        		System.out.println("Enter Destination");
        		
        		System.out.println("==========================");
        		destination = sc.next();
      	
        		if(!map.containsKey(destination)) {System.out.println();
       			 System.out.println("====== INVALID ENTRY ======");
       			System.out.println();
       			 break;
        		}
        		
    			System.out.println();
    			
    			TrainData d = new TrainData();
        		d.showTrains(source, destination);
        		break;
    			
    	case 'B' :
    			
    		if(cda == true) {
				System.out.println("YOUR ACCOUNT HAS ALREADY BEEN DELETED , PRESS F TO EXIT");
				break;
			}
    		
    			System.out.println();
        		
        		System.out.println("Enter Source");
        		
        		System.out.println("==========================");
        		source = sc.next();
        		
        		 if(!map.containsKey(source)) {System.out.println();
        			 System.out.println("====== INVALID ENTRY ======");
        			 System.out.println();
        			break;
        		 }
        		System.out.println();
        		
        		System.out.println("Enter Destination");
        		
        		System.out.println("==========================");
        		destination = sc.next();
        		
        		if(!map.containsKey(destination)) {System.out.println();
       			 System.out.println("====== INVALID ENTRY ======");
       			System.out.println();
       			 break;
        		}
        		
        		TrainData dd = new TrainData();
        		boolean b = dd.checkTrains(source, destination);
        		if(b == false) break;
        		
        		System.out.println();
        		
        		System.out.println("ENTER NUMBER OF SEATS");
        		
        		System.out.println("==========================");
        		
        		int NoOfSeats = sc.nextInt();
        		
        		if(!(NoOfSeats > 0 &&  NoOfSeats < 65)) {
        			System.out.println("!!!!!!!!!! WRONG INPUT !!!!!!!!!!");
        			System.out.println();
        			return;
        		}
        		
        		System.out.println();

        	    stations.calculateAmount(source,destination,NoOfSeats);
    			System.out.println();
    			
        		    			
        		break;
        		
        		
    			
    	case 'C' :
    		if(cda == true) {
				System.out.println("YOUR ACCOUNT HAS ALREADY BEEN DELETED , PRESS F TO EXIT");
				break;
			}
    		
    		System.out.println();
    		
    		System.out.println("Enter Source");
    		
    		System.out.println("==========================");
    		source = sc.next();
    		
    		 if(!map.containsKey(source)) {System.out.println();
    			 System.out.println("====== INVALID ENTRY ======");
    			 System.out.println();
    			break;
    		 }sourceMain = source;
    		System.out.println();
    		
    		System.out.println("Enter Destination");
    		
    		System.out.println("==========================");
    		destination = sc.next();
    		System.out.println();
    		
    		if(!map.containsKey(destination)) {System.out.println();
   			 System.out.println("====== INVALID ENTRY ======");
   			System.out.println();
   			 break;
    		}destinationMain = destination;
    		
    		TrainData ddd = new TrainData();
    		 b = ddd.checkTrains(source, destination);
    		if(b == false ||  source == destination) {
    			break;
    		}
    		ddd.showTrains(source, destination);
    		System.out.println("====== WRITE THE TRAIN NUMBER TO TRAVEL WITH ======");
    		int train_no = sc.nextInt();
    		System.out.println();
    		System.out.println("====== WRITE THE CABIN NUMBER OF THE TRAIN ======");
    		int c = 0;
    		
    	do {
    		c = sc.nextInt();
    		if(c <=0 || c>5) {
    			System.out.println("===== PLEASE ENTER A VALID CABIN NUMBER =====");
    			System.out.println();
    		}
    	}while((c <=0 || c>5));
    			

		System.out.println("===== ENTER NUMBER OF SEATS =====");
		 noOfSeats = sc.nextInt();
		System.out.println();
    	
    	if(!(noOfSeats > 0 &&  noOfSeats < 65)) {
			System.out.println("!!!!!!!!!! WRONG INPUT !!!!!!!!!!");
			System.out.println();
			return;
		}
    	
    	SeatNo = object.get(train_no).booking( noOfSeats,c);
    	SeatNo.push(c);
    	SeatNo.push(train_no);
    	
    	stations.calculateAmount(source,destination,noOfSeats);
		System.out.println();
		
    	
    	break;
        		
        		
    			
    	case 'D' :
    		if(cda == true) {
				System.out.println("YOUR ACCOUNT HAS ALREADY BEEN DELETED , PRESS F TO EXIT");
				break;
			}
    		
    			System.out.println(" ENTER 1 TO CHECK BOOKED SEATS AND 0 TO REMOVE THE SEATS ");
    			String tt = sc.next();
    			char t = tt.charAt(0);
    			
    			if(t == '1') {
    				info();
    				break;
    			}else if(t == '0') {
    				deleteseats();
    				break;
    				
    			}else {
    				System.out.println();System.out.println("!!!!!!!! INVALID ENTRY !!!!!!!!");
    				System.out.println();
    			}
    			
        		break;
    			
        		
        case 'E':
        	if(cda == true) {
				System.out.println("YOUR ACCOUNT HAS ALREADY BEEN DELETED , PRESS F TO EXIT");
				break;
			}
        	
        	System.out.println("=======================================");
     		
        	deleteAccount();
    		
    		System.out.println();
    			
         		break;
         		
    			
    	case 'F' :
    			break;
    			
    			default :
    				System.out.println("!!!!!!!!!! INVALID ENTRY !! PLS ENTER AGAIN !!!!!!!!!!");
    				break;
    		
    		}
    	}while(option != 'F');
    	
    	 bbb();
     	
   } 
        
      void deleteseats() {
    	  
    	  Stack<Integer> s = new Stack(); s.addAll(SeatNo);
    	  
    	  if(s.isEmpty()) {
    		  System.out.println("========== NO BOOKED SEATS ==========");System.out.println();
    		  return;
    	  }
    	  
    	  int trainNo = s.pop();
          int Cabin = s.pop();
         
          SeatNo.clear();
          
          SeatNo = object.get(trainNo).delete(s,Cabin);
          
          if(!SeatNo.isEmpty()) {
        	  SeatNo.push(Cabin);
        	  SeatNo.push(trainNo);
          }
          s.clear();
		}
      
       
      void info() {
    	  
    	  Stack<Integer> s = new Stack(); s.addAll(SeatNo);    	  
    	  
    	  if(s.size() == 0) {
    		  System.out.println("========== NO BOOKED SEATS ==========");System.out.println();
    		  return;
    	  }
    	  System.out.println("Source      -------> "+ sourceMain);
    	  System.out.println("Destination -------> " + destinationMain);
    	  
    	  System.out.println();
    	 
    	
        System.out.println("Train -----> " + name.get(s.peek()) + " [" + s.pop() + "]");
        System.out.println();
        System.out.println("Cabin no is -----> "+ s.pop());
        System.out.println();
        System.out.println("--------- YOUR BOOKED SEATS ARE ---------");
        
        
    	  while(!s.isEmpty()) {
    		  System.out.print(s.pop()+" ");
    	  }
    	  System.out.println();
      }
      
      
      void deleteAccount(){
    	  sc = new Scanner(System.in);
    	  
      	System.out.println("!!!!!!!! TAKING CONFIRMATION !!!!!!!!");
      	System.out.println("===== ARE YOU SURE THAT YOU WANT TO DELETE YOUR ACCOUNT =====");
      	System.out.println();
      	System.out.println("===== IF YES ENTER 1 ELSE 0 =====");

      	int takeConfirmation = sc.nextInt();
      	
      	if(takeConfirmation == 0) {
      	
      		System.out.println("===== YOUR ACCOUNT IS RETAINED =====");
      		
      		return;
      	}
      	else if(takeConfirmation == 1) {
      		System.out.println();
      		
      		cda = true;
      		
      		deleteseats();
      		
      	RailId1.remove(IdName,password);
      
      	RailId.remove(IdName,RailId.get(IdName));
      	
      	System.out.println("========== YOUR ACCOUNT HAS BEEN DELETED ==========");}
      	else {
      		System.out.println("===== INVALID ENTRY =====");
      	}
      }
     
      
  }  


    
   class stations extends DsInJava{
	  private static final Graph graph = new Graph(41);
	   
	   static {
	 	 graph.addEdge(16,35);    graph.addEdge(17,25);	 graph.addEdge(32,31);	 graph.addEdge(19,22);	 graph.addEdge(15,14);   graph.addEdge(6,5);
		 graph.addEdge(35,36);    graph.addEdge(25,26);	 graph.addEdge(30,31);	 graph.addEdge(22,23);	 graph.addEdge(14,13);	 graph.addEdge(7,6);
		 graph.addEdge(36,37);	  graph.addEdge(26,27);	 graph.addEdge(30,29);	 graph.addEdge(23,24);	 graph.addEdge(13,12);	 graph.addEdge(7,0);
		 graph.addEdge(37,38);	  graph.addEdge(27,32);  graph.addEdge(29,28); 	 graph.addEdge(24,28);	 graph.addEdge(12,2); 	 graph.addEdge(8,7);
		 graph.addEdge(38,39);    graph.addEdge(32,33);	 graph.addEdge(15,16);	 graph.addEdge(19,20);	 graph.addEdge(2,1);     graph.addEdge(9,8);
		 graph.addEdge(39,40);	  graph.addEdge(33,34);	 graph.addEdge(15,18);	 graph.addEdge(20,21);	 graph.addEdge(2,3); 	 graph.addEdge(10,9);
		 graph.addEdge(16,17);	  graph.addEdge(34,38);	 graph.addEdge(18,19);	 graph.addEdge(21,25);	 graph.addEdge(4,5); 	 graph.addEdge(10,11);
		 
		 graph.addEdge(11,16);    graph.addEdge(3,4);
		 
		 
	  }

	public static void calculateAmount(String source,String destination,int noOfSeats) {

		
	       Stack<Integer> info = graph.bfs(map.get(source),map.get(destination) );
	       int c = info.pop();
	       System.out.println();
	       System.out.println("There will be "+ c+" stations to reach your destination."); 
	       System.out.println();
		   System.out.println("Path of the train to reach your destination is -->");
		   System.out.println();
		   
		   int i = 0;
		   while(!info.isEmpty()) {
			   i++;
			   int m = info.pop();
			   for(String a:map.keySet()) {
				   if(map.get(a).equals(m)) {
			   System.out.print(a);
			   if(!info.isEmpty()) System.out.print(" ---> ");
				   }
				   }
			   if(i>9) {System.out.println();i = 0;}
		   }
		   System.out.println();
		   System.out.println();  
		   System.out.println("AMOUNT ----> "+ (noOfSeats*(c-1)*40 + 60));
		   System.out.println();
		   
		
	}  
   }
