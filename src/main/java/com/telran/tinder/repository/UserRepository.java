package com.telran.tinder.repository;

import com.telran.tinder.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> getUsersByNameStartingWithIgnoreCase(String name);

    @Query("SELECT new User(u.id, u.name, u.rating, u.description) from User u" +
        " WHERE u.name like :name%")
    List<User> findAutocompleteNext(@Param(value = "name") String name);


    @Query(nativeQuery = true, value = "SELECT * FROM account WHERE name LIKE :name% ")
    List<User> findAutocompleteNextNext(@Param(value = "name") String name);

    @Query("SELECT new User(u.id, u.name, u.rating, u.description) from User u" +
            " WHERE u.rating between :minRating AND :maxRating")
    List<User> findByRatingRange(@Param(value = "minRating") int minRating, @Param(value = "maxRating") int maxRating);

    @Query(nativeQuery = true, value = "SELECT COUNT(*) AS users_description FROM account WHERE description LIKE :word% ")
    int countAllByWordInDescription(@Param(value = "word") String word);

    @Query("SELECT new User(u.id, u.name, u.rating, u.description) from User u" +
            " WHERE u.id = :id")
    boolean findById(@Param(value = "id") int id);

    @Query(nativeQuery = true, value = "SELECT * FROM account ORDER BY account.id LIMIT :pageSize OFFSET :paging")
    List<User> getAllUsers(int pageSize, int pageNum);
}
