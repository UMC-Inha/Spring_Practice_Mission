package javalab.umc7th_mission.service.TempService;

import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.GeneralException;
import javalab.umc7th_mission.apiPayload.exception.handler.TempHandler;
import org.springframework.stereotype.Service;

@Service
public class TempQueryServiceImpl implements TempQueryService {
    @Override
    public void checkFlag(Integer flag) {
        if (flag == 1)
            throw new GeneralException(ErrorStatus.TEMP_EXCEPTION);
    }
}
