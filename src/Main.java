import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void printTracks(ArrayList<Track> tracks,ArrayList<Author> authors){
        for(Track t:tracks)
            System.out.println("track name: "+t.getName()+"  author:"+nameById(t.getAuthorId(),authors));
    }

    public static String nameById(int id,ArrayList<Author> authors){
        String name="";
        for(Author a:authors)
            if(a.getId()==id)   name=a.getName();
        return name;
    }

    public static void printAuthors(ArrayList<Author> authors){
        for(Author a:authors)
            System.out.println(a);
    }
    public static void printCompanies(ArrayList<RecorderCompany> companies){
        for(RecorderCompany c:companies)
            System.out.println(c);
    }

    public static int searchAuthorId(String name,ArrayList<Author> authors)    throws NotFoundException {
        for(Author a:authors)
            if(a.getName().equalsIgnoreCase(name))  return a.getId();
        throw new NotFoundException();
    }

    public static int searchCompanyId(String name,ArrayList<RecorderCompany> companies)    throws NotFoundException{
        for(RecorderCompany c:companies)
            if(c.getName().equalsIgnoreCase(name))  return c.getId();
        throw new NotFoundException();
    }

    public static void printTracksByAuthor(ArrayList<Track> tracks, ArrayList<Author> authors) throws NotFoundException,NoTracksFoundException {
        Scanner name=new Scanner(System.in);
        boolean atLeast=false;
        String data;
        System.out.print("\ttype the name of the author:");
        int id=searchAuthorId(data=name.nextLine(),authors);
        System.out.println("ALL TRACKS OF"+data.toUpperCase());
        for(Track t: tracks)
            if(t.getAuthorId()==id) {
                System.out.println("Track name: "+t.getName());
                atLeast=true;
            }
        if(!atLeast)    throw new NoTracksFoundException();
    }

    public static void printTracksByCompany(ArrayList<Track> tracks, ArrayList<RecorderCompany> companies)  throws NotFoundException,NoTracksFoundException{
        Scanner name=new Scanner(System.in);
        String data;
        boolean atLeast=false;
        System.out.print("\ttype the name of the recording company:");
        int id=searchCompanyId(data=name.nextLine(),companies);
        System.out.println("ALL TRACKS OF"+data.toUpperCase());
        for(Track t: tracks)
            if(t.getCompanyId()==id) {
                System.out.println("Track name: "+t.getName());
                atLeast=true;
            }
        if(!atLeast)    throw new NoTracksFoundException();
    }

    public static void main(String[] args) {
        Scanner t,a,c;
        ArrayList<RecorderCompany> companies= new ArrayList<>();
        ArrayList<Track> tracks= new ArrayList<>();
        ArrayList<Author> authors= new ArrayList<>();
        try{
            c=new Scanner(new File("companies.txt"));
            t=new Scanner(new File("tracks.txt"));
            a=new Scanner(new File("authors.txt"));

        }catch(IOException e){System.out.println(e);return;}

        while(c.hasNextLine()){
            String data[]=c.nextLine().split(";");
            companies.add(new RecorderCompany(Integer.parseInt(data[0]),data[1]));
        }

        while(t.hasNextLine()){
            String data[]=t.nextLine().split(";");
            tracks.add(new Track(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[1])));
        }

        while(a.hasNextLine()){
            String data[]=a.nextLine().split(";");
            authors.add(new Author(Integer.parseInt(data[0]),data[1]));
        }

        Scanner in= new Scanner(System.in);
        boolean option=false;
        while(!option){
            System.out.print("\nType your choice: ");
            switch(Integer.parseInt(in.nextLine())){
                case 1:
                    printTracks(tracks,authors);
                    break;
                case 2:
                    printAuthors(authors);
                    break;
                case 3:
                    printCompanies(companies);
                    break;
                case 4:
                    try{printTracksByAuthor(tracks,authors);}
                    catch(NotFoundException | NoTracksFoundException e){System.out.println(e);}
                    break;
                case 5:
                    try{printTracksByCompany(tracks,companies);}
                    catch(NotFoundException | NoTracksFoundException e){System.out.println(e);}
                    break;
                default:    option=true;
            }
        }
    }
}
