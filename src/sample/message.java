package sample;

public class message {
    private int from;
    private String subject;
    private String content;

    public message() {
    }

    public message(int from, String subject, String content) {
        this.from = from;
        this.subject = subject;
        this.content = content;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
