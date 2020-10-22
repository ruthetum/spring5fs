package DI;

import java.time.LocalDateTime;

public class MemberRegisterService {
    private MemberDao memberDao;

    // 생서자를 통해 의존 객체를 주입 받음
    public MemberRegisterService(MemberDao memberDao) {
        this.memberDao = memberDao;
    }

    public Long regist(RegisterRequest req) {
        Member member = memberDao.selectByEmail(req.getEmail());
        if (member != null) {
            throw new DuplicationMeberException("Email is Duplication : " + req.getEmail());
        }
        Member newMember = new Member(
                req.getEmail(),
                req.getPassword(),
                req.getName(),
                LocalDateTime.now()
        );
        memberDao.insert(newMember);
        return newMember.getId();
    }
}
