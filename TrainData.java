package clg;

 public class TrainData extends DsInJava{
	 
	static class Node{
	     int train_no;
	     String entrytime;
	     String exittime;
	     int i;
	     
	    Node next;
	    
	    public Node(){
	    train_no = 0;
	    entrytime = null;
	    exittime = null ;
	    next = null;  
	    }

	    public Node(int t,String e,String et,int i){
	        train_no = t;
	        entrytime = e;
	        exittime = et;
	        this.i = i;
	        next=null;
	    }
	    }
	 
	 
	 
	 
	  static   class Linkl{
	  public Node head;
	    public Linkl(){
	        head= new Node();
	    }
	     public void add(int t,String e,String et,int i){
	          Node newptr= new Node(t,e,et,i);
	          if(head==null){
	              head = newptr;
	              Node newt = new Node();
	          }
	          else{
	              Node temp=head;
	              while(temp.next!=null){
	                  temp=temp.next;
	              }
	              temp.next=newptr;
	          }
	      }
	    
	   boolean checkTrains(Node d,String source,String destination) {

		   Node temp1 = head.next;  
		 int a =0;
		 if(map.get(source) > map.get(destination)) a = 1;
		 else a =-1;

		 while(temp1 != null ) {
			 Node temp2 = d;
			 while(temp2 != null) {
				 if(temp1.train_no == temp2.train_no) {
					 if(temp1.i == a && temp2.i == a) {
						 return true;
					 }
				 }
				 temp2 = temp2.next;
			 }
			 temp1 = temp1.next;
		 }
		 System.out.println();
		 System.out.println("======== NO DIRECT TRAINS ========");System.out.println();
	    return false;
	    }
	   
	   
	   
	   void showTrains(Node d,String source,String destination) {
		   Node temp1 = head.next;  
		 int a = 0;
		 if(map.get(source) > map.get(destination)) a = 1;
		 else a =-1;
	    	boolean y = false;
		 while(temp1 != null ){
			 Node temp2 = d;
			 while(temp2 != null) {
				 if(temp1.train_no == temp2.train_no) {
					 if(temp1.i == a && temp2.i == a) {
						 y = true;
						 System.out.println( name.get(temp1.train_no)+"  ["+temp1.train_no+"]");	
						 
						 System.out.println(source+"----->");
						 System.out.println("Arrival: "+temp1.entrytime +"      Departure: "+temp1.exittime);System.out.println();
						 
						 System.out.println(destination+"----->");
						 System.out.println("Arrival: "+temp2.entrytime +"      Departure: "+temp2.exittime);
						 
						 System.out.println();System.out.println();System.out.println();
					 }
				 }
				 temp2 = temp2.next;
			 }
			 temp1 = temp1.next;
		 }
		 if(y == false) {System.out.println();
			 System.out.println("======== NO DIRECT TRAINS ========");
			 System.out.println();
		 }
	    }
	   
	    }
	    
	    
	    
	    
	  static class pair{
	     Linkl s;
	     public pair(){
	    	 s = new Linkl();
	     }
	    }
	   
	 public static  pair p[] = new pair[41]; 
	 
	 static{
		 for(int i = 0;i<41;i++) {
				p[i] = new pair();
			}
		 
 p[16].s.add(1000,"11:00 a.m.","11:15 a.m.",1);     p[34].s.add(1004,"8:30 a.m.","8:32 a.m.",1);  p[20].s.add(1008,"12:58 p.m.","1:00 p.m.",1);		p[14].s.add(1020,"10:30 p.m.","10:32 p.m.",1);		
 p[16].s.add(1001,"7:00 p.m.","7:15 p.m.",-1);    	p[34].s.add(1005,"6:00 p.m.","6:02 p.m.",-1); p[20].s.add(1009,"2:28 p.m.","2:30 p.m.",-1);		p[14].s.add(1021,"3:00 a.m.","3:02 a.m.",-1);		
 p[16].s.add(1002,"9:00 a.m.","10:00 a.m.",1); 													  													p[14].s.add(1010,"6:30 p.m.","6:32 p.m.",1);
 p[16].s.add(1003,"5:00 p.m.","Destination",-1);   	p[33].s.add(1004,"9:00 a.m.","9:02 a.m.",1);  p[28].s.add(1004,"11:30 a.m.","3:00 p.m.",1); 	p[14].s.add(1011,"1:00 a.m.","1:02 a.m.",-1);		
 p[16].s.add(1016,"2:30 p.m.","2:32 p.m.",1);     	p[33].s.add(1005,"5:28 p.m.","5:30 p.m.",-1); p[28].s.add(1005,"2:00 p.m.","3:00 p.m.",-1);		p[14].s.add(1006,"3:30 p.m.","3:32 p.m.",1);		
 p[16].s.add(1017,"10:00 p.m.","10:02 p.m.",-1);     											  p[28].s.add(1018,"6:00 a.m.","7:00 a.m.",1);  	p[14].s.add(1007,"9:00 p.m.","9:02 p.m.",-1);
 p[16].s.add(1014,"10:00 a.m.","11:00 a.m.",1);	    p[31].s.add(1004,"10:00 a.m.","10:02 a.m.",1);p[28].s.add(1019,"2:00 p.m.","Destination",-1);										
 p[16].s.add(1015,"5:30 p.m.","Destination",-1);	p[31].s.add(1005,"4:30 p.m.","4:32 p.m.",-1); p[28].s.add(1010,"2:00 p.m.","3:00 p.m.",1);		p[13].s.add(1020,"11:00 p.m.","11:02 p.m.",1);		
 p[16].s.add(1006,"10:00 a.m.","11:00 a.m.",1);			     									  p[28].s.add(1011,"4:30 a.m.","Destination",-1);	p[13].s.add(1021,"2:28 a.m.","2:30 a.m.",-1);		
 p[16].s.add(1007,"7:00 p.m.","Destination",-1);	p[30].s.add(1004,"10:28 a.m.","10:30 p.m.",1);													p[13].s.add(1010,"7:00 p.m.","7:02 p.m.",1);		
  													p[30].s.add(1005,"3:58 p.m.","4:00 p.m.",-1); p[24].s.add(1018,"7:30 a.m.","7:32 a.m.",1);		p[13].s.add(1011,"00:30 a.m.","00:32 a.m.",-1);
 p[35].s.add(1000,"10:38 a.m.","10:40 a.m.",1); 												  p[24].s.add(1019,"1:28 p.m.","1:30 p,m,",-1);		p[13].s.add(1006,"3:58 p.m.","4:00 p.m.",1);		
 p[35].s.add(1001,"7:35 p.m.","7:37 p.m.",-1);		p[29].s.add(1004,"10:58 a.m.","11:00 p.m.",1);p[24].s.add(1010,"3:30 p.m.","3:32 p.m.",1);		p[13].s.add(1007,"8:30 p.m.","8:32 p.m.",-1);		
 p[35].s.add(1002,"10:20 a.m.","10:22 a.m.",1);		p[29].s.add(1005,"3:30 p.m.","3:32 p.m.",-1); p[24].s.add(1011,"4:00 a.m.","4:02 a.m.",-1);										
 p[35].s.add(1003,"4:40 p.m.","4:42 p.m.",-1);																										p[12].s.add(1020,"11:28 p.m.","11:30 p.m.",1);		
		   											p[32].s.add(1004,"9:30 a.m.","9:32 a.m.",1);  p[23].s.add(1018,"8:00 a.m.","8:02 a.m.",1);		p[12].s.add(1021,"1:58 a.m.","2:00 a.m.",-1);
 p[36].s.add(1000,"9:58 a.m.","10:00 a.m.",1); 		p[32].s.add(1005,"5:00 p.m.","5:02 p.m.",-1); p[23].s.add(1019,"1:00 p.m.","1:02 p.m.",-1);		p[12].s.add(1010,"7:30 p.m.","7:32 p.m.",1);   
 p[36].s.add(1001,"8:18 p.m.","8:20 p.m.",-1);		p[32].s.add(1006,"11:00 a.m.","12:00 p.m.",1); p[23].s.add(1010,"3:58 p.m.","4:00 p.m.",1);		p[12].s.add(1011,"00:00 a.m.","00:02 a.m.",-1);		
 p[36].s.add(1002,"10:58 a.m.","11:00 a.m.",1);		p[32].s.add(1007,"00:30 a.m.","Destination",-1); p[23].s.add(1011,"3:30 a.m.","3:32 a.m.",-1);	p[12].s.add(1006,"4:30 p.m.","4:32 p.m.",1);		
 p[36].s.add(1003,"4:00 p.m.","4:02 p.m.",-1);		p[32].s.add(1014,"1:30 p.m.","3:00 p.m.",1);													p[12].s.add(1007,"7:58 p.m.","8:00 p.m.",-1);		
		   											p[32].s.add(1015,"1:30 p.m.","3:00 p.m.",-1);p[22].s.add(1018,"8:30 a.m.","8:32 a.m.",1);	   
 p[37].s.add(1000,"9:30 a.m.","9:32 a.m.",1); 													p[22].s.add(1019,"12:30 p.m.","12:32 p.m.",-1);		p[1].s.add(1020,"00:30 a.m.","1:00 a.m.",1);		
 p[37].s.add(1001,"8:40 p.m.","8:42 p.m.",-1);		p[27].s.add(1006,"12:28 p.m.","12:30 p.m.",1);p[22].s.add(1010,"4:30 p.m.","4:32 p.m.",1);		p[1].s.add(1021,"00:30 a.m.","1:00 a.m.",-1);		
 p[37].s.add(1002,"11:28 a.m.","11:30 a.m.",1);		p[27].s.add(1007,"11:58 p.m.","00:00 a.m.",-1);	p[22].s.add(1011,"3:00 a.m.","3:02 a.m.",-1);	p[1].s.add(1010,"9:00 p.m.","11:00 p.m.",1);		
 p[37].s.add(1003,"3:30 p.m.","3:32 p.m.",-1);		p[27].s.add(1014,"1:00 p.m.","1:02 p.m.",1);													p[1].s.add(1011,"9:00 p.m.","11:00 p.m.",-1);		
		   											p[27].s.add(1015,"3:28 p.m.","3:30 p.m.",-1);p[18].s.add(1018,"9:28 a.m.","9:30 a.m.",1);		p[1].s.add(1006,"5:30 p.m.","7:00 p.m.",1);
 p[38].s.add(1000,"9:00 a.m.","9:02 a.m.",1); 											        p[18].s.add(1019,"11:30 a.m.","11:32 a.m.",-1);		p[1].s.add(1007,"5:30 p.m.","7:00 p.m.",-1);		
 p[38].s.add(1001,"9:10 p.m.","9:12 p.m.",-1);		p[26].s.add(1006,"1:00 p.m.","1:02 p.m.",1);p[18].s.add(1010,"5:30 p.m.","5:32 p.m.",1);		p[1].s.add(1012,"3:00 p.m.","5:00 p.m.",1);		
 p[38].s.add(1002,"11:58 a.m.","12:00 p.m.",1);		p[26].s.add(1007,"11:30 p.m.","11:32 p.m.",-1);p[18].s.add(1011,"2:00 a.m.","2:02 a.m.",-1);	p[1].s.add(1013,"3:00 p.m.","5:00 p.m.",-1);		
 p[38].s.add(1003,"2:58 p.m.","3:00 p.m.",-1);	    p[26].s.add(1014,"12:30 p.m.","12:32 p.m.",1);																		
 p[38].s.add(1004,"8:00 a.m.","8:02 a.m.",1);		p[26].s.add(1015,"3:58 p.m.","4:00 p.m.",-1);p[19].s.add(1018,"9:00 a.m.","9:02 a.m.",1);		p[2].s.add(1020,"11:58 p.m.","00:00 a.m.",1);
 p[38].s.add(1005,"6:30 p.m.","6:32 p.m.",-1);													p[19].s.add(1019,"11:58 a.m.","12:00 p.m.",-1);		p[2].s.add(1021,"1:30 a.m.","1:32 a.m.",-1);		
		   											p[17].s.add(1006,"2:00 p.m.","2:02 p.m.",1);p[19].s.add(1010,"5:00 p.m.","5:02 p.m.",1);		p[2].s.add(1010,"8:00 p.m.","8:02 p.m.",1);		
 p[39].s.add(1000,"8:28 a.m.","8:30 a.m.",1); 		p[17].s.add(1007,"10:30 p.m.","10:32 p.m.",-1);	p[19].s.add(1011,"2:30 a.m.","2:32 a.m.",-1);	p[2].s.add(1011,"11:28","11:30",-1);		
 p[39].s.add(1001,"9:40 p.m.","9:42 p.m.",-1);		p[17].s.add(1014,"11:30 p.m.","11:32 p.m.",1);p[19].s.add(1008,"1:30 p.m.","2:00 p.m.",1);		p[2].s.add(1006,"5:00 p.m.","5:02 p.m.",1);		
 p[39].s.add(1002,"12:28 p.m.","12:30 p.m.",1);		p[17].s.add(1015,"5:00 p.m.","5:02 p.m.",-1);p[19].s.add(1009,"1:30 p.m.","2:00 p.m.",-1);		p[2].s.add(1007,"7:30 p.m.","7:32 p.m.",-1);
 p[39].s.add(1003,"2:28 p.m.","2:30 p.m.",-1);				     																					p[2].s.add(1012,"2:30 p.m.","2:32 p.m.",1);		
 p[39].s.add(1004,"7:30 a.m.","7:32 a.m.",1);	 	p[25].s.add(1006,"1:28 p.m.","1:30 p.m.",1);p[15].s.add(1018,"10:00 a.m.","11:00 a.m.",1);		p[2].s.add(1013,"5:30 p.m.","5:32 p.m.",-1);		
 p[39].s.add(1005,"6:58 p.m.","7:00 p.m.",-1);		p[25].s.add(1007,"11:00 p.m.","11:02 p.m.",-1);	p[15].s.add(1019,"10:00 a.m.","11:00 a.m.",-1);										
		   											p[25].s.add(1014,"12:00 p.m.","12:02 p.m.",1);p[15].s.add(1010,"6:00 p.m.","6:02 p.m.",1);			p[3].s.add(1012,"2:00 p.m.","2:02 p.m.",1);		
 p[40].s.add(1000,"7:15 a.m.","8:00 a.m.",1); 		p[25].s.add(1015,"4:30 p.m.","4:32 p.m.",-1);p[15].s.add(1011,"1:30 a.m.","1:32 a.m.",-1);			p[3].s.add(1013,"6:00 p.m.","6:02 p.m.",-1);		
 p[40].s.add(1001,"10:00 p.m.","Destination",-1);	p[25].s.add(1008,"11:00 p.m.","12:00 p.m.",1);p[15].s.add(1006,"3:00 p.m.","3:02 p.m.",1);										
 p[40].s.add(1002,"12:58 p.m.","1:00 p.m.",1);		p[25].s.add(1009,"3:30 p.m.","Destination",-1);p[15].s.add(1007,"9:30 p.m.","9:32 p.m.",-1);		p[4].s.add(1012,"1:30 p.m.","1:32 p.m.",1);
 p[40].s.add(1003,"1:00 p.m.","2:00 p.m.",-1);							    					p[15].s.add(1020,"9:00 p.m.","10:00 p.m.",1);			p[4].s.add(1013,"6:30 p.m.","6:32 p.m.",-1);
 p[40].s.add(1004,"6:00 a.m.","7:00 a.m.",1);		p[21].s.add(1008,"12:30 p.m.","12:32 p.m.",1);p[15].s.add(1021,"3:30 a.m.","Destination",-1);
 p[40].s.add(1005,"7:30 p.m.","Destination",-1);	p[21].s.add(1009,"3:00 p.m.","3:02 p.m.",-1);
 
 
 p[5].s.add(1012,"12:58 p.m.","1:00 p.m.",1);		p[9].s.add(1000,"12:30 p.m.","12:32 p.m.",1);	p[7].s.add(1000,"1:30 p.m","1:33 p.m.",1);
 p[5].s.add(1013,"7:00 p.m.","7:02 p.m.",-1);	 	p[9].s.add(1001,"5:32 p.m.","5:34 p.m.",-1);    p[7].s.add(1001,"4:30 p.m.","4:32 p.m.",-1);
 													p[9].s.add(1016,"12:28 p.m.","12:30 p.m.",1);	p[7].s.add(1016,"1:30 p.m.","1:32 p.m.",1);
 p[6].s.add(1012,"12:28 p.m.","12:30 p.m.",1);		p[9].s.add(1017,"5:30 p.m.","5:32 p.m.",-1);	p[7].s.add(1017,"4:30 p.m.","4:32 p.m.",-1);
 p[6].s.add(1013,"7:30 p.m.","7:32 p.m.",-1);														p[7].s.add(1012,"11:00 a.m.","12:00 p.m.",1);
 													p[8].s.add(1000,"1:00 p.m.","1:02 p.m.",1);     p[7].s.add(1013,"8:00 p.m.","Destination",-1);
 p[11].s.add(1000,"11:30 a.m.","11:32 a.m.",1); 	p[8].s.add(1001,"5:00 p.m.","5:05 p.m.",-1);
 p[11].s.add(1001,"6:30 p.m.","6:32 p.m.",-1);	    p[8].s.add(1016,"1:00 p.m.","1:02 p.m.",1);
 p[11].s.add(1016,"11:30 a.m.","11:32 a.m.",1);		p[8].s.add(1017,"5:00 p.m.","5:02 p.m.",-1);
 p[11].s.add(1017,"6:30 p.m.","6:32 p.m.",-1);						
 													p[0].s.add(1000,"2:00 p.m.","4:00 p.m.",1);
 p[10].s.add(1000,"11:58 a.m.","12:00 p.m.",1);		p[0].s.add(1001,"2:00 p.m.","4:00 p.m.",-1);
 p[10].s.add(1001,"6:00 p.m.","6:02 p.m.",-1);		p[0].s.add(1016,"2:00 p.m.","4:00 p.m.",1);
 p[10].s.add(1016,"12:00 p.m.","12:02 p.m.",1);		p[0].s.add(1017,"2:00 p.m.","4:00 p.m.",-1);
 p[10].s.add(1017,"6:00 p.m.","6:02 p.m.",-1);
	 }

	
	 
	public boolean checkTrains(String source,String destination) {
		if(map.get(source) == map.get(destination)) {
			System.out.println("===== YOU DESTINATION IS AS SAME AS SOURCE =====");System.out.println();
			return false;
		}
		return p[map.get(source)].s.checkTrains(p[map.get(destination)].s.head.next,source,destination);
	}
	 
	public void showTrains(String source,String destination) {
		if(map.get(source) == map.get(destination)) {
			System.out.println("===== YOU DESTINATION IS AS SAME AS SOURCE =====");System.out.println();
			return;
		}
		p[map.get(source)].s.showTrains(p[map.get(destination)].s.head.next,source,destination);
	}
	  
	   
}
 
 

 
 
 
 
 
 
 
