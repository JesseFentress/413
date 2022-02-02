public class Student {
    private int id;
    private String fn;
    private String ln;
    private String email;
    private String major;

    public Student(int id, String fn, String ln, String email, String major) {
        this.id = id;
        this.fn = fn;
        this.ln = ln;
        this.email = email;
        this.major = major;
    }
    public String getMajor() {
        return major;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getFn() {
        return fn;
    }
    public void setFn(String fn) {
        this.fn = fn;
    }
    public String getLn() {
        return ln;
    }
    public void setLn(String ln) {
        this.ln = ln;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setMajor(String major) {
        this.major = major;
    }
    @Override
    public String toString() {
        return getFn();
    }

}
