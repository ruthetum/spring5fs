package main;

import Assembler.Assembler;
import DI.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 메인 메소드
public class Main {

    private static Assembler assembler = new Assembler();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.print("명령어를 입력하세요 : ");
            String cmd = bufferedReader.readLine();
            if (cmd.equalsIgnoreCase("exit")) {
                System.out.println("종료");
                break;
            }
            if (cmd.startsWith("new ")) {
                processNewCommand(cmd.split(" "));
                continue;
            } else if (cmd.startsWith("change ")) {
                processChangeCommand(cmd.split(" "));
                continue;
            }
            printHelp();
        }
    }

    private static void processNewCommand(String[] arg) {
        if (arg.length != 5) {
            printHelp();
            return;
        }
        MemberRegisterService regSvc = assembler.getRegSvc();
        RegisterRequest req = new RegisterRequest();
        req.setEmail(arg[1]);
        req.setName(arg[2]);
        req.setPassword(arg[3]);
        req.setConfirmPassword(arg[4]);

        if (!req.isPasswordEqualToConfirmPassword()) {
            System.out.println("비밀번호가 일치하지 않음.\n");
            return;
        }
        try {
            regSvc.regist(req);
            System.out.println("등록 완료\n");
        } catch (DuplicationMeberException e) {
            System.out.println("이미 존재하는 이메일.\n");
        }
    }

    private static void processChangeCommand(String[] arg) {
        if (arg.length != 4) {
            printHelp();
            return;
        }

        ChangePasswordService changePasswordService = assembler.getPwdSvc();;
        try {
            changePasswordService.changePassword(arg[1], arg[2], arg[3]);
            System.out.println("비밀번호 변경 완료\n");
        } catch (MemberNotFoundException e) {
            System.out.println("존재하지 않는 이메일\n");
        } catch (WrongIdPasswordException e) {
            System.out.println("이메일과 비밀번호가 일치하지 않음.\n");
        }
    }

    private static void printHelp() {
        System.out.println();
        System.out.println("[명령어 사용법]");
        System.out.println("- new [이메일] [이름] [비밀번호] [비밀번호 확인]");
        System.out.println("- change [이메일] [현재 비밀번호] [변경할 비밀번호]\n");
    }
}
