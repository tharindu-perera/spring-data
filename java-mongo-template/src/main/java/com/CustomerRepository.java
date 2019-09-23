package com;


 import org.springframework.data.mongodb.repository.MongoRepository;
 import org.springframework.data.rest.core.annotation.RepositoryRestResource;

 import java.util.List;
 @RepositoryRestResource
 public interface CustomerRepository extends MongoRepository<Customer, String> {

    public List<Customer> findByFirstName(String firstName);
    public List<Customer> findByLastName(String lastName);

}
