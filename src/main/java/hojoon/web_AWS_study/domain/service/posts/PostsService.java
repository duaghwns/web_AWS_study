package hojoon.web_AWS_study.domain.service.posts;

import hojoon.web_AWS_study.domain.posts.Posts;
import hojoon.web_AWS_study.domain.posts.PostsRepository;
import hojoon.web_AWS_study.web.dto.PostsResponseDto;
import hojoon.web_AWS_study.web.dto.PostsSaveRequestDto;
import hojoon.web_AWS_study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto) {
        Posts posts = postsRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id : "+id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id) {
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id : " + id));
        return new PostsResponseDto(entity);
    }
}
