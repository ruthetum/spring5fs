package DI;

import org.springframework.beans.factory.annotation.Autowired;

public class MemberInfoPrinter {

    private MemberDao memberDao;
    private MemberPrinter memberPrinter;

    public void printMemberInfo(String email) {
        Member member = memberDao.selectByEmail(email);
        if (member == null) {
            System.out.println("데이터 없음\n");
            return;
        }
        memberPrinter.print(member);
        System.out.println();
    }

    // @Autowired는 메소드에도 붙일 수 있음
    @Autowired
    public void setMemberDao(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    @Autowired
    public void setMemberPrinter(MemberPrinter memberPrinter) {
        this.memberPrinter = memberPrinter;
    }
}
