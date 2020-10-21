package chap02;

public class Greeter {

    private String format;

    public String greet(String guest) {
        return String.format(format, guest);
    }

    public void setFormat(String format) {
        this.format = format;
    }
}

//Greeter greeter = new Greeter();
//greeter.setFormat("%s, 안녕!");
//Stirng msg = greeter.greet("홍길동");
//System.out.println(msg); // '홍길동, 안녕!' 출력
