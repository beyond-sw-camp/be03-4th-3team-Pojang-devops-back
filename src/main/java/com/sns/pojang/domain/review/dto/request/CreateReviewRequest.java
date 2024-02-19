package com.sns.pojang.domain.review.dto.request;

import com.sns.pojang.domain.member.entity.Address;
import com.sns.pojang.domain.member.entity.Member;
import com.sns.pojang.domain.member.entity.Role;
import com.sns.pojang.domain.review.entity.Review;
import com.sns.pojang.domain.store.entity.Store;
import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class CreateReviewRequest {

    // 별점
    @NotEmpty(message = "별점을 입력해주세요.")
    private int rating;

    // 내용
    @NotEmpty(message = "리뷰를 작성해주세요.")
    private String contents;

    public Review toEntity(int rating, String contents){
        return Review.builder()
                .rating(rating)
                .contents(contents)
                .build();
    }

}