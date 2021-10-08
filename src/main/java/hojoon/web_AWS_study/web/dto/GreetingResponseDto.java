package hojoon.web_AWS_study.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class GreetingResponseDto {
    private final String name;
    private final int amount;
}
