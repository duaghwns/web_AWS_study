package hojoon.web_AWS_study.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT P FROM POSTS P ORDER BY P.ID DESC")
    List<Posts> findAllDesc();
}
