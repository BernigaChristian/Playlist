public class NoTracksFoundException extends Exception{
    public NoTracksFoundException(){super();}
    public String toString(){
        return "SORRY! there are no tracks of this author/recording company";
    }
}
