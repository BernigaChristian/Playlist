public class Track {
    private int authorId;
    private int companyId;
    private String name;

    public Track(String name,int companyId,int authorId){
        this.authorId=authorId;
        this.companyId=companyId;
        this.name=name;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
