package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import beans.Libro;

@Repository
public abstract interface LibroRepository extends JpaRepository<Libro, Integer>{

}
