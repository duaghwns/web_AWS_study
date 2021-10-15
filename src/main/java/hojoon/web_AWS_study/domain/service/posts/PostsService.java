package hojoon.web_AWS_study.domain.service.posts;

import hojoon.web_AWS_study.domain.posts.Posts;
import hojoon.web_AWS_study.domain.posts.PostsRepository;
import hojoon.web_AWS_study.web.dto.PostsListResponseDto;
import hojoon.web_AWS_study.web.dto.PostsResponseDto;
import hojoon.web_AWS_study.web.dto.PostsSaveRequestDto;
import hojoon.web_AWS_study.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

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

    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream().map(PostsListResponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete(Long id) {
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시물이 없습니다. id : " + id));
        postsRepository.delete(posts);
    }
}
