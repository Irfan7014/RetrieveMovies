package awesomemovies;
import databases.MovieDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Formatter;
public class AwesomeMovies {
    static MovieDatabase movieDatabase = new MovieDatabase();
    static InputStreamReader ins=new InputStreamReader(System.in);
    static BufferedReader br=new BufferedReader(ins);
    static Formatter fmt = new Formatter();  
    private static void insertMovie()throws IOException{
        String movieName, actor, actress, director;
        int yearOfRelease;
        System.out.print("\nEnter Movie name: ");
        movieName = br.readLine();
        System.out.print("Enter Actor's name: ");
        actor = br.readLine();
        System.out.print("Enter Actress' name: ");
        actress = br.readLine();
        System.out.print("Enter Director's name: ");
        director = br.readLine();
        System.out.print("Enter Year Of Release: ");
        yearOfRelease = Integer.parseInt(br.readLine());
        String q = "INSERT INTO movies_details VALUES (DEFAULT, '"+movieName+"', '"+actor+"', '"+actress+"', '"+yearOfRelease+"', '"+director+"');";
        try{
            movieDatabase.s.executeUpdate(q);
            System.out.println("\nMovie Added Successfully");
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void retrieveMovies(String inputString) {
        String q = "SELECT * FROM movies_details WHERE movie LIKE '%"+inputString+"%' OR actor LIKE '%"+inputString+"%' OR actress LIKE '%"+inputString+"%' OR yearOfRelease LIKE '%"+inputString+"%' OR director LIKE '%"+inputString+"%';";
        int id=0;
        try{
            ResultSet rs = movieDatabase.s.executeQuery(q);
            System.out.format("%-6s %-30s %-20s %-20s %-5s %-20s\n","SR.NO.","MOVIE","ACTOR","ACTRESS","YEAR","DIRECTOR");
            while(rs.next()){
               id++;
               System.out.format("%-6d %-30s %-20s %-20s %-5d %-20s\n",id,rs.getString("movie"),rs.getString("actor"),rs.getString("actress"),rs.getLong("yearOfRelease"),rs.getString("director"));
            }
            if(id==0)
                System.out.println("\nNo such movie found!!!");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void retrieveMovies(String searchString,String columnName) {
        String q = "SELECT * FROM movies_details WHERE "+columnName+" LIKE '%"+searchString+"%';";
        int id=0;
        try{
            ResultSet rs = movieDatabase.s.executeQuery(q);
            System.out.format("%-6s %-30s %-20s %-20s %-5s %-20s\n","SR.NO.","MOVIE","ACTOR","ACTRESS","YEAR","DIRECTOR");
            while(rs.next()){
               id++;
               System.out.format("%-6d %-30s %-20s %-20s %-5d %-20s\n",id,rs.getString("movie"),rs.getString("actor"),rs.getString("actress"),rs.getLong("yearOfRelease"),rs.getString("director"));
            }
            if(id==0)
                System.out.println("\nNo such movie found!!!");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void retrieveMovies(String actorName,String actressName, String actorTag, String actressTag){
        String q = "SELECT * FROM movies_details WHERE "+actorTag+" LIKE '%"+actorName+"%' OR "+actressTag+" LIKE '%"+actressName+"%';";
        int id=0;
        try{
            ResultSet rs = movieDatabase.s.executeQuery(q);
            System.out.format("%-6s %-30s %-20s %-20s %-5s %-20s\n","SR.NO.","MOVIE","ACTOR","ACTRESS","YEAR","DIRECTOR");
            while(rs.next()){
               id++;
               System.out.format("%-6d %-30s %-20s %-20s %-5d %-20s\n",id,rs.getString("movie"),rs.getString("actor"),rs.getString("actress"),rs.getLong("yearOfRelease"),rs.getString("director"));
            }
            if(id==0)
                System.out.println("\nNo such movie found!!!");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    private static void retrieveMovies(){
        String q = "SELECT * FROM movies_details;";
        int id=0;
        try{
            ResultSet rs = movieDatabase.s.executeQuery(q);
            System.out.format("%-6s %-30s %-20s %-20s %-5s %-20s\n","SR.NO.","MOVIE","ACTOR","ACTRESS","YEAR","DIRECTOR");
            while(rs.next()){
               id++;
               System.out.format("%-6d %-30s %-20s %-20s %-5d %-20s\n",id,rs.getString("movie"),rs.getString("actor"),rs.getString("actress"),rs.getLong("yearOfRelease"),rs.getString("director"));
            }
            if(id==0)
                System.out.println("\nNo such movie found!!!");
            
        }
        catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void main(String[] args) throws IOException {
        int choice;
        String movieName, actor, actress, director, yearOfRelease;
        while(true)
        {
            System.out.println("\n\n1. Add a movie");
            System.out.println("2. Search a movie by movie name");
            System.out.println("3. Search movies by actor name");
            System.out.println("4. Search movies by actress name");
            System.out.println("5. Search movies by Actor & Actress' Name");
            System.out.println("6. Search movies by director name");
            System.out.println("7. Search movies by Year Of Release");
            System.out.println("8. Search movies by Input String");
            System.out.println("9. Retrieve All Movie Details");
            System.out.println("10. To Exit");
            System.out.print("Enter your choice: ");
            choice = Integer.parseInt(br.readLine());
            switch(choice){
                case 1:
                    insertMovie();
                    break;
                case 2:
                    System.out.print("\nEnter Movie name: ");
                    movieName = br.readLine();
                    retrieveMovies(movieName,"movie");
                    break;
                case 3:
                    System.out.print("\nEnter Actor name: ");
                    actor = br.readLine();
                    retrieveMovies(actor,"actor");
                    break;
                case 4:
                    System.out.print("\nEnter Actress' name: ");
                    actress = br.readLine();
                    retrieveMovies(actress,"actress");
                    break;
                case 5:
                    System.out.print("\nEnter Actor's name: ");
                    actor = br.readLine();
                    System.out.print("\nEnter Actress' name: ");
                    actress= br.readLine();
                    retrieveMovies(actor,actress,"actor","actress");
                    break;
                case 6:
                    System.out.print("\nEnter Director name: ");
                    director = br.readLine();
                    retrieveMovies(director,"director");
                    break;
                case 7:
                    System.out.print("\nEnter Year: ");
                    yearOfRelease = br.readLine();
                    retrieveMovies(yearOfRelease,"yearOfRelease");
                    break;
                case 8:
                    System.out.print("\nInput String: ");
                    String inputString = br.readLine();
                    retrieveMovies(inputString);
                    break;
                case 9:
                    retrieveMovies();
                    break;
                case 10:
                    System.exit(0);
                    break;
                default: System.out.println("\nInvalid Choice");
                         
            }
            
        }
    }
}
   
