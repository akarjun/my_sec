import java.util.Scanner;

import com.mongodb.*;

public class javamongo {

   public static void main( String args[] ) {
	   Scanner in = new Scanner(System.in);
      try{   
		
		int choice;	
		// Connect to MongoDB
		
		MongoClient mongo = new MongoClient("localhost", 27017);

		// Get database 
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("mobile");

		// if collection doesn't exists, MongoDB will create it for you
		DBCollection table = db.getCollection("user");
		System.out.println("Collection created successfully");
        do
		{
			System.out.println("MENU\n1.Create \n2.Read \n3.Update"+
					"\n4.Delete \n5.Display all documents \n Enter your choice (0 for exit)");
			choice=in.nextInt();
			switch(choice)
			{
			case 1:
				BasicDBObject document= new BasicDBObject();

				document = new BasicDBObject();
				document.put("name", "Tushar");
				document.put("age", 31);
				table.insert(document);
				document = new BasicDBObject();
				document.put("name", "Ram");
				document.put("age", 40); 
				table.insert(document);
				document = new BasicDBObject();
				document.put("name", "Vivek");
				document.put("age", 20); 
				table.insert(document);
				document = new BasicDBObject();
				document.put("name", "Mohan");
				document.put("age", 41); 
				table.insert(document);
				document = new BasicDBObject();
				document.put("name", "Samrat");
				document.put("age", 25); 
				table.insert(document);
				System.out.println("Collection Inserted successfully");
				
				break;
			case 2:
				/**** Find and display ****/
				BasicDBObject searchQuery = new BasicDBObject();
				searchQuery.put("name", "Tushar");

				DBCursor cursor = table.find(searchQuery);

				while (cursor.hasNext()) {
					System.out.println(cursor.next());
				}
				System.out.println("Collection displayed successfully");
				break;
				

				
			case 3:
				/**** Update ****/
				BasicDBObject query = new BasicDBObject();
				query.put("name", "Mohan");

				BasicDBObject newDocument = new BasicDBObject();
				newDocument.put("name", "Mohan-Mahajan");

				BasicDBObject updateObj = new BasicDBObject();
				updateObj.put("$set", newDocument);

				table.update(query, updateObj);
				System.out.println("Collection updated successfully");
				break;
				
				
			case 4:
				//Delete
				BasicDBObject searchQuery1 = new BasicDBObject();
				searchQuery1.put("name", "Samrat");
				table.remove(searchQuery1);
				System.out.println("Collection deleted successfully");
				break;
			
			case 5:
				
				DBCursor cursor2 = table.find();
				while (cursor2.hasNext()) {
				   System.out.println(cursor2.next());
				}
			}
    	
		}while(choice!=0);
         
      }catch(Exception e){
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      }
   }
}