package com.sns.pojang.domain.review.controller;

import com.sns.pojang.domain.review.dto.request.ReviewRequest;
import com.sns.pojang.domain.review.dto.response.ReviewResponse;
import com.sns.pojang.domain.review.service.ReviewService;
import com.sns.pojang.global.response.SuccessResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;

import static com.sns.pojang.global.response.SuccessMessage.*;

@RestController
@RequestMapping("/api/orders")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // 리뷰 등록
    @PostMapping("/{orderId}/reviews")
    public ResponseEntity<SuccessResponse<ReviewResponse>> createReview(
            @PathVariable Long orderId, @Valid @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.created(URI.create("/" + orderId + "/reviews"))
                .body(SuccessResponse.create(HttpStatus.CREATED.value(),
                        CREATE_REVIEW_SUCCESS.getMessage(),
                        reviewService.createReview(orderId, reviewRequest)));
    }

    // 리뷰 수정
    @PatchMapping("/{orderId}/reviews")
    public ResponseEntity<SuccessResponse<ReviewResponse>> updateReview(
            @PathVariable Long orderId, @Valid @RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok(SuccessResponse.update(HttpStatus.OK.value(),
                UPDATE_REVIEW_SUCCESS.getMessage(), reviewService.updateReview(orderId, reviewRequest)));
    }


}
