package DI;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.format.DateTimeFormatter;

public class MemberPrinter {
    private DateTimeFormatter dateTimeFormatter;

//    @Autowired
//    private Optional<DateTimeFormatter> opt;

//    @Autowired
//    @Nullable
//    private DateTimeFormatter dateTimeFormatter;

    public MemberPrinter() {
        dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy년 MM월 dd일");
    }

    public void print(Member member){
        if (dateTimeFormatter == null) {
            System.out.printf(
                "회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%tF\n",
                member.getId(),
                member.getEmail(),
                member.getName(),
                member.getRegisterDateTime()
            );
        } else {
            System.out.printf(
                "회원 정보 : 아이디=%d, 이메일=%s, 이름=%s, 등록일=%s\n",
                member.getId(),
                member.getEmail(),
                member.getName(),
                dateTimeFormatter.format(member.getRegisterDateTime())
            );
        }
    }

    @Autowired(required = false)
    public void setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
        this.dateTimeFormatter = dateTimeFormatter;
    }
}
