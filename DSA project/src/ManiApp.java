import java.io.BufferedReader;
import java.io.InputStreamReader;


public class ManiApp {

	public static void main(String[] args) {
		
		System.out.println("\tMain Menu");
		
		while(true){
		
		System.out.println("1 for insert");
		System.out.println("2 for search");
		System.out.println("3 for delete");
		System.out.println("4 for exit");
		
		
		String s=getInput("Enter the operation");
		int op=Integer.parseInt(s);
		System.out.println(op);
		
switch(op){
		
		case 1:
			System.out.println("insert function");
			break;
		
		case 2:
			System.out.println("search function");
			break;
		
		case 3:
			System.out.println("delete function");
			break;
		
		case 4:
			System.exit(1);	
		
		default:
			System.out.println("wrong input");
		
		
		}
		}
		
	}

	public static String getInput(String prompt){
		BufferedReader stdin= new BufferedReader(new InputStreamReader(System.in));
		System.out.print(prompt);
		System.out.flush();
		try{
			return stdin.readLine();
		}
		catch(Exception e){
			return "error :"+e.getMessage();
			
		}
	}
}
