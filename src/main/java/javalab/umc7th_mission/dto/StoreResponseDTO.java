package umc.spring.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StoreResponseDTO {
    private Long id;
    private String name;
    private String address;
    private String regionName;
}
