package javalab.umc7th_mission.service.ReviewCommandService;

import jakarta.transaction.Transactional;
import javalab.umc7th_mission.apiPayload.code.status.ErrorStatus;
import javalab.umc7th_mission.apiPayload.exception.MemberNotFoundException;
import javalab.umc7th_mission.apiPayload.exception.StoreNotFoundException;
import javalab.umc7th_mission.converter.ReviewConverter;
import javalab.umc7th_mission.domain.Member;
import javalab.umc7th_mission.domain.Review;
import javalab.umc7th_mission.domain.Store;
import javalab.umc7th_mission.repository.MemberRepository.MemberRepository;
import javalab.umc7th_mission.repository.ReviewRepository.ReviewRepository;
import javalab.umc7th_mission.repository.StoreRepository.StoreRepository;
import javalab.umc7th_mission.web.dto.ReviewRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    @Override
    public Review addReview(ReviewRequestDTO.AddDTO request) {
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new MemberNotFoundException(ErrorStatus.MEMBER_NOT_FOUND));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(() -> new StoreNotFoundException(ErrorStatus.STORE_NOT_FOUND));

        Review newReview = ReviewConverter.toReview(member, store, request);

        return reviewRepository.save(newReview);
    }
}