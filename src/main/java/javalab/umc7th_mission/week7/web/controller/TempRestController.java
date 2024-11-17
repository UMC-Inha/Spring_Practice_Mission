package javalab.umc7th_mission.week7.web.controller;

import javalab.umc7th_mission.week7.apiPayload.ApiResponse;
import javalab.umc7th_mission.week7.converter.TempConverter;
import javalab.umc7th_mission.week7.service.TempQueryService;
import javalab.umc7th_mission.week7.web.dto.TempResponse;
import javalab.umc7th_mission.week7.web.dto.TempResponse.TempTestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor
public class TempRestController {

    private final TempQueryService tempQueryService;

    @GetMapping("/test")
    public ApiResponse<TempTestDTO> testAPI(){

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag){
        tempQueryService.CheckFlag(flag);
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }
}
