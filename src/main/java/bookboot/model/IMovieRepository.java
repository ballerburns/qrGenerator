/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookboot.model;
 
import java.util.List;
 
import org.springframework.data.repository.CrudRepository;
import  bookboot.model.Movie;

public interface IMovieRepository extends CrudRepository<Movie, Long> {
 
    List<Movie> findByYearLessThan(int year);
 
}