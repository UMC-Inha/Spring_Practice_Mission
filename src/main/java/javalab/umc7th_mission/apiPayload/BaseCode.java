package javalab.umc7th_mission.apiPayload;

//해당 인터페이스의 역할 -> 구체화 하는 Status에서
// 두개의 메소드를 반드시 오버라이드할 것을 강제하는 역할
public interface BaseCode {
    ReasonDTO getReason();
    ReasonDTO getReasonHttpStatus();
}
