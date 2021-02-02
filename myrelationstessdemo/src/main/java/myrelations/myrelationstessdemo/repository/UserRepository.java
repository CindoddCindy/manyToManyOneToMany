package myrelations.myrelationstessdemo.repository;

import myrelations.myrelationstessdemo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<User, Long>
{

   // Page<User> findByLibraryId(Long libraryId, Pageable pageable);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.library.id = ?1")
    void deleteByLibraryId(Long libraryId);



    Optional<User> findByEmail(String email);
    //@Query(value = "delete  from t_user_roles where users_id= :user_id", nativeQuery = true)
    //void deleteRelation(@Param("user_id") Long user_id);
    //@Query("from User where id= :id")
    //User  findByUserId(@Param("id") Long id);
    @Query(value = "select * from t_user", nativeQuery = true)
    List<User> findAllByUserId();

    Page<User> findByLibraryId(Long libraryId, Pageable pageable);
    Optional<User> findByIdAndLibraryId(Long id, Long libraryId);
}
