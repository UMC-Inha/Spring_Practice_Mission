package umc.study.service.TempService;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class TempCommandServiceImpl implements TempCommandService {
    // 컨트롤러는 인터페이스를 의존하며 실제 인터페이스에 대한 구체화 클래스는 스프링부트의 의존성 주입을 이용한다
}
