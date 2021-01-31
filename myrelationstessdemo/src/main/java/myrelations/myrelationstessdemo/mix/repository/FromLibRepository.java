package myrelations.myrelationstessdemo.mix.repository;

import myrelations.myrelationstessdemo.manytomany.entitiy.User;
import myrelations.myrelationstessdemo.mix.entity.FromLib;
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
public interface FromLibRepository extends JpaRepository<FromLib, Integer> {

    Page<FromLib> findByLibraryId(Integer libraryId, Pageable pageable);

    Optional<FromLib> findByEmail(String email);
    //@Query(value = "delete  from t_user_roles where users_id= :user_id", nativeQuery = true)
    //void deleteRelation(@Param("user_id") Long user_id);
    //@Query("from User where id= :id")
    //User  findByUserId(@Param("id") Long id);
    @Query(value = "select * from from_lib", nativeQuery = true)
    List<FromLib> findAllByFromLibId();



    @Modifying
    @Transactional
    @Query("DELETE FROM Book b WHERE b.library.id = ?1")
    void deleteByLibraryId(Integer libraryId);

}
