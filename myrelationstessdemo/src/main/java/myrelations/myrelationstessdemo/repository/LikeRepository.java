package myrelations.myrelationstessdemo.repository;

import myrelations.myrelationstessdemo.model.Comment;
import myrelations.myrelationstessdemo.model.Like;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {

    Page<Like> findByPostId(Long postId, Pageable pageable);
    Optional<Like> findByIdAndPostId(Long id, Long postId);
}
