package easynotes.repository;

import easynotes.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */
 @RepositoryRestResource
public interface NoteRepository extends JpaRepository<Book, Long> {

}
