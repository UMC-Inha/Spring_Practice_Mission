package javalab.umc7th_mission.domain.enums;

//24.11.19 MemberConverter에서 스위치문을 위해 정수 값 매핑 추가
public enum Gender {
    MALE(1), FEMALE(2), OTHER(3), UNKNOWN(4);

    private final int value;

    Gender(int value) {
        this.value = value;
    }
    public int getValue() {
        return value;
    }

    public static Gender fromValue(int value) {
        for (Gender gender : Gender.values()) {
            if (gender.getValue() == value) {
                return gender;
            }
        }
        throw new IllegalArgumentException("잘못된 Gender의 값: " + value);
    }
}
