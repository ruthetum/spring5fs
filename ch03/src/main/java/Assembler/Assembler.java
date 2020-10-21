package Assembler;

import DI.ChangePasswordService;
import DI.MemberDao;
import DI.MemberRegisterService;

// 어셈블러
public class Assembler {

    private MemberDao memberDao;
    private MemberRegisterService regSvc;
    private ChangePasswordService pwdSvc;

    public Assembler() {
        memberDao = new MemberDao();
        regSvc = new MemberRegisterService(memberDao);
        pwdSvc = new ChangePasswordService();
        pwdSvc.setMemberDao(memberDao);
    }

    public MemberDao getMemberDao() {
        return memberDao;
    }

    public MemberRegisterService getRegSvc() {
        return regSvc;
    }

    public ChangePasswordService getPwdSvc() {
        return pwdSvc;
    }
}
