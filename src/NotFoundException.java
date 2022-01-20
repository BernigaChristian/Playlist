public class NotFoundException extends Exception{
    public NotFoundException(){super();}

    public String toString(){
        return "SORRY! the author/recording company you are looking for doesn't exist";
    }
}
