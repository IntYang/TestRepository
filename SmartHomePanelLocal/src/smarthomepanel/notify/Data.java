package smarthomepanel.notify;

public class Data {

    private String date;
    private String name;
    private String content;

    public Data(String date, String name, String content) {
        this.date = date;
        this.name = name;
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    
    

   

}
