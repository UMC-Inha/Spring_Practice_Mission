package javalab.umc7th_mission.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MemberInfoDto {
    private String nickname;
    private String email;
    private Integer points;
    private String phoneNumber;
}
