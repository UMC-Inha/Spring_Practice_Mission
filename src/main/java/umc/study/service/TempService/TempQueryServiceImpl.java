package umc.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.apiPayload.code.status.ErrorStatus;
import umc.study.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements  TempQueryService{
    // 컨트롤러는 인터페이스를 의존하며 실제 인터페이스에 대한 구체화 클래스는 스프링부트의 의존성 주입을 이용한다
    @Override
    public void CheckFlag(Integer flag){
        if(flag == 1) //if문 내부로 들어오면 Service 이후 controller로 가지 않고, 바로 Exception handler에 의해 응답이 보내진다.
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
